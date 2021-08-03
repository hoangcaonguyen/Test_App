package com.example.myapplication.Sile;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Cons;
import com.example.myapplication.R;
import com.example.myapplication.network.Respones.Math;
import com.example.myapplication.sql.SQLHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ShowSore extends AppCompatActivity {
    private TextView tv_SumCauDung, tv_SumCauSai, tv_SumCauChuaLam, tv_SumDiem;
    private Button bt_luu, bt_thoat, bt_choilai;
    private List<Math> list;
    private int count = 0;
    private int countError = 0;
    private Float scocer;
    private String nam;
    private int idde;
    private SQLHelper sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sore);
        sqlHelper = new SQLHelper(this);
        init();
        list = new ArrayList<>();
        list = ScreenSlideActivity.getList();
        nam = getIntent().getStringExtra("mon");
        idde = getIntent().getIntExtra("id_de", 0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumber() != null) {
                if (list.get(i).getResult().equals(list.get(i).getNumber())) {
                    count++;
                } else {
                    countError++;
                }
            }
            if (count == 0) {
                tv_SumCauDung.setText("0");
            } else {
                tv_SumCauDung.setText(count + "");
            }
            if (countError == 0) {
                tv_SumCauSai.setText("0");
            } else {
                tv_SumCauSai.setText(countError + "");
            }
            if (count == 0 && countError == 0) {
                tv_SumCauChuaLam.setText(list.size() + "");
            } else {
                tv_SumCauChuaLam.setText(list.size() - (countError + count) + "/" + list.size());
            }
            scocer = (10 / ((float) list.size()) * count);
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);

            tv_SumDiem.setText(df.format(scocer) + "/10");

            bt_thoat.setOnClickListener(v -> {
                finish();
            });
        }

        if (nam.equals("toan")) {
            sqlHelper.updateDiem(Cons.DB_DE_T, idde, tv_SumDiem.getText().toString());

        } else if (nam.equals("ly")) {
            sqlHelper.updateDiem(Cons.DB_DE_L, idde, tv_SumDiem.getText().toString());

        } else if (nam.equals("hoa")) {
            sqlHelper.updateDiem(Cons.DB_DE_H, idde, tv_SumDiem.getText().toString());

        }
    }

    public void init() {
        tv_SumCauDung = (TextView) findViewById(R.id.tv_SumCauDung);
        tv_SumCauSai = (TextView) findViewById(R.id.tv_SumCauSai);
        tv_SumCauChuaLam = (TextView) findViewById(R.id.tv_SumCauChuaLam);
        tv_SumDiem = (TextView) findViewById(R.id.tv_SumDiem);
        //bt_choilai=(Button)findViewById(R.id.bt_choilai);
        bt_thoat = (Button) findViewById(R.id.bt_thoat);
        //bt_luu=(Button)findViewById(R.id.bt_luu);

    }


}