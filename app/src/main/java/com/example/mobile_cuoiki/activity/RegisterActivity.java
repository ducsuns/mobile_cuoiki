package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.model.StudentClass;
import com.example.mobile_cuoiki.sqlite.StudentClassDAO;

public class RegisterActivity extends AppCompatActivity {
    private EditText edtIDstudent, edtIDclass, edtKihoc,edtTinchi;
    private Button btnAdd,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentClassDAO studentclassDAO = new StudentClassDAO(getBaseContext());

                String idClass = edtIDclass.getText().toString();
                String idStudent = edtIDstudent.getText().toString();
                String kihoc= edtKihoc.getText().toString();
                String tinchi=edtTinchi.getText().toString();

                StudentClass studentClass=new StudentClass(Integer.parseInt(idStudent),Integer.parseInt(idClass),kihoc,Integer.parseInt(tinchi));
                studentclassDAO.add(studentClass);

                Toast.makeText(getBaseContext(), "Add Success", Toast.LENGTH_SHORT).show();
                reset();
                finish();
            }
        });
    }
    public void init(){
        edtIDclass=findViewById(R.id.edtMalop);
        edtIDstudent=findViewById(R.id.edtMasinhvien);
        edtKihoc=findViewById(R.id.edtKihoc);
        edtTinchi=findViewById(R.id.edtSotinchi);

        btnAdd=findViewById(R.id.btnAdd);
        btnBack=findViewById(R.id.btnBack);
    }
    protected void reset() {
        edtIDclass.setText("");
        edtIDstudent.setText("");
        edtKihoc.setText("");
        edtTinchi.setText("");
    }
}