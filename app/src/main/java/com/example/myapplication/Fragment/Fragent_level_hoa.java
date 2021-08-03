package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.Hoa;
import com.example.myapplication.Ly;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class Fragent_level_hoa extends Fragment {


    private Button bt_de, btn_tb, btn_kho;

    public Fragent_level_hoa() {
        // Required empty public constructor
    }


    public static Fragent_level_hoa newInstance(String param1, String param2) {
        Fragent_level_hoa fragment = new Fragent_level_hoa();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn Hóa Học");
        return inflater.inflate(R.layout.fragment_levelhoa, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        bt_de.setOnClickListener(v -> {
            Intent ly = new Intent(getContext(), Hoa.class);
            startActivity(ly);
        });
        btn_kho.setOnClickListener(v -> {
            Intent ly = new Intent(getContext(), Hoa.class);
            startActivity(ly);
        });
        btn_tb.setOnClickListener(v -> {
            Intent ly = new Intent(getContext(), Hoa.class);
            startActivity(ly);
        });
    }

    public void init() {
        bt_de = getActivity().findViewById(R.id.level_de);
        btn_tb = getActivity().findViewById(R.id.level_tb);
        btn_kho = getActivity().findViewById(R.id.level_kho);
    }
}