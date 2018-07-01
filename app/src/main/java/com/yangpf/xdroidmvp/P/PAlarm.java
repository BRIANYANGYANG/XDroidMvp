package com.yangpf.xdroidmvp.P;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.yangpf.xdroidmvp.M.Constants;
import com.yangpf.xdroidmvp.M.GankioPicservice;
import com.yangpf.xdroidmvp.V.IAlarmV;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.droidlover.xdroidmvp.log.XLog;
import cn.droidlover.xdroidmvp.mvp.XPresent;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/6/17 0017.
 */

public class PAlarm extends XPresent<IAlarmV>  {

    public void startLogin() {
        getV().loginEX("test login    fffffffff");
        getV().loginSuc();


    }

    public void  startAlarm() {
        getV().AlarmEX("test alarm ffffff");
        getV().AlarmSuc();

    }

    public void getAlarmData(){
        //rxjava
        io.reactivex.Observable.interval(1, TimeUnit.SECONDS).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        String t = "num=" + String.valueOf(aLong);
                        XLog.d(t);
                        getV().showText(t);
                    }
                });

    }

    private String url = "http://ww1.sinaimg.cn/large/0065oQSqly1frslruxdr1j30j60ok79c.jpg/";
    public void downloadPic(final Context mContext, final ImageView imageview) {
        //OK设置请求超时时间，读取超时时间
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ww1.sinaimg.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        GankioPicservice GankioPicservice = retrofit.create(com.yangpf.xdroidmvp.M.GankioPicservice.class);

        Observable<ResponseBody> observable = GankioPicservice.downloadPic("0065oQSqly1frslruxdr1j30j60ok79c.jpg");

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        XLog.d("**********************************");
                        byte[] bys = null;
                        try {
                            bys = value.bytes();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Glide.with(mContext).load(bys).into(imageview);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


}
