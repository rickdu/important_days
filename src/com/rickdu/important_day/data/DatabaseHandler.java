package com.rickdu.important_day.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IntelliJ IDEA.
 * User: Rick
 * Date: 3/10/12
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseHandler {

    private static final String DB_NAME = "important_day.db";
    private static final String DB_TABLE = "important_day";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "_name";
    public static final String KEY_TYPE = "_type";
    public static final String KEY_YEAR = "_year";
    public static final String KEY_MONTH = "_month";
    public static final String KEY_DAY = "_day";
    public static final String KEY_COMMENT = "_comment";
    public static final String KEY_TAG = "_tag";

    private static final String TABLE_CREATE = "CREATE TABLE " + DB_TABLE + " (" +
            KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME + " VARCHAR(1000), " +
            KEY_TYPE + " VARCHAR(20), " +
            KEY_YEAR + " INTEGER, " +
            KEY_MONTH + " INTEGER, " +
            KEY_DAY + " INTEGER, " +
            KEY_COMMENT + " VARCHAR(1000), " +
            KEY_TAG + " VARCHAR(20)" +
            ")";

    private SQLiteDatabase db = null;
    private Context context = null;

    private DatabaseHelper dbHelper = null;

    private static final int VERSION = 2;

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DB_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
        }
    }

    public DatabaseHandler(Context context) {
        this.context = context;
    }

    public void open() {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public Cursor findAll() {
        return db.query(DB_TABLE,
                new String[]{KEY_ID, KEY_NAME, KEY_TYPE, KEY_YEAR, KEY_MONTH, KEY_DAY, KEY_COMMENT, KEY_TAG},
                null, null, null, null, null);
    }

    public long insert(EventModel model) {
        return db.insert(DB_TABLE, KEY_ID, this.toContentValues(model));
    }

    public ContentValues toContentValues(EventModel model) {
        ContentValues cv = new ContentValues();
        if (model.getId() != -1)
            cv.put(KEY_ID, model.getId());
        cv.put(KEY_NAME, model.getName());
        cv.put(KEY_TYPE, model.getType());
        cv.put(KEY_YEAR, model.getYear());
        cv.put(KEY_MONTH, model.getMonth());
        cv.put(KEY_DAY, model.getDay());
        cv.put(KEY_COMMENT, model.getComment());
        cv.put(KEY_TAG, model.getTag());
        return cv;
    }
}
