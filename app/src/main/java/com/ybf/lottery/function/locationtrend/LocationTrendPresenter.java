package com.ybf.lottery.function.locationtrend;

import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.model.bean.locationtrendbean.LocationTrendBean;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/4/21.
 * Use:定位走势的presenter
 */

public class LocationTrendPresenter extends BaseMvpPresenter<LocationTrendContract.IView> implements LocationTrendContract.P{

    ManageRepository repository;
    public LocationTrendPresenter(LocationTrendContract.IView view) {
        super(view);
        this.repository = dataManager.manageRepository;
    }

    @Override
    public void loadData(String period, int fType) {
        Flowable<LocationTrendBean> flowable = repository.bjscLocationTrendLoginData(period , fType);
        addSubscribe(flowable, new MySubscriber<LocationTrendBean>() {
            @Override
            public void onNext(LocationTrendBean locationTrendBean) {
                if (locationTrendBean.getCode() == 200) {
                    baseView.loginSuccess(locationTrendBean);
                }else{
                    baseView.loginFailed(locationTrendBean);
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
