package com.example.nicols.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BDUsuarios extends SQLiteOpenHelper{
    String sqlCreate = ("create table Usurios (usuario text, password text, nombre text)");

        public BDUsuarios(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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
