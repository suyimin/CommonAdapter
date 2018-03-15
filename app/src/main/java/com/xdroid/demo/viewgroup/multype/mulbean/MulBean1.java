package com.xdroid.demo.viewgroup.multype.mulbean;

import com.xdroid.adapter.viewgroup.adapter.mul.IMulTypeHelper;
import com.xdroid.demo.R;

public class MulBean1 implements IMulTypeHelper {
    private String url;

    public MulBean1(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public MulBean1 setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_mulbean_1;
    }
}
