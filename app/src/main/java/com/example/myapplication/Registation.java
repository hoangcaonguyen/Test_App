package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.network.Respones.Acc;
import com.example.myapplication.sql.SQLHelper;

public class Registation extends AppCompatActivity {
    private Button btn;
    private SQLHelper sqlHelper;
    private EditText edtname, edtns, edttk, edtmk;
    private TextView txt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);
        sqlHelper = new SQLHelper(this);
        init();
        txt_login.setOnClickListener(v -> {
            finish();
        });
        btn.setOnClickListener(v -> {
            if (edtname.getText().toString().length() > 0 &&
                    edtns.getText().toString().length() > 0 &&
                    edttk.getText().toString().length() > 0 && edtmk.getText().toString().length() > 0) {
                sqlHelper.InsertAcc(new Acc(edtname.getText().toString().trim(), edtmk.getText().toString().trim(), "", edtns.getText().toString(), edttk.getText().toString()));
                Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                refestText();
                finish();
            } else {
                if (edtname.getText().toString().length() == 0) {
                    edtname.setHintTextColor(getResources().getColor(R.color.red));
                }
                if (edtns.getText().toString().length() == 0) {
                    edtns.setHintTextColor(getResources().getColor(R.color.red));
                }
                if (edttk.getText().toString().length() == 0) {
                    edttk.setHintTextColor(getResources().getColor(R.color.red));
                }
                if (edtmk.getText().toString().length() == 0) {
                    edtmk.setHintTextColor(getResources().getColor(R.color.red));
                }
                Toast.makeText(this, "vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        btn = findViewById(R.id.btn_dki);
        edtname = findViewById(R.id.edt_ht);
        edtns = findViewById(R.id.edt_ns);
        edttk = findViewById(R.id.edt_username);
        edtmk = findViewById(R.id.edt_mk);
        txt_login = findViewById(R.id.txt_loginn);
    }

    private void refestText() {
        edtname.setText("");
        edtmk.setText("");
        edttk.setText("");
        edtns.setText("");
        edtname.setHintTextColor(getResources().getColor(android.R.color.tertiary_text_light));
        edtns.setHintTextColor(getResources().getColor(android.R.color.tertiary_text_light));
        edttk.setHintTextColor(getResources().getColor(android.R.color.tertiary_text_light));
        edtmk.setHintTextColor(getResources().getColor(android.R.color.tertiary_text_light));
    }
}