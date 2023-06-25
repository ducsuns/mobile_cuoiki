package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.adapter.ListClassAdapter;
import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.readwritefile.ReadWriteClass;
import com.example.mobile_cuoiki.sqlite.ClassDAO;

import java.util.List;

public class ListClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_class);
        loadListClass();
    }
    private void loadListClass() {

        ClassDAO classDAO =new ClassDAO(getBaseContext());

        List<Classes> classesList =classDAO.getAll();

        ListView listView=findViewById(R.id.listClass);


        ListClassAdapter adapter=new ListClassAdapter(ListClassActivity.this,classesList);

        listView.setAdapter(adapter);

    }
}