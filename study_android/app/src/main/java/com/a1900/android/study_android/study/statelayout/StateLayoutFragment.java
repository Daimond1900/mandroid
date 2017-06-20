package com.a1900.android.study_android.study.statelayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.a1900.android.study_android.R;
import com.allen.apputils.MLog;
import com.allen.apputils.ToastUtils;
import com.classic.common.MultipleStatusView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 1900 on 2017/6/20.
 */

public class StateLayoutFragment extends Fragment {

    @BindView(R.id.loading_bt)
    Button mLoadingBt;
    Unbinder unbinder;
    @BindView(R.id.empty_bt)
    Button mEmptyBt;
    @BindView(R.id.error_bt)
    Button mErrorBt;
    @BindView(R.id.main_multiplestatusview)
    MultipleStatusView mMainMultiplestatusview;
    @BindView(R.id.context_bt)
    Button mCcontextBt;
    @BindView(R.id.no_network_bt)
    Button mNoNetworkBt;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MLog.LOG_OUT = true;
        MLog.d("haha------");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_state_layouot, container, false);
        unbinder = ButterKnife.bind(this, view);
        mMainMultiplestatusview.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.loading_view:

                        break;
                    case R.id.empty_retry_view:
                        ToastUtils.showShortToast("点击了空视图");
                        mMainMultiplestatusview.showLoading();
                        break;
                    case R.id.error_retry_view:
                        ToastUtils.showShortToast("点击了错误视图");
                        MLog.d("点击了错误视图");
                        break;
                    case R.id.no_network_retry_view:
                        ToastUtils.showShortToast("点击了无网络视图");
                        MLog.d("点击了无网络视图");
                        break;
                    default:
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.loading_bt, R.id.empty_bt, R.id.error_bt, R.id.context_bt, R.id.no_network_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loading_bt:
                mMainMultiplestatusview.showLoading();
                break;
            case R.id.empty_bt:
                mMainMultiplestatusview.showEmpty();
                break;
            case R.id.error_bt:
                mMainMultiplestatusview.showError();
                break;
            case R.id.context_bt:
                mMainMultiplestatusview.showContent();
                break;
            case R.id.no_network_bt:
                mMainMultiplestatusview.showNoNetwork();
                break;


        }
    }
}
