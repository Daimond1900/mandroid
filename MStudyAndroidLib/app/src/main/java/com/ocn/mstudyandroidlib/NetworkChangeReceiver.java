package com.ocn.mstudyandroidlib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by 1900 on 2017/9/4.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String netWorkMsg = "";
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            netWorkMsg = "网络可用！";
        } else {
            netWorkMsg = "网络不可用！";
        }

        Toast.makeText(context, netWorkMsg, Toast.LENGTH_SHORT).show();
    }
}
