package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.network.Respones.Acc;
import com.example.myapplication.sql.SQLHelper;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    private EditText edt_email, edt_pass;
    private Button btn_login;
    private TextView txtdki, txtquen, txtname, txtpass;
    private SQLHelper sqlHelper;
    private List<Acc> list;
    private CheckBox checkBox;
    private SharedPreferences sharedPreferences;
    private Boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqlHelper = new SQLHelper(this);
        list = new ArrayList<>();
        sharedPreferences = this.getSharedPreferences("c", Context.MODE_PRIVATE);
        list = sqlHelper.getAcc();
        init();
        if (sharedPreferences != null) {
            edt_email.setText(sharedPreferences.getString(Cons.EMAIL, ""));
            edt_pass.setText(sharedPreferences.getString(Cons.PASS, ""));
        }
        txtdki.setOnClickListener(v -> {
            Intent i = new Intent(this, Registation.class);
            startActivity(i);
        });
        txtquen.setOnClickListener(v -> {
            Intent i = new Intent(this, ForgotPass.class);
            startActivity(i);
            finish();
        });

        btn_login.setOnClickListener(v -> {
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (edt_pass.getText().toString().trim().equals(list.get(i).getPass()) && edt_email.getText().toString().trim().equals(list.get(i).getEmail())) {
                        check = true;

                    } else {
                        check = false;

                    }
                }
                if (check) {
                    if (checkBox.isChecked()) {
                        SharedPreferences.Editor editor1 = sharedPreferences.edit();
                        editor1.putString(Cons.EMAIL, edt_email.getText().toString());
                        editor1.putString(Cons.PASS, edt_pass.getText().toString());
                        editor1.putBoolean(Cons.ChECK_BOX, true);
                        editor1.commit();
                    } else {
                        SharedPreferences.Editor editor1 = sharedPreferences.edit();
                        editor1.remove(Cons.EMAIL);
                        editor1.remove(Cons.PASS);
                        editor1.remove(Cons.ChECK_BOX);
                        editor1.commit();

                    }
                    Intent j = new Intent(this, MainActivity.class);
                    startActivity(j);
                    finish();
                } else {
                    txtname.setTextColor(getResources().getColor(R.color.red));
                    txtpass.setTextColor(getResources().getColor(R.color.red));
                    Toast.makeText(this, "Tài khoản không tông tại", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void init() {
        edt_email = findViewById(R.id.edt_username);
        edt_pass = findViewById(R.id.edt_mk);
        btn_login = findViewById(R.id.btn_login);
        txtdki = findViewById(R.id.dki);
        txtquen = findViewById(R.id.quen);
        txtname = findViewById(R.id.txt_tk);
        txtpass = findViewById(R.id.txt_pass);
        checkBox = findViewById(R.id.checkbox);
    }

    @Override
    protected void onResume() {
        super.onResume();
        list = sqlHelper.getAcc();
    }
}