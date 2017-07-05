package com.a1900.android.study_android;

import android.app.Application;

import com.allen.apputils.MLog;
import com.allen.apputils.ToastUtils;
import com.allen.apputils.Utils;
import com.itheima.retrofitutils.ItheimaHttp;

/**
 * Created by 1900 on 2017/7/4.
 */

public class MyApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        MLog.LOG_OUT = true;
        Utils.init(this);
        ToastUtils.init(true);
        ItheimaHttp.init(this, "http://www.oschina.net/");//使用前必须调用（如果调用过则不需要重复调用）

        AppContext.init(this);
    }

    
}
