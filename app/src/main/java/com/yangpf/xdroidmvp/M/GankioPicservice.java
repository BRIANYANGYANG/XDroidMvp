package com.yangpf.xdroidmvp.M;

/**
 * Created by Administrator on 2018/6/18 0018.
 */

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Description: 下载进度回调
 * Created by jia on 2017/11/30.
 * 人之所以能，是相信能
 */
public interface GankioPicservice {
    @GET("large/{fileName}")
    Observable<ResponseBody> downloadPic(@Path("fileName") String fileName);

}
