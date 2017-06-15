package com.a1900.android.study_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.a1900.android.study_android.study.fragment.CrimeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.study_fragment_button)
    Button mStudyFragmentButton;
    @BindView(R.id.study_recyclerview_button)
    Button mStudyRecyclerviewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.study_fragment_button, R.id.study_recyclerview_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.study_fragment_button:
                startActivity(CrimeActivity.newCrimeActivity(this)); /*学习UI fragment与fragment 管理器 入口*/
                break;
            case R.id.study_recyclerview_button:

                break;
            default:
                break;
        }
    }
}
