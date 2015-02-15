package com.muxistudio.jinyixin.queryuserinformation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity2 extends ActionBarActivity {
    private HttpClient httpClient;
    private HttpGet httpGet;
    protected TextView content;
    private String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        content =(TextView) findViewById(R.id.content);



        Thread thread = new  Thread(new Runnable() {
            @Override
            public void run() {

                EditText username = (EditText) findViewById(R.id.username);
                String path ="https://www.v2ex.com/api/members/show.json?username="+ username;
                httpClient = new DefaultHttpClient();
                httpGet = new HttpGet(path);

                try{
                    HttpResponse httpResponse = httpClient.execute(httpGet);
                    HttpEntity entity = httpResponse.getEntity();
                    if(entity != null){
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));

                        String line = null;
                        StringBuilder builder = new StringBuilder();
                        while ((line = bufferedReader.readLine()) != null){
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
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    thread.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
