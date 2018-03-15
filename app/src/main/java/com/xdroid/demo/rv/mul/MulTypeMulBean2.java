package com.xdroid.demo.rv.mul;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xdroid.adapter.rv.ViewHolder;
import com.xdroid.adapter.rv.mul.IMulTypeHelper;

import com.xdroid.demo.R;

public class MulTypeMulBean2 implements IMulTypeHelper {
    private String background;

    public MulTypeMulBean2(String background) {
        this.background = background;
    }

    public String getBackground() {
        return background;
    }

    public MulTypeMulBean2 setBackground(String background) {
        this.background = background;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_rv_mulbean_2;
    }

    @Override
    public void onBind(ViewHolder holder) {
        Glide.with(holder.itemView.getContext()).load(background).into((ImageView) holder.getView(R.id.banner));
    }
}
