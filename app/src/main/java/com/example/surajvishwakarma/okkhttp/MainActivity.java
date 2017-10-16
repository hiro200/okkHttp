package com.example.surajvishwakarma.okkhttp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .addHeader("x-mysolomeo-session-key", "02e57c7d-d071-4c63-b491-1194a9939ea5.2016-11-01T18:15:11.005Z")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept-Type", "application/json")
                .url("http://api.drivewealth.io/v1/countries").build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    String jsonResponce = response.body().string();
                    JSONArray accounts = null;
                    try {
                        accounts = new JSONArray(jsonResponce);

                        final List<CountryList> accountList = new Gson().fromJson(accounts.toString(), new TypeToken<ArrayList<CountryList>>() {
                        }.getType());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ListView listView = (ListView) findViewById(R.id.myList);
                                listView.setAdapter(new ArrayAdapter<CountryList>(MainActivity.this, android.R.layout.simple_list_item_1, accountList));
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void openPostRequest(View view) {

        startActivity(new Intent(getApplicationContext(),PostActivity.class));
    }
}
