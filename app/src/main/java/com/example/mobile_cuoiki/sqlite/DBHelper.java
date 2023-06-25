package com.example.mobile_cuoiki.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="PTIT";
    private static final int DB_VERSION=1;

    // class
    private static final String TABLE_NAME_1="class";
    private static final String ID_1="id";
    private static final String NAME_1="name";
    private static final String DESCRIPTION_1="description";

    //student
    private static final String TABLE_NAME_2="student";
    private static final String ID_2="id";
    private static final String NAME_2="name";
    private static final String DOB="dob";
    private static final String HOMETOWN="hometown";
    private static final String SCHOOLYEAR="schoolyear";

    //student_class
    private static final String TABLE_NAME_3="studentclass";
    private static final String ID_3="id";
    private static final String ID_STUDENT="idstudent";
    private static final String ID_CLASS="idclass";
    private static final String SEMESTER="semester";
    private static final String CREDIT="credit";



    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // tạo bảng classSql
        String classSql = "CREATE TABLE " + TABLE_NAME_1 + " (" +
                ID_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  // id auto
                NAME_1 + " TEXT, " +
                DESCRIPTION_1 + " TEXT)";

        // tạo bảng studentSql
        String studentSql = "CREATE TABLE " + TABLE_NAME_2 + " (" +
                ID_2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME_2 + " TEXT, " +
                DOB + " TEXT, " +
                HOMETOWN + " TEXT, " +
                SCHOOLYEAR + " TEXT)";



        // Tạo bảng studentclass
        String studentclassSql= "CREATE TABLE "+ TABLE_NAME_3+ " ("+
                ID_3 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ID_STUDENT + " INTEGER, " +
                ID_CLASS + " INTEGER, " +
                SEMESTER + " TEXT, "+
                CREDIT + " TEXT, " +
                "FOREIGN KEY(" + ID_STUDENT + ") REFERENCES "+ TABLE_NAME_2 + "(" + ID_2 + "), " +
                "FOREIGN KEY(" + ID_CLASS + ") REFERENCES "+ TABLE_NAME_1 + "(" + ID_1 + ")" +
                ")";
        sqLiteDatabase.execSQL(studentSql); //lệnh thực thi
        sqLiteDatabase.execSQL(classSql);
        sqLiteDatabase.execSQL(studentclassSql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String classesSql="DROP TABLE IF EXISTS class";
        String studentSql="DROP TABLE IF EXISTS student";
        String studentclassSql="DROP TABLE IF EXISTS studentclass";

        sqLiteDatabase.execSQL(classesSql);
        sqLiteDatabase.execSQL(studentSql);
        sqLiteDatabase.execSQL(studentclassSql);

        onCreate(sqLiteDatabase);
    }
}
