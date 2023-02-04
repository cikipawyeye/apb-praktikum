package com.example.databasefakultas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "dbFakultas.db";
    private static final int VERSION = 1;

    // attribute
    private static final String TABLE_NAME = "fakultas";
    private static final String KEY_ID = "id_fk";
    private static final String KEY_NAME = "fk_name";

    // create table
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (" +
            KEY_ID + " STRING PRIMARY KEY, " +
            KEY_NAME + " STRING NOT NULL" +
            ")";

    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
