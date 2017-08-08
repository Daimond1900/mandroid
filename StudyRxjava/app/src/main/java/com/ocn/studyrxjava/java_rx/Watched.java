package com.ocn.studyrxjava.java_rx;

/**
 * Created by 1900 on 2017/8/1.
 */

public interface Watched {

    public void addWatcher(Watcher watcher);

    public void removeWatcher(Watcher watcher);

    public void notifyWatchers(String str);
}
