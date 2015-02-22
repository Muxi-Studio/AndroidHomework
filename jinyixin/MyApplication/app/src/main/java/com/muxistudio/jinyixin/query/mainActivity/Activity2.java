package com.muxistudio.jinyixin.query.mainActivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.muxistudio.jinyixin.query.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.PrivateKey;
import java.util.Locale;


public class Activity2 extends ActionBarActivity {

    private String temp;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        content = (TextView) findViewById(R.id.content);
        Intent receive = getIntent();
        Bundle bundle_receive=receive.getExtras();
        String username = bundle_receive.getString("name");
        String tip = bundle_receive.getString("tip");
        if(tip.equals("username"))
        {
        final String path = "https://www.v2ex.com/api/members/show.json?username=" + username;

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
                    while((line=bufferedReader.readLine()) != null)
                    {
                         builder.append(line);
                    }
                    temp = builder.toString();
                    Log.i("result",temp);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            content.setText(temp);
                        }
                    });
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();
        }else {
            final String path = "https://www.v2ex.com/api/members/show.json?id=" + username;

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
                        while((line=bufferedReader.readLine()) != null)
                        {
                            builder.append(line);
                        }
                        temp = builder.toString();
                        Log.i("result",temp);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                content.setText(temp);
                            }
                        });
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            });
            thread.start();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
