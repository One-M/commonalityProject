package com.ybf.lottery.function.locationtrend;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;
import com.ybf.lottery.model.bean.locationtrendbean.LocationTrendBean;

/**
 * Created by XQyi on 2018/4/21.
 * Use:定位走势的契约类contract
 */

public interface LocationTrendContract {

    interface IView extends BaseView{
        void loginSuccess(LocationTrendBean locationTrendBean);
        void loginFailed(LocationTrendBean locationTrendBean);
        void loginError();
    }
    interface P extends BasePresenter<IView>{
        void loadData(String period , int fType);
    }
}
