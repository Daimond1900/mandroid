package com.ocn.mstudyandroidlib;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RunPremissionActivity extends AppCompatActivity {

    @BindView(R.id.call_bt)
    Button mCallBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_premission);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.call_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.call_bt:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    callPhone();
                }
                break;
        }
    }

    private void callPhone() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    callPhone();
                } else {
                    Toast.makeText(this, "没有权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    public static Intent getInstance(Context mContxt) {
        return new Intent(mContxt, RunPremissionActivity.class);
    }
}
