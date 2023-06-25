package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.adapter.ListStudentAdapter;
import com.example.mobile_cuoiki.model.Student;
import com.example.mobile_cuoiki.sqlite.StudentDAO;

import java.util.List;

public class ListStudentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);
        loadListStudent();
        Button btnSearch =findViewById(R.id.btnSearch);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edtName= findViewById(R.id.edtSearchName);
                EditText edtYear= findViewById(R.id.edtSearchYear);

                String name= edtName.getText().toString();
                String year= edtYear.getText().toString();

                loadListStudentByNameAndYear(name,year);
            }
        });


    }
    private void loadListStudent() {
        StudentDAO studentDAO = new StudentDAO(getBaseContext());
        List<Student> studentList= studentDAO.getAll();
        ListView listStudentView = findViewById(R.id.listStudent);


        ListStudentAdapter adapter=new ListStudentAdapter(ListStudentActivity.this,studentList);

        listStudentView.setAdapter(adapter);

    }
    private void loadListStudentByNameAndYear(String name,String year) {
        StudentDAO studentDAO = new StudentDAO(getBaseContext());
        List<Student> studentList= studentDAO.getStudentsBySchoolYearAndName(name,year);
        ListView listStudentView = findViewById(R.id.listStudent);


        ListStudentAdapter adapter=new ListStudentAdapter(ListStudentActivity.this,studentList);
        listStudentView.setAdapter(adapter);

    }

}