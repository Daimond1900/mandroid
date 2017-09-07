package com.ocn.updateapk;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

/**
 * Created by 1900 on 2017/9/6.
 */

public interface ServiceData {

    interface UpdateApk {
        @Streaming
        @GET("/down/version.txt")
        Call<ResponseBody> ICheckVersion();

    }

}
