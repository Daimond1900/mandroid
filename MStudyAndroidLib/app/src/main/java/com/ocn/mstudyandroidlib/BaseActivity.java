package com.ocn.mstudyandroidlib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 1900 on 2017/9/4.
 */

public class BaseActivity extends AppCompatActivity {
    private OffLoginListener offLoginListener;
    public LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ocn.OFF_LOGIN");
        offLoginListener = new OffLoginListener();
        localBroadcastManager.registerReceiver(offLoginListener, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (offLoginListener != null) {
            localBroadcastManager.unregisterReceiver(offLoginListener);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    class OffLoginListener extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);
            builder.setTitle("警告")
                    .setCancelable(false)
                    .setMessage("您的账号在其他地方登录！")
                    .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCollector.finishAll();
                        }
                    });
            builder.show();
        }
    }
}
