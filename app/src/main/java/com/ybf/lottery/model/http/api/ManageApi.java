package com.ybf.lottery.model.http.api;

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

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by XQyi on 2018/3/8.
 * Use: 网络请求接口管理集合(api)
 * --共用Api类--
 */

public interface ManageApi {

    /**
     * 北京赛车历史开奖倒计时接口
     * @param lottery
     * @return
     */
    @GET("trend-api/lottery/findLotteryInfo")    //lottery=PK10
    Flowable<BJRacecarCountDownBean> bjRacecarCountDownLoginData(@Query("lottery") String lottery);

    /**
     * 北京赛车历史开奖数据
     * @param drawDate 日期
     * ps: ResponseBody——retrofit中 返回未解析的原始json数据，这里处理不规范接口数据时单独解析
     * @return
     */
    @GET("trend-api/pk10/findPk10History")
    Flowable<ResponseBody> bjRacecarHistoryResponseBodyLoginData(@Query("drawDate") String drawDate);

    /**
     * 北京赛车数据统计(亚冠-龙虎)统计
     * @param period 统计期数
     * @return
     */
    @GET("trend-api/pk10/findStatistical")
    Flowable<BJRacecarStatisticYDDLBean> bjRacecarStatisticYDDLLoginData(@Query("period") String period);

    /**
     * 北京赛车数据统计(双面统计)
     * @param period 统计期数
     * @return
     */
    @GET("trend-api/pk10/findSmTrend")
    Flowable<BJRacecarStatisticSMTJBean> bjRacearStatisticSMTJLoginData(@Query("period") String period);

    /**
     * 北京赛车数据统计(和值龙虎)
     * @param period 统计期数
     * @return
     */
    @GET("trend-api/pk10/findSumTrend")
    Flowable<BJRacecarStatisticSumBean> bjRacecarStatisticSumLoginData(@Query("period") String period);

    /**
     * 北京赛车基本走势
     * @param period
     * @return
     */
    @GET("trend-api/pk10/findBaseTrend")
    Flowable<BasicTrendBean> bjscBasicTrendLoginData(@Query("period") String period);

    /**
     * 北京赛车龙虎走势
     * @param period 统计期数
     * @param fType 名次
     * @return
     */
    @GET("trend-api/pk10/findDragonTigerTrend")
    Flowable<DragonTigerTrendBean> bjscDTThrendLoginData(@Query("period") String period ,
                                                         @Query("fType") String fType);

    /**
     * 北京赛车冠亚和值
     * @param period 期数
     * @return
     */
    @GET("trend-api/pk10/findPositionTrend")
    Flowable<WinnerRunnerSumValueBean> bjscWRSumValueLoginData(@Query("period") String period);

    /**
     * 北京赛车定位走势
     * @param period 统计期数
     * @param fType 名次
     * @return
     */
    @GET("trend-api/pk10/findFirstSecondSumTrend")
    Flowable<LocationTrendBean> bjscLocationTrendLoginData(@Query("period") String period,
                                                           @Query("fType") int fType);
    /**
     * 北京赛车冠亚走势
     * @param period 期数
     * @return
     */
    @GET("trend-api/pk10/findFirstSecondTrend")
    Flowable<FirstSecondTrendBean> bjscFirstSecondTrendLoginData(@Query("period") String period);

    /**
     * 大小形态
     * @param period 期数
     * @return
     */
    @GET("trend-api/pk10/findBigSmallTrend")
    Flowable<BigSmallTrendBean> bjscBigSmallLoginData(@Query("period") String period);

}
