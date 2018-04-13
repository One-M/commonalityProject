package com.ybf.lottery.function.dragontigertrend;

import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.model.bean.dragontigertrendbean.DragonTigerTrendBean;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/4/13.
 * Use:龙虎走势presenter
 */

public class BJRacecarDragonTigerTrendPresenter extends BaseMvpPresenter<BJRacecarDragonTigerTrendContract.mView> implements BJRacecarDragonTigerTrendContract.Presenter{

    ManageRepository repository;
    public BJRacecarDragonTigerTrendPresenter(BJRacecarDragonTigerTrendContract.mView view) {
        super(view);
        this.repository = dataManager.manageRepository;
    }

    @Override
    public void loadData(String period , String fType) {
        Flowable<DragonTigerTrendBean> flowable = repository.bjscDTTrendLoginData(period , fType);
        addSubscribe(flowable, new MySubscriber<DragonTigerTrendBean>() {
            @Override
            public void onNext(DragonTigerTrendBean dragonTigerTrendBean) {
                if (dragonTigerTrendBean.getCode() == 200) {
                    baseView.loginSuccess(dragonTigerTrendBean);
                }else{
                    baseView.loginFailed(dragonTigerTrendBean);
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
