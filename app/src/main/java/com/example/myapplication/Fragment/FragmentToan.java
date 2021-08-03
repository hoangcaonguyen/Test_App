package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Sile.ScreenSlideActivity;
import com.example.myapplication.sql.SQLHelper;

import java.util.ArrayList;


public class FragmentToan extends Fragment {
    private CustomAdapter customAdapter;
    private GridView gridView;
    private SQLHelper sqlHelper;
    private ArrayList<Contact> list;

    public FragmentToan() {
        // Required empty public constructor
    }

    // ham nay de su dung voi cac view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn Toán Học");
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_toan, container, false);
    }


    // ham nay de viet lenh
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView = getActivity().findViewById(R.id.gv_numberexam);
        sqlHelper = new SQLHelper(getContext());
        ArrayList arrayList = new ArrayList();
        list = new ArrayList<>();
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
        if (sqlHelper.getDT().size() > 0) {

        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                sqlHelper.InsertDT((Contact) arrayList.get(i));
            }
        }
        list = sqlHelper.getDT();
        customAdapter = new CustomAdapter(getActivity(), R.layout.layout_ds_de, list);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("id_de", sqlHelper.getDT().get(position).getIdDe());
                intent.putExtra("subject", "toan");
                startActivity(intent);
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        list = sqlHelper.getDT();
        customAdapter.update(list);
    }

}