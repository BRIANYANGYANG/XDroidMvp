package com.yangpf.xdroidmvp.V;

import com.yangpf.xdroidmvp.P.PMulti;

import cn.droidlover.xdroidmvp.mvp.IView;

/**
 * Created by Administrator on 2018/6/17 0017.
 */

/**
 * view公共方法抽取
 */
public interface ICommonV extends IView<PMulti>{
    void showError(Exception e);

    void loadImg(String path);




}
