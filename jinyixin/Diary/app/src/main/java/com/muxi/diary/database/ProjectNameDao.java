package com.muxi.diary.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2015/1/3.
 */
public class ProjectNameDao {
    private SQLiteDatabase db;

    public ProjectNameDao(Context context) {
        db = DatabaseHelper.getInstance(context);
    }

    public void insertDiary(String title, String content) {
        String insertDiarySQL = "INSERT INTO " + DatabaseHelper.TABLE_DIARY
                + " VALUES (NULL, ?, ?)";
        db.execSQL(insertDiarySQL, new String[]{title, content});
    }

    public List<Map<String, String>> loadDiary() {
        String querySQL = "SELECT * from " + DatabaseHelper.TABLE_DIARY;
        Cursor cursor = db.rawQuery(querySQL, null);

        List<Map<String, String>> list = new ArrayList<>();

        if (cursor.getCount() >= 1) {
            while (cursor.moveToNext()) {
                Map<String, String> map = new HashMap<>();
                map.put(DatabaseHelper.KEY_DIARY_TITLE,
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_DIARY_TITLE)));
                map.put(DatabaseHelper.KEY_DIARY_CONTENT,
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.KEY_DIARY_CONTENT)));
                list.add(map);
            }
        }

        return list;
    }
}
