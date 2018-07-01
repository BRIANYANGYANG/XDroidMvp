package com.yangpf.xdroidmvp.V;

import android.os.Bundle;

import cn.droidlover.xdroidmvp.mvp.XActivity;

/**
 * Created by Administrator on 2018/6/17 0017.
 */

public class NoPActivity extends XActivity {
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public Object newP() {
        return null;
    }
}
