package com.retrofit.testretorfit.models;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String testBody;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTestBody() {
        return testBody;
    }

    public void setTestBody(String testBody) {
        this.testBody = testBody;
    }
}