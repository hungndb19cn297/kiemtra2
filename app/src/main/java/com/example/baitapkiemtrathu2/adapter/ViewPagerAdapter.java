package com.example.baitapkiemtrathu2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.baitapkiemtrathu2.fragment.InfoFragment;
import com.example.baitapkiemtrathu2.fragment.ListFragment;
import com.example.baitapkiemtrathu2.fragment.SearchFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ListFragment();
        }
        if (position == 1) {
            return new InfoFragment();
        }
        if (position == 2) {
            return new SearchFragment();
        }
        return new ListFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Home";
        }
        if (position == 1) {
            return "Info";
        }
        if (position == 2) {
            return "Search";
        }
        return "Home";
    }
}
