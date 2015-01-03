package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2015/1/3.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static DatabaseHelper instance = null;

    private final static String DATABASE_NAME = "project_db";
    private final static int DATABASE_VERSION = 1;
//在程序发调试过程中如果出错，需要把数据库的内容清除。

    public final static String TABLE_DIARY = "diary";
    public final static String TABLE_NAME = "name";

    public final static String KEY_DIARY_ID = "_id";
    //id前面要加下划线
    public final static String KEY_DIARY_TITLE = "title";
    public final static String KEY_DIARY_CONTENT = "content";
    public final static String KEY_DIARY_DATE = "date";

    public final static String KEY_NAME_ID = "_id";

    public final static String TYPE_TEXT = " TEXT, ";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static SQLiteDatabase getInstance(Context context){
        if (instance == null){
            instance = new DatabaseHelper(context);
        }
//这样可以减少很多的耗时的过程
        return instance.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createProjectNameSQL = "CREATE TABLE IF NOT EXISTS " + TABLE_DIARY
                + "(" + KEY_DIARY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_DIARY_TITLE + TYPE_TEXT
                + KEY_DIARY_CONTENT + TYPE_TEXT
                + KEY_DIARY_DATE + " TEXT);";

        db.execSQL(createProjectNameSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
