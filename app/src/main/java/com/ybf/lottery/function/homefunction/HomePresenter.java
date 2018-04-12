package com.ybf.lottery.function.homefunction;

import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.model.bean.BJRacecarCountDownBean;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/4/11.
 * Use: 首页的presenter
 */

public class HomePresenter extends BaseMvpPresenter<HomeContract.IView> implements HomeContract.Presenter{

    ManageRepository manageRepository;

    public HomePresenter(HomeContract.IView view) {
        super(view);
        this.manageRepository = dataManager.manageRepository;
    }

    @Override
    public void loadTimeData() {
        Flowable<BJRacecarCountDownBean> flowable = manageRepository.bjRacecarCountDownLoginData("PK10");
        addSubscribe(flowable, new MySubscriber<BJRacecarCountDownBean>() {
            @Override
            public void onNext(BJRacecarCountDownBean countDownBean) {
                if (countDownBean.getCode() == 200) {
                    baseView.loadTimeSuccess(countDownBean);
                }else{
                    baseView.loadTimeFailed(countDownBean);
                }
            }
        });
    }
}
