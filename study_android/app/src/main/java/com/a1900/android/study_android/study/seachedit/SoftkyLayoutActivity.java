package com.a1900.android.study_android.study.seachedit;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.a1900.android.study_android.study.seachedit.SeachFragment;
import com.a1900.android.study_android.study.fragment.SingleFragmentActivity;

/**
 * Created by 1900 on 2017/6/21.
 */

public class SoftkyLayoutActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SeachFragment();
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, SoftkyLayoutActivity.class);
        return intent;
    }
}
