package com.example.dmartins.flickrapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E491 on 25/11/2016.
 */
public class PhotoInfo {

    @SerializedName("owner")
    private Owner owner;
    @SerializedName("title")
    private Title title;


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

}
