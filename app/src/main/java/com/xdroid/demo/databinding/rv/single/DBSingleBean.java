package com.xdroid.demo.databinding.rv.single;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.xdroid.demo.BR;


public class DBSingleBean extends BaseObservable {
    private String avatar;
    private String name;

    public DBSingleBean(String avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public DBSingleBean setAvatar(String avatar) {
        this.avatar = avatar;
        notifyPropertyChanged(BR.avatar);
        return this;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public DBSingleBean setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
        return this;
    }
}
