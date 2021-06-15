package com.example.huilv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="myrate.db";
    public static final String TB_NAME="rate";
    public static final int DB_VERSION=1;
    private String sql;

    public DBHelper(@Nullable Context context){
        super(context,DB_NAME,null,DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String aql = "CREATE TABLE"+TB_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,CURNAME TEXT,CURRATE TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
