package com.xdroid.demo.viewgroup.linearlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.xdroid.adapter.viewgroup.VGUtil;
import com.xdroid.adapter.viewgroup.adapter.cache.ViewHolder;
import com.xdroid.adapter.viewgroup.adapter.single.SingleAdapter;
import com.xdroid.adapter.viewgroup.listener.OnItemClickListener;
import com.xdroid.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 介绍：单一Item类型：
 */
public class LinearLayoutActivity extends AppCompatActivity {

    private List<K50Bean> mDatas;

    private LinearLayout llCurrent, llUseMore, llRecent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        llCurrent = (LinearLayout) findViewById(R.id.llCurrent);
        llUseMore = (LinearLayout) findViewById(R.id.llUseMore);
        llRecent = (LinearLayout) findViewById(R.id.llRecent);
        mDatas = initDatas();


        final SingleAdapter adapter1 = new SingleAdapter<K50Bean>(this, mDatas, R.layout.item_50k) {
            @Override
            public void onBindViewHolder(ViewGroup parent, ViewHolder holder, K50Bean data, int pos) {
                holder.setText(R.id.tv, data.getName());
            }
        };

        //单一ItemView
        //ViewGroupUtils.addViews(llCurrent, adapter1);
        final VGUtil vgUtil = new VGUtil(llCurrent, adapter1, new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View itemView, int position) {
                Toast.makeText(LinearLayoutActivity.this, "position：" + position + "被删除了", Toast.LENGTH_SHORT).show();
                mDatas.remove(position);
                adapter1.notifyDatasetChanged();
            }
        });
        vgUtil.bind();

        new VGUtil.Builder()
                .setParent(llUseMore)
                .setAdapter(new SingleAdapter<K50Bean>(this, mDatas, R.layout.item_50k) {
                    @Override
                    public void onBindViewHolder(ViewGroup parent, ViewHolder holder, K50Bean data, int pos) {
                        holder.setText(R.id.tv, data.getName());
                    }
                })
                .build()
                .bind();
/*        ViewGroupUtils.addViews(llRecent, new SingleAdapter<K50Bean>(this, mDatas, R.layout.item_50k) {
            @Override
            public void onBindViewHolder(ViewGroup parent, ViewHolder holder, K50Bean data, int pos) {
                holder.setText(R.id.tv, data.getName());
            }
        });*/
        new VGUtil.Builder()
                .setParent(llRecent)
                .setAdapter(new SingleAdapter<K50Bean>(this, mDatas, R.layout.item_50k) {
                    @Override
                    public void onBindViewHolder(ViewGroup parent, ViewHolder holder, K50Bean data, int pos) {
                        holder.setText(R.id.tv, data.getName());
                    }
                })
                .build()
                .bind();


        findViewById(R.id.btnChange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (K50Bean data : mDatas) {
                    data.setName("替换了");
                }

                //单一ItemView刷新
                //ViewGroupUtils.refreshUI(llCurrent, adapter1);
                adapter1.notifyDatasetChanged();
            }
        });

    }

    public List<K50Bean> initDatas() {
        List<K50Bean> datas = new ArrayList<>();
        datas.add(new K50Bean("自行车"));
        datas.add(new K50Bean("自行车"));
        datas.add(new K50Bean("自行车"));
        datas.add(new K50Bean("自行车"));
        datas.add(new K50Bean("自行车"));
        datas.add(new K50Bean("自行车"));
        datas.add(new K50Bean("自行车"));
        datas.add(new K50Bean("自行车"));
        return datas;
    }
}
