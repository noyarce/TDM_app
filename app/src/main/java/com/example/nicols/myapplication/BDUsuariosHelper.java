package com.example.nicols.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BDUsuariosHelper extends SQLiteOpenHelper{
    String sqlCreate = ("create table usuarios (username text, password text, name text)");

        public BDUsuariosHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE USUARIOS IF EXISTS");
    db.execSQL(sqlCreate);
    }
}
