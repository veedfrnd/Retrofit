package com.retrofit.testretorfit.models;

import com.google.gson.annotations.SerializedName;

public class Letter {

    @SerializedName("Date")
    private String date;
    @SerializedName("Discription")
    private String discription;
    @SerializedName("URL")
    private String uRL;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getURL() {
        return uRL;
    }

    public void setURL(String uRL) {
        this.uRL = uRL;
    }

}