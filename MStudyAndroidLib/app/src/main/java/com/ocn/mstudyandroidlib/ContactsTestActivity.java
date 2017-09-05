package com.ocn.mstudyandroidlib;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactsTestActivity extends AppCompatActivity {

    @BindView(R.id.contacts_lv)
    ListView contactsLv;

    List<String> contactsStr;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_test);
        ButterKnife.bind(this);
        contactsStr = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsStr);
        contactsLv.setAdapter(adapter);
        // 动态权限申请
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        } else {
            // 访问通讯录的内容提供器
            readContacts();
        }
    }

    /**
     * 读取通讯录
     */
    private void readContacts() {
        Cursor cursor = null;
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contactsStr.add(contactName + "\n" + number);
            }
            cursor.close();
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 访问通讯录的内容提供器
                    readContacts();
                } else {
                    Toast.makeText(this, "权限申请失败！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    public static Intent getInstance(Context mContext) {
        return new Intent(mContext, ContactsTestActivity.class);
    }
}
