package com.ybf.lottery.function.firstsecondtrend;

import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.function.locationtrend.LocationTrendContract;
import com.ybf.lottery.model.bean.firstsecondtrendbean.FirstSecondTrendBean;
import com.ybf.lottery.model.bean.locationtrendbean.LocationTrendBean;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/4/21.
 * Use:定位走势的presenter
 */

public class FirstSecondPresenter extends BaseMvpPresenter<FirstSecondContract.IView> implements FirstSecondContract.P{

    ManageRepository repository;
    public FirstSecondPresenter(FirstSecondContract.IView view) {
        super(view);
        this.repository = dataManager.manageRepository;
    }

    @Override
    public void loadData(String period) {
        Flowable<FirstSecondTrendBean> flowable = repository.bjscFirstSecondTrendLoginData(period);
        addSubscribe(flowable, new MySubscriber<FirstSecondTrendBean>() {
            @Override
            public void onNext(FirstSecondTrendBean firstSecondTrendBean) {
                if (firstSecondTrendBean.getCode() == 200) {
                    baseView.loginSuccess(firstSecondTrendBean);
                }else{
                    baseView.loginFailed(firstSecondTrendBean);
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
