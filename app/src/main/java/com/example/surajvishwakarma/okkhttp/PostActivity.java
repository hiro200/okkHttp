package com.example.surajvishwakarma.okkhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostActivity extends AppCompatActivity {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        textView = (TextView) findViewById(R.id.reponce);

        UserPost userPost = new UserPost();
        userPost.setWlpID("DW");
        userPost.setLastName("ndfd");
        userPost.setFirstName("bak");
        userPost.setEmailAddress1("sdfdsf@gmail.com");
        userPost.setLanguageID("en_US");
        userPost.setPassword("Start@1234");
        userPost.setUsername("fdgdfg");


        String json = new Gson().toJson(userPost);

        final OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        final Request request = new Request.Builder().addHeader("x-mysolomeo-session-key", "02e57c7d-d071-4c63-b491-1194a9939ea5.2016-11-01T18:15:11.005Z")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept-Type", "application/json")
                .url("http://api.drivewealth.io/v1/signups/live")
                .post(body)
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    final String jsonResponce  =response.body().string();
                    PostActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            UserDetails userDetails = new Gson().fromJson(jsonResponce,new TypeToken<UserDetails>() {}.getType());
                            textView.setText("Username:"+userDetails.getUsername() + "\n Password:"+ userDetails.getPassword()+ "\n UserID:"+ userDetails.getUserID());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
