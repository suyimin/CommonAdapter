package com.xdroid.demo.viewgroup.multype.mulbean;

import com.xdroid.adapter.viewgroup.adapter.mul.IMulTypeHelper;
import com.xdroid.demo.R;

public class MulBean2 implements IMulTypeHelper {
    private String name;

    public MulBean2(String url) {
        this.name = url;
    }

    public String getName() {
        return name;
    }

    public MulBean2 setName(String url) {
        this.name = url;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_mulbean_2;
    }
}
