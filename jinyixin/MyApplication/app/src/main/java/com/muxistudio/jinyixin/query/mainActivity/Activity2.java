package com.muxistudio.jinyixin.query.mainActivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.muxistudio.jinyixin.query.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

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
        Bundle bundle_receive = receive.getExtras();
        String username = bundle_receive.getString("name");
        String tip = bundle_receive.getString("tip");
        final String path;
        if (tip.equals("username")) {
            path = "https://www.v2ex.com/api/members/show.json?username=" + username;
        } else {
            path = "https://www.v2ex.com/api/members/show.json?id=" + username;
        }
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
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();

//        JSONObject jsonObject = null;
//        try {
//            jsonObject = new JSONObject(temp);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        try {
//            assert jsonObject != null;
//            String statue1 = jsonObject.getString("statue");
//            int id1 = jsonObject.getInt("id");
//            String url1 = jsonObject.getString("url");
//            String usernames1 = jsonObject.getString("username");
//            String website1 = jsonObject.getString("website");
//            String twitter1 = jsonObject.getString("twitter");
//            String psn1 = jsonObject.getString("psn");
//            String github1 = jsonObject.getString("github");
//            String btc1 = jsonObject.getString("btc");
//            String location1 = jsonObject.getString("location");
//            String tagline1 = jsonObject.getString("tagline");
//            String bio1 = jsonObject.getString("bio");
//            String avatar_mini1 = jsonObject.getString("avatar_mini");
//            EditText statue = (EditText) findViewById(R.id.statue);
//            EditText id = (EditText) findViewById(R.id.id);
//            EditText url = (EditText) findViewById(R.id.url);
//            EditText usernames = (EditText) findViewById(R.id.usernames);
//            EditText website = (EditText) findViewById(R.id.website);
//            EditText twitter = (EditText) findViewById(R.id.twitter);
//            EditText psn = (EditText) findViewById(R.id.psn);
//            EditText github = (EditText) findViewById(R.id.github);
//            EditText btc = (EditText) findViewById(R.id.btc);
//            EditText location = (EditText) findViewById(R.id.location);
//            EditText tagline = (EditText) findViewById(R.id.tagline);
//            EditText bio = (EditText) findViewById(R.id.bio);
//            EditText avatar_mini = (EditText) findViewById(R.id.avatar_mini);
//            statue.setText(statue1);
//            id.setText(id1);
//            url.setText(url1);
//            usernames.setText(usernames1);
//            website.setText(website1);
//            twitter.setText(twitter1);
//            psn.setText(psn1);
//            github.setText(github1);
//            btc.setText(btc1);
//            location.setText(location1);
//            tagline.setText(tagline1);
//            bio.setText(bio1);
//            avatar_mini.setText(avatar_mini1);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        //content.setText(temp);

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
