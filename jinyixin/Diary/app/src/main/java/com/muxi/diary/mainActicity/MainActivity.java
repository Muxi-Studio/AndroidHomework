package com.muxi.diary.mainActicity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.muxi.diary.R;

import java.util.List;
import java.util.Map;

import database.DatabaseHelper;
import database.ProjectNameDao;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private MyAdapter adapter;
    ProjectNameDao projectNameDao;
    EditText title,item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =(Button)findViewById(R.id.newone);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainContent.class);
                startActivity(intent);
            }
        });

    init();

     listView = (ListView) findViewById(R.id.list);
     adapter = new MyAdapter(this);
     listView.setAdapter(adapter);

    }

    private void init() {
        projectNameDao = new ProjectNameDao(this);
        title = (EditText) findViewById(R.id.list_title);
        item = (EditText) findViewById(R.id.list_item);
        load();
    }
    private void load(){
       List<Map<String ,String >> list = projectNameDao.loadDiary();
        Map<String ,String > map = list.get(0);
        title.setText(map.get(DatabaseHelper.KEY_DIARY_TITLE));
        item.setText(map.get(DatabaseHelper.KEY_DIARY_CONTENT));
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
