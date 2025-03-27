package com.example.sqlite_5d9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentGradeDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "students";
    private static final String TABLE_NAME = "StudentGrade";
    private static final String KEY_ID = "rollno";
    private static final String KEY_NAME = "name";
    private static final String KEY_AVG = "avg";
    private static final String KEY_GRADE = "grade";

    public StudentGradeDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_NAME + " TEXT, "
                + KEY_AVG + " REAL, "
                + KEY_GRADE + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, student.getRollno());
        values.put(KEY_NAME, student.getName());
        values.put(KEY_AVG, student.getAvg());
        values.put(KEY_GRADE, student.getGrade());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String getStudent(int rollno) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(TABLE_NAME, new String[]{KEY_ID, KEY_NAME, KEY_AVG, KEY_GRADE},
                KEY_ID + "=?", new String[]{String.valueOf(rollno)}, null, null, null);
        try {
            if (c != null && c.moveToFirst()) {
                int r = c.getInt(0);
                String name = c.getString(1);
                float avg = c.getFloat(2);
                String grade = c.getString(3);
                return "Roll= " + r + "\nName= " + name + "\nAverage= " + avg + "\nGrade= " + grade;
            } else {
                return "No record found";
            }
        } finally {
            if (c != null) c.close();
            db.close();
        }
    }

    public void deleteStudent(int rollno) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID + "=?", new String[]{String.valueOf(rollno)});
        db.close();
    }

    public void updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, student.getName());
        values.put(KEY_AVG, student.getAvg());
        values.put(KEY_GRADE, student.getGrade());
        db.update(TABLE_NAME, values, KEY_ID + "=?", new String[]{String.valueOf(student.getRollno())});
        db.close();
    }
}