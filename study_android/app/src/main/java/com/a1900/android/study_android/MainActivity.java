package com.a1900.android.study_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.a1900.android.study_android.study.erjxlk.M2jLayoutActivity;
import com.a1900.android.study_android.study.fragment.list.CrimeListActivity;
import com.a1900.android.study_android.study.seachedit.SoftkyLayoutActivity;
import com.a1900.android.study_android.study.statelayout.StateLayoutActivity;
import com.allen.apputils.MLog;
import com.allen.apputils.ToastUtils;
import com.allen.apputils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.study_fragment_button)
    Button mStudyFragmentButton;
    @BindView(R.id.study_statelayout_button)
    Button mStudyStatelayoutButton;
    @BindView(R.id.softkey_seach_bt)
    Button mSoftkeySeachBt;
    @BindView(R.id.m2jxl_bt)
    Button mM2jxlBt;
    @BindView(R.id.customSpinner_bt)
    Button mCustomSpinner_bt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MLog.LOG_OUT = true;
        Utils.init(this);
        ToastUtils.init(true);
    }

    @OnClick({R.id.study_fragment_button, R.id.study_statelayout_button, R.id.softkey_seach_bt, R.id.m2jxl_bt,R.id.customSpinner_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.study_fragment_button:
                startActivity(CrimeListActivity.newCrimeListActivity(this)); /*学习UI fragment与fragment 管理器 入口*/
                break;
            case R.id.study_statelayout_button:
                startActivity(StateLayoutActivity.getIntent(this));
                break;
            case R.id.softkey_seach_bt:
                startActivity(SoftkyLayoutActivity.getIntent(this));
                break;
            case R.id.m2jxl_bt:
                startActivity(M2jLayoutActivity.getIntent(this));
                break;
            case R.id.customSpinner_bt:
                startActivity(CustomSpinnerActivity.getIntent(this));
                break;
            default:
                break;
        }
    }

}
