package com.ybf.lottery.function.datastatistics;

import com.ybf.lottery.base.BaseMvpPresenter;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticSMTJBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticSumBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticYDDLBean;
import com.ybf.lottery.model.http.repository.ManageRepository;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;

/**
 * Created by XQyi on 2018/3/24.
 * Use:北京赛车数据统计的Presenter
 */

public class BJRacecarDataStatisticsPresenter extends BaseMvpPresenter<BJRacecarDataStatisticsContract.IView> implements BJRacecarDataStatisticsContract.Presenter {

    ManageRepository manageRepository;
    public BJRacecarDataStatisticsPresenter(BJRacecarDataStatisticsContract.IView view) {
        super(view);
        this.manageRepository = dataManager.manageRepository;
    }

    @Override
    public void yddlLoad(String issueNum) {
        Flowable<BJRacecarStatisticYDDLBean> flowable = manageRepository.bjRacecarStatisticYDDLLoginData(issueNum);
        addSubscribe(flowable, new MySubscriber<BJRacecarStatisticYDDLBean>() {
            @Override
            public void onNext(BJRacecarStatisticYDDLBean yddlBean) {
                if (yddlBean.getCode() == 200) {
                    baseView.yddlSuccess(yddlBean);
                }else{
                    baseView.yddlFailed(yddlBean);
                }
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                baseView.yddlError();
            }
        });
    }

    @Override
    public void smLoad(String issueNum) {
        Flowable<BJRacecarStatisticSMTJBean> flowable = manageRepository.bjRacearStatisticSMTJLoginData(issueNum);
        addSubscribe(flowable, new MySubscriber<BJRacecarStatisticSMTJBean>() {
            @Override
            public void onNext(BJRacecarStatisticSMTJBean smtjBean) {
                if (smtjBean.getCode() == 200) {
                    baseView.smSuccess(smtjBean);
                }else{
                    baseView.smFailed(smtjBean);
                }
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                baseView.smError();
            }
        });
    }

    @Override
    public void sumLoad(String issueNum) {
        Flowable<BJRacecarStatisticSumBean> flowable = manageRepository.bjRacecarStatisticSumLoginData(issueNum);
        addSubscribe(flowable, new MySubscriber<BJRacecarStatisticSumBean>() {
            @Override
            public void onNext(BJRacecarStatisticSumBean sumBean) {
                if (sumBean.getCode() == 200) {
                    baseView.sumSuccess(sumBean);
                }else{
                    baseView.sumFailed(sumBean);
                }
            }

            @Override
            public void onError(Throwable t) {
                super.onError(t);
                baseView.sumError();
            }
        });
    }
}
