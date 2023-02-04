package com.example.jadwal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {
    // database: nama dan version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbActivity.db";

    // table & activity column
    private static final String TABLE = "activity";
    private static final String KEY_ID = "id_activity";
    private static final String KEY_NAME = "name";
    private static final String KEY_DATE = "date";
    private static final String KEY_DESC = "description";

    // create table
    private static final String CREATE_TABLE_FAKULTAS = "CREATE TABLE " + TABLE +
            " (" +
            KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME + " STRING NOT NULL, " +
            KEY_DATE + " STRING NOT NULL, " +
            KEY_DESC + " STRING NOT NULL " +
            ")";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_FAKULTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE);
        onCreate(sqLiteDatabase);
    }
}
