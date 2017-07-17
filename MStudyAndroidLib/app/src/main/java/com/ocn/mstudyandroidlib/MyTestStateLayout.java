package com.ocn.mstudyandroidlib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.classic.common.MultipleStatusView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 1900 on 2017/7/13.
 */

public class MyTestStateLayout extends AppCompatActivity {


    @BindView(R.id.test_loading)
    Button mTestLoading;
    @BindView(R.id.test_error)
    Button mTestError;
    @BindView(R.id.test_empty)
    Button mTestEmpty;
    @BindView(R.id.test_no_net)
    Button mTestNoNet;
    @BindView(R.id.test_context)
    Button mTestContext;
    @BindView(R.id.main_multiplestatusview)
    MultipleStatusView mMainMultiplestatusview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytest_state_layout);
        ButterKnife.bind(this);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MyTestStateLayout.class);
    }

    @OnClick({R.id.test_loading, R.id.test_error, R.id.test_empty, R.id.test_no_net, R.id.test_context})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.test_loading:
                mMainMultiplestatusview.showLoading();
                break;
            case R.id.test_error:
                mMainMultiplestatusview.showError();
                break;
            case R.id.test_empty:
                mMainMultiplestatusview.showEmpty();
                break;
            case R.id.test_no_net:
                mMainMultiplestatusview.showNoNetwork();
                break;
            case R.id.test_context:
                mMainMultiplestatusview.showContent();
                break;
        }
    }
}
