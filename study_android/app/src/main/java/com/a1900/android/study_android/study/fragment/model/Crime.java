package com.a1900.android.study_android.study.fragment.model;

import java.util.UUID;

/**
 * Created by 1900 on 2017/6/15.
 */

public class Crime {
    private UUID mId;       // 恶习的ID
    private String mTitle;  // 标题名

    public Crime() {
        this.mId = UUID.randomUUID();
    }

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
