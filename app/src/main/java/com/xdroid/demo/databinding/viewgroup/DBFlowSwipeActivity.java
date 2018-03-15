package com.xdroid.demo.databinding.viewgroup;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xdroid.adapter.databinding.viewgroup.SingleBindingAdapter;
import com.xdroid.adapter.viewgroup.VGUtil;
import com.xdroid.swipemenu.SwipeMenuLayout;
import com.xdroid.demo.R;
import com.xdroid.demo.databinding.ActivityDbflowSwipeBinding;

import java.util.ArrayList;
import java.util.List;

public class DBFlowSwipeActivity extends AppCompatActivity {
    ActivityDbflowSwipeBinding mBinding;
    SingleBindingAdapter mAdapter;
    List<FlowBean> mDatas;
    VGUtil mVGUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_dbflow_swipe, null, false);
        setContentView(mBinding.getRoot());

        mAdapter = new SingleBindingAdapter<>(this, mDatas = iniDatas(), R.layout.item_db_flow_swipe);
        mAdapter.setItemPresenter(new ItemDelPresenter());
        //ViewGroupUtils.addViews(mBinding.flowLayout, mAdapter);
        mVGUtil = new VGUtil.Builder()
                .setParent(mBinding.flowLayout)
                .setAdapter(mAdapter)
                .build()
                .bind();

    }

    public class ItemDelPresenter {
        public void onDelClick(FlowBean flowBean, View view) {
            mDatas.remove(flowBean);
            ((SwipeMenuLayout) view.getParent()).quickClose();
            //ViewGroupUtils.refreshUI(mBinding.flowLayout, mAdapter);
            mAdapter.notifyDatasetChanged();
        }
    }

    //没看头
    private List<FlowBean> iniDatas() {
        List<FlowBean> datas = new ArrayList<>();

/*        for (int i=0;i<10;i++){

        }*/
        datas.add(new FlowBean("我也不知道管我什么事的新闻"));
        datas.add(new FlowBean("体育"));

        datas.add(new FlowBean("吃瓜群众喜欢的"));
        datas.add(new FlowBean("军事"));
        datas.add(new FlowBean("娱乐圈"));

        datas.add(new FlowBean("我猜你也许喜欢的吧"));
        datas.add(new FlowBean("八卦"));
        datas.add(new FlowBean("老板让我随便推送的"));
        datas.add(new FlowBean("张旭童的那些事儿"));
        datas.add(new FlowBean("小马可以来了"));
        return datas;
    }
}
