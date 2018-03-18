package com.ybf.lottery.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by XQyi on 2018/3/9.
 * Use:带MVP的fragment基类
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment {

    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
    }

    public abstract T initPresenter();

    @Override
    public void onDestroy() {
        if (null != mPresenter) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }
}
