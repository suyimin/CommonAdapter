package com.xdroid.demo.viewgroup.multype;

import com.xdroid.adapter.viewgroup.adapter.mul.IMulTypeHelper;

import com.xdroid.demo.R;

public class MulTypeBean implements IMulTypeHelper {
    private String avatar;
    private String name;
    private boolean receive;

    public MulTypeBean(String avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    public boolean isReceive() {
        return receive;
    }

    public MulTypeBean setReceive(boolean receive) {
        this.receive = receive;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public MulTypeBean setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getName() {
        return name;
    }

    public MulTypeBean setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        if (isReceive()) {
            return R.layout.item_mul_1;
        } else {
            return R.layout.item_mul_2;
        }
    }
}
