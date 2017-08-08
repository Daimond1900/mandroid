package com.ocn.studyrxjava.java_rx;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的一个被观察者
 * Created by 1900 on 2017/8/1.
 */

public class ConcreateWatched implements Watched{

    private List<Watcher> watchers = new ArrayList<>();


    @Override
    public void addWatcher(Watcher watcher) {
        watchers.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        watchers.remove(watcher);
    }

    @Override
    public void notifyWatchers(String str) {
        for (Watcher watcher : watchers) {
            watcher.update(str);
        }
    }
}
