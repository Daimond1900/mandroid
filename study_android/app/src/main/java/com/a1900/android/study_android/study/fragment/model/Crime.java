package com.a1900.android.study_android.study.fragment.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by 1900 on 2017/6/15.
 */

public class Crime {
    private UUID mId;       // 恶习的ID
    private String mTitle;  // 标题名
    private Date mDate;
    private boolean mSolved; //是否处理了

    public Crime() {
        this.mId = UUID.randomUUID();
        this.mDate = new Date();
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Date getmDate() {
        return mDate;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
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
