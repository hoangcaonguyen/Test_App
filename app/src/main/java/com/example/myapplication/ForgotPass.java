
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.sql.SQLHelper;

public class ForgotPass extends AppCompatActivity {
    private EditText edttk, edtpass, edtconfirm;
    private Button btn;
    private SQLHelper sqlHelper;
    private TextView txtlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);
        init();
        sqlHelper = new SQLHelper(this);
        txtlogin.setOnClickListener(v -> {
            finish();
        });
        btn.setOnClickListener(v -> {
            for (int i = 0; i < sqlHelper.getAcc().size(); i++) {
                if (sqlHelper.getAcc().get(i).getEmail().equals(edttk.getText().toString())) {
                    if (edtpass.getText().toString().equals(edttk.getText().toString())) {
                        sqlHelper.upDatePass(sqlHelper.getAcc().get(i).getEmail(), edtpass.getText().toString());
                        Intent in = new Intent(this, Login.class);
                        startActivity(in);
                        finish();
                    } else {
                        Toast.makeText(this, "Mật khẩu không trùng nhau", Toast.LENGTH_SHORT).show();
                        edtconfirm.setTextColor(getResources().getColor(R.color.red));
                    }

                } else {
                    edttk.setTextColor(getResources().getColor(R.color.red));
                    Toast.makeText(this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    private void init() {
        edttk = findViewById(R.id.edt_ht);
        edtpass = findViewById(R.id.edt_ns);
        edtconfirm = findViewById(R.id.edt_username);
        btn = findViewById(R.id.btn_dki);
        txtlogin = findViewById(R.id.txt_login);
    }
}