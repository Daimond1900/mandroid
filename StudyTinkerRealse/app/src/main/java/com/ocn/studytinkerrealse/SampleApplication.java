package com.ocn.studytinkerrealse;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by 1900 on 2017/8/30.
 */

@DefaultLifeCycle(application = "com.ocn.studytinkerrealse.MyApplication",// 自定义生成
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class SampleApplication extends DefaultApplicationLike {

    public static SampleApplication sampleApplication;

    public SampleApplication(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag,
                             long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sampleApplication = this;
        //将我们自己的MyApplication中的所有逻辑放在这里，例如初始化一些第三方
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);

        // 其原理是分包架构，所以在加载初要加载其余的分包
        MultiDex.install(base);
        TinkerInstaller.install(this);

    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callback) {
        // 生命周期，默认配置
        getApplication().registerActivityLifecycleCallbacks(callback);
    }

    /**
     * 获取SampleApplication实例
     *
     * @return
     */
    public static SampleApplication getSampleApplication() {
        return sampleApplication;
    }

}