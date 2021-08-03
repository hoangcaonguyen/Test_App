package com.example.myapplication.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private ArrayList<Contact> ArrList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.ArrList = objects;
        this.context = context;
        this.resource = resource;

    }

    public void update (ArrayList<Contact> contacts) {
        this.ArrList = contacts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_ds_de, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tv_number = (TextView) convertView.findViewById(R.id.tv_number);
            viewHolder.tv_diem = (TextView) convertView.findViewById(R.id.trv_diem);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        Contact contact = ArrList.get(position);
        viewHolder.tv_number.setText(contact.getmNumberExam());
        if (contact.getDiem() == null) {
            viewHolder.tv_diem.setText("");
        } else {
            viewHolder.tv_diem.setText(contact.getDiem());
        }

        return convertView;
    }

    public class ViewHolder {
        TextView tv_number, tv_diem;

    }
}

