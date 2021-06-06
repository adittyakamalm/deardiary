package com.example.dairyapp.view;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
//Tanggal Pengerjaan : 02 - 06 - 2021
//NIM                : 10118337
//NAMA               : ADITTYA KAMAL M
//KELAS              : IF - 8

public class DiaryDatabase extends SQLiteOpenHelper {

    private static  final  int DATABASE_VERSION = 3;
    private static  final String DATABASE_NAME = "diarydb";
    private static  final String DATABASE_TABLE = "diarytable";

    // Nama kolom database
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "Judul";
    private static final String KEY_CONTENT = "isi";
    private static final String KEY_DATE = "tanggal";
    private static final String KEY_TIME = "waktu";

    DiaryDatabase(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+DATABASE_TABLE+" ("+
                KEY_ID+" INTEGER PRIMARY KEY,"+
                KEY_TITLE+" TEXT,"+
                KEY_CONTENT+" TEXT,"+
                KEY_DATE+" TEXT,"+
                KEY_TIME+" TEXT"
                +" )";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }

    public long tambahDiary(Diary diary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(KEY_TITLE, diary.getJudul());
        c.put(KEY_CONTENT, diary.getIsi());
        c.put(KEY_DATE, diary.getDate());
        c.put(KEY_TIME, diary.getTime());

        long ID = db.insert(DATABASE_TABLE, null, c);
        Log.d("Inserted", "ID = > " + ID);
        return ID;
    }

    public Diary getDiary(long id){
        // select * from diarytable where id=1
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DATABASE_TABLE,new String[]{KEY_ID,KEY_TITLE,KEY_CONTENT,KEY_DATE,KEY_TIME}, KEY_ID+"=?",
                new String[]{String.valueOf(id)}, null,null,null);

        if(cursor != null)
            cursor.moveToFirst();
            return new Diary(cursor.getLong(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4));
    }

    public List<Diary> getDiary(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Diary> allDiary = new ArrayList<>();
        // select * from databaseName
        String query = "SELECT * FROM " +DATABASE_TABLE;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do {
                Diary diary = new Diary();
                diary.setID(cursor.getLong(0));
                diary.setJudul(cursor.getString(1));
                diary.setIsi(cursor.getString(2));
                diary.setDate(cursor.getString(3));
                diary.setTime(cursor.getString(4));

                allDiary.add(diary);

            } while (cursor.moveToNext());
        }
        return allDiary;
    }

    public int editDiary(Diary diary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        Log.d("Edited","Edited Title : => "+diary.getJudul()+"\n ID => "+diary.getID());
        c.put(KEY_TITLE,diary.getJudul());
        c.put(KEY_CONTENT,diary.getIsi());
        c.put(KEY_DATE,diary.getDate());
        c.put(KEY_TIME,diary.getTime());

        return db.update(DATABASE_TABLE,c,KEY_ID+"=?",new String[]{String.valueOf(diary.getID())});
    }

    void deleteDiary (long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE, KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }
}
