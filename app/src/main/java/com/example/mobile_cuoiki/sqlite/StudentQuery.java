package com.example.mobile_cuoiki.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mobile_cuoiki.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentQuery {
    private Context context;
    private DBHelper databaseHelper;

    private static final String TABLE_NAME_2="student";
    private static final String ID_2="id";
    private static final String NAME_2="name";
    private static final String DOB="dob";
    private static final String HOMETOWN="hometown";
    private static final String SCHOOLYEAR="schoolyear";

    public StudentQuery(Context context) {
        this.context = context;
        this.databaseHelper = new DBHelper(context);
    }
    public void add (Student student){ // thêm sinh viêm
//        SQLiteDatabase db= databaseHelper.getWritableDatabase();
//        ContentValues values= new ContentValues();
//        values.put(NAME_2,student.getName());
//        values.put(DOB,student.getDob());
//        values.put(HOMETOWN,student.getHometown());
//        values.put(SCHOOLYEAR, student.getSchoolyear());
//
//        db.insert(TABLE_NAME_2, null, values);
//        db.close();
        SQLiteDatabase db= databaseHelper.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(ID_2,student.getId());
        values.put(NAME_2,student.getName());
        values.put(DOB,student.getDob());
        values.put(HOMETOWN,student.getHometown());
        values.put(SCHOOLYEAR, student.getSchoolyear());

        db.insert(TABLE_NAME_2,null,values);
        db.close();
    }

    public List<Student> getAll(){
        SQLiteDatabase db= databaseHelper.getReadableDatabase();

        String sqlQuery= "SELECT * FROM "+ TABLE_NAME_2;

        List<Student> studentList= new ArrayList<>();

        Cursor cursor = db.rawQuery(sqlQuery,null);

        if(cursor.moveToFirst())
            while (cursor.moveToNext()){
                Student student =new Student();

                student.setId(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setDob(cursor.getString(2));
                student.setHometown(cursor.getString(3));
                student.setSchoolyear(cursor.getString(4));

                studentList.add(student);
            }
       cursor.close();
       db.close();
       return studentList;


    }
    //    public List<Student> getAll(){  // list sinh viên
////        SQLiteDatabase db= databaseHelper.getReadableDatabase();
////        String sqlQuery = "SELECT * FROM " + TABLE_NAME_2;
////        List<Student> studentList =new ArrayList<>();
////        Cursor cursor = db.rawQuery(sqlQuery,null);
////        if(cursor.moveToFirst()){
////            do{
////                Student student =new Student();
////                student.setId(cursor.getInt(0));
////                student.setName(cursor.getString(1));
////                student.setDob(cursor.getString(2));
////                student.setHometown(cursor.getString(3));
////                student.setSchoolyear(cursor.getString(4));
////
////                studentList.add(student);
////            }while (cursor.moveToNext());
////        }
////        cursor.close();
////        db.close();
////        return studentList;
//
//        SQLiteDatabase db= databaseHelper.getReadableDatabase();
//
//        String sqlQuery ="SELECT * FROM " + TABLE_NAME_2;
//
//        List<Student> studentList =new ArrayList<>();
//        Cursor cursor = db.rawQuery(sqlQuery,null);
//        if(cursor.moveToFirst())
//            while (cursor.moveToNext()){
//                Student student =new Student();
//
//                student.setId(cursor.getInt(0));
//                student.setName(cursor.getString(1));
//                student.setDob(cursor.getString(2));
//                student.setHometown(cursor.getString(3));
//                student.setSchoolyear(cursor.getString(4));
//
//                studentList.add(student);
//            }
//        cursor.close();
//        db.close();
//        return studentList;
//    }

    public List<Student> getStudentsBySchoolYearAndName(String name, String schoolYear) { // tìm kiếm theo tên và năm học
        List<Student> studentList = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        String query ="SELECT * FROM "+ TABLE_NAME_2 + " WHERE " + NAME_2 + " =? AND "+ SCHOOLYEAR+ " =?";
        String[] args = {name, schoolYear};

        Cursor cursor = db.rawQuery(query,args);

        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setDob(cursor.getString(2));
                student.setHometown(cursor.getString(3));
                student.setSchoolyear(cursor.getString(4));

                studentList.add(student);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return studentList;
    }

}
