package com.ocn.ourcookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.heima.tabview.library.TabView;
import com.heima.tabview.library.TabViewChild;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<TabViewChild> tabViewChildList = new ArrayList<>();
        TabViewChild tabViewChild01 = new TabViewChild(R.drawable.ic_action_botom_1, R.drawable.ic_action_botom_1_1, "首页", HomePageFragment.newInstance());
        TabViewChild tabViewChild02 = new TabViewChild(R.drawable.ic_action_botom_1, R.drawable.ic_action_botom_1_1, "等待", HomePageFragment.newInstance());
        TabViewChild tabViewChild03 = new TabViewChild(R.drawable.ic_action_botom_1, R.drawable.ic_action_botom_1_1, "等待", HomePageFragment.newInstance());
        TabViewChild tabViewChild04 = new TabViewChild(R.drawable.ic_action_botom_1, R.drawable.ic_action_botom_1_1, "等待", HomePageFragment.newInstance());
        TabViewChild tabViewChild05 = new TabViewChild(R.drawable.ic_action_botom_1, R.drawable.ic_action_botom_1_1, "等待", HomePageFragment.newInstance());
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);
        tabViewChildList.add(tabViewChild04);
        tabViewChildList.add(tabViewChild05);

        TabView tabView = (TabView) findViewById(R.id.tabView);
        tabView.setTabViewChild(tabViewChildList, getSupportFragmentManager());
        tabView.setOnTabChildClickListener(new TabView.OnTabChildClickListener() {
            @Override
            public void onTabChildClick(int position, ImageView imageView, TextView textView) {
                Toast.makeText(MainActivity.this, ""+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
