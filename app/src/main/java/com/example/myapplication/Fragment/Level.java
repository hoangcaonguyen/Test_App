package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Toan;

import org.jetbrains.annotations.NotNull;

public class Level extends Fragment {
    private Button bt_de, btn_tb, btn_kho;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn Toán Học");
        return inflater.inflate(R.layout.activity_level, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        bt_de.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Toan.class);
            startActivity(intent);
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.content_main,
//                    new FragmentToan()).commit();
        });
        btn_kho.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Toan.class);
            startActivity(intent);
        });
        btn_tb.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), Toan.class);
            startActivity(intent);
        });
    }

    public void init() {
        bt_de = getActivity().findViewById(R.id.level_de);
        btn_tb = getActivity().findViewById(R.id.level_tb);
        btn_kho = getActivity().findViewById(R.id.level_kho);
    }
}