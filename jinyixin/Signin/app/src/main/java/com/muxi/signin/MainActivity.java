package com.muxi.signin;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;

import java.lang.ref.Reference;


public class MainActivity extends ActionBarActivity {
    NumberPicker year,month,day;
    int maxyear =2010;
    int minyear =1970;
    int maxmonth= 12;
    int minmonth= 1;
    int maxday=31;
    int minday=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        year = (NumberPicker) findViewById(R.id.year);
        month = (NumberPicker) findViewById(R.id.month);
        day = (NumberPicker) findViewById(R.id.day);
        year.setMaxValue(2010);
        month.setMaxValue(12);
        day.setMaxValue(31);
        year.setMinValue(1970);
        month.setMinValue(1);
        day.setMinValue(1);
        year.setValue(1970);
        month.setValue(1);
        day.setValue(1);
        Button bn = (Button) findViewById(R.id.submit);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

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
