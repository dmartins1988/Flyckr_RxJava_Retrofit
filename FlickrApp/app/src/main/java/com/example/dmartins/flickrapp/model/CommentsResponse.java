package com.example.dmartins.flickrapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by E491 on 28/11/2016.
 */

public class CommentsResponse implements Serializable {

    @SerializedName("comments")
    private Comments comments;

    public Comments getComments() {
        return comments;
    }

    public void setComment(Comments comment) {
        this.comments = comment;
    }
}
