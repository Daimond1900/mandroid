package com.ocn.ourcookies.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1900 on 2017/7/26.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private List<String> tabs = new ArrayList<>();
    private List<Fragment> viewPagers = new ArrayList<>();

    public TabAdapter(FragmentManager fm, List<String> tabs, List<Fragment> viewPagers) {
        super(fm);
        this.tabs = tabs;
        this.viewPagers = viewPagers;
    }

    @Override
    public Fragment getItem(int position) {
        return viewPagers.get(position);
    }

    @Override
    public int getCount() {
        return viewPagers.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position % tabs.size());
    }
}
