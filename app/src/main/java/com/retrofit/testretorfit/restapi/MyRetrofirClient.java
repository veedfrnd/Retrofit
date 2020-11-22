package com.retrofit.testretorfit.restapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofirClient {

    static String BASE_URL = "https://jsonplaceholder.typicode.com/";   // JsonPlaceHolder API
    //String BASE_URL = "http://www.unfpamp.in/UmangHelpline.asmx/";   // @GET("GetLetter")  simple SOAP Service
    // String BASE_URL = "http://192.169.226.66/att.asmx/";  //@GET("GetTotalVisite"),@POST("UpdateVcode")  simple SOAP Service



    //region Interceptor or null serialized retrofit
    public static Retrofit getRetrofit() {

        //region Logging Intercepted ke liye taki hm sari details ko dk saken http se jo ho rhi hai like pojo class ki object ko json me or headers
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();
        //endregion

        //region json me null values ko bhi bej dega. islire null serilize by Gson
        Gson gson = new GsonBuilder().serializeNulls().create();
        //endregion

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)) // null ko bhi bej rhe hai serilize kr ke
                .client(httpClient) // http client ke sath interceptor use
                .build();

        return retrofit;
    }
    //endregion

}
