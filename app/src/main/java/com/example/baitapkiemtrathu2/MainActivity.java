package com.example.baitapkiemtrathu2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.example.baitapkiemtrathu2.adapter.ViewPagerAdapter;
import com.example.baitapkiemtrathu2.db.Database;
import com.example.baitapkiemtrathu2.model.Model;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    BottomNavigationView nav;
    FloatingActionButton fbtn;
    TabLayout tabLayout;
    public static Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.vp);
        nav = findViewById(R.id.nav);
        fbtn = findViewById(R.id.floatingActionButton);

        db = new Database(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        vp.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(vp);
        fbtn.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, AddActivity.class);
            i.putExtra("id", -1);
            startActivity(i);
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    nav.getMenu().findItem(R.id.mHome).setChecked(true);
                    return;
                }
                if (position == 1) {
                    nav.getMenu().findItem(R.id.mNoti).setChecked(true);
                    return;
                }
                if (position == 2) {
                    nav.getMenu().findItem(R.id.mSearch).setChecked(true);
                    return;
                }
                nav.getMenu().findItem(R.id.mHome).setChecked(true);
                return;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mHome) {
                    vp.setCurrentItem(0);
                }
                if (item.getItemId() == R.id.mNoti) {
                    vp.setCurrentItem(1);
                }
                if (item.getItemId() == R.id.mSearch) {
                    vp.setCurrentItem(2);
                }
                return true;
            }
        });
    }

}