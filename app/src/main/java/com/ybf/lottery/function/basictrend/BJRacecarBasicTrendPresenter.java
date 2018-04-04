package com.ybf.lottery.function.basictrend;

import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.model.bean.bjscbasictrendbean.BasicTrendBean;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/3/28.
 * Use:北京赛车基本走势的presenter
 */

public class BJRacecarBasicTrendPresenter extends BaseMvpPresenter<BJRacecarBasicTrendContract.IView> implements BJRacecarBasicTrendContract.Presenter {

    ManageRepository manageRepository;
    public BJRacecarBasicTrendPresenter(BJRacecarBasicTrendContract.IView view) {
        super(view);
        this.manageRepository = dataManager.manageRepository;
    }

    @Override
    public void loadData(String period) {
        Flowable<BasicTrendBean> flowable = manageRepository.bjscBasicTrendLoginData(period);
        addSubscribe(flowable, new MySubscriber<BasicTrendBean>() {
            @Override
            public void onNext(BasicTrendBean basicTrendBean) {
                if (basicTrendBean.getCode() == 200) {
                    baseView.loginSuccess(basicTrendBean);
                }else{
                    baseView.loginFailed(basicTrendBean);
                }
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                baseView.loginError();
            }
        });
    }
}
