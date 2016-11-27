package com.example.dmartins.flickrapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by David Martins on 25/11/2016.
 */
public class PhotoInfo implements Serializable{

    @SerializedName("owner")
    private Owner owner;
    @SerializedName("title")
    private Title title;
    @SerializedName("dates")
    private Dates dates;
    @SerializedName("comments")
    private Comments comment;


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Comments getComment() {
        return comment;
    }

    public void setComment(Comments comment) {
        this.comment = comment;
    }
}
