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

import java.util.List;


public class ListClassAdapter extends ArrayAdapter<Classes> {

    private OnItemClickListener mListener;

    public ListClassAdapter(@NonNull Context context, @NonNull List<Classes> listClass) {
        super(context, R.layout.item_class,listClass);
    }

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Classes classes=getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_class,parent,false);
        }

        TextView id=convertView.findViewById(R.id.tvID);
        TextView name=convertView.findViewById(R.id.tvName);

        id.setText(""+classes.getId()); // setText
        name.setText(classes.getName());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(classes.getId());
                }
            }
        });

        return convertView;
    }

    public interface OnItemClickListener {
        void onItemClick(int id);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}
