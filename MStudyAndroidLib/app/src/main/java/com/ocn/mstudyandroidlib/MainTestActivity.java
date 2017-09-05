package com.ocn.mstudyandroidlib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainTestActivity extends BaseActivity {

    @BindView(R.id.off_login_bt)
    Button mOffLoginBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
        ButterKnife.bind(this);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    public static Intent getInstance(Context mContext) {
        return new Intent(mContext, MainTestActivity.class);
    }

    @OnClick(R.id.off_login_bt)
    public void onViewClicked() {
        Intent intent = new Intent("com.ocn.OFF_LOGIN");
        localBroadcastManager.sendBroadcast(intent);
    }
}
