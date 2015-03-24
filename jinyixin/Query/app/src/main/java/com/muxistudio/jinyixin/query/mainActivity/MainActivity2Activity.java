package com.muxistudio.jinyixin.query.mainActivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.muxistudio.jinyixin.query.R;
import com.muxistudio.jinyixin.query.netWork.Api;


public class MainActivity2Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        ListView listView = (ListView) findViewById(R.id.list);
        MyAdapter adapter = new MyAdapter(this);

        Intent receive = getIntent();

        Bundle bundle_receive = receive.getExtras();

        String receive_info = bundle_receive.getString("path");

        String tip = bundle_receive.getString("tip");

        final String path;
        if (tip.equals("username")) {
            path = Api.V2EX_username_URL + receive_info;
        } else {
            path = Api.V2EX_ID_URL + receive_info;
        }

        listView.setAdapter(adapter);
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
