package com.xdroid.demo.databinding.rv.multype.mulbean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.xdroid.adapter.databinding.rv.mul.IBaseMulInterface;
import com.xdroid.demo.BR;
import com.xdroid.demo.R;

public class MulTypeMulBean2 extends BaseObservable implements IBaseMulInterface {
    private String background;

    public MulTypeMulBean2(String background) {
        this.background = background;
    }

    @Bindable
    public String getBackground() {
        return background;
    }

    public MulTypeMulBean2 setBackground(String background) {
        this.background = background;
        notifyPropertyChanged(BR.background);
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_db_mulbean_2;
    }
}
