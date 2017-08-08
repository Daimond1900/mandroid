package com.ocn.mstudyandroidlib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 1900 on 2017/7/26.
 */

public class StudyDesignActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.pager)
    ViewPager mPager;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer)
    DrawerLayout mDrawer;
    @BindView(R.id.navigation)
    NavigationView mNavigation;

    private List<String> list_title;                                      //tab名称列表
    private List<View> listViews;
    private List<Fragment> list_fragment;

    private View newsView;                                                //定义新闻页面
    private View sportView;                                               //定义体育页面
    private View funView;                                                 //定义娱乐页面

    private ViewAdapter vAdapter;                                         //定义以view为切换的adapter
    private FragmentAdapter fAdapter;                                     //定义以fragment为切换的adapter

    private NewsFragment nFragment;
    private SportsFragment sFragment;
    private Funfragment fFragment;


    private int[] tabImg;

    public StudyDesignActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_design_activity);
        ButterKnife.bind(this);
        initControls();

//        viewChanage();

        fragmentChange();

        initToolbar();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, 0, 0);
        mDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        mNavigation.setNavigationItemSelectedListener(this);
    }

    private void initControls() {
        //为tabLayout上的图标赋值
        tabImg = new int[]{R.drawable.ic_action_tab, R.drawable.ic_action_tab, R.drawable.ic_action_tab};
    }

    private void viewChanage() {
        listViews = new ArrayList<>();
        LayoutInflater mInflater = getLayoutInflater();

        newsView = mInflater.inflate(R.layout.fragment_news, null);
        sportView = mInflater.inflate(R.layout.fragment_sports, null);
        funView = mInflater.inflate(R.layout.fragment_funfragment, null);
        listViews.add(newsView);
        listViews.add(sportView);
        listViews.add(funView);

        list_title = new ArrayList<>();
        list_title.add("新闻");
        list_title.add("体育");
        list_title.add("娱乐");

        //设置TabLayout的模式,这里主要是用来显示tab展示的情况的
        //TabLayout.MODE_FIXED          各tab平分整个工具栏,如果不设置，则默认就是这个值
        //TabLayout.MODE_SCROLLABLE     适用于多tab的，也就是有滚动条的，一行显示不下这些tab可以用这个
        //                              当然了，你要是想做点特别的，像知乎里就使用的这种效果
        mTab.setTabMode(TabLayout.MODE_FIXED);

        //设置tablayout距离上下左右的距离
        //tab_title.setPadding(20,20,20,20);

        //为TabLayout添加tab名称
        mTab.addTab(mTab.newTab().setText(list_title.get(0)));
        mTab.addTab(mTab.newTab().setText(list_title.get(1)));
        mTab.addTab(mTab.newTab().setText(list_title.get(2)));


        vAdapter = new ViewAdapter(this, listViews, list_title, tabImg);
        mPager.setAdapter(vAdapter);

        //将tabLayout与viewpager连起来
        mTab.setupWithViewPager(mPager);
    }

    /**
     * 采用viewpager中切换fragment
     */
    private void fragmentChange() {
        list_fragment = new ArrayList<>();

        nFragment = new NewsFragment();
        sFragment = new SportsFragment();
        fFragment = new Funfragment();


        list_fragment.add(nFragment);
        list_fragment.add(sFragment);
        list_fragment.add(fFragment);

        list_title = new ArrayList<>();
        list_title.add("新闻");
        list_title.add("体育");
        list_title.add("娱乐");

        fAdapter = new FragmentAdapter(getSupportFragmentManager(), list_fragment, list_title);
        mPager.setAdapter(fAdapter);

        //将tabLayout与viewpager连起来
        mTab.setupWithViewPager(mPager);
    }


    public static Intent newIntent(Context context) {
        Intent view = new Intent(context, StudyDesignActivity.class);
        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_4:
                finish();
                break;


        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
