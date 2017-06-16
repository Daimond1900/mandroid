package com.a1900.android.study_android.study.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

    /*页面跳转*/
    public static Intent newCrimeActivity(Context context) {
        Intent intent = new Intent(context, CrimeActivity.class);
        return intent;
    }
}
