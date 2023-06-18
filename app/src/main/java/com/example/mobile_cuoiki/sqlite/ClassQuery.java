package com.example.mobile_cuoiki.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mobile_cuoiki.model.Classes;

import java.util.ArrayList;
import java.util.List;

public class ClassQuery {
    private Context context;
    private DBHelper databaseHelper;

    private static final String TABLE_NAME_1="class";
    private static final String ID_1="id";
    private static final String NAME_1="name";
    private static final String DESCRIPTION_1="description";

    public ClassQuery(Context context) {
        this.context = context;
        this.databaseHelper = new DBHelper(context);
    }
    public void add (Classes classes){   // thêm lớp
        SQLiteDatabase db= databaseHelper.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(NAME_1,classes.getName());
        values.put(DESCRIPTION_1, classes.getDescription());

        db.insert(TABLE_NAME_1, null, values);
        db.close();
    }
    public List<Classes> getAll(){  // list lớp
        SQLiteDatabase db= databaseHelper.getReadableDatabase();
        String sqlQuery = "SELECT * FROM " + TABLE_NAME_1;
        List<Classes> classList =new ArrayList<>();
        Cursor cursor = db.rawQuery(sqlQuery,null);
        if(cursor.moveToFirst()){
            do{
                Classes classes = new Classes();
                classes.setId(cursor.getInt(0));
                classes.setName(cursor.getString(1));
                classes.setDescription(cursor.getString(2));

                classList.add(classes);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return classList;
    }
}
