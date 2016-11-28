package com.example.dmartins.flickrapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by davidmartins on 27/11/2016.
 */
public class Comment implements Serializable {

    @SerializedName("authorname")
    private String authorName;
    @SerializedName("realname")
    private String realname;
    @SerializedName("_content")
    private String content;

    public Comment(String authorName, String realname, String content) {
        this.authorName = authorName;
        this.realname = realname;
        this.content = content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
