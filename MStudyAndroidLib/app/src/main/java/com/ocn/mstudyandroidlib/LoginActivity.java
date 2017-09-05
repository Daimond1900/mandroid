package com.ocn.mstudyandroidlib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.username_et)
    EditText mUsernameEt;
    @BindView(R.id.password_et)
    EditText mPasswordEt;
    @BindView(R.id.login_bt)
    Button mLoginBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_bt:
                String username = mUsernameEt.getText().toString().trim();
                String password = mPasswordEt.getText().toString().trim();
                if ("123".equals(username) && "123".equals(password)) {
                    startActivity(MainTestActivity.getInstance(this));
                }
                break;
        }
    }

    public static Intent getInstance(Context mContext) {
        return new Intent(mContext, LoginActivity.class);
    }
}
