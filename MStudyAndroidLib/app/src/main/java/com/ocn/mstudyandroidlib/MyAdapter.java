package com.ocn.mstudyandroidlib;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1900 on 2017/7/26.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private List<String> list = new ArrayList<>();

    public MyAdapter(FragmentManager fm, List<String> stringList) {
        super(fm);
        this.list = stringList;
    }

    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
