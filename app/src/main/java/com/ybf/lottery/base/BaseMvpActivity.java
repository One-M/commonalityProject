package com.ybf.lottery.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import javax.inject.Inject;

/**
 * Created by XQyi on 2018/3/3.
 * Use: 带MVP的Activity基类
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity {

    @Inject
    protected T basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresenter = initInject();
        attach();
    }

    protected void attach() {
        if (null != basePresenter) {
            basePresenter.attachView(this);
        }
    }

    protected abstract T initInject();

    @Override
    protected void onDestroy() {
        if (null != basePresenter) {
            basePresenter.detachView();
            basePresenter = null;
        }
        super.onDestroy();
    }
}
