package com.example.dmartins.flickrapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by E491 on 25/11/2016.
 */

public class PhotoInfoResponse implements Serializable{

    @SerializedName("photo")
    private PhotoInfo photoInfo;

    public PhotoInfo getPhotoInfo() {
        return photoInfo;
    }

    public void setPhotoInfo(PhotoInfo photoInfo) {
        this.photoInfo = photoInfo;
    }
}
