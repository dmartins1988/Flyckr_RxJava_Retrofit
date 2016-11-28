package com.example.dmartins.flickrapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by E491 on 28/11/2016.
 */

public class Comments implements Serializable {

    @SerializedName("photo_id")
    private String photoId;
    @SerializedName("comment")
    private List<Comment> comment;

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }
}
