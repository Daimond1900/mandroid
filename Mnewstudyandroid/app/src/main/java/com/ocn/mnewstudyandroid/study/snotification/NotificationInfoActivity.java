package com.ocn.mnewstudyandroid.study.snotification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ocn.mnewstudyandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationInfoActivity extends AppCompatActivity {

    @BindView(R.id.notify_info_text)
    TextView mNotifyInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_info);
        ButterKnife.bind(this);
        String notify_content_text = getIntent().getStringExtra("notify_content_text");
//        int notify_id = getIntent().getIntExtra("notify_id", 0);
        mNotifyInfoText.setText(notify_content_text);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.cancel(notify_id);
    }


    public static Intent getInstance(Context context,  String cText) {
        Intent intent = new Intent(context, NotificationInfoActivity.class);
        intent.putExtra("notify_content_text", cText);
        return intent;
    }
}
