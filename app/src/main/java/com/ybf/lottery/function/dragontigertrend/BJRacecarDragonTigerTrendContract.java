package com.ybf.lottery.function.dragontigertrend;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;
import com.ybf.lottery.model.bean.dragontigertrendbean.DragonTigerTrendBean;

/**
 * Created by XQyi on 2018/4/13.
 * Use:龙虎走势的contract
 */

public interface BJRacecarDragonTigerTrendContract {

    interface mView extends BaseView{
        void loginSuccess(DragonTigerTrendBean dragonTigerTrendBean);
        void loginFailed(DragonTigerTrendBean dragonTigerTrendBean);
        void loginError();
    }

    interface Presenter extends BasePresenter<mView>{
        void loadData(String period , String fType);
    }
}
