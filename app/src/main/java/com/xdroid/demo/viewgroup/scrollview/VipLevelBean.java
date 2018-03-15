package com.xdroid.demo.viewgroup.scrollview;

import com.xdroid.adapter.viewgroup.adapter.mul.IMulTypeHelper;
import com.xdroid.demo.R;

public class VipLevelBean implements IMulTypeHelper {
    private int level;
    private int levelValue;
    private boolean isCurrent;

    public VipLevelBean(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public VipLevelBean setLevel(int level) {
        this.level = level;
        return this;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public VipLevelBean setCurrent(boolean current) {
        isCurrent = current;
        return this;
    }

    public int getLevelValue() {
        return levelValue;
    }

    public VipLevelBean setLevelValue(int levelValue) {
        this.levelValue = levelValue;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        if (isCurrent()) {
            return R.layout.item_current;
        } else {
            return R.layout.item_normal;
        }
    }
}
