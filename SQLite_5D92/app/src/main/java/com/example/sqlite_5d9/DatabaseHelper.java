package com.example.sqlite_5d9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "StudentDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";
    private static final String COL_ROLL = "roll";
    private static final String COL_NAME = "name";
    private static final String COL_AVG = "avg";
    private static final String COL_GRADE = "grade";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ROLL + " TEXT PRIMARY KEY, " +
                COL_NAME + " TEXT, " +
                COL_AVG + " TEXT, " +
                COL_GRADE + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert a student
    public boolean insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ROLL, student.getRoll());
        values.put(COL_NAME, student.getName());
        values.put(COL_AVG, student.getAvg());
        values.put(COL_GRADE, student.getGrade());
        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result != -1; // Return true if insert successful
    }

    // Get a student by roll number
    public Student getStudent(String roll) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COL_ROLL, COL_NAME, COL_AVG, COL_GRADE},
                COL_ROLL + "=?",
                new String[]{roll}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            Student student = new Student(
                    cursor.getString(0), // roll
                    cursor.getString(1), // name
                    cursor.getString(2), // avg
                    cursor.getString(3)  // grade
            );
            cursor.close();
            return student;
        }
        if (cursor != null) cursor.close();
        return null;
    }

    // Update a student
    public boolean updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, student.getName());
        values.put(COL_AVG, student.getAvg());
        values.put(COL_GRADE, student.getGrade());
        int result = db.update(TABLE_NAME, values, COL_ROLL + "=?",
                new String[]{student.getRoll()});
        db.close();
        return result > 0; // Return true if update successful
    }

    // Delete a student
    public boolean deleteStudent(String roll) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_NAME, COL_ROLL + "=?",
                new String[]{roll});
        db.close();
        return result > 0; // Return true if delete successful
    }
}