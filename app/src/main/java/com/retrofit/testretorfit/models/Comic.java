package com.retrofit.testretorfit.models;

import com.google.gson.annotations.SerializedName;

public class Comic {
    @SerializedName("ComicTrNo")
    private String comicTrNo;
    @SerializedName("ComicName")
    private String comicName;

    public Comic() {
    }


    public Comic(String comicTrNo, String comicName) {
        super();
        this.comicTrNo = comicTrNo;
        this.comicName = comicName;
    }

    public String getComicTrNo() {
        return comicTrNo;
    }

    public void setComicTrNo(String comicTrNo) {
        this.comicTrNo = comicTrNo;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

}