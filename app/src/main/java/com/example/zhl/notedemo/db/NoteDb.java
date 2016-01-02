package com.example.zhl.notedemo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.w3c.dom.ProcessingInstruction;

/**
 * Created by zhl on 2015/12/31.
 */
public class NoteDb {

    private static NoteDb noteDb;
    private static final String DB_NAME = "note_db";
    private static final int VERSION = 1;
    private SQLiteDatabase db;


    private NoteDb(Context context){
        NoteDbHelper noteDbHelper = new NoteDbHelper(context,DB_NAME,null,VERSION);
        db = noteDbHelper.getWritableDatabase();
    }

    public synchronized static NoteDb getInstance(Context context){
        if (noteDb == null){
            noteDb = new NoteDb(context);
        }
        return noteDb;
    }

    //新增便签
    public void saveNote(String tempTitle,String tempContent,String tempDate){
        ContentValues values = new ContentValues();
        values.put("title",tempTitle);
        values.put("content",tempContent);
        values.put("date",tempDate);
        db.insert("note", null, values);
        values.clear();
    }

    //更新便签
    public void updateNote(String tempTitle, String tempContent, String tempDate,String starttempdate){
        ContentValues values = new ContentValues();
        values.put("title",tempTitle);
        values.put("content",tempContent);
        values.put("date", tempDate);
        db.update("note", values, "date = ?", new String[]{starttempdate});
    }

    //查询所有数据库数据（all）
    public Cursor queryAll(){
        return db.query("note",null,null,null,null,null,"date desc");
    }


    //查询所有数据库数据（work）

    //查询所有数据库数据（life）

    //查询所有数据库数据（other）

    //查询所有数据库数据（share）

    //查询所有数据库数据（about）

    //删除选中的数据
    public void delete(String cursorId){
        db.delete("note","_id = ?",new String[]{cursorId});
    }





}
