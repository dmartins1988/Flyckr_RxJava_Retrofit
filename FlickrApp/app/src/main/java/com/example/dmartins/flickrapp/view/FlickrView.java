package com.example.dmartins.flickrapp.view;

import com.example.dmartins.flickrapp.model.Photo;

import java.util.ArrayList;

/**
 * Created by David Martins on 25/11/2016.
 */

public interface FlickrView {

    void displayRecentGallery(ArrayList<Photo> listPhotos);

    void displayPhotoClicked();

}
