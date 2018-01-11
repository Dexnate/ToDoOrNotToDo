package fr.mk.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Formation on 11/01/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "tache_database";
    private static final int DATABASE_VERSION = 1;

    private static final String TACHE_TABLE_SQL ="CREATE TABLE taches("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "name TEXT,"+
            "checked Integer NOT NULL)";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }





    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TACHE_TABLE_SQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS taches");
        this.onCreate(db);

    }
}
