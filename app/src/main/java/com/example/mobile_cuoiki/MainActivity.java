package com.example.mobile_cuoiki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobile_cuoiki.activity.AddClassActivity;
import com.example.mobile_cuoiki.activity.AddStudentActivity;
import com.example.mobile_cuoiki.activity.ListClassActivity;
import com.example.mobile_cuoiki.activity.ListClassRegisterActivity;
import com.example.mobile_cuoiki.activity.ListStudentActivity;
import com.example.mobile_cuoiki.activity.RegisterActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnAddClass, btnAddStudent, btnRegister, btnListClass, btnListStudent, btnListRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), AddClassActivity.class);
                startActivity(intent);
            }
        });
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), AddStudentActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnListClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ListClassActivity.class);
                startActivity(intent);
            }
        });
        btnListStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ListStudentActivity.class);
                startActivity(intent);
            }
        });
        btnListRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), ListClassRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public void init(){
        btnAddClass=findViewById(R.id.btnAddClass);
        btnAddStudent=findViewById(R.id.btnAddStudent);
        btnRegister=findViewById(R.id.btnRegister);
        btnListClass=findViewById(R.id.btnListClass);
        btnListStudent=findViewById(R.id.btnListStudent);
        btnListRegister=findViewById(R.id.btnListRegister);
    }
}