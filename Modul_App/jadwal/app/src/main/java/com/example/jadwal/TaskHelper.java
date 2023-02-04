package com.example.jadwal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class TaskHelper {
    DatabaseHandler dbHandler;

    TaskHelper(Context context) {
        dbHandler = new DatabaseHandler(context);
    }

    // insert
    public int insert(Task task) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Task.KEY_NAME, task.getName());
        content.put(Task.KEY_DATE, task.getDate());
        content.put(Task.KEY_DESC, task.getDesc());

        return (int) db.insert(Task.TABLE, null, content);
    }

    // get single
    public Task getTask(String id) {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String query = "select * from " + Task.TABLE + " where " + Task.KEY_ID + " = '" + id + "'";

        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();


        Task task = new Task(
                cursor.getString(cursor.getColumnIndexOrThrow(Task.KEY_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Task.KEY_NAME)),
                cursor.getString(cursor.getColumnIndexOrThrow(Task.KEY_DESC)),
                cursor.getString(cursor.getColumnIndexOrThrow(Task.KEY_DATE))
        );

        cursor.close();
        return task;
    }

    // update
    public int update(Task task) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Task.KEY_ID, task.getId());
        content.put(Task.KEY_NAME, task.getName());
        content.put(Task.KEY_DATE, task.getDate());
        content.put(Task.KEY_DESC, task.getDesc());

        return (int) db.update(Task.TABLE, content, Task.KEY_ID + "=?",
                new String[] {String.valueOf(task.getId())});
    }

    // delete
    public boolean delete(String id) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();

        return db.delete(Task.TABLE, Task.KEY_ID + "='" + id + "'", null) > 0;
    }

    // get data
    public ArrayList<Task> getData() {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        ArrayList<Task> listOfTask = new ArrayList<Task>();

        String query = "select * from " + Task.TABLE;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        Task task;
        if (cursor.getCount() > 0) {
            do {
                task = new Task();

                task.setId(cursor.getString(cursor.getColumnIndexOrThrow(Task.KEY_ID)));
                task.setName(cursor.getString(cursor.getColumnIndexOrThrow(Task.KEY_NAME)));
                task.setDate(cursor.getString(cursor.getColumnIndexOrThrow(Task.KEY_DATE)));
                task.setDesc(cursor.getString(cursor.getColumnIndexOrThrow(Task.KEY_DESC)));

                listOfTask.add(task);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return listOfTask;
    }
}
