package com.ybf.lottery.function.basictrend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ybf.lottery.R;
import com.ybf.lottery.adapter.IssueDataAdapter;
import com.ybf.lottery.adapter.bjscbasictrendadapter.BasicTrendAdapter;
import com.ybf.lottery.base.BaseMvpFragment;
import com.ybf.lottery.diyview.trend.CustomTrendView;
import com.ybf.lottery.diyview.trend.HeaderHorizontalScrollView;
import com.ybf.lottery.diyview.trend.LeftNumberCustomListView;
import com.ybf.lottery.diyview.trend.LeftNumberSynchScrollView;
import com.ybf.lottery.diyview.trend.ScrollChangeCallback;
import com.ybf.lottery.diyview.trend.TrendScrollViewWidget;
import com.ybf.lottery.model.bean.bjscbasictrendbean.BasicTrendBean;
import com.ybf.lottery.model.bean.bjscbasictrendbean.BasicTrendStatisticBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/3/28.
 * Use:北京赛车基本走势的fragment
 */

public class BJRacecarBasicTrendFragment extends BaseMvpFragment<BJRacecarBasicTrendPresenter> implements BJRacecarBasicTrendContract.IView, ScrollChangeCallback {

    @BindView(R.id.basic_trend_issue_scroll_left)
    LeftNumberSynchScrollView mLeftScroll;
    @BindView(R.id.basic_trend_header_scroll)
    HeaderHorizontalScrollView mHeadScroll;
    @BindView(R.id.basic_trend_scroll_content)
    TrendScrollViewWidget mContentScroll;

    @BindView(R.id.lv_basic_trend_issue)
    LeftNumberCustomListView issueListView;
    @BindView(R.id.custom_basic_trend_view)
    CustomTrendView customTrendView;
    @BindView(R.id.basic_trend_statistic_recycle)
    RecyclerView statisticRecyclerView;

    private IssueDataAdapter issueDataAdapter;

