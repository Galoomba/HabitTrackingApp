package com.example.starhood.habittrackingapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Adapter;

/**
 * Created by Starhood on 7/6/17.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private String tabTitles[] = new String[]{"ViewHabits", "InsertHabit"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ViewData();
        } else if (position == 1) {
            return new IncomingDataFragment();
        } else {
            return new ViewData();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
