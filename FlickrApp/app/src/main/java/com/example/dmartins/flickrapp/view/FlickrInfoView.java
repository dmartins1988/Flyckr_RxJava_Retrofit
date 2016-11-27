package com.example.dmartins.flickrapp.view;

import com.example.dmartins.flickrapp.model.PhotoInfoResponse;

/**
 * Created by David Martins on 25/11/2016.
 */

public interface FlickrInfoView {
    void showPhotoInfo(PhotoInfoResponse photo);
    void displayPhoto();
}
