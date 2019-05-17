package com.example.newopedia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String nama, String jenis_kelamin, String bounty, String anggota, String posisi, String haki, String buah_iblis, String tipe_buah, String biografi, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO KARAKTER VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, nama);
        statement.bindString(2, jenis_kelamin);
        statement.bindString(3, bounty);
        statement.bindString(4, anggota);
        statement.bindString(5, posisi);
        statement.bindString(6, haki);
        statement.bindString(7, buah_iblis);
        statement.bindString(8, tipe_buah);
        statement.bindString(9, biografi);
        statement.bindBlob(10, image);

        statement.executeInsert();
    }

    public void updateData(String nama, String jenis_kelamin, String bounty, String anggota, String posisi, String haki, String buah_iblis, String tipe_buah, String biografi, byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE KARAKTER SET nama = ?, jenis_kelamin = ?, bounty=? , anggota=? ,posisi=?, haki=?, buah_iblis=?, tipe_buah=?,biografi=?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, nama);
        statement.bindString(2, jenis_kelamin);
        statement.bindString(3, bounty);
        statement.bindString(4, anggota);
        statement.bindString(5, posisi);
        statement.bindString(6, haki);
        statement.bindString(7, buah_iblis);
        statement.bindString(8, tipe_buah);
        statement.bindString(9, biografi);
        statement.bindBlob(10, image);
        statement.bindDouble(11, (double)id);

        statement.execute();
        database.close();
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM KARAKTER WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
