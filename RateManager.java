package com.example.huilv;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class RateManager {
    private static final String TAG = "db";
    private DBHelper dbHelper;
    private String TB_NAME;

    public RateManager(Context context){
        this.dbHelper = new DBHelper(context);
        this.TB_NAME = DBHelper.TB_NAME;
    }

    public void add(RateItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("curname",item.getCurName());
        values.put("currate",item.getCurRate());
        db.insert(TB_NAME,null,values);
        db.close();
    }
}
