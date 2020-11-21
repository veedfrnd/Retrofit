package com.retrofit.testretorfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.retrofit.testretorfit.models.Post;
import com.retrofit.testretorfit.restapi.MyAPIInterface;

import java.util.List;

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
        myAPIInterface = MyAPIInterface.retrofit.create(MyAPIInterface.class);
    }

    public void RunCode(View view) {
        //getPosts();

    }

    private void getPosts() {
        Call<List<Post>> call = myAPIInterface.getPosts();
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