package com.ocn.mnewstudyandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.ocn.mnewstudyandroid.study.smd.SMDActivity;
import com.ocn.mnewstudyandroid.study.snotification.SnotificationActivity;
import com.ocn.mnewstudyandroid.study.stakephoto.StakephotoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.s_notification_bt)
    Button mSnotificationBt;
    @BindView(R.id.s_take_photo_bt)
    Button mSTakePhotoBt;
    @BindView(R.id.s_material_design_bt)
    Button mSMaterialDesignBt;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
    }

    @OnClick({R.id.s_notification_bt, R.id.s_take_photo_bt, R.id.s_material_design_bt})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.s_notification_bt:
                startActivity(SnotificationActivity.getInstance(this));
                break;
            case R.id.s_take_photo_bt:
                startActivity(StakephotoActivity.getInstance(this));
                break;
            case R.id.s_material_design_bt:
                startActivity(SMDActivity.getInstance(this));
                break;
        }
    }
}
