package com.muxi.diary.mainActicity;

import android.content.Intent;
import android.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.muxi.diary.R;

import com.muxi.diary.database.DatabaseHelper;
import com.muxi.diary.database.ProjectNameDao;

import java.util.List;
import java.util.Map;

public class MainContent extends ActionBarActivity {

    Button button2;
    EditText editText1, editText2;
    ProjectNameDao projectNameDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainContent.this, MainActivity.class);
                startActivity(intent);
            }
        });

        init();
    }

    private void init() {
        projectNameDao = new ProjectNameDao(this);

        editText1 = (EditText) findViewById(R.id.title);
        editText2 = (EditText) findViewById(R.id.item);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projectNameDao.insertDiary(editText1.getText().toString(),
                        editText2.getText().toString());
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_content, menu);
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
