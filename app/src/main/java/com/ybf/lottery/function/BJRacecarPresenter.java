package com.ybf.lottery.function;

import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.model.bean.BJRacecarCountDownBean;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/3/15.
 * Use:北京赛车activity的presenter
 */

public class BJRacecarPresenter extends BaseMvpPresenter<BJRacecarContract.IView> implements BJRacecarContract.Presenter{

    ManageRepository manageRepository;

    public BJRacecarPresenter(BJRacecarContract.IView view) {
        super(view);
        this.manageRepository = dataManager.manageRepository;
    }

    @Override
    public void loadData() {
        Flowable<BJRacecarCountDownBean> flowable = manageRepository.bjRacecarCountDownLoginData("PK10");
        addSubscribe(flowable, new MySubscriber<BJRacecarCountDownBean>() {
            @Override
            public void onNext(BJRacecarCountDownBean countDownBean) {
                if (countDownBean.getCode() == 200) {
                    baseView.loadSuccess(countDownBean);
                }else{
                    baseView.loadFailed(countDownBean);
                }
            }
        });
    }
}
