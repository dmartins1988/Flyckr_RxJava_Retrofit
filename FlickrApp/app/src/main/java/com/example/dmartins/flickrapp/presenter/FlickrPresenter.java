package com.example.dmartins.flickrapp.presenter;

import com.example.dmartins.flickrapp.model.Photo;
import com.example.dmartins.flickrapp.model.PhotoResponse;
import com.example.dmartins.flickrapp.service.FlickrService;
import com.example.dmartins.flickrapp.view.FlickrView;

import java.util.ArrayList;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by E491 on 25/11/2016.
 */

public class FlickrPresenter {

    FlickrView mFlickrView;
    FlickrService mFlickrService;

    public FlickrPresenter(FlickrView mFlickrView, FlickrService mFlickrService) {
        this.mFlickrView = mFlickrView;
        this.mFlickrService = mFlickrService;
    }

    public void loadGallery() {

        mFlickrService
                .getApi()
                .getObservableRecentPhotos(
                        FlickrService.METHOD_GET_RECENT,
                        FlickrService.KEY,
                        FlickrService.JSON,
                        FlickrService.NO_JSON_CALLBACK)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PhotoResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PhotoResponse photoResponse) {
                        ArrayList<Photo> list = new ArrayList<>();
                        for (Photo p : photoResponse.getPhotos().getPhoto()) {
                            Photo photo = new Photo(
                                    p.getId(),
                                    p.getSecret(),
                                    p.getServer(),
                                    p.getFarm()
                            );
                            list.add(photo);
                        }
                        mFlickrView.displayRecentGallery(list);
                    }
                });

    }

    public void showPhoto() {
        mFlickrView.displayPhotoClicked();
    }

}
