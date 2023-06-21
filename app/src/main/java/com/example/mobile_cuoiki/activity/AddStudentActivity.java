package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.model.Student;
import com.example.mobile_cuoiki.sqlite.ClassQuery;
import com.example.mobile_cuoiki.sqlite.StudentQuery;
// thêm sinh viên mới, tượng tự AddClass
public class AddStudentActivity extends AppCompatActivity {
    private Button btnAdd, btnBack;
    private EditText edtName,edtQuequan,edtNamsinh,edtNamhoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        init();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentQuery studentQuery = new StudentQuery(getApplicationContext());

                String name = edtName.getText().toString();
                String namsinh = edtNamsinh.getText().toString();
                String quequan= edtQuequan.getText().toString();
                String namhoc=edtNamhoc.getText().toString();


                Student student= new Student(name,namsinh,quequan,namhoc);
                studentQuery.add(student);
                Toast.makeText(getBaseContext(), "Add Success", Toast.LENGTH_SHORT).show();
                reset();
//                setResult(RESULT_OK, null);
                finish();
            }
        });
    }
    protected void reset() {
        edtName.setText("");
        edtNamsinh.setText("");
        edtQuequan.setText("");
        edtNamhoc.setText("");
    }
    public void init(){
        btnAdd=findViewById(R.id.btnAdd);
        btnBack=findViewById(R.id.btnBack);

        edtName=findViewById(R.id.edtName);
        edtNamsinh=findViewById(R.id.edtNamsinh);
        edtQuequan=findViewById(R.id.edtQuequan);
        edtNamhoc=findViewById(R.id.edtNamhoc);
    }
}