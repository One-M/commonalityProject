package com.ybf.lottery.function.homefunction;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;
import com.ybf.lottery.model.bean.BJRacecarCountDownBean;

/**
 * Created by XQyi on 2018/4/11.
 * Use:首页的contract
 */

public interface HomeContract {
    interface IView extends BaseView {

        void loadTimeSuccess(BJRacecarCountDownBean countDownBean);
        void loadTimeFailed(BJRacecarCountDownBean failedData);
    }

    interface Presenter extends BasePresenter<IView> {
        void loadTimeData();
    }
}
