package com.quynhlm.dev.devonthi5.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Db_Helper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DevOnThi5";
    public static final int DATABASE_VERSION = 1;

    public Db_Helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_table_sinhvien = "CREATE TABLE sinhVien (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "Birthday INTEGER NOT NULL," +
                "MSSV TEXT NOT NULL)";
        sqLiteDatabase.execSQL(create_table_sinhvien);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
