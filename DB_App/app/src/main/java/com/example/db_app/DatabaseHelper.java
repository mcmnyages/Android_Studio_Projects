package com.example.db_app;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";
    private static final String COLUMN_REG_NUMBER = "reg_number";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SCHOOL = "school";
    private static final String COLUMN_DEPARTMENT = "department";
    private static final String COLUMN_COURSE = "course";
    private static final String COLUMN_YEAR = "year";
    private static final String COLUMN_SEMESTER = "semester";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_REG_NUMBER + " TEXT PRIMARY KEY, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_SCHOOL + " TEXT, " +
                COLUMN_DEPARTMENT + " TEXT, " +
                COLUMN_COURSE + " TEXT, " +
                COLUMN_YEAR + " TEXT, " +
                COLUMN_SEMESTER + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addStudent(String regNumber, String name, String school, String department,
                           String course, String year, String semester) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_REG_NUMBER, regNumber);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SCHOOL, school);
        values.put(COLUMN_DEPARTMENT, department);
        values.put(COLUMN_COURSE, course);
        values.put(COLUMN_YEAR, year);
        values.put(COLUMN_SEMESTER, semester);

        return db.insert(TABLE_NAME, null, values);
    }

    public Cursor viewStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        String queryString = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(queryString, null);
        return cursor;
    }

    public boolean updateStudent(String regNumber, String name, String school, String department,
                                 String course, String year, String semester) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_SCHOOL, school);
        values.put(COLUMN_DEPARTMENT, department);
        values.put(COLUMN_COURSE, course);
        values.put(COLUMN_YEAR, year);
        values.put(COLUMN_SEMESTER, semester);

        return db.update(TABLE_NAME, values, COLUMN_REG_NUMBER + "=?", new String[]{regNumber}) > 0;
    }

    public boolean deleteStudent(String regNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COLUMN_REG_NUMBER + "=?", new String[]{regNumber}) > 0;
    }
}