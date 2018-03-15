package com.xdroid.demo.rv.mul;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xdroid.adapter.rv.ViewHolder;
import com.xdroid.adapter.rv.mul.IMulTypeHelper;

import com.xdroid.demo.R;

public class MulTypeMulBean1 implements IMulTypeHelper {
    private String avatar;
    private String name;

    public MulTypeMulBean1(String avatar, String name) {
        this.avatar = avatar;
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public MulTypeMulBean1 setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getName() {
        return name;
    }

    public MulTypeMulBean1 setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_rv_mulbean_1;
    }

    @Override
    public void onBind(ViewHolder holder) {
        holder.setText(R.id.tv, name);
        Glide.with(holder.itemView.getContext()).load(avatar).into((ImageView) holder.getView(R.id.iv1));
        Glide.with(holder.itemView.getContext()).load(avatar).into((ImageView) holder.getView(R.id.iv2));
    }
}