    @Override
    public BJRacecarBasicTrendPresenter initPresenter() {
        return new BJRacecarBasicTrendPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.bjsc_basic_trend_lay, container, false);
        ButterKnife.bind(this , mView);
        initView();
        initData("30");
        return mView;
    }
    private void initView(){

        LinearLayoutManager manager = new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL ,false);
        statisticRecyclerView.setLayoutManager(manager);

        mLeftScroll.setScrollViewListener(this);
        mHeadScroll.setScrollViewListener(this);
        mContentScroll.setScrollViewListener(this);
    }

    private void initData(String period){
        mPresenter.loadData(period);
    }

    @Override
    public void loginSuccess(BasicTrendBean basicTrendBean) {
        Log.d("loginSuccess ",basicTrendBean.getCode()+"");
        if (basicTrendBean == null) {
            return;
        }
        List<BasicTrendBean.ZsBean> zsList = basicTrendBean.getZs();
        //期号显示
        bindQiHaoData(getIssueList(zsList));
        //走势号码区域
        customTrendView.setShowDatas(zsList);

        BasicTrendBean.TjBean tj = basicTrendBean.getTj();
        setStatisticData(tj);

    }
    /**数据统计数据显示*/
    private void setStatisticData(BasicTrendBean.TjBean tjBean){
        BasicTrendBean.TjBean.tjDataBean occ = tjBean.getOcc();//出现次数
        BasicTrendBean.TjBean.tjDataBean maxCont = tjBean.getMaxCont();//最大连出
        BasicTrendBean.TjBean.tjDataBean maxMiss = tjBean.getMaxMiss();//最大遗漏
        BasicTrendBean.TjBean.tjDataBean avgMiss = tjBean.getAvgMiss();//平均遗漏
        BasicTrendBean.TjBean.tjDataBean lastMiss = tjBean.getLastMiss();//当前遗漏

        List<BasicTrendStatisticBean> statisticDataList = customData(occ, maxCont, maxMiss, avgMiss, lastMiss);

        BasicTrendAdapter basicTrendAdapter = new BasicTrendAdapter(statisticDataList, getContext());
        statisticRecyclerView.setAdapter(basicTrendAdapter);
    }

    /**数据统计数据封装*/
    private List<BasicTrendStatisticBean> customData(BasicTrendBean.TjBean.tjDataBean occ , BasicTrendBean.TjBean.tjDataBean maxCont , BasicTrendBean.TjBean.tjDataBean maxMiss ,
                            BasicTrendBean.TjBean.tjDataBean avgMiss , BasicTrendBean.TjBean.tjDataBean lastMiss){
        List<BasicTrendStatisticBean> statisticDataList = new ArrayList<>();

        BasicTrendStatisticBean trendStatisticBeanA1 = new BasicTrendStatisticBean();
        trendStatisticBeanA1.setData1(occ.getN11());
        trendStatisticBeanA1.setData2(maxCont.getN11());
        trendStatisticBeanA1.setData3(maxMiss.getN11());
        trendStatisticBeanA1.setData4(avgMiss.getN11());
        trendStatisticBeanA1.setData5(lastMiss.getN11());
        statisticDataList.add(trendStatisticBeanA1);
        BasicTrendStatisticBean trendStatisticBeanA2 = new BasicTrendStatisticBean();
        trendStatisticBeanA2.setData1     (occ.getN12());
        trendStatisticBeanA2.setData2 (maxCont.getN12());
        trendStatisticBeanA2.setData3 (maxMiss.getN12());
        trendStatisticBeanA2.setData4 (avgMiss.getN12());
        trendStatisticBeanA2.setData5(lastMiss.getN12());
        statisticDataList.add(trendStatisticBeanA2);
        BasicTrendStatisticBean trendStatisticBeanA3 = new BasicTrendStatisticBean();
        trendStatisticBeanA3.setData1     (occ.getN13());
        trendStatisticBeanA3.setData2 (maxCont.getN13());
        trendStatisticBeanA3.setData3 (maxMiss.getN13());
        trendStatisticBeanA3.setData4 (avgMiss.getN13());
        trendStatisticBeanA3.setData5(lastMiss.getN13());
        statisticDataList.add(trendStatisticBeanA3);
        BasicTrendStatisticBean trendStatisticBeanA4 = new BasicTrendStatisticBean();
        trendStatisticBeanA4.setData1     (occ.getN14());
        trendStatisticBeanA4.setData2 (maxCont.getN14());
        trendStatisticBeanA4.setData3 (maxMiss.getN14());
        trendStatisticBeanA4.setData4 (avgMiss.getN14());
        trendStatisticBeanA4.setData5(lastMiss.getN14());
        statisticDataList.add(trendStatisticBeanA4);
        BasicTrendStatisticBean trendStatisticBeanA5 = new BasicTrendStatisticBean();
        trendStatisticBeanA5.setData1     (occ.getN15());
        trendStatisticBeanA5.setData2 (maxCont.getN15());
        trendStatisticBeanA5.setData3 (maxMiss.getN15());
        trendStatisticBeanA5.setData4 (avgMiss.getN15());
        trendStatisticBeanA5.setData5(lastMiss.getN15());
        statisticDataList.add(trendStatisticBeanA5);
        BasicTrendStatisticBean trendStatisticBeanA6 = new BasicTrendStatisticBean();
        trendStatisticBeanA6.setData1     (occ.getN16());
        trendStatisticBeanA6.setData2 (maxCont.getN16());
        trendStatisticBeanA6.setData3 (maxMiss.getN16());
        trendStatisticBeanA6.setData4 (avgMiss.getN16());
        trendStatisticBeanA6.setData5(lastMiss.getN16());
        statisticDataList.add(trendStatisticBeanA6);
        BasicTrendStatisticBean trendStatisticBeanA7 = new BasicTrendStatisticBean();
        trendStatisticBeanA7.setData1     (occ.getN17());
        trendStatisticBeanA7.setData2 (maxCont.getN17());
        trendStatisticBeanA7.setData3 (maxMiss.getN17());
        trendStatisticBeanA7.setData4 (avgMiss.getN17());
        trendStatisticBeanA7.setData5(lastMiss.getN17());
        statisticDataList.add(trendStatisticBeanA7);
        BasicTrendStatisticBean trendStatisticBeanA8 = new BasicTrendStatisticBean();
        trendStatisticBeanA8.setData1     (occ.getN18());
        trendStatisticBeanA8.setData2 (maxCont.getN18());
        trendStatisticBeanA8.setData3 (maxMiss.getN18());
        trendStatisticBeanA8.setData4 (avgMiss.getN18());
        trendStatisticBeanA8.setData5(lastMiss.getN18());
        statisticDataList.add(trendStatisticBeanA8);
        BasicTrendStatisticBean trendStatisticBeanA9 = new BasicTrendStatisticBean();
        trendStatisticBeanA9.setData1     (occ.getN19());
        trendStatisticBeanA9.setData2 (maxCont.getN19());
        trendStatisticBeanA9.setData3 (maxMiss.getN19());
        trendStatisticBeanA9.setData4 (avgMiss.getN19());
        trendStatisticBeanA9.setData5(lastMiss.getN19());
        statisticDataList.add(trendStatisticBeanA9);
        BasicTrendStatisticBean trendStatisticBeanA10 = new BasicTrendStatisticBean();
        trendStatisticBeanA10.setData1     (occ.getN110());
        trendStatisticBeanA10.setData2 (maxCont.getN110());
        trendStatisticBeanA10.setData3 (maxMiss.getN110());
        trendStatisticBeanA10.setData4 (avgMiss.getN110());
        trendStatisticBeanA10.setData5(lastMiss.getN110());
        statisticDataList.add(trendStatisticBeanA10);

        BasicTrendStatisticBean trendStatisticBeanB1 = new BasicTrendStatisticBean();
        trendStatisticBeanB1.setData1     (occ.getN21());
        trendStatisticBeanB1.setData2 (maxCont.getN21());
        trendStatisticBeanB1.setData3 (maxMiss.getN21());
        trendStatisticBeanB1.setData4 (avgMiss.getN21());
        trendStatisticBeanB1.setData5(lastMiss.getN21());
        statisticDataList.add(trendStatisticBeanB1);
        BasicTrendStatisticBean trendStatisticBeanB2 = new BasicTrendStatisticBean();
        trendStatisticBeanB2.setData1     (occ.getN22());
        trendStatisticBeanB2.setData2 (maxCont.getN22());
        trendStatisticBeanB2.setData3 (maxMiss.getN22());
        trendStatisticBeanB2.setData4 (avgMiss.getN22());
        trendStatisticBeanB2.setData5(lastMiss.getN22());
        statisticDataList.add(trendStatisticBeanB2);
        BasicTrendStatisticBean trendStatisticBeanB3 = new BasicTrendStatisticBean();
        trendStatisticBeanB3.setData1     (occ.getN23());
        trendStatisticBeanB3.setData2 (maxCont.getN23());
        trendStatisticBeanB3.setData3 (maxMiss.getN23());
        trendStatisticBeanB3.setData4 (avgMiss.getN23());
        trendStatisticBeanB3.setData5(lastMiss.getN23());
        statisticDataList.add(trendStatisticBeanA3);
        BasicTrendStatisticBean trendStatisticBeanB4 = new BasicTrendStatisticBean();
        trendStatisticBeanB4.setData1     (occ.getN24());
        trendStatisticBeanB4.setData2 (maxCont.getN24());
        trendStatisticBeanB4.setData3 (maxMiss.getN24());
        trendStatisticBeanB4.setData4 (avgMiss.getN24());
        trendStatisticBeanB4.setData5(lastMiss.getN24());
        statisticDataList.add(trendStatisticBeanB4);
        BasicTrendStatisticBean trendStatisticBeanB5 = new BasicTrendStatisticBean();
        trendStatisticBeanB5.setData1     (occ.getN25());
        trendStatisticBeanB5.setData2 (maxCont.getN25());
        trendStatisticBeanB5.setData3 (maxMiss.getN25());
        trendStatisticBeanB5.setData4 (avgMiss.getN25());
        trendStatisticBeanB5.setData5(lastMiss.getN25());
        statisticDataList.add(trendStatisticBeanB5);
        BasicTrendStatisticBean trendStatisticBeanB6 = new BasicTrendStatisticBean();
        trendStatisticBeanB6.setData1     (occ.getN26());
        trendStatisticBeanB6.setData2 (maxCont.getN26());
        trendStatisticBeanB6.setData3 (maxMiss.getN26());
        trendStatisticBeanB6.setData4 (avgMiss.getN26());
        trendStatisticBeanB6.setData5(lastMiss.getN26());
        statisticDataList.add(trendStatisticBeanB6);
        BasicTrendStatisticBean trendStatisticBeanB7 = new BasicTrendStatisticBean();
        trendStatisticBeanB7.setData1     (occ.getN27());
        trendStatisticBeanB7.setData2 (maxCont.getN27());
        trendStatisticBeanB7.setData3 (maxMiss.getN27());
        trendStatisticBeanB7.setData4 (avgMiss.getN27());
        trendStatisticBeanB7.setData5(lastMiss.getN27());
        statisticDataList.add(trendStatisticBeanB7);
        BasicTrendStatisticBean trendStatisticBeanB8 = new BasicTrendStatisticBean();
        trendStatisticBeanB8.setData1     (occ.getN28());
        trendStatisticBeanB8.setData2 (maxCont.getN28());
        trendStatisticBeanB8.setData3 (maxMiss.getN28());
        trendStatisticBeanB8.setData4 (avgMiss.getN28());
        trendStatisticBeanB8.setData5(lastMiss.getN28());
        statisticDataList.add(trendStatisticBeanB8);
        BasicTrendStatisticBean trendStatisticBeanB9 = new BasicTrendStatisticBean();
        trendStatisticBeanB9.setData1     (occ.getN29());
        trendStatisticBeanB9.setData2 (maxCont.getN29());
        trendStatisticBeanB9.setData3 (maxMiss.getN29());
        trendStatisticBeanB9.setData4 (avgMiss.getN29());
        trendStatisticBeanB9.setData5(lastMiss.getN29());
        statisticDataList.add(trendStatisticBeanB9);
        BasicTrendStatisticBean trendStatisticBeanB10 = new BasicTrendStatisticBean();
        trendStatisticBeanB10.setData1     (occ.getN210());
        trendStatisticBeanB10.setData2 (maxCont.getN210());
        trendStatisticBeanB10.setData3 (maxMiss.getN210());
        trendStatisticBeanB10.setData4 (avgMiss.getN210());
        trendStatisticBeanB10.setData5(lastMiss.getN210());
        statisticDataList.add(trendStatisticBeanB10);

        BasicTrendStatisticBean trendStatisticBeanC1 = new BasicTrendStatisticBean();
        trendStatisticBeanC1.setData1     (occ.getN31());
        trendStatisticBeanC1.setData2 (maxCont.getN31());
        trendStatisticBeanC1.setData3 (maxMiss.getN31());
        trendStatisticBeanC1.setData4 (avgMiss.getN31());
        trendStatisticBeanC1.setData5(lastMiss.getN31());
        statisticDataList.add(trendStatisticBeanC1);
        BasicTrendStatisticBean trendStatisticBeanC2 = new BasicTrendStatisticBean();
        trendStatisticBeanC2.setData1     (occ.getN32());
        trendStatisticBeanC2.setData2 (maxCont.getN32());
        trendStatisticBeanC2.setData3 (maxMiss.getN32());
        trendStatisticBeanC2.setData4 (avgMiss.getN32());
        trendStatisticBeanC2.setData5(lastMiss.getN32());
        statisticDataList.add(trendStatisticBeanC2);
        BasicTrendStatisticBean trendStatisticBeanC3 = new BasicTrendStatisticBean();
        trendStatisticBeanC3.setData1     (occ.getN33());
        trendStatisticBeanC3.setData2 (maxCont.getN33());
        trendStatisticBeanC3.setData3 (maxMiss.getN33());
        trendStatisticBeanC3.setData4 (avgMiss.getN33());
        trendStatisticBeanC3.setData5(lastMiss.getN33());
        statisticDataList.add(trendStatisticBeanA3);
        BasicTrendStatisticBean trendStatisticBeanC4 = new BasicTrendStatisticBean();
        trendStatisticBeanC4.setData1     (occ.getN34());
        trendStatisticBeanC4.setData2 (maxCont.getN34());
        trendStatisticBeanC4.setData3 (maxMiss.getN34());
        trendStatisticBeanC4.setData4 (avgMiss.getN34());
        trendStatisticBeanC4.setData5(lastMiss.getN34());
        statisticDataList.add(trendStatisticBeanC4);
        BasicTrendStatisticBean trendStatisticBeanC5 = new BasicTrendStatisticBean();
        trendStatisticBeanC5.setData1     (occ.getN35());
        trendStatisticBeanC5.setData2 (maxCont.getN35());
        trendStatisticBeanC5.setData3 (maxMiss.getN35());
        trendStatisticBeanC5.setData4 (avgMiss.getN35());
        trendStatisticBeanC5.setData5(lastMiss.getN35());
        statisticDataList.add(trendStatisticBeanC5);
        BasicTrendStatisticBean trendStatisticBeanC6 = new BasicTrendStatisticBean();
        trendStatisticBeanC6.setData1     (occ.getN36());
        trendStatisticBeanC6.setData2 (maxCont.getN36());
        trendStatisticBeanC6.setData3 (maxMiss.getN36());
        trendStatisticBeanC6.setData4 (avgMiss.getN36());
        trendStatisticBeanC6.setData5(lastMiss.getN36());
        statisticDataList.add(trendStatisticBeanC6);
        BasicTrendStatisticBean trendStatisticBeanC7 = new BasicTrendStatisticBean();
        trendStatisticBeanC7.setData1     (occ.getN37());
        trendStatisticBeanC7.setData2 (maxCont.getN37());
        trendStatisticBeanC7.setData3 (maxMiss.getN37());
        trendStatisticBeanC7.setData4 (avgMiss.getN37());
        trendStatisticBeanC7.setData5(lastMiss.getN37());
        statisticDataList.add(trendStatisticBeanC7);
        BasicTrendStatisticBean trendStatisticBeanC8 = new BasicTrendStatisticBean();
        trendStatisticBeanC8.setData1     (occ.getN38());
        trendStatisticBeanC8.setData2 (maxCont.getN38());
        trendStatisticBeanC8.setData3 (maxMiss.getN38());
        trendStatisticBeanC8.setData4 (avgMiss.getN38());
        trendStatisticBeanC8.setData5(lastMiss.getN38());
        statisticDataList.add(trendStatisticBeanC8);
        BasicTrendStatisticBean trendStatisticBeanC9 = new BasicTrendStatisticBean();
        trendStatisticBeanC9.setData1     (occ.getN39());
        trendStatisticBeanC9.setData2 (maxCont.getN39());
        trendStatisticBeanC9.setData3 (maxMiss.getN39());
        trendStatisticBeanC9.setData4 (avgMiss.getN39());
        trendStatisticBeanC9.setData5(lastMiss.getN39());
        statisticDataList.add(trendStatisticBeanC9);
        BasicTrendStatisticBean trendStatisticBeanC10 = new BasicTrendStatisticBean();
        trendStatisticBeanC10.setData1     (occ.getN310());
        trendStatisticBeanC10.setData2 (maxCont.getN310());
        trendStatisticBeanC10.setData3 (maxMiss.getN310());
        trendStatisticBeanC10.setData4 (avgMiss.getN310());
        trendStatisticBeanC10.setData5(lastMiss.getN310());
        statisticDataList.add(trendStatisticBeanC10);

        BasicTrendStatisticBean trendStatisticBeanD1 = new BasicTrendStatisticBean();
        trendStatisticBeanD1.setData1     (occ.getN41());
        trendStatisticBeanD1.setData2 (maxCont.getN41());
        trendStatisticBeanD1.setData3 (maxMiss.getN41());
        trendStatisticBeanD1.setData4 (avgMiss.getN41());
        trendStatisticBeanD1.setData5(lastMiss.getN41());
        statisticDataList.add(trendStatisticBeanD1);
        BasicTrendStatisticBean trendStatisticBeanD2 = new BasicTrendStatisticBean();
        trendStatisticBeanD2.setData1     (occ.getN42());
        trendStatisticBeanD2.setData2 (maxCont.getN42());
        trendStatisticBeanD2.setData3 (maxMiss.getN42());
        trendStatisticBeanD2.setData4 (avgMiss.getN42());
        trendStatisticBeanD2.setData5(lastMiss.getN42());
        statisticDataList.add(trendStatisticBeanD2);
        BasicTrendStatisticBean trendStatisticBeanD3 = new BasicTrendStatisticBean();
        trendStatisticBeanD3.setData1     (occ.getN43());
        trendStatisticBeanD3.setData2 (maxCont.getN43());
        trendStatisticBeanD3.setData3 (maxMiss.getN43());
        trendStatisticBeanD3.setData4 (avgMiss.getN43());
        trendStatisticBeanD3.setData5(lastMiss.getN43());
        statisticDataList.add(trendStatisticBeanA3);
        BasicTrendStatisticBean trendStatisticBeanD4 = new BasicTrendStatisticBean();
        trendStatisticBeanD4.setData1     (occ.getN44());
        trendStatisticBeanD4.setData2 (maxCont.getN44());
        trendStatisticBeanD4.setData3 (maxMiss.getN44());
        trendStatisticBeanD4.setData4 (avgMiss.getN44());
        trendStatisticBeanD4.setData5(lastMiss.getN44());
        statisticDataList.add(trendStatisticBeanD4);
        BasicTrendStatisticBean trendStatisticBeanD5 = new BasicTrendStatisticBean();
        trendStatisticBeanD5.setData1     (occ.getN45());
        trendStatisticBeanD5.setData2 (maxCont.getN45());
        trendStatisticBeanD5.setData3 (maxMiss.getN45());
        trendStatisticBeanD5.setData4 (avgMiss.getN45());
        trendStatisticBeanD5.setData5(lastMiss.getN45());
        statisticDataList.add(trendStatisticBeanD5);
        BasicTrendStatisticBean trendStatisticBeanD6 = new BasicTrendStatisticBean();
        trendStatisticBeanD6.setData1     (occ.getN46());
        trendStatisticBeanD6.setData2 (maxCont.getN46());
        trendStatisticBeanD6.setData3 (maxMiss.getN46());
        trendStatisticBeanD6.setData4 (avgMiss.getN46());
        trendStatisticBeanD6.setData5(lastMiss.getN46());
        statisticDataList.add(trendStatisticBeanD6);
        BasicTrendStatisticBean trendStatisticBeanD7 = new BasicTrendStatisticBean();
        trendStatisticBeanD7.setData1     (occ.getN47());
        trendStatisticBeanD7.setData2 (maxCont.getN47());
        trendStatisticBeanD7.setData3 (maxMiss.getN47());
        trendStatisticBeanD7.setData4 (avgMiss.getN47());
        trendStatisticBeanD7.setData5(lastMiss.getN47());
        statisticDataList.add(trendStatisticBeanD7);
        BasicTrendStatisticBean trendStatisticBeanD8 = new BasicTrendStatisticBean();
        trendStatisticBeanD8.setData1     (occ.getN48());
        trendStatisticBeanD8.setData2 (maxCont.getN48());
        trendStatisticBeanD8.setData3 (maxMiss.getN48());
        trendStatisticBeanD8.setData4 (avgMiss.getN48());
        trendStatisticBeanD8.setData5(lastMiss.getN48());
        statisticDataList.add(trendStatisticBeanD8);
        BasicTrendStatisticBean trendStatisticBeanD9 = new BasicTrendStatisticBean();
        trendStatisticBeanD9.setData1     (occ.getN49());
        trendStatisticBeanD9.setData2 (maxCont.getN49());
        trendStatisticBeanD9.setData3 (maxMiss.getN49());
        trendStatisticBeanD9.setData4 (avgMiss.getN49());
        trendStatisticBeanD9.setData5(lastMiss.getN49());
        statisticDataList.add(trendStatisticBeanD9);
        BasicTrendStatisticBean trendStatisticBeanD10 = new BasicTrendStatisticBean();
        trendStatisticBeanD10.setData1     (occ.getN410());
        trendStatisticBeanD10.setData2 (maxCont.getN410());
        trendStatisticBeanD10.setData3 (maxMiss.getN410());
        trendStatisticBeanD10.setData4 (avgMiss.getN410());
        trendStatisticBeanD10.setData5(lastMiss.getN410());
        statisticDataList.add(trendStatisticBeanD10);

        BasicTrendStatisticBean trendStatisticBeanE1 = new BasicTrendStatisticBean();
        trendStatisticBeanE1.setData1     (occ.getN51());
        trendStatisticBeanE1.setData2 (maxCont.getN51());
        trendStatisticBeanE1.setData3 (maxMiss.getN51());
        trendStatisticBeanE1.setData4 (avgMiss.getN51());
        trendStatisticBeanE1.setData5(lastMiss.getN51());
        statisticDataList.add(trendStatisticBeanE1);
        BasicTrendStatisticBean trendStatisticBeanE2 = new BasicTrendStatisticBean();
        trendStatisticBeanE2.setData1     (occ.getN52());
        trendStatisticBeanE2.setData2 (maxCont.getN52());
        trendStatisticBeanE2.setData3 (maxMiss.getN52());
        trendStatisticBeanE2.setData4 (avgMiss.getN52());
        trendStatisticBeanE2.setData5(lastMiss.getN52());
        statisticDataList.add(trendStatisticBeanE2);
        BasicTrendStatisticBean trendStatisticBeanE3 = new BasicTrendStatisticBean();
        trendStatisticBeanE3.setData1     (occ.getN53());
        trendStatisticBeanE3.setData2 (maxCont.getN53());
        trendStatisticBeanE3.setData3 (maxMiss.getN53());
        trendStatisticBeanE3.setData4 (avgMiss.getN53());
        trendStatisticBeanE3.setData5(lastMiss.getN53());
        statisticDataList.add(trendStatisticBeanA3);
        BasicTrendStatisticBean trendStatisticBeanE4 = new BasicTrendStatisticBean();
        trendStatisticBeanE4.setData1     (occ.getN54());
        trendStatisticBeanE4.setData2 (maxCont.getN54());
        trendStatisticBeanE4.setData3 (maxMiss.getN54());
        trendStatisticBeanE4.setData4 (avgMiss.getN54());
        trendStatisticBeanE4.setData5(lastMiss.getN54());
        statisticDataList.add(trendStatisticBeanE4);
        BasicTrendStatisticBean trendStatisticBeanE5 = new BasicTrendStatisticBean();
        trendStatisticBeanE5.setData1     (occ.getN55());
        trendStatisticBeanE5.setData2 (maxCont.getN55());
        trendStatisticBeanE5.setData3 (maxMiss.getN55());
        trendStatisticBeanE5.setData4 (avgMiss.getN55());
        trendStatisticBeanE5.setData5(lastMiss.getN55());
        statisticDataList.add(trendStatisticBeanE5);
        BasicTrendStatisticBean trendStatisticBeanE6 = new BasicTrendStatisticBean();
        trendStatisticBeanE6.setData1     (occ.getN56());
        trendStatisticBeanE6.setData2 (maxCont.getN56());
        trendStatisticBeanE6.setData3 (maxMiss.getN56());
        trendStatisticBeanE6.setData4 (avgMiss.getN56());
        trendStatisticBeanE6.setData5(lastMiss.getN56());
        statisticDataList.add(trendStatisticBeanE6);
        BasicTrendStatisticBean trendStatisticBeanE7 = new BasicTrendStatisticBean();
        trendStatisticBeanE7.setData1     (occ.getN57());
        trendStatisticBeanE7.setData2 (maxCont.getN57());
        trendStatisticBeanE7.setData3 (maxMiss.getN57());
        trendStatisticBeanE7.setData4 (avgMiss.getN57());
        trendStatisticBeanE7.setData5(lastMiss.getN57());
        statisticDataList.add(trendStatisticBeanE7);
        BasicTrendStatisticBean trendStatisticBeanE8 = new BasicTrendStatisticBean();
        trendStatisticBeanE8.setData1     (occ.getN58());
        trendStatisticBeanE8.setData2 (maxCont.getN58());
        trendStatisticBeanE8.setData3 (maxMiss.getN58());
        trendStatisticBeanE8.setData4 (avgMiss.getN58());
        trendStatisticBeanE8.setData5(lastMiss.getN58());
        statisticDataList.add(trendStatisticBeanE8);
        BasicTrendStatisticBean trendStatisticBeanE9 = new BasicTrendStatisticBean();
        trendStatisticBeanE9.setData1     (occ.getN59());
        trendStatisticBeanE9.setData2 (maxCont.getN59());
        trendStatisticBeanE9.setData3 (maxMiss.getN59());
        trendStatisticBeanE9.setData4 (avgMiss.getN59());
        trendStatisticBeanE9.setData5(lastMiss.getN59());
        statisticDataList.add(trendStatisticBeanE9);
        BasicTrendStatisticBean trendStatisticBeanE10 = new BasicTrendStatisticBean();
        trendStatisticBeanE10.setData1     (occ.getN510());
        trendStatisticBeanE10.setData2 (maxCont.getN510());
        trendStatisticBeanE10.setData3 (maxMiss.getN510());
        trendStatisticBeanE10.setData4 (avgMiss.getN510());
        trendStatisticBeanE10.setData5(lastMiss.getN510());
        statisticDataList.add(trendStatisticBeanE10);

        BasicTrendStatisticBean trendStatisticBeanF1 = new BasicTrendStatisticBean();
        trendStatisticBeanF1.setData1     (occ.getN61());
        trendStatisticBeanF1.setData2 (maxCont.getN61());
        trendStatisticBeanF1.setData3 (maxMiss.getN61());
        trendStatisticBeanF1.setData4 (avgMiss.getN61());
        trendStatisticBeanF1.setData5(lastMiss.getN61());
        statisticDataList.add(trendStatisticBeanF1);
        BasicTrendStatisticBean trendStatisticBeanF2 = new BasicTrendStatisticBean();
        trendStatisticBeanF2.setData1     (occ.getN62());
        trendStatisticBeanF2.setData2 (maxCont.getN62());
        trendStatisticBeanF2.setData3 (maxMiss.getN62());
        trendStatisticBeanF2.setData4 (avgMiss.getN62());
        trendStatisticBeanF2.setData5(lastMiss.getN62());
        statisticDataList.add(trendStatisticBeanF2);
        BasicTrendStatisticBean trendStatisticBeanF3 = new BasicTrendStatisticBean();
        trendStatisticBeanF3.setData1     (occ.getN63());
        trendStatisticBeanF3.setData2 (maxCont.getN63());
        trendStatisticBeanF3.setData3 (maxMiss.getN63());
        trendStatisticBeanF3.setData4 (avgMiss.getN63());
        trendStatisticBeanF3.setData5(lastMiss.getN63());
        statisticDataList.add(trendStatisticBeanA3);
        BasicTrendStatisticBean trendStatisticBeanF4 = new BasicTrendStatisticBean();
        trendStatisticBeanF4.setData1     (occ.getN64());
        trendStatisticBeanF4.setData2 (maxCont.getN64());
        trendStatisticBeanF4.setData3 (maxMiss.getN64());
        trendStatisticBeanF4.setData4 (avgMiss.getN64());
        trendStatisticBeanF4.setData5(lastMiss.getN64());
        statisticDataList.add(trendStatisticBeanF4);
        BasicTrendStatisticBean trendStatisticBeanF5 = new BasicTrendStatisticBean();
        trendStatisticBeanF5.setData1     (occ.getN65());
        trendStatisticBeanF5.setData2 (maxCont.getN65());
        trendStatisticBeanF5.setData3 (maxMiss.getN65());
        trendStatisticBeanF5.setData4 (avgMiss.getN65());
        trendStatisticBeanF5.setData5(lastMiss.getN65());
        statisticDataList.add(trendStatisticBeanF5);
        BasicTrendStatisticBean trendStatisticBeanF6 = new BasicTrendStatisticBean();
        trendStatisticBeanF6.setData1     (occ.getN66());
        trendStatisticBeanF6.setData2 (maxCont.getN66());
        trendStatisticBeanF6.setData3 (maxMiss.getN66());
        trendStatisticBeanF6.setData4 (avgMiss.getN66());
        trendStatisticBeanF6.setData5(lastMiss.getN66());
        statisticDataList.add(trendStatisticBeanF6);
        BasicTrendStatisticBean trendStatisticBeanF7 = new BasicTrendStatisticBean();
        trendStatisticBeanF7.setData1     (occ.getN67());
        trendStatisticBeanF7.setData2 (maxCont.getN67());
        trendStatisticBeanF7.setData3 (maxMiss.getN67());
        trendStatisticBeanF7.setData4 (avgMiss.getN67());
        trendStatisticBeanF7.setData5(lastMiss.getN67());
        statisticDataList.add(trendStatisticBeanF7);
        BasicTrendStatisticBean trendStatisticBeanF8 = new BasicTrendStatisticBean();
        trendStatisticBeanF8.setData1     (occ.getN68());
        trendStatisticBeanF8.setData2 (maxCont.getN68());
        trendStatisticBeanF8.setData3 (maxMiss.getN68());
        trendStatisticBeanF8.setData4 (avgMiss.getN68());
        trendStatisticBeanF8.setData5(lastMiss.getN68());
        statisticDataList.add(trendStatisticBeanF8);
        BasicTrendStatisticBean trendStatisticBeanF9 = new BasicTrendStatisticBean();
        trendStatisticBeanF9.setData1     (occ.getN69());
        trendStatisticBeanF9.setData2 (maxCont.getN69());
        trendStatisticBeanF9.setData3 (maxMiss.getN69());
        trendStatisticBeanF9.setData4 (avgMiss.getN69());
        trendStatisticBeanF9.setData5(lastMiss.getN69());
        statisticDataList.add(trendStatisticBeanF9);
        BasicTrendStatisticBean trendStatisticBeanF10 = new BasicTrendStatisticBean();
        trendStatisticBeanF10.setData1     (occ.getN610());
        trendStatisticBeanF10.setData2 (maxCont.getN610());
        trendStatisticBeanF10.setData3 (maxMiss.getN610());
        trendStatisticBeanF10.setData4 (avgMiss.getN610());
        trendStatisticBeanF10.setData5(lastMiss.getN610());
        statisticDataList.add(trendStatisticBeanF10);

        BasicTrendStatisticBean trendStatisticBeanG1 = new BasicTrendStatisticBean();
        trendStatisticBeanG1.setData1     (occ.getN71());
        trendStatisticBeanG1.setData2 (maxCont.getN71());
        trendStatisticBeanG1.setData3 (maxMiss.getN71());
        trendStatisticBeanG1.setData4 (avgMiss.getN71());
        trendStatisticBeanG1.setData5(lastMiss.getN71());
        statisticDataList.add(trendStatisticBeanG1);
        BasicTrendStatisticBean trendStatisticBeanG2 = new BasicTrendStatisticBean();
        trendStatisticBeanG2.setData1     (occ.getN72());
        trendStatisticBeanG2.setData2 (maxCont.getN72());
        trendStatisticBeanG2.setData3 (maxMiss.getN72());
        trendStatisticBeanG2.setData4 (avgMiss.getN72());
        trendStatisticBeanG2.setData5(lastMiss.getN72());
        statisticDataList.add(trendStatisticBeanG2);
        BasicTrendStatisticBean trendStatisticBeanG3 = new BasicTrendStatisticBean();
        trendStatisticBeanG3.setData1     (occ.getN73());
        trendStatisticBeanG3.setData2 (maxCont.getN73());
        trendStatisticBeanG3.setData3 (maxMiss.getN73());
        trendStatisticBeanG3.setData4 (avgMiss.getN73());
        trendStatisticBeanG3.setData5(lastMiss.getN73());
        statisticDataList.add(trendStatisticBeanA3);
        BasicTrendStatisticBean trendStatisticBeanG4 = new BasicTrendStatisticBean();
        trendStatisticBeanG4.setData1     (occ.getN74());
        trendStatisticBeanG4.setData2 (maxCont.getN74());
        trendStatisticBeanG4.setData3 (maxMiss.getN74());
        trendStatisticBeanG4.setData4 (avgMiss.getN74());
        trendStatisticBeanG4.setData5(lastMiss.getN74());
        statisticDataList.add(trendStatisticBeanG4);
        BasicTrendStatisticBean trendStatisticBeanG5 = new BasicTrendStatisticBean();
        trendStatisticBeanG5.setData1     (occ.getN75());
        trendStatisticBeanG5.setData2 (maxCont.getN75());
        trendStatisticBeanG5.setData3 (maxMiss.getN75());
        trendStatisticBeanG5.setData4 (avgMiss.getN75());
        trendStatisticBeanG5.setData5(lastMiss.getN75());
        statisticDataList.add(trendStatisticBeanG5);
        BasicTrendStatisticBean trendStatisticBeanG6 = new BasicTrendStatisticBean();
        trendStatisticBeanG6.setData1     (occ.getN76());
        trendStatisticBeanG6.setData2 (maxCont.getN76());
        trendStatisticBeanG6.setData3 (maxMiss.getN76());
        trendStatisticBeanG6.setData4 (avgMiss.getN76());
        trendStatisticBeanG6.setData5(lastMiss.getN76());
        statisticDataList.add(trendStatisticBeanG6);
        BasicTrendStatisticBean trendStatisticBeanG7 = new BasicTrendStatisticBean();
        trendStatisticBeanG7.setData1     (occ.getN77());
        trendStatisticBeanG7.setData2 (maxCont.getN77());
        trendStatisticBeanG7.setData3 (maxMiss.getN77());
        trendStatisticBeanG7.setData4 (avgMiss.getN77());
        trendStatisticBeanG7.setData5(lastMiss.getN77());
        statisticDataList.add(trendStatisticBeanG7);
        BasicTrendStatisticBean trendStatisticBeanG8 = new BasicTrendStatisticBean();
        trendStatisticBeanG8.setData1     (occ.getN78());
        trendStatisticBeanG8.setData2 (maxCont.getN78());
        trendStatisticBeanG8.setData3 (maxMiss.getN78());
        trendStatisticBeanG8.setData4 (avgMiss.getN78());
        trendStatisticBeanG8.setData5(lastMiss.getN78());
        statisticDataList.add(trendStatisticBeanG8);
        BasicTrendStatisticBean trendStatisticBeanG9 = new BasicTrendStatisticBean();
        trendStatisticBeanG9.setData1     (occ.getN79());
        trendStatisticBeanG9.setData2 (maxCont.getN79());
        trendStatisticBeanG9.setData3 (maxMiss.getN79());
        trendStatisticBeanG9.setData4 (avgMiss.getN79());
        trendStatisticBeanG9.setData5(lastMiss.getN79());
        statisticDataList.add(trendStatisticBeanG9);
        BasicTrendStatisticBean trendStatisticBeanG10 = new BasicTrendStatisticBean();
        trendStatisticBeanG10.setData1     (occ.getN710());
        trendStatisticBeanG10.setData2 (maxCont.getN710());
        trendStatisticBeanG10.setData3 (maxMiss.getN710());
        trendStatisticBeanG10.setData4 (avgMiss.getN710());
        trendStatisticBeanG10.setData5(lastMiss.getN710());
        statisticDataList.add(trendStatisticBeanG10);

        BasicTrendStatisticBean trendStatisticBeanH1 = new BasicTrendStatisticBean();
        trendStatisticBeanH1.setData1     (occ.getN81());
        trendStatisticBeanH1.setData2 (maxCont.getN81());
        trendStatisticBeanH1.setData3 (maxMiss.getN81());
        trendStatisticBeanH1.setData4 (avgMiss.getN81());
        trendStatisticBeanH1.setData5(lastMiss.getN81());
        statisticDataList.add(trendStatisticBeanH1);
        BasicTrendStatisticBean trendStatisticBeanH2 = new BasicTrendStatisticBean();
        trendStatisticBeanH2.setData1     (occ.getN82());
        trendStatisticBeanH2.setData2 (maxCont.getN82());
        trendStatisticBeanH2.setData3 (maxMiss.getN82());
        trendStatisticBeanH2.setData4 (avgMiss.getN82());
        trendStatisticBeanH2.setData5(lastMiss.getN82());
        statisticDataList.add(trendStatisticBeanH2);
        BasicTrendStatisticBean trendStatisticBeanH3 = new BasicTrendStatisticBean();
        trendStatisticBeanH3.setData1     (occ.getN83());
        trendStatisticBeanH3.setData2 (maxCont.getN83());
        trendStatisticBeanH3.setData3 (maxMiss.getN83());
        trendStatisticBeanH3.setData4 (avgMiss.getN83());
        trendStatisticBeanH3.setData5(lastMiss.getN83());
        statisticDataList.add(trendStatisticBeanA3);
        BasicTrendStatisticBean trendStatisticBeanH4 = new BasicTrendStatisticBean();
        trendStatisticBeanH4.setData1     (occ.getN84());
        trendStatisticBeanH4.setData2 (maxCont.getN84());
        trendStatisticBeanH4.setData3 (maxMiss.getN84());
        trendStatisticBeanH4.setData4 (avgMiss.getN84());
        trendStatisticBeanH4.setData5(lastMiss.getN84());
        statisticDataList.add(trendStatisticBeanH4);
        BasicTrendStatisticBean trendStatisticBeanH5 = new BasicTrendStatisticBean();
        trendStatisticBeanH5.setData1     (occ.getN85());
        trendStatisticBeanH5.setData2 (maxCont.getN85());
        trendStatisticBeanH5.setData3 (maxMiss.getN85());
        trendStatisticBeanH5.setData4 (avgMiss.getN85());
        trendStatisticBeanH5.setData5(lastMiss.getN85());
        statisticDataList.add(trendStatisticBeanH5);
        BasicTrendStatisticBean trendStatisticBeanH6 = new BasicTrendStatisticBean();
        trendStatisticBeanH6.setData1     (occ.getN86());
        trendStatisticBeanH6.setData2 (maxCont.getN86());
        trendStatisticBeanH6.setData3 (maxMiss.getN86());
        trendStatisticBeanH6.setData4 (avgMiss.getN86());
        trendStatisticBeanH6.setData5(lastMiss.getN86());
        statisticDataList.add(trendStatisticBeanH6);
        BasicTrendStatisticBean trendStatisticBeanH7 = new BasicTrendStatisticBean();
        trendStatisticBeanH7.setData1     (occ.getN87());
        trendStatisticBeanH7.setData2 (maxCont.getN87());
        trendStatisticBeanH7.setData3 (maxMiss.getN87());
        trendStatisticBeanH7.setData4 (avgMiss.getN87());
        trendStatisticBeanH7.setData5(lastMiss.getN87());
        statisticDataList.add(trendStatisticBeanH7);
        BasicTrendStatisticBean trendStatisticBeanH8 = new BasicTrendStatisticBean();
        trendStatisticBeanH8.setData1     (occ.getN88());
        trendStatisticBeanH8.setData2 (maxCont.getN88());
        trendStatisticBeanH8.setData3 (maxMiss.getN88());
        trendStatisticBeanH8.setData4 (avgMiss.getN88());
        trendStatisticBeanH8.setData5(lastMiss.getN88());
        statisticDataList.add(trendStatisticBeanH8);
        BasicTrendStatisticBean trendStatisticBeanH9 = new BasicTrendStatisticBean();
        trendStatisticBeanH9.setData1     (occ.getN89());
        trendStatisticBeanH9.setData2 (maxCont.getN89());
        trendStatisticBeanH9.setData3 (maxMiss.getN89());
        trendStatisticBeanH9.setData4 (avgMiss.getN89());
        trendStatisticBeanH9.setData5(lastMiss.getN89());
        statisticDataList.add(trendStatisticBeanH9);
        BasicTrendStatisticBean trendStatisticBeanH10 = new BasicTrendStatisticBean();
        trendStatisticBeanH10.setData1     (occ.getN810());
        trendStatisticBeanH10.setData2 (maxCont.getN810());
        trendStatisticBeanH10.setData3 (maxMiss.getN810());
        trendStatisticBeanH10.setData4 (avgMiss.getN810());
        trendStatisticBeanH10.setData5(lastMiss.getN810());
        statisticDataList.add(trendStatisticBeanH10);

        BasicTrendStatisticBean trendStatisticBeanI1 = new BasicTrendStatisticBean();
        trendStatisticBeanI1.setData1     (occ.getN91());
        trendStatisticBeanI1.setData2 (maxCont.getN91());
        trendStatisticBeanI1.setData3 (maxMiss.getN91());
        trendStatisticBeanI1.setData4 (avgMiss.getN91());
        trendStatisticBeanI1.setData5(lastMiss.getN91());
        statisticDataList.add(trendStatisticBeanI1);
        BasicTrendStatisticBean trendStatisticBeanI2 = new BasicTrendStatisticBean();
        trendStatisticBeanI2.setData1     (occ.getN92());
        trendStatisticBeanI2.setData2 (maxCont.getN92());
        trendStatisticBeanI2.setData3 (maxMiss.getN92());
        trendStatisticBeanI2.setData4 (avgMiss.getN92());
        trendStatisticBeanI2.setData5(lastMiss.getN92());
        statisticDataList.add(trendStatisticBeanI2);
        BasicTrendStatisticBean trendStatisticBeanI3 = new BasicTrendStatisticBean();
        trendStatisticBeanI3.setData1     (occ.getN93());
        trendStatisticBeanI3.setData2 (maxCont.getN93());
        trendStatisticBeanI3.setData3 (maxMiss.getN93());
        trendStatisticBeanI3.setData4 (avgMiss.getN93());
        trendStatisticBeanI3.setData5(lastMiss.getN93());
        statisticDataList.add(trendStatisticBeanA3);
        BasicTrendStatisticBean trendStatisticBeanI4 = new BasicTrendStatisticBean();
        trendStatisticBeanI4.setData1     (occ.getN94());
        trendStatisticBeanI4.setData2 (maxCont.getN94());
        trendStatisticBeanI4.setData3 (maxMiss.getN94());
        trendStatisticBeanI4.setData4 (avgMiss.getN94());
        trendStatisticBeanI4.setData5(lastMiss.getN94());
        statisticDataList.add(trendStatisticBeanI4);
        BasicTrendStatisticBean trendStatisticBeanI5 = new BasicTrendStatisticBean();
        trendStatisticBeanI5.setData1     (occ.getN95());
        trendStatisticBeanI5.setData2 (maxCont.getN95());
        trendStatisticBeanI5.setData3 (maxMiss.getN95());
        trendStatisticBeanI5.setData4 (avgMiss.getN95());
        trendStatisticBeanI5.setData5(lastMiss.getN95());
        statisticDataList.add(trendStatisticBeanI5);
        BasicTrendStatisticBean trendStatisticBeanI6 = new BasicTrendStatisticBean();
        trendStatisticBeanI6.setData1     (occ.getN96());
        trendStatisticBeanI6.setData2 (maxCont.getN96());
        trendStatisticBeanI6.setData3 (maxMiss.getN96());
        trendStatisticBeanI6.setData4 (avgMiss.getN96());
        trendStatisticBeanI6.setData5(lastMiss.getN96());
        statisticDataList.add(trendStatisticBeanI6);
        BasicTrendStatisticBean trendStatisticBeanI7 = new BasicTrendStatisticBean();
        trendStatisticBeanI7.setData1     (occ.getN97());
        trendStatisticBeanI7.setData2 (maxCont.getN97());
        trendStatisticBeanI7.setData3 (maxMiss.getN97());
        trendStatisticBeanI7.setData4 (avgMiss.getN97());
        trendStatisticBeanI7.setData5(lastMiss.getN97());
        statisticDataList.add(trendStatisticBeanI7);
        BasicTrendStatisticBean trendStatisticBeanI8 = new BasicTrendStatisticBean();
        trendStatisticBeanI8.setData1     (occ.getN98());
        trendStatisticBeanI8.setData2 (maxCont.getN98());
        trendStatisticBeanI8.setData3 (maxMiss.getN98());
        trendStatisticBeanI8.setData4 (avgMiss.getN98());
        trendStatisticBeanI8.setData5(lastMiss.getN98());
        statisticDataList.add(trendStatisticBeanI8);
        BasicTrendStatisticBean trendStatisticBeanI9 = new BasicTrendStatisticBean();
        trendStatisticBeanI9.setData1     (occ.getN99());
        trendStatisticBeanI9.setData2 (maxCont.getN99());
        trendStatisticBeanI9.setData3 (maxMiss.getN99());
        trendStatisticBeanI9.setData4 (avgMiss.getN99());
        trendStatisticBeanI9.setData5(lastMiss.getN99());
        statisticDataList.add(trendStatisticBeanI9);
        BasicTrendStatisticBean trendStatisticBeanI10 = new BasicTrendStatisticBean();
        trendStatisticBeanI10.setData1     (occ.getN910());
        trendStatisticBeanI10.setData2 (maxCont.getN910());
        trendStatisticBeanI10.setData3 (maxMiss.getN910());
        trendStatisticBeanI10.setData4 (avgMiss.getN910());
        trendStatisticBeanI10.setData5(lastMiss.getN910());
        statisticDataList.add(trendStatisticBeanI10);

        BasicTrendStatisticBean trendStatisticBeanJ1 = new BasicTrendStatisticBean();
        trendStatisticBeanJ1.setData1     (occ.getN101());
        trendStatisticBeanJ1.setData2 (maxCont.getN101());
        trendStatisticBeanJ1.setData3 (maxMiss.getN101());
        trendStatisticBeanJ1.setData4 (avgMiss.getN101());
        trendStatisticBeanJ1.setData5(lastMiss.getN101());
        statisticDataList.add(trendStatisticBeanJ1);
        BasicTrendStatisticBean trendStatisticBeanJ2 = new BasicTrendStatisticBean();
        trendStatisticBeanJ2.setData1     (occ.getN102());
        trendStatisticBeanJ2.setData2 (maxCont.getN102());
        trendStatisticBeanJ2.setData3 (maxMiss.getN102());
        trendStatisticBeanJ2.setData4 (avgMiss.getN102());
        trendStatisticBeanJ2.setData5(lastMiss.getN102());
        statisticDataList.add(trendStatisticBeanJ2);
        BasicTrendStatisticBean trendStatisticBeanJ3 = new BasicTrendStatisticBean();
        trendStatisticBeanJ3.setData1     (occ.getN103());
        trendStatisticBeanJ3.setData2 (maxCont.getN103());
        trendStatisticBeanJ3.setData3 (maxMiss.getN103());
        trendStatisticBeanJ3.setData4 (avgMiss.getN103());
        trendStatisticBeanJ3.setData5(lastMiss.getN103());
        statisticDataList.add(trendStatisticBeanA3);
        BasicTrendStatisticBean trendStatisticBeanJ4 = new BasicTrendStatisticBean();
        trendStatisticBeanJ4.setData1     (occ.getN104());
        trendStatisticBeanJ4.setData2 (maxCont.getN104());
        trendStatisticBeanJ4.setData3 (maxMiss.getN104());
        trendStatisticBeanJ4.setData4 (avgMiss.getN104());
        trendStatisticBeanJ4.setData5(lastMiss.getN104());
        statisticDataList.add(trendStatisticBeanJ4);
        BasicTrendStatisticBean trendStatisticBeanJ5 = new BasicTrendStatisticBean();
        trendStatisticBeanJ5.setData1     (occ.getN105());
        trendStatisticBeanJ5.setData2 (maxCont.getN105());
        trendStatisticBeanJ5.setData3 (maxMiss.getN105());
        trendStatisticBeanJ5.setData4 (avgMiss.getN105());
        trendStatisticBeanJ5.setData5(lastMiss.getN105());
        statisticDataList.add(trendStatisticBeanJ5);
        BasicTrendStatisticBean trendStatisticBeanJ6 = new BasicTrendStatisticBean();
        trendStatisticBeanJ6.setData1     (occ.getN106());
        trendStatisticBeanJ6.setData2 (maxCont.getN106());
        trendStatisticBeanJ6.setData3 (maxMiss.getN106());
        trendStatisticBeanJ6.setData4 (avgMiss.getN106());
        trendStatisticBeanJ6.setData5(lastMiss.getN106());
        statisticDataList.add(trendStatisticBeanJ6);
        BasicTrendStatisticBean trendStatisticBeanJ7 = new BasicTrendStatisticBean();
        trendStatisticBeanJ7.setData1     (occ.getN107());
        trendStatisticBeanJ7.setData2 (maxCont.getN107());
        trendStatisticBeanJ7.setData3 (maxMiss.getN107());
        trendStatisticBeanJ7.setData4 (avgMiss.getN107());
        trendStatisticBeanJ7.setData5(lastMiss.getN107());
        statisticDataList.add(trendStatisticBeanJ7);
        BasicTrendStatisticBean trendStatisticBeanJ8 = new BasicTrendStatisticBean();
        trendStatisticBeanJ8.setData1     (occ.getN108());
        trendStatisticBeanJ8.setData2 (maxCont.getN108());
        trendStatisticBeanJ8.setData3 (maxMiss.getN108());
        trendStatisticBeanJ8.setData4 (avgMiss.getN108());
        trendStatisticBeanJ8.setData5(lastMiss.getN108());
        statisticDataList.add(trendStatisticBeanJ8);
        BasicTrendStatisticBean trendStatisticBeanJ9 = new BasicTrendStatisticBean();
        trendStatisticBeanJ9.setData1     (occ.getN109());
        trendStatisticBeanJ9.setData2 (maxCont.getN109());
        trendStatisticBeanJ9.setData3 (maxMiss.getN109());
        trendStatisticBeanJ9.setData4 (avgMiss.getN109());
        trendStatisticBeanJ9.setData5(lastMiss.getN109());
        statisticDataList.add(trendStatisticBeanJ9);
        BasicTrendStatisticBean trendStatisticBeanJ10 = new BasicTrendStatisticBean();
        trendStatisticBeanJ10.setData1     (occ.getN1010());
        trendStatisticBeanJ10.setData2 (maxCont.getN1010());
        trendStatisticBeanJ10.setData3 (maxMiss.getN1010());
        trendStatisticBeanJ10.setData4 (avgMiss.getN1010());
        trendStatisticBeanJ10.setData5(lastMiss.getN1010());
        statisticDataList.add(trendStatisticBeanJ10);

        return statisticDataList;
    }

    @Override
    public void loginFailed(BasicTrendBean basicTrendBean) {
        Log.d("loginFailed ",basicTrendBean.getCode()+"");
    }

    @Override
    public void loginError() {
        Log.d("loginError ","接口异常");
    }

    /** 期号的数据显示*/
    private void bindQiHaoData(List<String> numList) {
        if (issueDataAdapter == null) {
            issueDataAdapter = new IssueDataAdapter(R.layout.items , getContext());
            issueDataAdapter.bindData(numList);
            issueListView.setAdapter(issueDataAdapter);
        }else{
            issueDataAdapter.bindData(numList);
            issueDataAdapter.notifyDataSetChanged();
            //复位
            mLeftScroll.scrollTo(0, 0);
            mHeadScroll.scrollTo(0,0);
        }
    }
    /**获取期号的集合*/
    private List<String> getIssueList(List<BasicTrendBean.ZsBean> zsBeanList){
        List<String> issueList = new ArrayList<>();
        for (BasicTrendBean.ZsBean zsData : zsBeanList) {
            issueList.add(zsData.getISSUE());
        }
        return issueList;
    }

    @Override
    public void changeXScroll(int left) {
        //顶部和底部容器滑动的回调;
        //此时需要同步中间走势的View的位置;
        mContentScroll.scrollTo(left, mContentScroll.getScrollY());
        //同步顶部自身的位置;
        mHeadScroll.scrollTo(left,0);
    }

    @Override
    public void changeYScoll(int top) {
        //中间走势View滑动位置的改变回调;
        //同步左边期号的Y轴的位置
        mLeftScroll.scrollTo(0, top);
        //同步中间走势View的位置
        mContentScroll.scrollTo(mContentScroll.getScrollX(), top);
        //有走势图头部...
        mHeadScroll.scrollTo(mContentScroll.getScrollX(),0);
    }
}
