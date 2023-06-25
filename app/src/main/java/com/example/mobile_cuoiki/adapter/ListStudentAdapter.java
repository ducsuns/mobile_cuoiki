package com.example.mobile_cuoiki.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobile_cuoiki.R;
import com.example.mobile_cuoiki.model.Classes;
import com.example.mobile_cuoiki.model.Student;

import java.util.List;



public class ListStudentAdapter extends ArrayAdapter<Student> {
    public ListStudentAdapter(@NonNull Context context, @NonNull List<Student> listStudent) {
        super(context, R.layout.item_student, listStudent);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Student student=getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_student,parent,false);
        }

        TextView id=convertView.findViewById(R.id.tvID);
        TextView name=convertView.findViewById(R.id.tvName);
        TextView namsinh=convertView.findViewById(R.id.tvNamsinh);
        TextView quequan=convertView.findViewById(R.id.tvQuequan);
        TextView namhoc=convertView.findViewById(R.id.tvNamhoc);


        id.setText(""+student.getId());
        name.setText(student.getName());
        namsinh.setText(student.getDob());
        quequan.setText(student.getHometown());
        namhoc.setText(student.getSchoolyear());

        return convertView;
    }
}
