package com.example.dmartins.flickrapp.service;

import com.example.dmartins.flickrapp.model.PhotoResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by E491 on 25/11/2016.
 */

public class FlickrService {

    private static final String URL = "https://api.flickr.com/services/";
    public static String KEY = "cf2a63a4af252b0262a8fab86764790b";
    public static String METHOD = "flickr.photos.getRecent";
    public static String JSON = "json";
    public static String NO_JSON_CALLBACK = "1";
    private FlickApi mFlickrApi;

    public FlickrService() {

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        mFlickrApi = retrofit2.create(FlickApi.class);
    }

    public FlickApi getApi() {
        return mFlickrApi;
    }

    public interface FlickApi {

        @GET("rest/")
        Observable<PhotoResponse> getObservableRecentPhotos(@Query("method") String method,
                                                            @Query("api_key") String apiKey,
                                                            @Query("format") String format,
                                                            @Query("nojsoncallback") String noJsonCallback);

    }

}
