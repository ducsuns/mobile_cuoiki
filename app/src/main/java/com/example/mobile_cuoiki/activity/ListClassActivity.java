package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.adapter.ListClassAdapter;
import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.readwrite.ReadWriteClass;
import com.example.mobile_cuoiki.sqlite.ClassQuery;

import java.util.ArrayList;
import java.util.List;

public class ListClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_class);
        loadListClass();
    }
    private void loadListClass() { // hiển thị tất cả các class

        ReadWriteClass readWriteClass =new ReadWriteClass(getApplicationContext());

        List<Classes> classesList =readWriteClass.readClass(getApplicationContext(),"class.txt");

        ListView listView=findViewById(R.id.listClass);

//        ArrayAdapter<Classes> adapter =new ArrayAdapter<>(ListClassActivity.this, android.R.layout.simple_list_item_1,classesList);

        ListClassAdapter adapter=new ListClassAdapter(ListClassActivity.this,classesList);

        listView.setAdapter(adapter);

    }
}