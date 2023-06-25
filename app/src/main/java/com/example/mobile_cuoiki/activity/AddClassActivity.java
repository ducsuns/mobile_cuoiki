package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.readwritefile.ReadWriteClass;

public class AddClassActivity extends AppCompatActivity {
    private Button btnAdd, btnBack;
    private EditText  edtName,edtMota,edtId;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        init();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadWriteClass readWriteClass=new ReadWriteClass(getApplicationContext());

                String name= edtName.getText().toString();
                String mota=edtMota.getText().toString();
                String id= edtId.getText().toString();

                Classes classes =new Classes(Integer.parseInt(id),name,mota);
                readWriteClass.writeClass(getApplicationContext(),"class.txt",classes);
                reset();
            }
        });



    }
    protected void reset() {
        edtName.setText("");
        edtMota.setText("");
        edtId.setText("");
    }
    public void init(){
        btnAdd=findViewById(R.id.btnAdd);
        btnBack=findViewById(R.id.btnBack);
        edtMota=findViewById(R.id.edtMota);
        edtName=findViewById(R.id.edtName);
        edtId=findViewById(R.id.edtId);
    }
}