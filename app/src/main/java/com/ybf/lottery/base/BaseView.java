package com.ybf.lottery.base;

import android.support.annotation.StringRes;

/**
 * Created by XQyi on 2018/3/2.
 * Use: 全局view接口，ps:处理全局时间[全局toast提示、网络异常处理]
 */

public interface BaseView {

    //消息提示，子类里实现[toast提示]
    void showTipMsg(String msg);
    //消息提示，子类里实现[toast提示]
    void showTipMsg(@StringRes int msg);
    //网络请求加载条_显示
    void showLoading();
    //网络请求加载条_隐藏
    void hideLoading();
    //用户token判断
    void invalidToken();
    //Finish() 处理
    void myFinish();
}
