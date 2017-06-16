package com.a1900.android.study_android.study.fragment.list;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.a1900.android.study_android.study.fragment.SingleFragmentActivity;

/**
 * Created by 1900 on 2017/6/16.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    /*页面跳转*/
    public static Intent newCrimeListActivity(Context context) {
        Intent intent = new Intent(context, CrimeListActivity.class);
        return intent;
    }
}
