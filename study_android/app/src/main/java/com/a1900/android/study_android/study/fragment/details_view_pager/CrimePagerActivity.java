package com.a1900.android.study_android.study.fragment.details_view_pager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.a1900.android.study_android.R;
import com.a1900.android.study_android.study.fragment.details.CrimeFragment;
import com.a1900.android.study_android.study.fragment.model.Crime;
import com.a1900.android.study_android.study.fragment.model.CrimeLab;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 托管crimefragmeng的activity
 * Created by 1900 on 2017/6/17.
 */

public class CrimePagerActivity extends AppCompatActivity {
    private static final String EXTRA_LIST_TO_DETAILS_TAG = "com.a1900.android.study_android.study.fragment.details_view_pager.tag.position";
    private static final String TAG = "CrimePagerActivity";

    @BindView(R.id.activity_crime_pager_view_pager)
    ViewPager mActivityCrimePagerViewPager;

    private List<Crime> crimeList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        ButterKnife.bind(this);

        int mPostion = getIntent().getIntExtra(EXTRA_LIST_TO_DETAILS_TAG, 0);
        crimeList = CrimeLab.get(this).getCrimeList();

        FragmentManager fm = getSupportFragmentManager();

        mActivityCrimePagerViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return CrimeFragment.newCrimeFragment(position);
            }

            @Override
            public int getCount() {
                return crimeList.size();
            }
        });

        for (int i = 0; i < crimeList.size(); i++) {
            if (i == mPostion) {
                mActivityCrimePagerViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    /*页面跳转*/
    public static Intent newCrimePagerActivity(Context context, int position) {
        Intent intent = new Intent(context, CrimePagerActivity.class);
        intent.putExtra(EXTRA_LIST_TO_DETAILS_TAG, position);
        return intent;
    }
}
