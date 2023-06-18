package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.adapter.ListClassAdapter;
import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.sqlite.ClassQuery;

import java.util.List;

public class ListClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_class);
        loadListClass();
    }
    private void loadListClass() { // hiển thị tất cả các class
        ClassQuery classQuery = new ClassQuery(getBaseContext());

        List<Classes> classList = classQuery.getAll(); // lấy list class từ getALL() của ClassQuery

        ListView listClassView = findViewById(R.id.listClass); // tìm kiếm view trong activity_list_class.xml

        ListClassAdapter adapter=new ListClassAdapter(ListClassActivity.this,classList);  // truyền class list và adapter
        listClassView.setAdapter(adapter); // set adapter cho view (activity_list_class)
    }
}