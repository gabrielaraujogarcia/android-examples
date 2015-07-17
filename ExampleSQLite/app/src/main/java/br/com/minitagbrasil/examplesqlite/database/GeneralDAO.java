package br.com.minitagbrasil.examplesqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ggarcia on 17/07/15.
 */
public class GeneralDAO {

    protected Context context;
    protected DBHelper dbHelper;
    protected SQLiteDatabase database;

    public GeneralDAO(Context context) {
        this.context = context;
        this.dbHelper = new DBHelper(context);
        this.openConnection();
    }

    protected void openConnection() {
        this.database = dbHelper.getWritableDatabase();
    }

//    protected void closeConnection() {
//        dbHelper.close();
//    }

}
