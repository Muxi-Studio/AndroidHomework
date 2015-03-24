package com.muxistudio.jinyixin.query.netWork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

/**
 * Created by jinyixin on 15/3/14.
 */
public class NetExecute {
    String temp;
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(path);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setConnectTimeout(10000);

                httpURLConnection.setRequestMethod("GET");

                httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().toString());

                InputStream inputStream = httpURLConnection.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                StringBuilder builder = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    builder.append(line);
                }

                temp = builder.toString();
                Log.i("result", temp);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        content.setText(temp);
//                            if(temp!=null) {
//                                try {
//                                    JSONObject jsonObject = new JSONObject(temp);
//                                    String status = jsonObject.optString("status");
//                                    int id = jsonObject.optInt("id");
//                                    String url = jsonObject.optString("url");
//                                    String usernames = jsonObject.optString("username");
//                                    String website = jsonObject.optString("website");
//                                    String twittwe = jsonObject.optString("twitter");
//                                    String psn = jsonObject.optString("psn");
//                                    String github = jsonObject.optString("github");
//                                    String btc = jsonObject.optString("btc");
//                                    String location = jsonObject.optString("location");
//                                    String tagline = jsonObject.optString("tagline");
//                                    String bio = jsonObject.optString("bio");
//                                    int created = jsonObject.optInt("created");
//                                    EditText editText1 = (EditText) findViewById(R.id.statue);
//                                    editText1.setText(status);
//                                    EditText editText2 = (EditText) findViewById(R.id.id);
//                                    editText2.setText(id);
//                                    EditText editText3 = (EditText) findViewById(R.id.url);
//                                    editText3.setText(url);
//                                    EditText editText4 = (EditText) findViewById(R.id.usernames);
//                                    editText4.setText(usernames);
//                                    EditText editText5 = (EditText) findViewById(R.id.website);
//                                    editText5.setText(website);
//                                    EditText editText6 = (EditText) findViewById(R.id.twitter);
//                                    editText6.setText(twittwe);
//                                    EditText editText7 = (EditText) findViewById(R.id.psn);
//                                    editText7.setText(psn);
//                                    EditText editText8 = (EditText) findViewById(R.id.github);
//                                    editText8.setText(github);
//                                    EditText editText9 = (EditText) findViewById(R.id.btc);
//                                    editText9.setText(btc);
//                                    EditText editText10 = (EditText) findViewById(R.id.location);
//                                    editText10.setText(location);
//                                    EditText editText11 = (EditText) findViewById(R.id.tagline);
//                                    editText11.setText(tagline);
//                                    EditText editText12 = (EditText) findViewById(R.id.bio);
//                                    editText12.setText(bio);
//
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
                    }
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    });
    thread.start();
}