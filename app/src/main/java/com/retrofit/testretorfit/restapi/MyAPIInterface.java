package com.retrofit.testretorfit.restapi;

import com.retrofit.testretorfit.models.Letter;
import com.retrofit.testretorfit.models.Post;
import com.retrofit.testretorfit.models.TotalVisits;
import com.retrofit.testretorfit.models.UpdateVCode;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

import static com.retrofit.testretorfit.restapi.MyRetrofirClient.BASE_URL;

public interface MyAPIInterface {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //region GET Methods todo : that will retrieve data from server
    /*simple get request jsonplaceholder se*/
    @GET("posts")
    Call<List<Post>> getPosts();

    /*dynaic url param with path*/
    @GET("posts/{id}/comments")
    Call<List<Post>> getPosts(@Path("id") int postId);


    /*simple SOAP Service without param*/
    @GET("GetLetter")
    Call<List<Letter>> getLetters();

    /*simple SOAP Service with param*/
    /*todo: isi tarah apn  only  Query ka use kr skte hai map ka use na krna ho to*/
    @GET("GetTotalVisite")
    Call<List<TotalVisits>> getTotalVisits(@QueryMap Map<String, String> qmap);
    //endregion

    //region Post methods todo :  ye server pr resource ko create krta hai
    /*Post method for Placeholder api*/
    @POST("posts")
    Call<Post> createPost(@Body Post post);


    /*Y object k form me service pr data le jaa rhe hai SOAP service se bhale hi formURLEncode lika hai*/
    /*todo: isi tarah apn only fields ka use kr skte hai map ka use na krna ho to*/
    @FormUrlEncoded
    @POST("UpdateVcode")
    Call<List<UpdateVCode>> updateVCo(@FieldMap Map<String, String> body);
    //endregion

    //region PUT method todo : y method particular id ke behalf me sari fields ko update kr degi(us particular resource ko pura hi overridde,  kr degi, agr resource nhi milega to create kr degi
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id,@Body Post post);
    //endregion

    //region todo : y method particular id ke behalf me sirf unhi  fields ko update kr degi jin fields ko beja ja rha hai(partial update.)
    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id,@Body Post post);
    //endregion

    @DELETE("posts/(id)")
    Call<Void> deletePost(@Path("id") int id);

}
