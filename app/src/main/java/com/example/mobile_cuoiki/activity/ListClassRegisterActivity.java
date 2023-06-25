package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.adapter.ListClassAdapter;
import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.sqlite.StudentClassDAO;

import java.util.List;

public class ListClassRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_register);
        loadListClass();
    }

    private void loadListClass() {
         StudentClassDAO studentClassDAO = new StudentClassDAO(getBaseContext());

         List<Classes> classList = studentClassDAO.getClassesRegister();

         ListView listClassView = findViewById(R.id.listRegister);


        ListClassAdapter adapter=new ListClassAdapter(ListClassRegisterActivity.this,classList);


         adapter.setOnItemClickListener(new ListClassAdapter.OnItemClickListener() {
             @Override
             public void onItemClick(int id) {
                 Intent intent=new Intent(getApplicationContext(), ListStudentRegisterActivity.class);
                 intent.putExtra("CLASS_ID", id);
                 startActivity(intent);
             }
         });
         listClassView.setAdapter(adapter);// set adapter cho view
    }
}