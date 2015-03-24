package com.muxistudio.jinyixin.no10;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends ActionBarActivity {

    private HttpClient httpClient;
    private HttpGet httpGet;

    private String temp;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = (TextView) findViewById(R.id.content);

//网络连接的部分不允许写在主线程里面，一定要注意
        new Thread(new Runnable() {
            @Override
            public void run() {

                httpClient = new DefaultHttpClient();//
                httpGet = new HttpGet("https://api.douban.com/v2/book/search?q=哈利波特&count=1");//

//try一下，以防网络不稳定而挂掉
//buffer的内容如果不清楚书上有，我也有在tower上整理：关于输入输出的一个分享
                try {
                    HttpResponse httpResponse = httpClient.execute(httpGet);
                    HttpEntity entity = httpResponse.getEntity();
                    if (entity != null) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));

                        String line = null;
                        StringBuilder builder = new StringBuilder();
                        while ((line = br.readLine()) != null) {
                            builder.append(line);
                        }
                        temp = builder.toString();
                        Log.i("result", temp);

//runOnUiThread是填写UI的方法，因为在非主线程不允许填写UI
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                content.setText(temp);
                            }
                        });
                    }

                } catch (IOException e) {
                    //可以输出一个什么网络错误的提示
                }
            }
        }).start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
