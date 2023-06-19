package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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

        ArrayAdapter<Classes> adapter=new ArrayAdapter<>(ListClassActivity.this, android.R.layout.simple_list_item_1,classList); // truyền class list và adapter.Đây là adapter có sẵn, sử dụng layout
        // simple_list_item_1.xml có sẵn của android, lưu ý cần toString() ở model.Đc cái là nhah chứ không custom đc


//        ListClassAdapter adapter=new ListClassAdapter(ListClassActivity.this,classList); // này là adapter tự custom. Lâu hơn cái dùng sẵn
        listClassView.setAdapter(adapter); // set adapter cho view (activity_list_class)
    }
}