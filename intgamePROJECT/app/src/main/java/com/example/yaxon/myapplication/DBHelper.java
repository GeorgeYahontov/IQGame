package com.example.yaxon.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by yaxon on 02.11.2016.
 */

    public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bdgame";
    public static final String TABLE_TQESTIONS = "tableqestions";

    public static final String KEY_ID = "_id" ;
    public static final String KEY_QCOLUMN = "question";
    public static final String KEY_ANSWER = "answer";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TQESTIONS + "("+KEY_ID
        + "integer primary key,"+KEY_QCOLUMN + "text"+ KEY_ANSWER +"text" +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TABLE_TQESTIONS);

        onCreate(db);
    }
}
