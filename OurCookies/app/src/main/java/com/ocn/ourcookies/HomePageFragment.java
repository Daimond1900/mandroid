package com.ocn.ourcookies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.allen.apputils.MLog;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by 1900 on 2017/7/6.
 */

public class HomePageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        initData();

        return view;
    }

    private void initData() {
        Request request = ItheimaHttp.newGetRequest("user/regist");
        request.putParams("username","lovexj");
        request.putParams("password","5201314");
        request.putParams("name","爱哭的大脸猫");
        Call call = ItheimaHttp.send(request, new HttpResponseListener<UserBean>() {

            @Override
            public void onResponse(UserBean userBean) {
                MLog.d("info = " + userBean.getInfo() + "---message = " + userBean.getMessage());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable e) {
                super.onFailure(call, e);
                MLog.d(e.getMessage());
            }
        });
    }


    public static Fragment newInstance() {
        return new HomePageFragment();
    }
}
