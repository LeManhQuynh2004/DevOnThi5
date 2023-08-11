package com.quynhlm.dev.devonthi5.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.quynhlm.dev.devonthi5.Database.Db_Helper;
import com.quynhlm.dev.devonthi5.Model.SinhVien;

import java.util.ArrayList;

public class SinhVienDao {
    Db_Helper dbHelper;

    public SinhVienDao(Context context) {
        dbHelper = new Db_Helper(context);
    }

    public boolean insertData(SinhVien sinhVien) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",sinhVien.getId());
        contentValues.put("name", sinhVien.getName());
        contentValues.put("Birthday", sinhVien.getBirthday());
        contentValues.put("MSSV", sinhVien.getMSSV());
        long check = sqLiteDatabase.insert("sinhVien", null, contentValues);
        return check > 0;
    }

    public boolean DeleteData(SinhVien sinhVien) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String dk[] = {String.valueOf(sinhVien.getId())};
        long check = sqLiteDatabase.delete("sinhVien", "id=?", dk);
        return check > 0;
    }

    public boolean UpdateData(SinhVien sinhVien) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        String dk[] = {String.valueOf(sinhVien.getId())};
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", sinhVien.getName());
        contentValues.put("Birthday", sinhVien.getBirthday());
        contentValues.put("MSSV", sinhVien.getMSSV());
        long check = sqLiteDatabase.update("sinhVien", contentValues, "id=?", dk);
        return check > 0;
    }

    public ArrayList<SinhVien> selectAll() {
        ArrayList<SinhVien> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM sinhVien", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new SinhVien(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        return list;
    }
}
