package com.yangpf.xdroidmvp.M;

/**
 * Created by Administrator on 2018/6/18 0018.
 */

/**
 * Description: 下载进度回调
 * Created by jia on 2017/11/30.
 * 人之所以能，是相信能
 */
public interface JsDownloadListener {

    void onStartDownload();

    void onProgress(int progress);

    void onFinishDownload();

    void onFail(String errorInfo);

}
