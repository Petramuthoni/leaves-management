package com.example.splashscreen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE = "LEAVE";
    public static final String TABLENAME = "register";
    public static final String COL1 = "EID";
    public static final String COL2 = "FirstName";
    public static final String COL3 = "LastName";
    public static final String COL4 = "Email";
    public static final String COL5 = "Password";

    public static final String TABLENAME2 = "register";
    public static final String COL6 = "EID";
    public static final String COL7 = "FirstName";
    public static final String COL8= "LastName";
    public static final String COL9 = "Leave SDate";
    public static final String COL10 = "Leave EDate";

    public DataBaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLENAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,EID INTEGER,FirstName TEXT,LastName TEXT,Email TEXT,Password TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLENAME2+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, EID INTEGER,FirstName VARCHAR(255),LastName VARCHAR(255),SDate VARCHAR(255),EDate VARCHAR(255))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
      db.execSQL("DROP TABLE IF EXISTS " + TABLENAME);
      db.execSQL("DROP TABLE IF EXISTS  "+ TABLENAME2);
      onCreate(db);
    }
}
