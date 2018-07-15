package com.yangpf.xdroidmvp;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;
import com.whieenz.LogCook;
import com.yangpf.xdroidmvp.M.DownloadService;
import com.yangpf.xdroidmvp.M.DownloadUtils;
import com.yangpf.xdroidmvp.M.JsDownloadListener;
import com.yangpf.xdroidmvp.utils.ACache;
import com.yangpf.xdroidmvp.utils.logtofile.LogUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.droidlover.xdroidmvp.log.XLog;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.message;
import static android.view.View.X;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.img1)
    ImageView img1;
    private final String IMAGE_URL = "https://ww1.sinaimg.cn/large/0065oQSqly1frslruxdr1j30j60ok79c.jpg/";
    //https://ww1.sinaimg.cn/large/0065oQSqly1frslruxdr1j30j60ok79c.jpg


    private static final int IS_SUCCESS = 1;
    private static final int IS_FAIL = 0;

    private OkHttpClient client;

   final String TAG = "MainActivity";

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        asyncGet();

        logTest();

    }

    private void logTest() {
        ACache aCache = ACache.get(this);
        aCache.put("testkey", "01");

        String a = aCache.getAsString("testkey");
        Logger.d(TAG+ "*****************************");
        Logger.d(TAG + a);

        LogCook.d(TAG, a);
        LogCook.d(TAG, "***********LogCook******************");


        Observable.interval(2, 3, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        LogCook.d(TAG, String.valueOf(i++));
                        Logger.d(TAG + i++);

                        for (int j = 0; j< 20; j++) {
                            LogUtils.i(TAG,"" +   i++);
                        }



                    }
                });


    }


    /**
     * 异步get,直接调用
     */
    private void asyncGet() {
        client = new OkHttpClient();
        final Request request = new Request.Builder().get()
                .url(IMAGE_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                if (response.isSuccessful()) {
                    XLog.d("okhttp", "response.isSuccessful");
                 DownloadUtils.writeFile(response.body().byteStream(), "/sdcard/666.jpg");

                } else {
                    XLog.d("okhttp", "response.fail");
                }
            }
        });
    }
}
