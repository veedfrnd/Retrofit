package com.retrofit.testretorfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.retrofit.testretorfit.models.Letter;
import com.retrofit.testretorfit.models.Post;
import com.retrofit.testretorfit.models.TotalVisits;
import com.retrofit.testretorfit.models.UpdateVCode;
import com.retrofit.testretorfit.restapi.MyAPIInterface;
import com.retrofit.testretorfit.restapi.MyRetrofirClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mTag;
    MyAPIInterface myAPIInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTag = findViewById(R.id.mTag);
        //myAPIInterface = MyAPIInterface.retrofit.create(MyAPIInterface.class);
        myAPIInterface = MyRetrofirClient.getRetrofit().create(MyAPIInterface.class);
    }

    public void RunCode(View view) {
        //getPosts();
        //getLetters();
        // getTotalVisits();
        // createPost();
        // updateVCode();
        //putPost();
        deletePost();
    }

    private void deletePost() {
        Call<Void> deletePostCall = myAPIInterface.deletePost(5);
        deletePostCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    /*todo post deleted*/
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void putPost() {
        Post putpost = new Post(5, null, "y puri post ke object ko hi update kr degi.");
        // Call<Post> putCall = myAPIInterface.putPost(5, post);
        Post patchpost = new Post(5, null, "partial update kregi.");

        Call<Post> patchPostCall = myAPIInterface.patchPost(5, patchpost);
        patchPostCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    showPost(response.body());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void updateVCode() {
        UpdateVCode vCode = new UpdateVCode("30", "12345");
        Map<String, String> OMap = new HashMap<String, String>();
        OMap.put("VCode", "30");
        OMap.put("dbid", "12345");
        Call<List<UpdateVCode>> callVcode = myAPIInterface.updateVCo(OMap);
        callVcode.enqueue(new Callback<List<UpdateVCode>>() {
            @Override
            public void onResponse(Call<List<UpdateVCode>> call, Response<List<UpdateVCode>> response) {
                mTag.setText("" + response.code());
                if (response.isSuccessful()) {
                    mTag.setText(response.body().get(0).getResp());
                }
            }

            @Override
            public void onFailure(Call<List<UpdateVCode>> call, Throwable t) {
                mTag.setText(t.getMessage());
            }
        });
    }

    private void createPost() {
        Post post = new Post(5, "Post Title", "This is post body");
        Call<Post> createCall = myAPIInterface.createPost(post);
        createCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    mTag.setText(response.code() + "\n");
                    showPost(response.body());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void getTotalVisits() {
        Map<String, String> qmap = new HashMap<>();
        qmap.put("dbid", "12345");
        qmap.put("TDate", "20/08/2020");
        qmap.put("SM_ID", "sm029");
        qmap.put("FDate", "01/07/2020");


        Call<List<TotalVisits>> call = myAPIInterface.getTotalVisits(qmap);
        call.enqueue(new Callback<List<TotalVisits>>() {
            @Override
            public void onResponse(Call<List<TotalVisits>> call, Response<List<TotalVisits>> response) {
                if (response.isSuccessful()) {
                    for (TotalVisits visit : response.body()) {
                        showVisit(visit);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<TotalVisits>> call, Throwable t) {
                mTag.append(t.getMessage());
            }
        });

    }

    private void showVisit(TotalVisits visit) {
        mTag.append("CHECKIN: " + visit.getCHECKIN() + "\n");
        mTag.append("CHECKOUT: " + visit.getCHECKOUT() + "\n");
        mTag.append("MINUTESCOUNT: " + visit.getMINUTESCOUNT() + "\n");
        mTag.append("SM_NAME: " + visit.getSMNAME() + "\n\n");
    }

    private void getLetters() {
        Call<List<Letter>> call = myAPIInterface.getLetters();
        call.enqueue(new Callback<List<Letter>>() {
            @Override
            public void onResponse(Call<List<Letter>> call, Response<List<Letter>> response) {
                if (response.isSuccessful()) {
                    for (Letter letter : response.body()) {
                        showLetters(letter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Letter>> call, Throwable t) {

            }
        });
    }

    private void showLetters(Letter letter) {
        mTag.append("Date: " + letter.getDate() + "\n");
        mTag.append("Description: " + letter.getDiscription() + "\n");
        mTag.append("Url: " + letter.getURL() + "\n\n");
    }

    private void getPosts() {
        Call<List<Post>> call = myAPIInterface.getPosts(5);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    for (Post post : response.body()) {
                        showPost(post);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    private void showPost(Post post) {
        mTag.append("UserId : " + post.getUserId() + "\n");
        mTag.append("Id : " + post.getId() + "\n");
        mTag.append("Title : " + post.getTitle() + "\n");
        mTag.append("Body : " + post.getTestBody() + "\n\n");
    }


    public void ClearCode(View view) {
        mTag.setText("");
    }
}