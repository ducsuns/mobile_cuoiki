package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.adapter.ListStudentAdapter;
import com.example.mobile_cuoiki.model.Student;
import com.example.mobile_cuoiki.sqlite.StudentClassQuery;
import com.example.mobile_cuoiki.sqlite.StudentQuery;

import java.util.List;
// hiển thị danh sách sinh viên đã đăng kí theo lớp
public class ListStudentRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student_register);
        loadListStudent();

    }
    private void loadListStudent() {
        Bundle extras = getIntent().getExtras();
        int classId = extras.getInt("CLASS_ID"); // lấy IdClass được truyền từ activity ListRegisterAcitivity

        StudentClassQuery studentClassQuery = new StudentClassQuery(getBaseContext());
        List<Student> studentList= studentClassQuery.getStudentsByClassID(classId);  // xem StudentClassQuery

        ListView listStudentView = findViewById(R.id.listStudentRegister);
        ListStudentAdapter adapter=new ListStudentAdapter(ListStudentRegisterActivity.this,studentList);

        listStudentView.setAdapter(adapter);

    }
}