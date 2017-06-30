package com.a1900.android.study_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.a1900.android.study_android.study.erjxlk.M2jLayoutActivity;
import com.piotrek.customspinner.CustomSpinner;

/**
 * Created by m1900 on 2017/6/30.
 */

public class CustomSpinnerActivity extends AppCompatActivity{

    private CustomSpinner colorSpinner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.customspinner_activity);

        colorSpinner = (CustomSpinner) findViewById(R.id.number_spinner);

        String[] types = new String[]{"1","2","3","4","5"};
        colorSpinner.initializeStringValues(types, "请选择xx");

        colorSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomSpinnerActivity.this, "点击了",Toast.LENGTH_SHORT).show();
            }
        });

        colorSpinner.setSpinnerEventsListener(new CustomSpinner.OnSpinnerEventsListener() {
            @Override
            public void onSpinnerOpened() {
                Toast.makeText(CustomSpinnerActivity.this, "打开了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSpinnerClosed() {
                Toast.makeText(CustomSpinnerActivity.this, "关闭了",Toast.LENGTH_SHORT).show();
            }
        });
    }


    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, CustomSpinnerActivity.class);
        return intent;
    }
}
