package com.example.user.imagesavedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "user_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "users";
    private static final String KEY_ID = "id";

    private static final String KEY_JENISADUAN = "jenisaduan";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_ALAMAT = "alamat";
    private static final String KEY_TELEFON= "telefon";
    private static final String KEY_EMEL = "emel";
    private static final String KEY_TARIKH = "tarikh";
    private static final String KEY_ADUAN = "aduan";
    private static final String KEY_IMAGE = "image";

    /*CREATE TABLE students ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,
   phone_number TEXT......);*/
    private static final String CREATE_TABLE_BARU = "CREATE TABLE "
            + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_JENISADUAN  + " TEXT, "+ KEY_NAMA + " TEXT, "+ KEY_ALAMAT + " TEXT, "+
            KEY_TELEFON + " TEXT, "+ KEY_EMEL + " TEXT, "+ KEY_TARIKH + " TEXT, "+ KEY_ADUAN + " TEXT, " + KEY_IMAGE  + " BLOB );";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("table", CREATE_TABLE_BARU);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BARU);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        onCreate(db);
    }
    public long addUserDetail(String jenisaduan, String nama, String alamat, String telefon, String emel, String tarikh, String aduan, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(KEY_JENISADUAN, jenisaduan);
        values.put(KEY_NAMA, nama);
        values.put(KEY_ALAMAT, alamat);
        values.put(KEY_TELEFON, telefon);
        values.put(KEY_EMEL, emel);
        values.put(KEY_TARIKH, tarikh);
        values.put(KEY_ADUAN, aduan);
        values.put(KEY_IMAGE, image);
        // insert row in students table
        long insert = db.insert(TABLE_USER, null, values);
        return insert;
    }
    public ArrayList<UserModel> getAllUsers() {
        ArrayList<UserModel> userModelArrayList = new ArrayList<UserModel>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                UserModel userModel = new UserModel();
                userModel.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                userModel.setJenisaduan(c.getString(c.getColumnIndex(KEY_JENISADUAN)));
                userModel.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
                userModel.setAlamat(c.getString(c.getColumnIndex(KEY_ALAMAT)));
                userModel.setTelefon(c.getString(c.getColumnIndex(KEY_TELEFON)));
                userModel.setEmel(c.getString(c.getColumnIndex(KEY_EMEL)));
                userModel.setTarikh(c.getString(c.getColumnIndex(KEY_TARIKH)));
                userModel.setAduan(c.getString(c.getColumnIndex(KEY_ADUAN)));

                userModel.setImage2(c.getBlob(c.getColumnIndex(KEY_IMAGE)));

                // adding to Students list
                userModelArrayList.add(userModel);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }
    public int updateUser(int id, String jenisaduan, String nama, String alamat , String telefon, String emel, String tarikh, String aduan, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();

        values.put(KEY_JENISADUAN, jenisaduan);
        values.put(KEY_NAMA, nama);
        values.put(KEY_ALAMAT, alamat);
        values.put(KEY_TELEFON, telefon);
        values.put(KEY_EMEL, emel);
        values.put(KEY_TARIKH, tarikh);
        values.put(KEY_ADUAN, aduan);
        values.put(KEY_IMAGE, image);

        // update row in students table base on students.is value
        return db.update(TABLE_USER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
    public void deleteUSer(int id) {
        // delete row in students table based on id
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
}
