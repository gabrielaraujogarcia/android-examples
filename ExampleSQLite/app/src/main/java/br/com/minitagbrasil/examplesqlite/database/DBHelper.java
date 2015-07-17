package br.com.minitagbrasil.examplesqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ggarcia on 17/07/15.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";

    //general
    public static final String DATABASE_NAME = "example_sqlite.db";
    private static final Integer DATABASE_VERSION = 1;
    private static final String COMMA_SEPARATOR = ", ";
    private static final String SQL_TEXT_TYPE = " TEXT ";
    private static final String SQL_INTEGER_TYPE = " INTEGER ";
    private static final String SQL_NULL = " NULL ";
    private static final String SQL_NOT_NULL = " NOT NULL ";
    private static final String SQL_AUTOINCREMENT = " AUTOINCREMENT ";
    private static final String SQL_PRIMARY_kEY = " PRIMARY KEY ";
    private static final String SQL_CREATE_TABLE_IF_NOT_EXISTIS = " CREATE TABLE IF NOT EXISTS ";

    //table columns
    public static final String TABLE_CAR = "car";
    public static final String COLUMN_CAR_ID = "id";
    public static final String COLUMN_CAR_NAME = "name";
    public static final String COLUMN_CAR_PLATE = "plate";
    public static final String COLUMN_CAR_YEAR = "year";

    //script to create the table
    public static final String CREATE_TABLE_CAR =
                    SQL_CREATE_TABLE_IF_NOT_EXISTIS + TABLE_CAR + " (" +
                    COLUMN_CAR_ID + SQL_INTEGER_TYPE + SQL_PRIMARY_kEY + SQL_AUTOINCREMENT +
                    COLUMN_CAR_NAME + SQL_TEXT_TYPE + SQL_NOT_NULL  + COMMA_SEPARATOR +
                    COLUMN_CAR_PLATE + SQL_TEXT_TYPE + SQL_NOT_NULL + COMMA_SEPARATOR +
                    COLUMN_CAR_YEAR + SQL_INTEGER_TYPE + SQL_NOT_NULL + ")";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "Create database: start");
        db.execSQL(CREATE_TABLE_CAR);
        Log.i(TAG, "Create database: done");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static String[] getCarColumns(){
        return new String[] {COLUMN_CAR_ID, COLUMN_CAR_NAME, COLUMN_CAR_PLATE, COLUMN_CAR_YEAR};
    }
}
