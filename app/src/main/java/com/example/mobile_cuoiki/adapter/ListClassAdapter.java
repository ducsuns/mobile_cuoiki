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
    // trả về một cái view, ở đây cụ thể là các item trong listClass, định nghĩa xem các item đó sẽ đc hiển thị dữ liệu như thế nào
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Classes classes=getItem(position); // lấy đối tượng Classes tại vị trí được chỉ định

        //Nếu view item này chưa được tạo ra, sẽ tạo mới view item  bằng cách
        // sử dụng phương thức `inflate()` để chuyển đổi layout xml (R.layout.item_class) thành một đối tượng Java View.
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_class,parent,false);
        }

        TextView id=convertView.findViewById(R.id.tvID); // tìm kiếm view trong item_class.xml
        TextView name=convertView.findViewById(R.id.tvName);

        id.setText(""+classes.getId()); // setText
        name.setText(classes.getName());

        // sự kiện onclick khi ấn vào mỗi item trong listClasses, khi click vào item sẽ lấy đc IdClass
        // IdClass này sẽ phục vụ việc in listClass đã được sinh viên đăng kí ở phần thống kê 'lớp học, sinh viên đã đăng kí'
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
