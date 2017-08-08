package com.ocn.ourcookies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ocn.ourcookies.adapter.TabAdapter;
import com.ocn.ourcookies.fragment.Test_1Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.home_tab)
    TabLayout mHomeTab;
    @BindView(R.id.home_pager)
    ViewPager mHomePager;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.navigation)
    NavigationView mNavigation;
    @BindView(R.id.drawer)
    DrawerLayout mDdrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initTabPager();

        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDdrawer, mToolbar, 0, 0);
        mDdrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        mNavigation.setNavigationItemSelectedListener(this);
    }

    private void initTabPager() {
        List<String> tabTexts = new ArrayList<>();  // 导航页标题
        List<Fragment> pagerView = new ArrayList<>();// 对应导航的fragment

        tabTexts.add("测试一");
        tabTexts.add("测试二");
        tabTexts.add("测试三");
        tabTexts.add("测试四");

        Fragment fragment_1 = Test_1Fragment.newInstance("测试一");
        Fragment fragment_2 = Test_1Fragment.newInstance("测试二");
        Fragment fragment_3 = Test_1Fragment.newInstance("测试三");
        Fragment fragment_4 = Test_1Fragment.newInstance("测试四");
        pagerView.add(fragment_1);
        pagerView.add(fragment_2);
        pagerView.add(fragment_3);
        pagerView.add(fragment_4);

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager(), tabTexts, pagerView);
        mHomePager.setAdapter(tabAdapter);
        mHomeTab.setupWithViewPager(mHomePager);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }
}
