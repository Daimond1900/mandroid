package com.a1900.android.study_android.study.statelayout;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.a1900.android.study_android.study.fragment.SingleFragmentActivity;

public class StateLayoutActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new StateLayoutFragment();
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context,StateLayoutActivity.class);
        return intent;
    }
}
