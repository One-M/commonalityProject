package com.ybf.lottery.diyview.trend;

/**
 * Created by XQyi on 2018/3/13.
 * 在ScrollView的onScrollChanged函数中回调下面的方法....
 */
public interface ScrollChangeCallback {
    //水平方向的改变
    void changeXScroll(int left);

    //垂直方向的改变
    void changeYScoll(int top);
}
