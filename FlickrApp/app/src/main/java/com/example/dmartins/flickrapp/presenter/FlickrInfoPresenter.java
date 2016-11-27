package com.example.dmartins.flickrapp.presenter;

import com.example.dmartins.flickrapp.model.PhotoInfoResponse;
import com.example.dmartins.flickrapp.service.FlickrService;
import com.example.dmartins.flickrapp.view.FlickrInfoView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by David Martins on 25/11/2016.
 */

public class FlickrInfoPresenter {

    FlickrInfoView mFlickrInfoView;
    FlickrService mFlickrService;

    public FlickrInfoPresenter(FlickrInfoView flickrInfoView, FlickrService flickrService) {
        this.mFlickrInfoView = flickrInfoView;
        this.mFlickrService = flickrService;
    }

    public void getPhotoInfo(String photoId) {
        mFlickrService
                .getApi()
                .getObservablePhotoInfo(
                        FlickrService.METHOD_GET_PHOTO_DETAIL,
                        FlickrService.KEY,
                        FlickrService.JSON,
                        FlickrService.NO_JSON_CALLBACK,
                        photoId
                )
                .enqueue(new Callback<PhotoInfoResponse>() {
                    @Override
                    public void onResponse(Call<PhotoInfoResponse> call, Response<PhotoInfoResponse> response) {
                        mFlickrInfoView.showPhotoInfo(response.body());
                        mFlickrInfoView.displayPhoto();
                    }

                    @Override
                    public void onFailure(Call<PhotoInfoResponse> call, Throwable t) {

                    }
                });

    }
}
