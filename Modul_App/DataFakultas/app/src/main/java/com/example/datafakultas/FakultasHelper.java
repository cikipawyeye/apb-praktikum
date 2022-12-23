package com.example.datafakultas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class FakultasHelper {
    private DatabaseHandler dbHandler;

    public FakultasHelper(Context context) {
        this.dbHandler = new DatabaseHandler(context);
    }

    // insert
    public int insert(Fakultas fakultas) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Fakultas.KEY_FK_ID, fakultas.idFk);
        content.put(Fakultas.KEY_FK_NAME, fakultas.namaFk);

        return (int) db.insert(Fakultas.TABLE_FK, null, content);
    }

    // update
    public int update(Fakultas fak) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Fakultas.KEY_FK_ID, fak.idFk);
        content.put(Fakultas.KEY_FK_NAME, fak.namaFk);

        return (int) db.update(Fakultas.TABLE_FK, content, Fakultas.KEY_FK_ID + "=?",
                new String[] {String.valueOf(fak.idFk)});
    }

    // delete
    public boolean delete(String id) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        return db.delete(Fakultas.TABLE_FK, Fakultas.KEY_FK_ID + "='" + id + "'", null) > 0;
    }

    // get data
    public ArrayList<Fakultas> getData() {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ArrayList<Fakultas> listOfFakultas = new ArrayList<Fakultas>();

        String query = "select * from " + Fakultas.TABLE_FK;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        Fakultas fakultas;
        if (cursor.getCount() > 0) {
            do {
                fakultas = new Fakultas();

                fakultas.setIdFk(cursor.getString(cursor.getColumnIndexOrThrow(Fakultas.KEY_FK_ID)));
                fakultas.setNamaFk(cursor.getString(cursor.getColumnIndexOrThrow(Fakultas.KEY_FK_NAME)));

                listOfFakultas.add(fakultas);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return listOfFakultas;
    }

}
