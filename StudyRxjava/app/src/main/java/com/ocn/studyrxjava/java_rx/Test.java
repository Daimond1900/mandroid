package com.ocn.studyrxjava.java_rx;

/**
 * Created by 1900 on 2017/8/1.
 */

public class Test {
    public static void main(String[] args) throws Exception {
        Watched weiguo = new ConcreateWatched();
        Watcher liangxiujuan = new ConcreateWatcher();
        Watcher liangxiujuan1 = new ConcreateWatcher();
        Watcher liangxiujuan2 = new ConcreateWatcher();

        weiguo.notifyWatchers("1");
        weiguo.notifyWatchers("2");
        weiguo.notifyWatchers("3");

        weiguo.addWatcher(liangxiujuan);
        weiguo.addWatcher(liangxiujuan1);
        weiguo.addWatcher(liangxiujuan2);
    }
}
