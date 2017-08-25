package com.ocn.mnewstudyandroid.study.smd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ocn.mnewstudyandroid.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SMDActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawerlayout)
    DrawerLayout mDrawerlayout;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.recyclerview_view)
    RecyclerView mRecyclerviewView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;

    private Fruit[] fruits = {new Fruit("橙子", R.mipmap.timgnew),
            new Fruit("苹果", R.mipmap.p1),
            new Fruit("香蕉", R.mipmap.p2),
            new Fruit("西瓜", R.mipmap.p3),
            new Fruit("梨", R.mipmap.p4),
            new Fruit("凤梨", R.mipmap.p5),
            new Fruit("樱桃", R.mipmap.p6),
            new Fruit("草莓", R.mipmap.p7),
            new Fruit("芒果", R.mipmap.p8),
            new Fruit("葡萄", R.mipmap.p9)};
    private List<Fruit> mFruitList = new ArrayList<>();
    private FruitAdapter mFruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smd);
        ButterKnife.bind(this);
//        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        //toolbar添加导航按钮
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerlayout, mToolbar, 0, 0);
            mDrawerlayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
        }

        mNavView.setCheckedItem(R.id.nav_call);
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerlayout.closeDrawers();
                return true;
            }
        });
        initFruits();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerviewView.setLayoutManager(gridLayoutManager);
        mFruitAdapter = new FruitAdapter(mFruitList);
        mRecyclerviewView.setAdapter(mFruitAdapter);
        mSwipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });
    }

    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        mFruitAdapter.notifyDataSetChanged();
                        mSwipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initFruits() {
        mFruitList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            mFruitList.add(fruits[index]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.md_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(this, "backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDrawerlayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, SMDActivity.class);
    }

    @OnClick({R.id.fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Snackbar.make(view, "数据删除", Snackbar.LENGTH_SHORT).setAction("撤回", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SMDActivity.this, "撤回成功", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
        }
    }
}
