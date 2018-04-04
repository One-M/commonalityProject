package com.ybf.lottery.function.basictrend;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;
import com.ybf.lottery.model.bean.bjscbasictrendbean.BasicTrendBean;

/**
 * Created by XQyi on 2018/3/28.
 * Use:北京赛车基本走势Contract
 */

public interface BJRacecarBasicTrendContract {

    interface IView extends BaseView{
        void loginSuccess(BasicTrendBean basicTrendBean);
        void loginFailed(BasicTrendBean basicTrendBean);
        void loginError();
    }

    interface Presenter extends BasePresenter<IView>{
        void loadData(String period);
    }
}
