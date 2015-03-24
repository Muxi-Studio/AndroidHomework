package com.muxi.diary.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2015/1/3.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper instance = null;

    private final static String DATABASE_NAME = "project_db";//数据库名
    private final static int DATABASE_VERSION = 1;//版本号

    public final static String TABLE_DIARY = "diary";//数据库表名,一个数据库中可以有多个表
    public final static String KEY_DIARY_ID = "_id";
    public final static String KEY_DIARY_TITLE = "title";
    public final static String KEY_DIARY_CONTENT = "content";

    public final static String TYPE_TEXT = " TEXT, ";


    public DatabaseHelper(Context context) // 构造函数，调用父类SQLiteOpenHelper的构造函数
    {          super(context, DATABASE_NAME, null, DATABASE_VERSION);   }



    public static SQLiteDatabase getInstance(Context context){
        if (instance == null){
            instance = new DatabaseHelper(context);
        }
        return instance.getReadableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createProjectNameSQL = "CREATE TABLE IF NOT EXISTS " + TABLE_DIARY
                + "(" + KEY_DIARY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_DIARY_TITLE + TYPE_TEXT
                + KEY_DIARY_CONTENT+ " TEXT);";//建表，给出字段名和类型

        db.execSQL(createProjectNameSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
