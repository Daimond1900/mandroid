package com.a1900.android.study_android.study.erjxlk;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.a1900.android.study_android.study.fragment.SingleFragmentActivity;
import com.a1900.android.study_android.study.seachedit.SeachFragment;
import com.a1900.android.study_android.study.seachedit.SoftkyLayoutActivity;

/**
 * Created by m1900 on 2017/6/30.
 */

public class M2jLayoutActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new ErjFragment();
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, M2jLayoutActivity.class);
        return intent;
    }
}
