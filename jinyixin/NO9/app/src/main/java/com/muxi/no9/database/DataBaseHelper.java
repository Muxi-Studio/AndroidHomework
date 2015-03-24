package com.muxi.no9.database;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 2bab on 14-12-27.
 * 数据库创建封装类
 */
public class DataBaseHelper extends SQLiteOpenHelper{

    private static DataBaseHelper instance = null;
//数据库命名
    private final static String DATABASE_NAME = "project_db";
//数据库版本（在程序发调试过程中如果出错，需要把数据库的内容清除。）
    private final static int DATABASE_VERSION = 1;

    public final static String TABLE_DIARY = "diary";
    public final static String TABLE_NAME = "name";

    //id前面要加下划线
    public final static String KEY_DIARY_ID = "_id";

    public final static String KEY_DIARY_TITLE = "title";
    public final static String KEY_DIARY_CONTENT = "content";
    public final static String KEY_DIARY_DATE = "date";

    public final static String KEY_NAME_ID = "_id";

    public final static String TYPE_TEXT = " TEXT, ";

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);//static????
    }

//获取实例的方法，这样可以减少很多的耗时的过程（判断是否已经有了实例，没有则创建否则就返回之前已经有的实例）
    public static SQLiteDatabase getInstance(Context context){
        if (instance == null){
            instance = new DataBaseHelper(context);
        }
        return instance.getReadableDatabase();
    }

    @Override
    // 建表，给出字段名和类型，TYPE_TEXT只是为了方便些，因为每一句结尾都是“TEXT，”
    public void onCreate(SQLiteDatabase db) {
        String createProjectNameSQL = "CREATE TABLE IF NOT EXISTS " + TABLE_DIARY
                + "(" + KEY_DIARY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_DIARY_TITLE + TYPE_TEXT
                + KEY_DIARY_CONTENT + TYPE_TEXT
                + KEY_DIARY_DATE + " TEXT);";
//执行SQL语句
        db.execSQL(createProjectNameSQL);
    }
//千万注意空格

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //
    }
}