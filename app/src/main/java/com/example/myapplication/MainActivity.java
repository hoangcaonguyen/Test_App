package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.myapplication.Fragment.Fragent_level_hoa;
import com.example.myapplication.Fragment.FragmentHome;
import com.example.myapplication.Fragment.Fragmentlevel_y;
import com.example.myapplication.Fragment.Level;
import com.example.myapplication.network.Respones.Math;
import com.example.myapplication.network.Respones.SubjectResponse;
import com.example.myapplication.network.SingltonRetrofitObject;
import com.example.myapplication.sql.SQLHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private AppBarConfiguration mAppBarConfiguration;
    private SQLHelper sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        sqlHelper = new SQLHelper(this);

        getDataJson();
        getDataToan();
        getHoa();
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        navigationView.getMenu().performIdentifierAction(R.id.nav_home, 0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getGroupId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            FragmentHome fragmentHome = new FragmentHome();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, fragmentHome, fragmentHome.getTag()).commit();

        } else if (id == R.id.nav_toan) {
            Level fragmentlevel = new Level();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, fragmentlevel, fragmentlevel.getTag()).commit();

        } else if (id == R.id.nav_ly) {

            Fragmentlevel_y fragment_level = new Fragmentlevel_y();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, fragment_level, fragment_level.getTag()).commit();


        } else if (id == R.id.nav_hoa) {
            Fragent_level_hoa fragment_level = new Fragent_level_hoa();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, fragment_level, fragment_level.getTag()).commit();

        }else {
            FragmentHome fragmentHome = new FragmentHome();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, fragmentHome, fragmentHome.getTag()).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getDataToan() {
        Call<List<SubjectResponse>> listCall = new SingltonRetrofitObject().getmInstance().getApi().getToan();
        listCall.enqueue(new Callback<List<SubjectResponse>>() {
            @Override
            public void onResponse(Call<List<SubjectResponse>> call, Response<List<SubjectResponse>> response) {
                if (sqlHelper.getAllMath().size() != 0) {
                    sqlHelper.DeleteAllMath();
                }
//                Collections.sort(response.body(), new Comparator<SubjectResponse>() {
//                    @Override
//                    public int compare(SubjectResponse o1, SubjectResponse o2) {
//                        if (Integer.parseInt(o1.getLevel())<  Integer.parseInt(o2.getLevel()))
//                            return -1;
//                        return Integer.parseInt(o1.getLevel()) > Integer.parseInt(o2.getLevel()) ? 1 : -1;
//                    }
//                });
                for (int i = 0; i < response.body().size(); i++) {
                    sqlHelper.InsertMath(new Math(response.body().get(i).getId(),
                            response.body().get(i).getQuestion(),
                            response.body().get(i).getAns_a(),
                            response.body().get(i).getAns_b(),
                            response.body().get(i).getAsn_c(),
                            response.body().get(i).getAns_d(),
                            response.body().get(i).getResult(),
                            response.body().get(i).getLevel()));
                }

            }

            @Override
            public void onFailure(Call<List<SubjectResponse>> call, Throwable t) {

            }
        });
    }

    private void getHoa() {
        Call<List<SubjectResponse>> listCall = new SingltonRetrofitObject().getmInstance().getApi().getHoa();
        listCall.enqueue(new Callback<List<SubjectResponse>>() {
            @Override
            public void onResponse(Call<List<SubjectResponse>> call, Response<List<SubjectResponse>> response) {
                if (sqlHelper.getAllHoa().size() != 0) {
                    sqlHelper.DeleteAllHoa();
                }
//                Collections.sort(response.body(), new Comparator<SubjectResponse>() {
//                    @Override
//                    public int compare(SubjectResponse o1, SubjectResponse o2) {
//                        return Integer.parseInt(o1.getLevel()) > Integer.parseInt(o2.getLevel()) ? 1 : -1;
//                    }
//                });
                for (int i = 0; i < response.body().size(); i++) {
                    sqlHelper.InsertHoa(new Math(response.body().get(i).getId(),
                            response.body().get(i).getQuestion(),
                            response.body().get(i).getAns_a(),
                            response.body().get(i).getAns_b(),
                            response.body().get(i).getAsn_c(),
                            response.body().get(i).getAns_d(),
                            response.body().get(i).getResult(),
                            response.body().get(i).getLevel()));
                }
            }

            @Override
            public void onFailure(Call<List<SubjectResponse>> call, Throwable t) {

            }
        });
    }

    private void getDataJson() {
        Call<List<SubjectResponse>> listCall = new SingltonRetrofitObject().getmInstance().getApi().getDuration();
        listCall.enqueue(new Callback<List<SubjectResponse>>() {
            @Override
            public void onResponse(Call<List<SubjectResponse>> call, Response<List<SubjectResponse>> response) {

                if (sqlHelper.getAllMath().size() != 0) {
                    sqlHelper.DeleteAllLy();
                }
//                Collections.sort(response.body(), new Comparator<SubjectResponse>() {
//                    @Override
//                    public int compare(SubjectResponse o1, SubjectResponse o2) {
//                        return Integer.parseInt(o1.getLevel()) > Integer.parseInt(o2.getLevel()) ? 1 : -1;
//                    }
//                });
                for (int i = 0; i < response.body().size(); i++) {
                    sqlHelper.InsertLy(new Math(response.body().get(i).getId(),
                            response.body().get(i).getQuestion(),
                            response.body().get(i).getAns_a(),
                            response.body().get(i).getAns_b(),
                            response.body().get(i).getAsn_c(),
                            response.body().get(i).getAns_d(),
                            response.body().get(i).getResult(),
                            response.body().get(i).getLevel()));
                }

            }

            @Override
            public void onFailure(Call<List<SubjectResponse>> call, Throwable t) {

            }
        });

    }
}
