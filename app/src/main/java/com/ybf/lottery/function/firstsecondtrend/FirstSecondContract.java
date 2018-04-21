package com.ybf.lottery.function.firstsecondtrend;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;
import com.ybf.lottery.model.bean.firstsecondtrendbean.FirstSecondTrendBean;
import com.ybf.lottery.model.bean.locationtrendbean.LocationTrendBean;

/**
 * Created by XQyi on 2018/4/21.
 * Use:冠亚走势的契约类contract
 */

public interface FirstSecondContract {

    interface IView extends BaseView{
        void loginSuccess(FirstSecondTrendBean firstSecondTrendBean);
        void loginFailed(FirstSecondTrendBean firstSecondTrendBean);
        void loginError();
    }
    interface P extends BasePresenter<IView>{
        void loadData(String period);
    }
}
