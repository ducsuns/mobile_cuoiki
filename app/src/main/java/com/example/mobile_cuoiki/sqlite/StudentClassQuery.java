package com.example.mobile_cuoiki.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.model.Student;
import com.example.mobile_cuoiki.model.StudentClass;

import java.util.ArrayList;
import java.util.List;

public class StudentClassQuery {

    private Context context;
    private DBHelper databaseHelper;
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
    // student_class
    private static final String TABLE_NAME_3="studentclass";
    private static final String ID_3="id";
    private static final String ID_STUDENT="idstudent";
    private static final String ID_CLASS="idclass";
    private static final String SEMESTER="semester";
    private static final String CREDIT="credit";

    public StudentClassQuery(Context context) {
        this.context = context;
        this.databaseHelper = new DBHelper(context);
    }

    public void add (StudentClass studentClass){  // đăng kí
//        SQLiteDatabase db= databaseHelper.getWritableDatabase();
//        ContentValues values= new ContentValues();
//        values.put(ID_STUDENT,studentClass.getIdStudent());
//        values.put(ID_CLASS, studentClass.getIdClass());
//        values.put(SEMESTER,studentClass.getSemester());
//        values.put(CREDIT, studentClass.getCredit());
//
//        db.insert(TABLE_NAME_3, null, values);
//        db.close();

        SQLiteDatabase db= databaseHelper.getWritableDatabase();

        ContentValues values =new ContentValues();

        values.put(ID_STUDENT,studentClass.getIdStudent());
        values.put(ID_CLASS,studentClass.getIdClass());
        values.put(SEMESTER,studentClass.getSemester());
        values.put(CREDIT,studentClass.getCredit());

        db.insert(TABLE_NAME_3,null,values);
        db.close();

    }
//    public List<StudentClass> getAll(){
//        SQLiteDatabase db= databaseHelper.getReadableDatabase();
//        String sqlQuery = "SELECT * FROM " + TABLE_NAME_3;
//        List<StudentClass> studentClasstList =new ArrayList<>();
//        Cursor cursor = db.rawQuery(sqlQuery,null);
//        if(cursor.moveToFirst()){
//            do{
//                StudentClass studentClass=new StudentClass();
//                studentClass.setId(cursor.getInt(0));
//                studentClass.setIdStudent(cursor.getInt(1));
//                studentClass.setIdClass(cursor.getInt(2));
//                studentClass.setSemester(cursor.getString(3));
//                studentClass.setCredit(cursor.getInt(4));
//
//                studentClasstList.add(studentClass);
//            }while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return studentClasstList;
//    }
    @SuppressLint("Range")
    public List<Classes> getClassesRegister() {  // list lớp đã được đăng kí
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String sqlQuery = "SELECT DISTINCT " + TABLE_NAME_1 + ".* " +
                "FROM " + TABLE_NAME_1 + " " +
                "INNER JOIN " + TABLE_NAME_3 + " ON " + TABLE_NAME_1 + "." + ID_1 + " = " + TABLE_NAME_3 + "." + ID_CLASS;

        List<Classes> classList = new ArrayList<>();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Classes classes = new Classes();

                classes.setId(cursor.getInt(cursor.getColumnIndex(ID_1)));
                classes.setName(cursor.getString(cursor.getColumnIndex(NAME_1)));
                classes.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION_1)));
                classList.add(classes);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return classList;
    }

//    public List<Classes> getAllClasses() {
//        SQLiteDatabase db = databaseHelper.getReadableDatabase();
//
//        String sqlQuery = "SELECT " + TABLE_NAME_1 + ".* " +
//                "FROM " + TABLE_NAME_1 + " " +
//                "INNER JOIN " + TABLE_NAME_3 + " ON " + TABLE_NAME_1 + "." + ID_1 + " = " + TABLE_NAME_3 + "." + ID_CLASS;
//
//        List<Classes> classList = new ArrayList<>();
//        Cursor cursor = db.rawQuery(sqlQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                Classes classes = new Classes();
//                classes.setId(cursor.getInt(cursor.getColumnIndex(ID_1)));
//                classes.setName(cursor.getString(cursor.getColumnIndex(NAME_1)));
//                classes.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION_1)));
//                classList.add(classes);
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        db.close();
//        return classList;
//    }


    @SuppressLint("Range")
    public List<Student> getStudentsByClassID(int classID) { // list sinh viên đã đăng kí, thông kê theo lớp, sắp xếp giảm dần theo id
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

//        String sqlQuery = "SELECT " + TABLE_NAME_2 + ".* " +
//                "FROM " + TABLE_NAME_2 + " " +
//                "INNER JOIN " + TABLE_NAME_3 + " ON " + TABLE_NAME_2 + "." + ID_2 + " = " + TABLE_NAME_3 + "." + ID_STUDENT + " " +
//                "WHERE " + TABLE_NAME_3 + "." + ID_CLASS + " = ?";
        String sqlQuery = "SELECT " + TABLE_NAME_2 + ".* " +
                "FROM " + TABLE_NAME_2 + " " +
                "INNER JOIN " + TABLE_NAME_3 + " ON " + TABLE_NAME_2 + "." + ID_2 + " = " + TABLE_NAME_3 + "." + ID_STUDENT + " " +
                "WHERE " + TABLE_NAME_3 + "." + ID_CLASS + " = ? " +
                "ORDER BY " + TABLE_NAME_2 + "." + ID_2 + " DESC";


        List<Student> studentList = new ArrayList<>();
        Cursor cursor = db.rawQuery(sqlQuery, new String[]{String.valueOf(classID)});

        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setId(cursor.getInt(cursor.getColumnIndex(ID_2)));
                student.setName(cursor.getString(cursor.getColumnIndex(NAME_2)));
                student.setDob(cursor.getString(cursor.getColumnIndex(DOB)));
                student.setHometown(cursor.getString(cursor.getColumnIndex(HOMETOWN)));
                student.setSchoolyear(cursor.getString(cursor.getColumnIndex(SCHOOLYEAR)));

                studentList.add(student);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return studentList;
    }
//
//    @SuppressLint("Range")
//    public List<Student> getStudentsDescById() {
//        SQLiteDatabase db = databaseHelper.getReadableDatabase();
//        List<Student> studentList = new ArrayList<>();
//        String sqlQuery = "SELECT * FROM " + TABLE_NAME_2 + " ORDER BY " + ID_2 + " DESC";
//        Cursor cursor = db.rawQuery(sqlQuery, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                Student student = new Student();
//                student.setId(cursor.getInt(cursor.getColumnIndex(ID_2)));
//                student.setName(cursor.getString(cursor.getColumnIndex(NAME_2)));
//                student.setDob(cursor.getString(cursor.getColumnIndex(DOB)));
//                student.setHometown(cursor.getString(cursor.getColumnIndex(HOMETOWN)));
//                student.setSchoolyear(cursor.getString(cursor.getColumnIndex(SCHOOLYEAR)));
//                studentList.add(student);
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        db.close();
//
//        return studentList;
//    }






}
