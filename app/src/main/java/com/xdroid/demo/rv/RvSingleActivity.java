package com.xdroid.demo.rv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xdroid.adapter.rv.CommonAdapter;
import com.xdroid.adapter.rv.ViewHolder;

import java.util.List;

import com.xdroid.demo.R;
import com.xdroid.demo.TestBean;

import static com.xdroid.demo.TestBean.initDatas;

public class RvSingleActivity extends AppCompatActivity {
    private static final String TAG = "zxt";
    private List<TestBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_single);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_rv_single);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CommonAdapter<TestBean>(this, mDatas = initDatas(), R.layout.item_test) {
            @Override
            public void convert(ViewHolder holder, TestBean testBean) {
                Glide.with(RvSingleActivity.this)
                        .load(testBean.getAvatar())
                        .into((ImageView) holder.itemView.findViewById(R.id.ivAvatar));
                ((TextView) holder.itemView.findViewById(R.id.tvName)).setText(testBean.getName());
            }
        });
    }
}
