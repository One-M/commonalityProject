package com.ybf.lottery.function.datastatistics;

import com.ybf.lottery.base.BasePresenter;
import com.ybf.lottery.base.BaseView;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticSMTJBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticSumBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticYDDLBean;

/**
 * Created by XQyi on 2018/3/24.
 * Use:北京赛车数据统计Contract
 */

public interface BJRacecarDataStatisticsContract {

    interface IView extends BaseView{

        /**亚冠、大小、单双、龙虎统计接口处理*/
        void yddlSuccess(BJRacecarStatisticYDDLBean yddlBean);
        void yddlFailed(BJRacecarStatisticYDDLBean yddlBean);//接口返回异常
        void yddlError();//请求错误
        /**双面走势处理*/
        void smSuccess(BJRacecarStatisticSMTJBean smtjBean);
        void smFailed(BJRacecarStatisticSMTJBean smtjBean);
        void smError();
        /**和值数据处理*/
        void sumSuccess(BJRacecarStatisticSumBean sumBean);
        void sumFailed(BJRacecarStatisticSumBean sumBean);
        void sumError();

    }
    interface Presenter extends BasePresenter<IView>{

        /**亚冠、大小、单双、龙虎统计数据请求*/
        void yddlLoad(String issueNum);
        /**双面走势数据请求*/
        void smLoad(String issueNum);
        /**和值数据请求*/
        void sumLoad(String issueNum);

    }
}
