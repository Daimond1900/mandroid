package com.ocn.mnewstudyandroid.study.snotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ocn.mnewstudyandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SnotificationActivity extends AppCompatActivity {

    @BindView(R.id.send_notification_info_bt)
    Button mSendNotificationInfoBt;
    @BindView(R.id.send_notification_info_bt1)
    Button mSendNotificationInfoBt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snotification);
        ButterKnife.bind(this);
    }


    public static Intent getInstance(Context context) {
        return new Intent(context, SnotificationActivity.class);
    }

    @OnClick({R.id.send_notification_info_bt, R.id.send_notification_info_bt1})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.send_notification_info_bt:
                sendNotification(this, 1);
                break;
            case R.id.send_notification_info_bt1:
                sendNotification(this, 2);
                break;
        }
    }

    private void sendNotification(Context context,int notifyId) {

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, NotificationInfoActivity.getInstance(this, "我是正文，我是正文，我是正文，我是正文，我是正文"), 0);
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("我是标题")   // 指定标题内容，状态栏就可以看到的内容
                .setContentText("我是正文，我是正文，我是正文，我是正文，我是正文")     // 正文
                .setWhen(System.currentTimeMillis())        // 被创建的时间，以毫秒为单位，下拉是这个时间会显示在上面
                .setSmallIcon(R.mipmap.ic_launcher)         // 小图标
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setAutoCancel(true)
                .build();

        notificationManager.notify(notifyId, notification);
    }
}


