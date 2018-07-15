package com.yangpf.xdroidmvp;

import android.app.Application;
import android.os.Environment;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.whieenz.LogCook;
import com.yangpf.xdroidmvp.utils.logtofile.LogUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/15 0015.
 */

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Logger.addLogAdapter(new AndroidLogAdapter());
        CsvFormatStrategy csv = CsvFormatStrategy.newBuilder().build();
        Logger.addLogAdapter(new DiskLogAdapter(csv));


        String logPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Xlog/";

        Logger.d(logPath);

        File mFile = new File(logPath);
        if (!mFile.exists()) {

                mFile.mkdir();

        }

        LogCook.getInstance() // 单例获取LogCook实例
                .setLogPath(logPath) //设置日志保存路径
                .setLogName("test01.log") //设置日志文件名
                .isOpen(true)  //是否开启输出日志
                .isSave(true)  //是否保存日志
                .initialize(); //完成初始化Crash监听

        LogUtils.setLogDir(Environment.getExternalStorageDirectory().getAbsolutePath() + "/zlog");
        LogUtils.setEnable(true);


    }
}
