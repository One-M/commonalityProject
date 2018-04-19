package com.ybf.lottery.function.winnerrunnersumvalue;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;
import com.ybf.lottery.model.bean.winnerrunnersumvaluebean.WinnerRunnerSumValueBean;

/**
 * Created by XQyi on 2018/4/19.
 * Use:冠亚和值的Contract
 */

public interface WinnerRunnerSumValueContract {

    interface mView extends BaseView{
        void loadSuccess(WinnerRunnerSumValueBean winnerRunnerSumValueBean);
        void loadFailed(WinnerRunnerSumValueBean winnerRunnerSumValueBean);
        void loadError();
    }

    interface P extends BasePresenter<mView>{
        void loadData(String period);
    }
}
