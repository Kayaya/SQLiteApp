package com.example.a1kayat34.sqliteapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

/**
 * Created by 1kayat34 on 20/11/2017.
 */

public class MyHelper extends SQLiteOpenHelper {
    static final int VERSION =1;
    static final String DATABASE_NAME = "musicDB";
    public MyHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Songs (id INTEGER PRIMARY KEY, title VARCHAR(255), artist VARCHAR(255), year VARCHAR(255))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Songs");
        onCreate(db);

    }

    //Add song
    public long insertSong(String title, String artist){

        SQLiteDatabase db = getWritableDatabase();
        Song song = null;

        SQLiteStatement stmt = db.compileStatement
                ("INSERT INTO Songs(title,artist) VALUES (?, ?)");
        stmt.bindString (1, title);
        stmt.bindString (2, artist);
        long id = stmt.executeInsert();
        return id;
    }

    //Find record with id
    public Song findSong(long id){

        Song song = null;
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Songs WHERE id=?",
                new String[] {""+id});
        if(cursor.moveToFirst()){
            song = new Song(cursor.getString(cursor.getColumnIndex("title")),
                    cursor.getString(cursor.getColumnIndex("artist")));
        }
        //Return song object if the song was found or null if it has not.
        return song;
    }

    //Update song details
    public int updateRecord(long id, String title, String artist, long year)
    {
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement
                ("UPDATE Songs SET title=?, artist=?, year=? WHERE id=?");
        stmt.bindString (1,title);
        stmt.bindString (2,title);
        stmt.bindLong (3, year);
        stmt.bindLong (4, id);
        //The number of rows being changed
        int nAffectedRows = stmt.executeUpdateDelete();
        return nAffectedRows;
    }



}
