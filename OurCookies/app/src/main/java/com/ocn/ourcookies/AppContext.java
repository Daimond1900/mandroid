package com.ocn.ourcookies;

import android.content.Context;

/**
 * Created by 1900 on 2017/7/5.
 */

public class AppContext {
    private static Context c;

    public static void init(Context ctx) {
        c = ctx;
    }

    public static Context get() {
        return c;
    }
}
