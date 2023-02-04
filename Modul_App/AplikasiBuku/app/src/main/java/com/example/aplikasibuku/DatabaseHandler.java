package com.example.aplikasibuku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "dbBuku.db";
    private static final int VERSION = 1;

    // attribute
    private static final String TABLE_NAME = "buku";
    private static final String KEY_ID = "id_book";
    private static final String KEY_TITLE = "book_title";
    private static final String KEY_AUTHOR = "book_author";
    private static final String KEY_YEAR = "book_year";

    // create table
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (" +
            KEY_ID + " STRING PRIMARY KEY, " +
            KEY_TITLE + " STRING NOT NULL, " +
            KEY_AUTHOR + " STRING NOT NULL, " +
            KEY_YEAR + " YEAR NOT NULL" +
            ")";

    public DatabaseHandler(@Nullable Context context) {
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
