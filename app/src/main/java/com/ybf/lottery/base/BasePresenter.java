package com.ybf.lottery.base;

/**
 * Created by XQyi on 2018/3/3.
 * Use: presenter基类（不带mvp）
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T baseView);

    void detachView();
}
