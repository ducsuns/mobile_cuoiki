package com.example.mobile_cuoiki.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.sqlite.ClassQuery;
// thêm lớp mới
public class AddClassActivity extends AppCompatActivity {
    private Button btnAdd, btnBack;
    private EditText  edtName,edtMota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        init();

        btnAdd.setOnClickListener(new View.OnClickListener() { //onclick nút Add
            @Override
            public void onClick(View view) {
                ClassQuery classQuery = new ClassQuery(getBaseContext());

                String name = edtName.getText().toString();  // lấy text từ EditText
                String mota = edtMota.getText().toString();

                Classes classes= new Classes(name,mota);
                classQuery.add(classes); // add lớp mới

                Toast.makeText(getBaseContext(), "Add Success", Toast.LENGTH_SHORT).show(); // thông báo
                reset(); // reset lại Edittext sau khi add thành công
                setResult(RESULT_OK, null);
                finish();
            }
        });



    }
    protected void reset() {
        edtName.setText("");
        edtMota.setText("");
    }
    public void init(){
        btnAdd=findViewById(R.id.btnAdd); // tìm kiếm view trong activity_add_class.xml
        btnBack=findViewById(R.id.btnBack);
        edtMota=findViewById(R.id.edtMota);
        edtName=findViewById(R.id.edtName);
    }
}