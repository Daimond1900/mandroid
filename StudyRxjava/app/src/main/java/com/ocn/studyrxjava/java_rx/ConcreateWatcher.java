package com.ocn.studyrxjava.java_rx;

import android.util.Log;

/**
 * Created by 1900 on 2017/8/1.
 */

public class ConcreateWatcher implements Watcher {
    private static final String TAG = "ConcreateWatcher";
    @Override
    public void update(String str) {
        Log.d(TAG, "update: " + str);
    }
}
