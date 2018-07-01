package com.yangpf.xdroidmvp.P;

import com.yangpf.xdroidmvp.V.ICommonV;

import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * Created by Administrator on 2018/6/17 0017.
 */

public class PMulti extends XPresent<ICommonV>  {

    public void loadData(){
        getV().showError(new IllegalStateException("test ill"));
    }
}
