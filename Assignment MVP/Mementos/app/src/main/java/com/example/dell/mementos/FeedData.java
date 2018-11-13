package com.example.dell.mementos;

import java.sql.Blob;

public class FeedData
{
    private String name;
    private String dp;
    private String post;
    private String rating;

    FeedData(String n, String d, String p, String r)
    {
        this.name = n;
        this.dp = d;
        this.post = p;
        this.rating = r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDp() {
        return dp;
    }

    public void setDp(String dp) {
        this.dp = dp;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
