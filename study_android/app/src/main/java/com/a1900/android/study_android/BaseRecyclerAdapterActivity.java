package com.a1900.android.study_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 1900 on 2017/7/4.
 */

public class BaseRecyclerAdapterActivity extends AppCompatActivity {

    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    @BindView(R.id.recycler_view)
    ItheimaRecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baserecycleradapter_activity);
        ButterKnife.bind(this);
       pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<NewsBean>(mSwipeRefreshLayout, mRecyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_recylerview;
            }

            @Override
            public String getApi() {
                //接口
                return "action/apiv2/news?pageToken=";
            }

            //是否加载更多的数据，根据业务逻辑自行判断，true表示有更多的数据，false表示没有更多的数据，如果不需要监听可以不重写该方法
            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                System.out.println("isMoreData" + holder);
                return true;
            }
        };

        pullToLoadMoreRecyclerView.requestData();
    }


    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<NewsBean.ResultBean.ItemsBean> {
        @BindView(R.id.new_title_tv)
        TextView mNewTitleTv;
        @BindView(R.id.new_detail_tv)
        TextView mNewDetailTv;
        @BindView(R.id.create_time_tv)
        TextView mCreateTimeTv;
        @BindView(R.id.click_num_tv)
        TextView mClickNumTv;


        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override
        public void onBindRealData() {
            mNewTitleTv.setText(mData.getTitle());
            mNewDetailTv.setText(mData.getBody());
            mCreateTimeTv.setText(mData.getPubDate());
            mClickNumTv.setText(mData.getViewCount()+"");
        }
    }


    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, BaseRecyclerAdapterActivity.class);
        return intent;
    }
}
