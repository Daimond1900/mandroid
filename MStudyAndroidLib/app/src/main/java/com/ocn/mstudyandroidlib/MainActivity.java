package com.ocn.mstudyandroidlib;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.flyco.animation.BaseAnimatorSet;
import com.flyco.animation.FlipEnter.FlipVerticalSwingEnter;
import com.flyco.animation.FlipExit.FlipVerticalExit;
import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.widget.MaterialDialog;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ezy.boost.update.ICheckAgent;
import ezy.boost.update.IUpdateChecker;
import ezy.boost.update.IUpdateParser;
import ezy.boost.update.UpdateError;
import ezy.boost.update.UpdateInfo;
import ezy.boost.update.UpdateManager;
import ezy.boost.update.UpdateUtil;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @BindView(R.id.test_dialog_bt)
    Button mTestDialogBt;
    @BindView(R.id.test_loading_image_lib_bt)
    Button mTestLoadingImageLibBt;
    @BindView(R.id.test_image_bt)
    ImageView mTestImageBt;

    String mCheckUrl = "http://139.196.90.28:3000/index/news";

    String mUpdateUrl = "http://139.196.90.28:3000/down/mstudylib.apk";
    @BindView(R.id.test_ui_state_change_bt)
    Button mTestUiStateChangeBt;
    @BindView(R.id.test_permission_bt)
    Button mTestPermissionBt;
    @BindView(R.id.test_loading_dialog_bt)
    Button mTestLoadingDialogBt;
    @BindView(R.id.test_design_bt)
    Button mTestDesignBt;
    @BindView(R.id.test_share_bt)
    Button mTestShareBt;
    @BindView(R.id.test_broadcast_bt)
    Button mTestBroadcastBt;
    @BindView(R.id.test_permission1_bt)
    Button mTestPermission1Bt;
    @BindView(R.id.test_other_provider_bt)
    Button mTtestOtherProviderBt;
    private BaseAnimatorSet mBasIn;
    private BaseAnimatorSet mBasOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mBasIn = new FlipVerticalSwingEnter();// dialog 进入动画
        mBasOut = new FlipVerticalExit();       // dialog 消失动画
        UpdateManager.setDebuggable(true);
        UpdateManager.setUrl(mCheckUrl, "yyb");
        UpdateManager.setWifiOnly(false);
//        UpdateManager.check(this);

        check(false, true, false, false, true, 998);

//        UpdateUtil.md5()

//

    }


    void check(boolean isManual, final boolean hasUpdate, final boolean isForce, final boolean isSilent, final boolean isIgnorable, final int
            notifyId) {
        UpdateManager.create(this).setChecker(new IUpdateChecker() {
            @Override
            public void check(ICheckAgent agent, String url) {
                Log.e("ezy.update", "checking");
                HttpURLConnection connection = null;
                try {
                    connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestProperty("Accept", "application/json");
                    connection.connect();
                    if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        agent.setInfo(UpdateUtil.readString(connection.getInputStream()));
                    } else {
                        agent.setError(new UpdateError(UpdateError.CHECK_HTTP_STATUS, "" + connection.getResponseCode()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    agent.setError(new UpdateError(UpdateError.CHECK_NETWORK_IO));
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).setUrl(mCheckUrl).setManual(isManual).setNotifyId(notifyId).setParser(new IUpdateParser() {
            @Override
            public UpdateInfo parse(String source) throws Exception {

                UpdateInfo info = new UpdateInfo();
                info.hasUpdate = hasUpdate;
                info.updateContent = "• 支持文字、贴纸、背景音乐，尽情展现欢乐气氛；\n• 两人视频通话支持实时滤镜，丰富滤镜，多彩心情；\n• 图片编辑新增艺术滤镜，一键打造文艺画风；\n• 资料卡新增点赞排行榜，看好友里谁是魅力之王。";
                info.versionCode = 1;
                info.versionName = "v1.0.0";
                info.url = mUpdateUrl;
                info.md5 = "51EA36DF7FDC8EE9271B232FC42480B3";
                info.size = 10149314;
                info.isForce = isForce;
                info.isIgnorable = isIgnorable;
                info.isSilent = isSilent;
                return info;
            }
        }).check();
    }

    @OnClick({R.id.test_design_bt,
            R.id.test_other_provider_bt,
            R.id.test_permission1_bt,
            R.id.test_loading_dialog_bt,
            R.id.test_permission_bt,
            R.id.test_dialog_bt,
            R.id.test_loading_image_lib_bt,
            R.id.test_ui_state_change_bt,
            R.id.test_broadcast_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.test_dialog_bt:   // 测试dialog
                startActivity(MyTestDialog.newIntent(MainActivity.this));
                break;
            case R.id.test_loading_image_lib_bt:   // 测试图片加载
                Glide.with(this).load("http://139.196.90.28:3000/images/ic_demo_org.jpg")
                        .placeholder(R.drawable.ic_demo_org)
                        .error(R.drawable.mask_starfish)
                        .into(mTestImageBt);
                break;

            case R.id.test_ui_state_change_bt:
                startActivity(MyTestStateLayout.newIntent(MainActivity.this));
                break;
            case R.id.test_permission_bt:
                final MaterialDialog dialog = new MaterialDialog(this);
                dialog.content("确定打开要相机吗？")
                        .btnNum(2)
                        .btnText("取消", "确定")
                        .showAnim(mBasIn)
                        .dismissAnim(mBasOut)
                        .show();
                dialog.setOnBtnClickL(new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        Toast.makeText(MainActivity.this, "那就对了", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }, new OnBtnClickL() {
                    @Override
                    public void onBtnClick() {
                        PermissionGen.needPermission(MainActivity.this, 100,
                                new String[]{
                                        Manifest.permission.CAMERA
                                }
                        );
                        dialog.dismiss();
                    }
                });

                break;
            case R.id.test_loading_dialog_bt:
//                CustomLoadingDialog.createLoadingDialog(this, "jiaz").show();
                Toast.makeText(this, "待完善", Toast.LENGTH_SHORT).show();
                break;
            case R.id.test_design_bt:
                startActivity(StudyDesignActivity.newIntent(this));
                break;
            case R.id.test_share_bt:

                break;
            case R.id.test_broadcast_bt:
                startActivity(BroadCastTestActivity.getInstance(this));
                break;
            case R.id.test_permission1_bt:
                startActivity(RunPremissionActivity.getInstance(this));
                break;
            case R.id.test_other_provider_bt:
                startActivity(ContactsTestActivity.getInstance(this));
                break;
            default:
                break;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }


    @PermissionSuccess(requestCode = 100)
    public void doSomething() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 启动系统相机
        startActivity(intent);
    }

    @PermissionFail(requestCode = 100)
    public void doFailSomething() {
        Toast.makeText(this, "Contact permission is not granted", Toast.LENGTH_SHORT).show();
    }

}
