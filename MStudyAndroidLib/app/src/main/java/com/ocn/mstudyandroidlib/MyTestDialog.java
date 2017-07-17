package com.ocn.mstudyandroidlib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flyco.animation.BaseAnimatorSet;
import com.flyco.animation.FlipEnter.FlipVerticalSwingEnter;
import com.flyco.animation.FlipExit.FlipVerticalExit;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.NormalDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by 1900 on 2017/7/11.
 */

public class MyTestDialog extends AppCompatActivity {
    @BindView(R.id.normal_dialog_default_two_bt)
    Button mNormalDialogDefaultTwoBt;

    private BaseAnimatorSet mBasIn;
    private BaseAnimatorSet mBasOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytest_dialog);
        ButterKnife.bind(this);
//        mBasIn = new FlipVerticalSwingEnter();  // dialog 进入动画
        mBasIn =  new FlipVerticalSwingEnter();// dialog 进入动画
        mBasOut = new FlipVerticalExit();       // dialog 消失动画

    }

    public static Intent newIntent(Context context) {
        return new Intent(context, MyTestDialog.class);
    }

    @OnClick(R.id.normal_dialog_default_two_bt)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.normal_dialog_default_two_bt: //通用的_含两个按钮的
                final NormalDialog dialog = new NormalDialog(this);
                dialog.content("是否确定退出程序?")//
                        .showAnim(mBasIn)//
                        .dismissAnim(mBasOut)//
                        .show();

                dialog.setOnBtnClickL(
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                Toast.makeText(MyTestDialog.this, "左",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        },
                        new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                Toast.makeText(MyTestDialog.this, "右",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                break;
            default:
                break;
        }

    }
}
