package com.ybf.lottery.model.http.repository;

import com.ybf.lottery.model.bean.BJRacecarCountDownBean;
import com.ybf.lottery.model.bean.bigsmalltrendbean.BigSmallTrendBean;
import com.ybf.lottery.model.bean.bjscbasictrendbean.BasicTrendBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticSMTJBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticSumBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticYDDLBean;
import com.ybf.lottery.model.bean.dragontigertrendbean.DragonTigerTrendBean;
import com.ybf.lottery.model.bean.firstsecondtrendbean.FirstSecondTrendBean;
import com.ybf.lottery.model.bean.locationtrendbean.LocationTrendBean;
import com.ybf.lottery.model.bean.winnerrunnersumvaluebean.WinnerRunnerSumValueBean;
import com.ybf.lottery.model.http.api.ManageApi;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;

/**
 * Created by XQyi on 2018/3/8.
 * Use: 共用Repository类
 */

public class ManageRepository {

    private ManageApi manageApi;
    public ManageRepository(ManageApi api){
        this.manageApi = api;
    }

    /**
     * /**
     * 北京赛车历史开奖倒计时接口
     * @param lottery
     * @return
     */
    public Flowable<BJRacecarCountDownBean> bjRacecarCountDownLoginData(String lottery){
        return manageApi.bjRacecarCountDownLoginData(lottery);
    }

    /**
     * 北京赛车历史开奖数据
     * @param drawDate 日期
     * ps: ResponseBody——retrofit中 返回未解析的原始json数据，这里处理不规范接口数据时单独解析
     * @return
     */
    public Flowable<ResponseBody> bjRacecarHistoryResponseBodyLoginData(String drawDate){
        return manageApi.bjRacecarHistoryResponseBodyLoginData(drawDate);
    }

    /**
     * 北京赛车数据统计(亚冠-龙虎)统计
     * @param period
     * @return
     */
    public Flowable<BJRacecarStatisticYDDLBean> bjRacecarStatisticYDDLLoginData(String period){
        return manageApi.bjRacecarStatisticYDDLLoginData(period);
    }

    /**
     * 北京赛车数据统计(双面统计)
     * @param period
     * @return
     */
    public Flowable<BJRacecarStatisticSMTJBean> bjRacearStatisticSMTJLoginData(String period){
        return manageApi.bjRacearStatisticSMTJLoginData(period);
    }

    /**
     * 北京赛车数据统计(和值龙虎)
     * @param period
     * @return
     */
    public Flowable<BJRacecarStatisticSumBean> bjRacecarStatisticSumLoginData(String period){
        return manageApi.bjRacecarStatisticSumLoginData(period);
    }

    /**
     * 北京赛车基本走势
     * @param period
     * @return
     */
    public Flowable<BasicTrendBean> bjscBasicTrendLoginData(String period){
        return manageApi.bjscBasicTrendLoginData(period);
    }

    /**
     * 北京赛车龙虎走势
     * @param period
     * @param fType
     * @return
     */
    public Flowable<DragonTigerTrendBean> bjscDTTrendLoginData(String period , String fType){
        return manageApi.bjscDTThrendLoginData(period , fType);
    }

    /***
     * 北京赛车冠亚和值
     * @param period
     * @return
     */
    public Flowable<WinnerRunnerSumValueBean> bjscWRSumValueLoginData(String period){
        return manageApi.bjscWRSumValueLoginData(period);
    }

    /**
     * 北京赛车定位走势
     * @param period
     * @param fType
     * @return
     */
    public Flowable<LocationTrendBean> bjscLocationTrendLoginData(String period , int fType){
        return manageApi.bjscLocationTrendLoginData(period , fType);
    }

    /***
     * 北京赛车冠亚走势
     * @param period
     * @return
     */
    public Flowable<FirstSecondTrendBean> bjscFirstSecondTrendLoginData(String period){
        return manageApi.bjscFirstSecondTrendLoginData(period);
    }

    /**
     * 大小形态
     * @param period
     * @return
     */
    public Flowable<BigSmallTrendBean> bjscBigSmallLoginData(String period){
        return manageApi.bjscBigSmallLoginData(period);
    }
}
