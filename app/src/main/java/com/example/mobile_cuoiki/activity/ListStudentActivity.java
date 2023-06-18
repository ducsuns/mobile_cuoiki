package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        btnSearch.setOnClickListener(new View.OnClickListener() { // onclick nút Tìm kiếm
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
        List<Student> studentList= studentQuery.getAll();
        ListView listStudentView = findViewById(R.id.listStudent);
        ListStudentAdapter adapter=new ListStudentAdapter(ListStudentActivity.this,studentList);

        listStudentView.setAdapter(adapter);

    }
    private void loadListStudentByNameAndYear(String name,String year) { // hiển thị các sinh viên được tìm kiếm theo tên, năm học
        StudentQuery studentQuery = new StudentQuery(getBaseContext());
        List<Student> studentList= studentQuery.getStudentsBySchoolYearAndName(name,year);
        ListView listStudentView = findViewById(R.id.listStudent);
        ListStudentAdapter adapter=new ListStudentAdapter(ListStudentActivity.this,studentList);
        listStudentView.setAdapter(adapter);

    }

}