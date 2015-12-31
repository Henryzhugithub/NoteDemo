package com.example.zhl.notedemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by zhl on 2015/12/31.
 */
public class NoteDbHelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE = "create table note ("
            +"_id integer primary key autoincrement,"
            +"title text,"
            +"content text,"
            +"date text)";

    public NoteDbHelper(Context context,String name,SQLiteDatabase.CursorFactory cursorFactory,int version){
        super(context,name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);   //创建Note表

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
