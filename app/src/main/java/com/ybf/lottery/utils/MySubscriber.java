package com.ybf.lottery.utils;

import com.ybf.lottery.base.BaseView;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by XQyi on 2018/3/3.
 * Use:retrofit 自定义订阅者 继承ResourceSubscriber 方便CompositeDisposable的处理  防止内存泄漏问题
 */

public abstract class MySubscriber<T> extends ResourceSubscriber<T> {

    private BaseView baseView;//获得BaseView实例
    private boolean showLoading;

    /**
     * 自定义异常处理
     */
    public MySubscriber() {}

    /**
     * 可调用BaseView中 异常提示
     * @param baseView baseview
     */
    public MySubscriber(BaseView baseView) {
        this.baseView = baseView;
    }

    /**
     * 可调用BaseView中 异常提示
     * @param baseView baseview
     * @param showLoading 是否显示baseview的加载框
     */
    public MySubscriber(BaseView baseView, boolean showLoading) {
        this.baseView = baseView;
        this.showLoading = showLoading;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (null != baseView && showLoading) {
            baseView.showLoading();
        }
    }

    @Override
    public void onError(Throwable t) {
        if (null == baseView) {
            return;
        }
        baseView.hideLoading();
        if (t instanceof ApiException) {
            ApiException apiException = (ApiException) t;
            switch (apiException.getCode()) {
                case HttpCode.NO_PARAMETER:
                    baseView.showTipMsg("参数为空");
                    break;
                case HttpCode.SERVER_ERR:
                    baseView.showTipMsg("服务器错误");
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onComplete() {
        if (null != baseView) {
            baseView.hideLoading();
        }
    }
}
