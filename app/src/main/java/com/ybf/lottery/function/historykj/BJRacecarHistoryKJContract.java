package com.ybf.lottery.function.historykj;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;
import com.ybf.lottery.model.bean.BJRacecarCountDownBean;
import com.ybf.lottery.model.bean.BJRacecarHistoryKJBean;

import java.util.List;

/**
 * Created by XQyi on 2018/3/15.
 * Use:北京赛车历史开奖的Contract
 */

public interface BJRacecarHistoryKJContract {

    interface IView extends BaseView {
        void loadSuccess(List<BJRacecarHistoryKJBean> historyKJBeanList);
        void loadFailed();
        void sereverError();

        void loadTimeSuccess(BJRacecarCountDownBean countDownBean);
        void loadTimeFailed(BJRacecarCountDownBean failedData);
    }
    interface Presenter extends BasePresenter<IView> {
        void loadData(String drawDate);
        void loadTimeData();
    }
}
