package com.example.dmartins.flickrapp.service;

import com.example.dmartins.flickrapp.model.CommentsResponse;
import com.example.dmartins.flickrapp.model.PhotoInfoResponse;
import com.example.dmartins.flickrapp.model.PhotoResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by David Martins on 25/11/2016.
 */

public class FlickrService {

    private static final String URL = "https://api.flickr.com/services/";
    public static String KEY = "cf2a63a4af252b0262a8fab86764790b";
    public static String METHOD_GET_RECENT = "flickr.photos.getRecent";
    public static String METHOD_GET_PHOTO_DETAIL = "flickr.photos.getInfo";
    public static String METHOD_GET_PHOTO_COMMENTS = "flickr.photos.comments.getList";
    public static String METHOD_GET_BY_USERNAME = "flickr.people.findByUsername";
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

        @GET("rest/")
        Call<PhotoInfoResponse> getPhotoInfo(@Query("method") String method,
                                             @Query("api_key") String apiKey,
                                             @Query("format") String format,
                                             @Query("nojsoncallback") String noJsonCallback,
                                             @Query("photo_id") String photoId);

        @GET("rest/")
        Call<CommentsResponse> getPhotoComments(@Query("method") String method,
                                                @Query("api_key") String apiKey,
                                                @Query("format") String format,
                                                @Query("nojsoncallback") String noJsonCallback,
                                                @Query("photo_id") String photoId);

    }

}
