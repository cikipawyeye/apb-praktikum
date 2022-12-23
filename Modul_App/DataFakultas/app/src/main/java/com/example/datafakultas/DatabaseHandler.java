package com.example.datafakultas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    // database: nama dan version
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dbFakultas.db";

    // table & activity column
    private static final String TABLE_FK = "fakultas";
    private static final String KEY_FK_ID = "id_fk";
    private static final String KEY_FK_NAME = "fk_name";

    // create table
    private static final String CREATE_TABLE_FAKULTAS = "CREATE TABLE " + TABLE_FK +
            " (" + KEY_FK_ID + " STRING PRIMARY KEY, " +
            KEY_FK_NAME + " STRING NOT NULL)";

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
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_FK);
        onCreate(sqLiteDatabase);
    }
}
