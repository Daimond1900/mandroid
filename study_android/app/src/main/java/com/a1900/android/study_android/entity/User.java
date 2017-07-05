package com.a1900.android.study_android.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 1900 on 2017/7/5.
 */

@Entity
public class User {
    @Id
    private Long id;
    private String username;
    @Transient
    private int tempUsageCount;
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 79420138)
    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }
    @Generated(hash = 586692638)
    public User() {
    }
}
