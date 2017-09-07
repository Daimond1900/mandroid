package com.ocn.updateapk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.cheack_version_bt)
    Button mCheackVersionBt;
    @BindView(R.id.version_content_tv)
    TextView mVersionContentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.cheack_version_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cheack_version_bt:
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.66.122:3000")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                final ServiceData.UpdateApk updateApk = retrofit.create(ServiceData.UpdateApk.class);
                Call<ResponseBody> stringReaderCall = updateApk.ICheckVersion();
                stringReaderCall.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                        final Response<ResponseBody> response1 = response;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                final StringBuilder sb = new StringBuilder();
                                Log.d(TAG, "onResponse: " + response1.body());
                                ResponseBody body = response1.body();
                                long length = body.contentLength();
                                Log.d(TAG, "onResponse: 文件长度： " + length);
                                Reader reader = body.charStream();
                                BufferedReader bufferedReader = new BufferedReader(reader);
                                String line = null;
                                try {
                                    while ((line = bufferedReader.readLine()) != null) {
                                        sb.append(line);
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } finally {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Gson gson = new Gson();
                                        UpdateApkInfo updateApkInfo = gson.fromJson(sb.toString(), UpdateApkInfo.class);
                                        Log.d(TAG, "run: updateApkInfo : " + updateApkInfo.getCODE());
                                        Log.d(TAG, "run: Float.parseFloat(updateApkInfo.getCODE()) > 1.34 : " + (Float.parseFloat(updateApkInfo.getCODE()) > 1.34));
                                        if (Float.parseFloat(updateApkInfo.getCODE()) > Float.parseFloat("1.34")) {
                                            mVersionContentTv.setText(sb.toString());
                                        } else {
                                            mVersionContentTv.setText("已经是最新的了");
                                        }
                                    }
                                });
                            }
                        }).start();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + call.request().url());
                        Log.d(TAG, t.toString());
                    }
                });

                break;
        }
    }
}
