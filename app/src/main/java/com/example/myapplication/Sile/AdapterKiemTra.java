package com.example.myapplication.Sile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.network.Respones.Math;

import java.util.List;

public class AdapterKiemTra extends BaseAdapter {
    private List<Math> arrayList;
    private LayoutInflater layoutInflater;

    public AdapterKiemTra(List arrayList, Context context) {
        this.arrayList = arrayList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_gvcautraloi, null);
            viewHolder.tvCauhoi = (TextView) convertView.findViewById(R.id.tv_Cauhoi);
            viewHolder.tvCautraloi = (TextView) convertView.findViewById(R.id.tv_Dapan);
            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
       viewHolder.tvCauhoi.setText("Câu số  " + (arrayList.get(position).getId() + 1) + " : ");
        viewHolder.tvCautraloi.setText(arrayList.get(position).getNumber());
        return convertView;
    }

    public static class ViewHolder {
        TextView tvCauhoi, tvCautraloi;


    }
}
