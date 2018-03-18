package com.ybf.lottery.function;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;
import com.ybf.lottery.model.bean.BJRacecarCountDownBean;

/**
 * Created by XQyi on 2018/3/15.
 * Use:北京赛车activity的Contract
 */

public interface BJRacecarContract {

    interface IView extends BaseView {
        void loadSuccess(BJRacecarCountDownBean countDownBean);
        void loadFailed(BJRacecarCountDownBean failedData);
    }
    interface Presenter extends BasePresenter<IView> {
        void loadData();
    }
}
