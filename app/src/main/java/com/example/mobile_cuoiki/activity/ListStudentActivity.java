package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.adapter.ListClassAdapter;
import com.example.mobile_cuoiki.adapter.ListStudentAdapter;
import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.model.Student;
import com.example.mobile_cuoiki.sqlite.ClassQuery;
import com.example.mobile_cuoiki.sqlite.StudentQuery;

import java.util.List;

public class ListStudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);
        loadListStudent();
        Button btnSearch =findViewById(R.id.btnSearch);


        // onclick nút Tìm kiếm
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edtName= findViewById(R.id.edtSearchName);
                EditText edtYear= findViewById(R.id.edtSearchYear);

                String name= edtName.getText().toString(); // lấy dữ liệu từ EditText
                String year= edtYear.getText().toString();

                loadListStudentByNameAndYear(name,year);
            }
        });


    }
    private void loadListStudent() {  // hiển thị tất cả sinh viên, tương tự ListClass
        StudentQuery studentQuery = new StudentQuery(getBaseContext());
        List<Student> studentList= studentQuery.getAll(); // xem lại StudentQuery
        ListView listStudentView = findViewById(R.id.listStudent);

        ArrayAdapter<Student> adapter=new ArrayAdapter<>(ListStudentActivity.this, android.R.layout.simple_list_item_1,studentList);

//        ListStudentAdapter adapter=new ListStudentAdapter(ListStudentActivity.this,studentList);

        listStudentView.setAdapter(adapter);// set adapter cho view

    }
    private void loadListStudentByNameAndYear(String name,String year) { // hiển thị các sinh viên được tìm kiếm theo tên, năm học
        StudentQuery studentQuery = new StudentQuery(getBaseContext());
        List<Student> studentList= studentQuery.getStudentsBySchoolYearAndName(name,year);
        ListView listStudentView = findViewById(R.id.listStudent);

        ArrayAdapter<Student> adapter=new ArrayAdapter<>(ListStudentActivity.this, android.R.layout.simple_list_item_1,studentList);// truyền studentlist và adapter.Đây là adapter có sẵn, sử dụng layout
        // simple_list_item_1.xml có sẵn của android, lưu ý cần toString() ở model.Đc cái là nhah chứ không custom đc

//        ListStudentAdapter adapter=new ListStudentAdapter(ListStudentActivity.this,studentList); // này là adapter tự custom. Lâu hơn cái dùng sẵn
        listStudentView.setAdapter(adapter); // set adapter cho view

    }

}