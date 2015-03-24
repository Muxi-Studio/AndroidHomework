package com.muxi.no9.mainactivity;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.muxi.no9.R;
import com.muxi.no9.database.DataBaseHelper;
import com.muxi.no9.database.ProjectNameDao;

import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {

    EditText title, content, date;
    TextView textView;
    Button saveBtn, loadBtn;
    ProjectNameDao projectNameDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){
        projectNameDao = new ProjectNameDao(this);

        textView = (TextView) findViewById(R.id.main_text);
        title = (EditText) findViewById(R.id.main_title);
        content = (EditText) findViewById(R.id.main_content);
        date = (EditText) findViewById(R.id.main_date);
        saveBtn = (Button) findViewById(R.id.main_save);
        loadBtn = (Button) findViewById(R.id.main_read);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load();
            }
        });
    }

    private void save(){
        //此处需要判断EditText是否为空，是否有非法数值
        projectNameDao.insertDiary(title.getText().toString(),
                content.getText().toString(),
                date.getText().toString());
    }

    private void load(){
        List<Map<String, String>> list = projectNameDao.loadDiary();

        Map<String, String> map = list.get(0);

        //textView.setText(map.get("title"));
        textView.setText(map.get(DataBaseHelper.KEY_DIARY_TITLE));
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