package com.retrofit.testretorfit.restapi;

import com.retrofit.testretorfit.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface MyAPIInterface {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl(BASE_URL)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();


    /*simple get request*/
    @GET("posts")
    Call<List<Post>> getPosts();

}
