package com.yangpf.xdroidmvp.V;

import android.os.Bundle;

import com.yangpf.xdroidmvp.P.PMulti;

import cn.droidlover.xdroidmvp.log.XLog;
import cn.droidlover.xdroidmvp.mvp.XActivity;

/**
 * Created by Administrator on 2018/6/17 0017.
 */

public class CActivity extends XActivity<PMulti> implements ICommonV {
    @Override
    public void initData(Bundle savedInstanceState) {
        getP().loadData();
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public PMulti newP() {
        return new PMulti();
    }


    @Override
    public void showError(Exception e) {
        XLog.d("c", e.toString());
    }

    @Override
    public void loadImg(String path) {
        XLog.d("C", path);
    }
}