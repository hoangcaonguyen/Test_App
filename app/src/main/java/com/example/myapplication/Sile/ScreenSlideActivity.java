package com.example.myapplication.Sile;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.example.myapplication.network.Respones.Math;
import com.example.myapplication.sql.SQLHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ScreenSlideActivity extends FragmentActivity {

    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private TextView tvKiemTra, tvTimer, tvScore;
    private ArrayList<Math> arr_Qes;
    private CounterClass counterClass;
    private String subject;
    private int number_exam;
    private int time;
    public int checkDA = 0;
    private SQLHelper sqlHelper;
    public static List<Math> list;
    public static int number_page;

    public static int getNumber_page() {
        return number_page;
    }

    public static void setNumber_page(int number_page) {
        ScreenSlideActivity.number_page = number_page;
    }

    public static List<Math> getList() {
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        list = new ArrayList<>();
        subject = getIntent().getStringExtra("subject");
        number_exam = getIntent().getIntExtra("id_de", 0);
        sqlHelper = new SQLHelper(this);
        if (subject.equals("ly")) {
            arr_Qes = new ArrayList<>(sqlHelper.getAllLy());
            int sum = arr_Qes.size() / 6;
            if (number_exam == 1) {
                for (int i = 0; i < sum; i++) {
                    list.add(arr_Qes.get(i));
                }
            }
            if (number_exam == 2) {

                for (int i = sum; i < 2 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }

            }
            if (number_exam == 3) {

                for (int i = 2 * sum; i < 3 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }
            }
            if (number_exam == 4) {

                for (int i = 3 * sum; i < 4 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }

            }
            if (number_exam == 5) {

                for (int i = 4 * sum; i < 5 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }

            }
            if (number_exam == 6) {

                for (int i = 5 * sum; i < arr_Qes.size(); i++) {
                    list.add(arr_Qes.get(i));
                }

            }

        } else if (subject.equals("toan")) {
            arr_Qes = new ArrayList<>(sqlHelper.getAllMath());

            int sum = arr_Qes.size() / 6;
            if (number_exam == 1) {
                for (int i = 0; i < sum; i++) {
                    list.add(arr_Qes.get(i));
                }
            }
            if (number_exam == 2) {

                for (int i = sum; i < 2 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }

            }
            if (number_exam == 3) {

                for (int i = 2 * sum; i < 3 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }
            }
            if (number_exam == 4) {

                for (int i = 3 * sum; i < 4 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }

            }
            if (number_exam == 5) {

                for (int i = 4 * sum; i < 5 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }

            }
            if (number_exam == 6) {

                for (int i = 5 * sum; i < arr_Qes.size(); i++) {
                    list.add(arr_Qes.get(i));
                }

            }
        } else if (subject.equals("hoa")) {
            arr_Qes = new ArrayList<>(sqlHelper.getAllHoa());
            int sum = arr_Qes.size() / 6;
            if (number_exam == 1) {
                for (int i = 0; i < sum; i++) {
                    list.add(arr_Qes.get(i));
                }
            }
            if (number_exam == 2) {

                for (int i = sum; i < 2 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }

            }
            if (number_exam == 3) {

                for (int i = 2 * sum; i < 3 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }
            }
            if (number_exam == 4) {

                for (int i = 3 * sum; i < 4 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }

            }
            if (number_exam == 5) {

                for (int i = 4 * sum; i < 5 * sum; i++) {
                    list.add(arr_Qes.get(i));
                }

            }
            if (number_exam == 6) {
                for (int i = 5 * sum; i < arr_Qes.size(); i++) {
                    list.add(arr_Qes.get(i));
                }
            }
        }
        setNumber_page(list.size());
        time = 20;
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        counterClass = new CounterClass(time * 60 * 1000, 1000);
        tvScore = findViewById(R.id.tvScore);
        tvKiemTra = findViewById(R.id.tvKiemTra);
        tvTimer = findViewById(R.id.tvTimer);
        tvKiemTra.setOnClickListener(v -> {
            KIemTra();
        });
        tvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        counterClass.start();
    }


    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            return ScreenSlidePageFragment.create(position, checkDA);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public void KIemTra() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialodkiemtra);
        AdapterKiemTra adapterKiemTra = new AdapterKiemTra(ScreenSlidePageFragment.getListmath(), this);
        GridView gridViewDanhsachcautraloi = (GridView) dialog.findViewById(R.id.gv_kiemtra);
        gridViewDanhsachcautraloi.setAdapter(adapterKiemTra);
        gridViewDanhsachcautraloi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewPager.setCurrentItem(position);
                dialog.dismiss();

            }

        });
        Button btDong, btKetthuc;
        btDong = (Button) dialog.findViewById(R.id.bt_dong);
        btKetthuc = (Button) dialog.findViewById(R.id.bt_ketthuc);
        btDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btKetthuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counterClass.cancel();
                dialog.dismiss();
                result();

            }

        });
        tvScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent1 = new Intent(ScreenSlideActivity.this, ShowSore.class);
                intent1.putExtra("mon", subject);
                intent1.putExtra("id_de", number_exam);
                startActivity(intent1);
            }
        });
        dialog.show();


    }

    public void result() {
        checkDA = 1;
        tvKiemTra.setVisibility(View.GONE);
        tvScore.setVisibility(View.VISIBLE);
        if (viewPager.getCurrentItem() >= 6) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 4);

        } else if (viewPager.getCurrentItem() <= 6) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 4);
        }

    }

    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            tvTimer.setText(countTime); //SetText cho textview hiện thị thời gian.
        }

        @Override
        public void onFinish() {
            tvTimer.setText("00:00");  //SetText cho textview hiện thị thời gian.
        }
    }

}
