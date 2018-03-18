package com.ybf.lottery.contract;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;

/**
 * Created by XQyi on 2018/3/3.
 * Use:
 */

public interface MainContract {

    interface IView extends BaseView {

    }
    interface Presenter extends BasePresenter<IView> {
        void loadData();
    }
}