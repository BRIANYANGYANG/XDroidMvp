package com.yangpf.xdroidmvp.V;

import com.yangpf.xdroidmvp.P.PAlarm;

import cn.droidlover.xdroidmvp.mvp.IView;

/**
 * Created by Administrator on 2018/7/1 0001.
 */

public interface IAlarmV extends IView<PAlarm> {


    void loginEX(String e);
    void loginSuc();

    void AlarmEX(String e);
    void AlarmSuc();

    void showText(String t);
}
