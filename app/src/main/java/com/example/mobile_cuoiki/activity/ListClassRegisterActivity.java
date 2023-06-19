package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.adapter.ListClassAdapter;
import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.sqlite.StudentClassQuery;

import java.util.List;
// hiển thị list các Class đã đc đăng kí
public class ListClassRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_register);
        loadListClass();
    }

    private void loadListClass() { // hiển thị list các Class đã đc đăng kí
         StudentClassQuery studentClassQuery = new StudentClassQuery(getBaseContext());

         List<Classes> classList = studentClassQuery.getClassesRegister(); //xem lại StudentClassQuery

         ListView listClassView = findViewById(R.id.listRegister);



        ListClassAdapter adapter=new ListClassAdapter(ListClassRegisterActivity.this,classList);

        // onclick vào item Class, xem lại trong ListClassAdapter
         adapter.setOnItemClickListener(new ListClassAdapter.OnItemClickListener() {
             @Override
             public void onItemClick(int id) {
                 Intent intent=new Intent(getApplicationContext(), ListStudentRegisterActivity.class); // khi click sẽ chuyển đến màn hình activity ListStudentRegisterActivity
                 intent.putExtra("CLASS_ID", id); // truyền IdClass đến activity ListStudentRegisterActivity để tí nữa xác định các sinh viên đã đăng kí lớp học có id như này
                 startActivity(intent);
             }
         });
         listClassView.setAdapter(adapter);// set adapter cho view
    }
}