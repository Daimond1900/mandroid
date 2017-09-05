package com.ocn.mstudyandroidlib;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BroadCastTestActivity extends AppCompatActivity {

    @BindView(R.id.send_my_broadcast_bt)
    Button mSendMyBroadcastBt;
    @BindView(R.id.login_off_project_bt)
    Button mLoginOffProjectBt;
    private NetworkChangeReceiver networkChangeReceiver;
    private IntentFilter mIntentFilter;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_test);
        ButterKnife.bind(this);
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, mIntentFilter);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

    }

    public static Intent getInstance(Context mContext) {
        return new Intent(mContext, BroadCastTestActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    @OnClick({R.id.send_my_broadcast_bt,R.id.login_off_project_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.send_my_broadcast_bt:
                Intent intent = new Intent("com.ocn.mstudyandroidlib.MY_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
                break;
            case R.id.login_off_project_bt:
                startActivity(LoginActivity.getInstance(this));
                break;
        }
    }
}
