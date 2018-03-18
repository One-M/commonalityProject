package com.ybf.lottery.activity;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;

/**
 * Created by XQyi on 2018/3/9.
 * Use:
 */

public interface RaceCarContract {

    interface IView extends BaseView {

    }
    interface Presenter extends BasePresenter<IView> {
        void loadData();
    }
}
