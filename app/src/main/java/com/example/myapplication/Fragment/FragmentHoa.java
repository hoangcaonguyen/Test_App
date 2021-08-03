package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Cons;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Sile.ScreenSlideActivity;
import com.example.myapplication.sql.SQLHelper;

import java.util.ArrayList;


public class FragmentHoa extends Fragment {
    CustomAdapter customAdapter;
    private GridView gridView;
    private SQLHelper sqlHelper;
    private ArrayList<Contact> list;

    public FragmentHoa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn Hóa Học");
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_hoa, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridView = (GridView) getActivity().findViewById(R.id.gv_numberexam);
        ArrayList arrayList = new ArrayList();
        list = new ArrayList<>();
        sqlHelper = new SQLHelper(getContext());
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
        if (sqlHelper.getDH().size() > 0) {

        } else {
            for (int i = 0; i < arrayList.size(); i++) {
                sqlHelper.InsertDH((Contact) arrayList.get(i));
            }
        }
        list = sqlHelper.getDH();
        customAdapter = new CustomAdapter(getActivity(), R.layout.layout_ds_de, list);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("id_de", sqlHelper.getDH().get(position).getIdDe());
                intent.putExtra("subject", "hoa");
                startActivity(intent);
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        list = sqlHelper.getDH();
        customAdapter.update(list);
    }
}