package com.a1900.android.study_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.a1900.android.study_android.entity.User;
import com.a1900.android.study_android.greendao.UserDao;
import com.a1900.android.study_android.utils.GreenDaoManager;
import com.allen.apputils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 1900 on 2017/7/5.
 */

public class StudyGreenDaoActivity extends AppCompatActivity {

    @BindView(R.id.add_bt)
    Button mAddBt;
    @BindView(R.id.query_bt)
    Button mQueryBt;
    @BindView(R.id.update_bt)
    Button mUpdateBt;
    @BindView(R.id.delete_bt)
    Button mDdeleteBt;
    private UserDao userDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_greendao_activity);
        ButterKnife.bind(this);
        userDao = GreenDaoManager.getInstance().getSession().getUserDao();
    }


    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, StudyGreenDaoActivity.class);
        return intent;
    }

    @OnClick({R.id.delete_bt,R.id.update_bt, R.id.add_bt, R.id.query_bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.delete_bt:
                User findDelete = userDao.queryBuilder().where(UserDao.Properties.Id.eq("3")).build().unique();
                if (findDelete!=null) {
                    userDao.delete(findDelete);
                }else {
                    ToastUtils.showShortToast("没有发现删除对象");
                }

                break;
            case R.id.add_bt:
                userDao.insert(new User(null, "weiguo"));
                break;
            case R.id.update_bt:
                User findUser = userDao.queryBuilder().where(UserDao.Properties.Id.eq(1)).build().unique();
                if (findUser != null) {
                    findUser.setUsername("梁秀娟");
                    userDao.update(findUser);
                } else {
                    ToastUtils.showShortToast("没有结果");
                }

                break;
            case R.id.query_bt:
                List<User> userList = userDao.queryBuilder().where(UserDao.Properties.Id.notEq(999))
                        .orderAsc(UserDao.Properties.Id)
                        .build().list();

                ToastUtils.showShortToast("" + userDao.queryBuilder().count() + "count数据");

                break;
            default:
                break;
        }

    }
}
