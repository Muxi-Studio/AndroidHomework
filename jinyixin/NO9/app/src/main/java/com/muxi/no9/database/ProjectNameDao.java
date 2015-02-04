package com.muxi.no9.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 2bab on 14-12-27.
 * 数据库接口封装类
 */
public class ProjectNameDao {

    private SQLiteDatabase db;

    public ProjectNameDao(Context context){
//db为获取实例的方法
        db = DataBaseHelper.getInstance(context);
    }
//插入新内容的方法
    public void insertDiary(String title, String content, String date){
        String insertDiarySQL = "INSERT INTO " + DataBaseHelper.TABLE_DIARY
                + " VALUES (NULL, ?, ?, ?)";
        db.execSQL(insertDiarySQL, new String[]{title, content, date});
    }
//传入到数据库
    public List<Map<String, String>> loadDiary(){
        String querySQL = "SELECT * from " + DataBaseHelper.TABLE_DIARY;
        Cursor cursor = db.rawQuery(querySQL, null);

        List<Map<String, String>> list = new ArrayList<>();

        if (cursor.getCount() >= 1){
            while (cursor.moveToNext()){
                Map<String, String> map = new HashMap<>();
                map.put(DataBaseHelper.KEY_DIARY_TITLE,
                        cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_DIARY_TITLE)));
                map.put(DataBaseHelper.KEY_DIARY_CONTENT,
                        cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_DIARY_CONTENT)));
                map.put("date",//名字是可以随便写的啦，我只是要用一个key-value键值对保存东西而已，但是下面的查询是要查询某字段的值，一定要传字段的名字进去啊
                        cursor.getString(cursor.getColumnIndex(DataBaseHelper.KEY_DIARY_DATE)));
                list.add(map);
            }
        }

        return list;
    }

}