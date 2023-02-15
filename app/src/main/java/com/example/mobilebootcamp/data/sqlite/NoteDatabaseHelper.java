package com.example.mobilebootcamp.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mobilebootcamp.models.content.Note;

import java.util.ArrayList;

public class NoteDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes.db";
    private static final String TABLE_NAME = "notes";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CONTENT = "content";

    public NoteDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_CONTENT + " TEXT)";
        db.execSQL(createTableQuery);

    }
    public void deleteNoteById(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME , "id = ?" , new String[] {String.valueOf(id)});
        sqLiteDatabase.close();
    }
    public void addNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CONTENT, note.getContent());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<Note> getAllNotes(){
        ArrayList<Note> employeeList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME , null );
        if (cursor.moveToFirst()){
            do{
                employeeList.add(new Note(cursor.getInt(0) , cursor.getString(1) ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return employeeList;
    }

}
