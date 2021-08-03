package com.example.myapplication.Sile;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.network.Respones.Math;
import com.example.myapplication.sql.SQLHelper;

import java.util.ArrayList;
import java.util.List;


public class ScreenSlidePageFragment extends Fragment {
    public static List<Math> listmath = new ArrayList<>();
    public static final String KEY = "page";
    public static final String CHECKANSER = "CheckAnser";
    private int mPageNumberNow;
    private TextView tvNum, tvQues, tvScore;
    private RadioGroup radioGroup;
    private RadioButton radA, radB, radC, radD;
    public int CheckDA;
    private SQLHelper sqlHelper;

    public ScreenSlidePageFragment() {

    }

    public static List<Math> getListmath() {
        return listmath;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        tvNum = (TextView) rootView.findViewById(R.id.tvNum);
        tvQues = (TextView) rootView.findViewById(R.id.tvQuestion);
        radA = (RadioButton) rootView.findViewById(R.id.radA);
        radB = (RadioButton) rootView.findViewById(R.id.radB);
        radC = (RadioButton) rootView.findViewById(R.id.radC);
        radD = (RadioButton) rootView.findViewById(R.id.radD);
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radGroup);
        return rootView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sqlHelper = new SQLHelper(getContext());

        listmath = ((ScreenSlideActivity) getActivity()).getList();
        for (int i = 0; i < listmath.size(); i++) {
            listmath.get(i).setId(i);
        }
        mPageNumberNow = getArguments().getInt(KEY);
        CheckDA = getArguments().getInt(CHECKANSER);
    }


    public static ScreenSlidePageFragment create(int pageNumberNow, int checkAnser) {
        ScreenSlidePageFragment screenSlidePageFragment = new ScreenSlidePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY, pageNumberNow);
        bundle.putInt(CHECKANSER, checkAnser);
        screenSlidePageFragment.setArguments(bundle);
        return screenSlidePageFragment;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("câu " + (mPageNumberNow + 1));
        tvQues.setText(listmath.get(mPageNumberNow).getQuestion());
        radA.setText(listmath.get(mPageNumberNow).getAns_a());
        radB.setText(listmath.get(mPageNumberNow).getAns_b());
        radC.setText(listmath.get(mPageNumberNow).getAsn_c());
        radD.setText(listmath.get(mPageNumberNow).getAns_d());
        if (CheckDA != 0) {
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
            checkDA(listmath.get(mPageNumberNow).getResult());

        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                listmath.get(mPageNumberNow).setNumber(getcheckID(checkedId));
            }
        });


    }

    private String getcheckID(int id) {
        if (id == R.id.radA) {
            return "A";
        } else if (id == R.id.radB) {

            return "B";
        } else if (id == R.id.radC) {

            return "C";
        } else if (id == R.id.radD) {

            return "D";
        } else {
            return " ";
        }

    }

    //h
    // Ham kt DA dung neu dung thi doi mau Dap an dung
    private void checkDA(String DA) {
        if (DA.equals("A")) {
            radA.setBackgroundColor(Color.RED);
        }
        if (DA.equals("B")) {
            radB.setBackgroundColor(Color.RED);

        }
        if (DA.equals("C")) {
            radC.setBackgroundColor(Color.RED);

        }
        if (DA.equals("D")) {
            radD.setBackgroundColor(Color.RED);

        }
    }

}

