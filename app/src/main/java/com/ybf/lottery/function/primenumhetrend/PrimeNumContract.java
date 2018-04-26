package com.ybf.lottery.function.primenumhetrend;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;
import com.ybf.lottery.model.bean.bigsmalltrendbean.BigSmallTrendBean;

/**
 * Created by XQyi on 2018/4/21.
 * Use:质合形态的契约类contract
 */

public interface PrimeNumContract {

    interface IView extends BaseView{
        void loginSuccess(BigSmallTrendBean bigSmallTrendBean);
        void loginFailed(BigSmallTrendBean bigSmallTrendBean);
        void loginError();
    }
    interface P extends BasePresenter<IView>{
        void loadData(String period);
    }
}
