package com.example.dmartins.flickrapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by E491 on 25/11/2016.
 */

public class Photo implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("secret")
    private String secret;
    @SerializedName("server")
    private String server;
    @SerializedName("farm")
    private String farm;

    public Photo(String id, String secret, String server, String farm) {
        this.id = id;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getUrl() {
        return new StringBuilder()
                .append("http://farm")
                .append(farm)
                .append(".static.flickr.com/")
                .append(server)
                .append("/")
                .append(id)
                .append("_")
                .append(secret)
                .append(".jpg")
                .toString();
    }
}
