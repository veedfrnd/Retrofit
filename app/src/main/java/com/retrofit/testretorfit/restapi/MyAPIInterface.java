package com.retrofit.testretorfit.restapi;

import com.retrofit.testretorfit.models.Letter;
import com.retrofit.testretorfit.models.Post;
import com.retrofit.testretorfit.models.TotalVisits;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface MyAPIInterface {
    //String BASE_URL = "https://jsonplaceholder.typicode.com/";   //@GET("posts") JsonPlaceHolder API
    //String BASE_URL = "http://www.unfpamp.in/UmangHelpline.asmx/";   // @GET("GetLetter")  simple SOAP Service
    String BASE_URL = "http://192.169.226.66/att.asmx/";  //@GET("GetTotalVisite") simple SOAP Service

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    /*simple get request*/
    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("GetLetter")
    Call<List<Letter>> getLetters();

    @GET("GetTotalVisite")
    Call<List<TotalVisits>> getTotalVisits(@QueryMap Map<String, String> qmap);

}
