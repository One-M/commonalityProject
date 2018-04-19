package com.ybf.lottery.function.winnerrunnersumvalue;

import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.model.bean.winnerrunnersumvaluebean.WinnerRunnerSumValueBean;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/4/19.
 * Use:冠亚和值的presenter
 */

public class WinnerRunnerSumValuePresenter extends BaseMvpPresenter<WinnerRunnerSumValueContract.mView> implements WinnerRunnerSumValueContract.P{

    ManageRepository repository;
    public WinnerRunnerSumValuePresenter(WinnerRunnerSumValueContract.mView view) {
        super(view);
        this.repository = dataManager.manageRepository;
    }

    @Override
    public void loadData(String period) {
        Flowable<WinnerRunnerSumValueBean> flowable = repository.bjscWRSumValueLoginData(period);
        addSubscribe(flowable, new MySubscriber<WinnerRunnerSumValueBean>() {
            @Override
            public void onNext(WinnerRunnerSumValueBean winnerRunnerSumValueBean) {
                if (winnerRunnerSumValueBean.getCode() == 200) {
                    baseView.loadSuccess(winnerRunnerSumValueBean);
                }else{
                    baseView.loadFailed(winnerRunnerSumValueBean);
                }
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                baseView.loadError();
            }
        });
    }
}
