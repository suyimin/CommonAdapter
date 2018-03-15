package com.xdroid.demo.rv.header;

import android.content.Intent;
import android.view.View;

import com.xdroid.adapter.rv.IHeaderHelper;
import com.xdroid.adapter.rv.ViewHolder;

import com.xdroid.demo.R;
import com.xdroid.demo.rv.mul.RvMulTypeMulBeanActivity;

public class HeaderBean implements IHeaderHelper {
    private String text;

    public HeaderBean(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public HeaderBean setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.header_banner;
    }

    @Override
    public void onBind(final ViewHolder holder) {
        holder.setText(R.id.tv, text);
        holder.setOnClickListener(R.id.tv, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击跳转到多ItemType
                holder.itemView.getContext().startActivity(new Intent(holder.itemView.getContext(), RvMulTypeMulBeanActivity.class));
            }
        });
    }
}
