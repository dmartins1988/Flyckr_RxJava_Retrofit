package com.example.dmartins.flickrapp.presenter;

import com.example.dmartins.flickrapp.model.Comment;
import com.example.dmartins.flickrapp.model.CommentsResponse;
import com.example.dmartins.flickrapp.model.PhotoInfoResponse;
import com.example.dmartins.flickrapp.service.FlickrService;
import com.example.dmartins.flickrapp.view.FlickrInfoView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                .getPhotoInfo(
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

    public void getPhotoComments(String photoId) {
        mFlickrService
                .getApi()
                .getPhotoComments(
                        FlickrService.METHOD_GET_PHOTO_COMMENTS,
                        FlickrService.KEY,
                        FlickrService.JSON,
                        FlickrService.NO_JSON_CALLBACK,
                        photoId
                )
                .enqueue(new Callback<CommentsResponse>() {
                    @Override
                    public void onResponse(Call<CommentsResponse> call, Response<CommentsResponse> response) {
                        ArrayList<Comment> listOfComments = new ArrayList<>();
                        if (response.body().getComments().getComment() != null) {
                            for (Comment c : response.body().getComments().getComment()) {
                                listOfComments.add(c);
                            }
                            mFlickrInfoView.displayPhotoComments(listOfComments);
                        }
                        mFlickrInfoView.displayNoComments();

                    }

                    @Override
                    public void onFailure(Call<CommentsResponse> call, Throwable t) {

                    }
                });
    }

}
