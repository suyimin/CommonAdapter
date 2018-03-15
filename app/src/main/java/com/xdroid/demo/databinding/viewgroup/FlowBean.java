package com.xdroid.demo.databinding.viewgroup;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.xdroid.demo.BR;


public class FlowBean extends BaseObservable {
    private String tag;

    @Bindable
    public String getTag() {
        return tag;
    }

    public FlowBean setTag(String tag) {
        this.tag = tag;
        notifyPropertyChanged(BR.tag);
        return this;
    }

    public FlowBean(String tag) {
        this.tag = tag;
    }
}
