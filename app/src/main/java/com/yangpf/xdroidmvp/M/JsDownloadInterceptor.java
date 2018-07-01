package com.yangpf.xdroidmvp.M;

import com.yangpf.xdroidmvp.M.JsDownloadListener;
import com.yangpf.xdroidmvp.M.JsResponseBody;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/6/18 0018.
 */

public class JsDownloadInterceptor implements Interceptor {

    private JsDownloadListener downloadListener;

    public JsDownloadInterceptor(JsDownloadListener downloadListener) {
        this.downloadListener = downloadListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder().body(
                new JsResponseBody(response.body(), downloadListener)).build();
    }
}
