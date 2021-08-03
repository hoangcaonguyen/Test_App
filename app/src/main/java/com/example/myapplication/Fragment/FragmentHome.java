package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.myapplication.Hoa;
import com.example.myapplication.Ly;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Toan;

import java.util.ArrayList;


public class FragmentHome extends Fragment {
    ViewFlipper viewFlipper;
    Button btntoan, btnly, btnhoa;

    public FragmentHome() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Ung Dung On Thi");

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewFlipper = getActivity().findViewById(R.id.Viewflipper);
        getData();
        btnhoa = getActivity().findViewById(R.id.hoa);
        btnly = getActivity().findViewById(R.id.ly);
        btntoan = getActivity().findViewById(R.id.toan);
        btnhoa.setOnClickListener(v -> {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, new Fragent_level_hoa(), "NewFragmentTag");
            ft.commit();
        });
        btntoan.setOnClickListener(v -> {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, new Level(), "NewFragmentTag");
            ft.commit();
        });
        btnly.setOnClickListener(v -> {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, new Fragmentlevel_y(), "NewFragmentTag");
            ft.commit();
        });

    }

    private void getData() {

        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://aztest.vn/uploads/news/2019/1_6.jpg");
        mangquangcao.add("https://pesthubt.com/images/homepage-hero.png");
        mangquangcao.add("https://itest.com.vn/static/125.jpg");
        mangquangcao.add("https://i.ytimg.com/vi/qlhO7yLqYP0/maxresdefault.jpg");
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            Glide.with(getActivity()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);
    }
}