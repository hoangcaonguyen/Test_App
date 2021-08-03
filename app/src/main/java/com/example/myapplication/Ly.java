package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.myapplication.Fragment.Contact;
import com.example.myapplication.Fragment.CustomAdapter;
import com.example.myapplication.Sile.ScreenSlideActivity;
import com.example.myapplication.sql.SQLHelper;

import java.util.ArrayList;

public class Ly extends AppCompatActivity {
    CustomAdapter customAdapter;
    private GridView gridView;
    private SQLHelper sqlHelper;
    private ArrayList<Contact> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ly);
        getSupportActionBar().setTitle("Môn Vật Lý");
        sqlHelper = new SQLHelper(this);
        gridView = findViewById(R.id.gv_numberexam);
        ArrayList arrayList = new ArrayList();
        list = new ArrayList();
        Contact contact1 = new Contact("Đề số 1", null, 1);
        Contact contact2 = new Contact("Đề số 2", null, 2);
        Contact contact3 = new Contact("Đề số 3", null, 3);
        Contact contact4 = new Contact("Đề số 4", null, 4);
        Contact contact5 = new Contact("Đề số 5", null, 5);
        Contact contact6 = new Contact("Đề số 6", null, 6);
        arrayList.add(contact1);
        arrayList.add(contact2);
        arrayList.add(contact3);
        arrayList.add(contact4);
        arrayList.add(contact5);
        arrayList.add(contact6);

        if (sqlHelper.getDL().size() > 0) {

        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                sqlHelper.InsertDL((Contact) arrayList.get(i));
            }
        }
        list = sqlHelper.getDL();
        customAdapter = new CustomAdapter(this, R.layout.layout_ds_de, list);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Ly.this, ScreenSlideActivity.class);
                intent.putExtra("subject", "ly");
                intent.putExtra("id_de", sqlHelper.getDL().get(position).getIdDe());
                startActivity(intent);
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        list = sqlHelper.getDL();
        customAdapter.update(list);

    }
}