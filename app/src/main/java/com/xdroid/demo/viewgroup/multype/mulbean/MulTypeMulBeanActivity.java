package com.xdroid.demo.viewgroup.multype.mulbean;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xdroid.adapter.viewgroup.VGUtil;
import com.xdroid.adapter.viewgroup.adapter.cache.ViewHolder;
import com.xdroid.adapter.viewgroup.adapter.mul.IMulTypeHelper;
import com.xdroid.adapter.viewgroup.adapter.mul.MulTypeAdapter;
import com.xdroid.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 介绍：多种Item类型：数据结构不同:：
 */
public class MulTypeMulBeanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_type_mul_bean);

        List datas = new ArrayList();
        for (int i = 0; i < 10; i++) {
            datas.add(new MulBean1("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg"));
            datas.add(new MulBean2("张旭童"));
        }


        //多种Item类型：数据结构不同 不传泛型了 使用时需要强转javaBean，判断ItemLayoutId
        /*ViewGroupUtils.addViews((ViewGroup) findViewById(R.id.activity_mul_type_mul_bean), new MulTypeAdapter(this, datas) {
            @Override
            public void onBindViewHolder(ViewGroup parent, ViewHolder holder, IMulTypeHelper data, int pos) {
                switch (data.getItemLayoutId()) {
                    case R.layout.item_mulbean_1:
                        MulBean1 mulBean1 = (MulBean1) data;
                        Glide.with(MulTypeMulBeanActivity.this)
                                .load(mulBean1.getUrl())
                                .into((ImageView) holder.itemView);
                        break;
                    case R.layout.item_mulbean_2:
                        MulBean2 mulBean2 = (MulBean2) data;
                        TextView tv = (TextView) holder.itemView;
                        tv.setText(mulBean2.getName());
                }
            }

        });*/
        //V1.8.0 建议使用Builder模式构建VGUtil
        new VGUtil.Builder()
                .setParent((ViewGroup) findViewById(R.id.activity_mul_type_mul_bean))
                .setAdapter(new MulTypeAdapter(this, datas) {
                    @Override
                    public void onBindViewHolder(ViewGroup parent, ViewHolder holder, IMulTypeHelper data, int pos) {
                        switch (data.getItemLayoutId()) {
                            case R.layout.item_mulbean_1:
                                MulBean1 mulBean1 = (MulBean1) data;
                                Glide.with(MulTypeMulBeanActivity.this)
                                        .load(mulBean1.getUrl())
                                        .into((ImageView) holder.itemView);
                                break;
                            case R.layout.item_mulbean_2:
                                MulBean2 mulBean2 = (MulBean2) data;
                                TextView tv = (TextView) holder.itemView;
                                tv.setText(mulBean2.getName());
                        }
                    }

                })
                .build()
                .bind();
    }
}
