package com.ybf.lottery.function.bigsmalltrend;

import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.function.locationtrend.LocationTrendContract;
import com.ybf.lottery.model.bean.bigsmalltrendbean.BigSmallTrendBean;
import com.ybf.lottery.model.bean.locationtrendbean.LocationTrendBean;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/4/21.
 * Use:大小形态的presenter
 */

public class BigSmallTrendPresenter extends BaseMvpPresenter<BigSmallTrendContract.IView> implements BigSmallTrendContract.P{

    ManageRepository repository;
    public BigSmallTrendPresenter(BigSmallTrendContract.IView view) {
        super(view);
        this.repository = dataManager.manageRepository;
    }

    @Override
    public void loadData(String period) {
        Flowable<BigSmallTrendBean> flowable = repository.bjscBigSmallLoginData(period);
        addSubscribe(flowable, new MySubscriber<BigSmallTrendBean>() {
            @Override
            public void onNext(BigSmallTrendBean bigSmallTrendBean) {
                if (bigSmallTrendBean.getCode() == 200) {
                    baseView.loginSuccess(bigSmallTrendBean);
                }else{
                    baseView.loginFailed(bigSmallTrendBean);
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
