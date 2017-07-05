package com.a1900.android.study_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.allen.apputils.MLog;
import com.itheima.loopviewpager.LoopViewPager;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
import org.itheima.recycler.header.RecyclerViewHeader;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by 1900 on 2017/7/4.
 */

public class BaseRecyclerAdapterActivity extends AppCompatActivity {

    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
//    @BindView(R.id.recycler_view)
//    ItheimaRecyclerView mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    LoopViewPager mLoopViewPager;
    private  ItheimaRecyclerView mRecyclerView;
    private int state = 0;
    private static final int STATE_REF = 1;
    private static final int STATE_MORE = 2;
    private String nextPageToken = "";
    private NewsBean mNewsBean;
    private List<NewsBean.ResultBean.ItemsBean> itemsBeen = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baserecycleradapter_activity);
        ButterKnife.bind(this);

        RecyclerViewHeader header = (RecyclerViewHeader) findViewById(R.id.recycler_header);
        mRecyclerView = (ItheimaRecyclerView) findViewById(R.id.recycler_view);
        header.attachTo(mRecyclerView);

        mLoopViewPager = (LoopViewPager) findViewById(R.id.lvp_pager);

        
        initBanner();
        
       pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<NewsBean>(mSwipeRefreshLayout, mRecyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_recylerview;
            }


            @Override
            public String getApi() {
                String url = "action/apiv2/news?pageToken=";
                switch (state) {
                    case STATE_REF:
                        break;
                    case STATE_MORE:
                        nextPageToken =  mNewsBean.getResult().getNextPageToken();
                        url += nextPageToken;
                        break;
                    default:
                        break;
                }
                //接口
                return url;
            }

            //是否加载更多的数据，根据业务逻辑自行判断，true表示有更多的数据，false表示没有更多的数据，如果不需要监听可以不重写该方法
            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
//                System.out.println("isMoreData" + holder);
                MLog.d("加载更多！");
                state = STATE_MORE;
                return true;
            }
        };

        pullToLoadMoreRecyclerView.setLoadingDataListener(new PullToLoadMoreRecyclerView.LoadingDataListener<NewsBean>() {

            @Override
            public void onRefresh() {
                //监听下啦刷新，如果不需要监听可以不重新该方法
                state = STATE_REF;
            }

            @Override
            public void onStart() {
                //监听http请求开始，如果不需要监听可以不重新该方法
            }

            @Override
            public void onSuccess(NewsBean newsBean ,Headers headers) {
                //监听http请求成功，如果不需要监听可以不重新该方法
                 mNewsBean= newsBean;
                List<NewsBean.ResultBean.ItemsBean> itemDatas = mNewsBean.getItemDatas();
                itemsBeen.addAll(itemDatas);
            }

            @Override
            public void onFailure() {
                //监听http请求失败，如果不需要监听可以不重新该方法
            }
        });


        pullToLoadMoreRecyclerView.requestData();
    }


    List<String> textBannerList = new ArrayList<>();
    List<String> imgBannerList = new ArrayList<>();

    private void initBanner() {
        Request request = ItheimaHttp.newGetRequest("action/apiv2/banner?catalog=1");//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<BannerBean>() {

            @Override
            public void onResponse(BannerBean bannerBean, Headers headers) {
                List<BannerBean.ResultBean.ItemsBean> itemDatas = bannerBean.getItemDatas();
                for (int i = 0; i < itemDatas.size(); i++) {
                    textBannerList.add(itemDatas.get(i).getName());
                    imgBannerList.add(itemDatas.get(i).getImg());
                }
                mLoopViewPager.setImgData(imgBannerList);
                mLoopViewPager.setTitleData(textBannerList);
                mLoopViewPager.start();
            }

            /**
             * 可以不重写失败回调
             * @param call
             * @param e
             */
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {

            }
        });
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
