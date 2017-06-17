package com.a1900.android.study_android.study.fragment.details;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.a1900.android.study_android.study.fragment.SingleFragmentActivity;

public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_LIST_TO_DETAILS_TAG = "com.a1900.android.study_android.study.fragment.details.tag.position";

    @Override
    protected Fragment createFragment() {
        int cPosition = getIntent().getIntExtra(EXTRA_LIST_TO_DETAILS_TAG, -1);

        return CrimeFragment.newCrimeFragment(cPosition);
    }

    /*页面跳转*/
    public static Intent newCrimeActivity(Context context, int position) {
        Intent intent = new Intent(context, CrimeActivity.class);
        intent.putExtra(EXTRA_LIST_TO_DETAILS_TAG, position);
        return intent;
    }
}
