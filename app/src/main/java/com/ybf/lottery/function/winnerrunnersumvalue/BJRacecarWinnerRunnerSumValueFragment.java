package com.ybf.lottery.function.winnerrunnersumvalue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ybf.lottery.R;
import com.ybf.lottery.adapter.IssueDataAdapter;
import com.ybf.lottery.adapter.bjscbasictrendadapter.BasicTrendAdapter;
import com.ybf.lottery.base.BaseMvpFragment;
import com.ybf.lottery.diyview.TrendFiltrateDialog;
import com.ybf.lottery.diyview.trend.CustomTrendLineView;
import com.ybf.lottery.diyview.trend.HeaderHorizontalScrollView;
import com.ybf.lottery.diyview.trend.LeftNumberCustomListView;
import com.ybf.lottery.diyview.trend.LeftNumberSynchScrollView;
import com.ybf.lottery.diyview.trend.ScrollChangeCallback;
import com.ybf.lottery.diyview.trend.TrendScrollViewWidget;
import com.ybf.lottery.model.bean.bjscbasictrendbean.BasicTrendStatisticBean;
import com.ybf.lottery.model.bean.dragontigertrendbean.LengthwaysDataBean;
import com.ybf.lottery.model.bean.dragontigertrendbean.TrendShowBean;
import com.ybf.lottery.model.bean.winnerrunnersumvaluebean.WinnerRunnerSumValueBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/4/19.
 * Use: 冠亚和值的fragment
 */

public class BJRacecarWinnerRunnerSumValueFragment extends BaseMvpFragment<WinnerRunnerSumValuePresenter> implements WinnerRunnerSumValueContract.mView, View.OnClickListener ,ScrollChangeCallback {

    @BindView(R.id.trend_header_ll)
    LinearLayout headerll;
    @BindView(R.id.winner_runner_sum_value_header_ll)
    LinearLayout sumValuell;
    @BindView(R.id.public_img_back)
    ImageView mBackImg;
    @BindView(R.id.public_txt_title)
    TextView titleTxt;
    @BindView(R.id.public_img_date)
    ImageView filterIcon;
    @BindView(R.id.data_login_ll)
    LinearLayout data_login_ll;
    @BindView(R.id.data_basic_trend_details_ll)
    LinearLayout data_ll;
    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.load_text)
    TextView loadText;
    @BindView(R.id.basic_trend_issue_scroll_left)
    LeftNumberSynchScrollView mLeftScroll;
    @BindView(R.id.basic_trend_header_scroll)
    HeaderHorizontalScrollView mHeadScroll;
    @BindView(R.id.basic_trend_scroll_content)
    TrendScrollViewWidget mContentScroll;
    @BindView(R.id.lv_basic_trend_issue)
    LeftNumberCustomListView issueListView;
    @BindView(R.id.custom_basic_trend_view)
    CustomTrendLineView customTrendView;
    @BindView(R.id.basic_trend_statistic_recycle)
    RecyclerView statisticRecyclerView;
    @BindView(R.id.statistic_basic_headerll)
    LinearLayout basicHeaderll;
    @BindView(R.id.statistic_winner_runner_sum_headerll)
    LinearLayout sumHeaderll;

    private static String SUM_VALUE_TYPE = "wrSumValueType";//fragment 入口传参 key
    private int sumValueType;

    private String TODAYKJ = "30";
    private String ISSUENUM_THIRTY = "30";
    private String ISSUENUM_FIFTY = "50";
    private String ISSUENUM_ONE_HUNDRED = "100";
    private String mPeriod = TODAYKJ;

    private int checkQSnum = 1;//选择期数(今日开奖:0 ;近30期:1;近50期:2;近100期:3) 默认30期
    private boolean omitType = true;//是否显示遗漏(默认显示)
    private boolean trendLineType = true;//是否显示折线(默认显示)
    private boolean lengways = false;//是否显示遗漏分层(默认不显示)
    private boolean cutOffLine = false;//是否显示分割线(默认不显示)
    private IssueDataAdapter issueDataAdapter;

    //纵向数据(列)
    private List<LengthwaysDataBean> lwListData3  = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData4  = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData5  = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData6  = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData7  = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData8  = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData9  = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData10 = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData11 = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData12 = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData13 = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData14 = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData15 = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData16 = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData17 = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData18 = new ArrayList<>();
    private List<LengthwaysDataBean> lwListData19 = new ArrayList<>();
    private List<LengthwaysDataBean> lwListDataSum = new ArrayList<>();//和值
    private List<LengthwaysDataBean> lwListDataBig  = new ArrayList<>();//大
    private List<LengthwaysDataBean> lwListDataSmall = new ArrayList<>();//小
    private List<LengthwaysDataBean> lwListDataOdd = new ArrayList<>();//单
    private List<LengthwaysDataBean> lwListDataEven = new ArrayList<>();//双

    @Override
    public WinnerRunnerSumValuePresenter initPresenter() {
        return new WinnerRunnerSumValuePresenter(this);
    }

    public static BJRacecarWinnerRunnerSumValueFragment newInstance(int wrSumType) {
        Bundle args = new Bundle();
        args.putInt(SUM_VALUE_TYPE , wrSumType);
        BJRacecarWinnerRunnerSumValueFragment fragment = new BJRacecarWinnerRunnerSumValueFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sumValueType = getArguments().getInt(SUM_VALUE_TYPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.bjsc_basic_trend_lay, container, false);
        ButterKnife.bind(this , mView);
        initView();
        initData(mPeriod);
        return mView;
    }
    private final int STATUS_LOADING = 0;//加载中
    private final int STATUS_LOAD_SUCCESS = 1;//加载成功
    private final int STATUS_LOAD_FAILED = 2;//加载失败
    private final int STATUS_SEREVER_ERROR = 3;//接口异常
    private void setStatus(int statu){
        switch (statu){
            case STATUS_LOADING:
                data_ll.setVisibility(View.GONE);
                data_login_ll.setVisibility(View.VISIBLE);
                loginProgress.setVisibility(View.VISIBLE);
                loadText.setText("加载中...");
                break;
            case STATUS_LOAD_SUCCESS:
                data_ll.setVisibility(View.VISIBLE);
                data_login_ll.setVisibility(View.GONE);
                break;
            case STATUS_LOAD_FAILED:
                data_ll.setVisibility(View.GONE);
                data_login_ll.setVisibility(View.VISIBLE);
                loginProgress.setVisibility(View.GONE);
                loadText.setText("加载失败");
                break;
            case STATUS_SEREVER_ERROR:
                data_ll.setVisibility(View.GONE);
                data_login_ll.setVisibility(View.VISIBLE);
                loginProgress.setVisibility(View.GONE);
                loadText.setText("暂无数据");
                break;
        }
    }
    private void initView(){
        if (sumValueType == 1) {
            mBackImg.setVisibility(View.VISIBLE);
            mBackImg.setOnClickListener(this);
        }else{
            mBackImg.setVisibility(View.GONE);
        }

        headerll.setVisibility(View.GONE);
        basicHeaderll.setVisibility(View.GONE);
        sumValuell.setVisibility(View.VISIBLE);
        sumHeaderll.setVisibility(View.VISIBLE);

        titleTxt.setText("冠亚和值");

        LinearLayoutManager manager = new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL ,false);
        statisticRecyclerView.setLayoutManager(manager);

        filterIcon.setVisibility(View.VISIBLE);
        filterIcon.setOnClickListener(this);
        mLeftScroll.setScrollViewListener(this);
        mHeadScroll.setScrollViewListener(this);
        mContentScroll.setScrollViewListener(this);
    }

    private void initData(String mPeriod){
        setStatus(STATUS_LOADING);
        mPresenter.loadData(mPeriod);
    }

    @Override
    public void loadSuccess(WinnerRunnerSumValueBean winnerRunnerSumValueBean) {
        setStatus(STATUS_LOAD_SUCCESS);
        if (winnerRunnerSumValueBean == null) {
            return;
        }
        List<WinnerRunnerSumValueBean.ZsBean> zsData = winnerRunnerSumValueBean.getZs();
        //期号设置
        bindQiHaoData(getIssueNumData(zsData));
        //走势区域
        customTrendView.setShowDatas(getTrendNumData(winnerRunnerSumValueBean) , getLYData(winnerRunnerSumValueBean) , 2 , omitType , trendLineType ,lengways, cutOffLine);
        //数据统计
        setStatisticData(winnerRunnerSumValueBean.getTj());
    }
    /**期数设置*/
    private void bindQiHaoData(List<String> issueNum){
        if (issueDataAdapter == null) {
            issueDataAdapter = new IssueDataAdapter(R.layout.items, getContext());
            issueDataAdapter.bindData(issueNum);
            issueListView.setAdapter(issueDataAdapter);
        }else{
            issueDataAdapter.bindData(issueNum);
            issueDataAdapter.notifyDataSetChanged();
            //复位
            mLeftScroll.scrollTo(0, 0);
            mHeadScroll.scrollTo(0,0);
        }

    }
    /**封装期数数据*/
    private List<String> getIssueNumData(List<WinnerRunnerSumValueBean.ZsBean> zsData){
        List<String> issueNum = new ArrayList<>();
        for (WinnerRunnerSumValueBean.ZsBean zs : zsData) {
            issueNum.add(zs.getISSUE());
        }
        return issueNum;
    }

    /**走势数据*/
    private List<TrendShowBean> getTrendNumData(WinnerRunnerSumValueBean sumValueBean){
        List<TrendShowBean> trendList = new ArrayList<>();
        List<WinnerRunnerSumValueBean.ZsBean> zsBeans = sumValueBean.getZs();
        for (int i = 0; i < zsBeans.size(); i++) {
            TrendShowBean showBean = new TrendShowBean();
            showBean.setDRAWCODE(zsBeans.get(i).getDRAWCODE());
            showBean.setZsData(getZSDatas(zsBeans.get(i)));
            trendList.add(showBean);
        }
        return trendList;
    }
    private List<Integer> getZSDatas(WinnerRunnerSumValueBean.ZsBean zsData){
        List<Integer> zsDataList = new ArrayList<>();
        zsDataList.add(zsData.getN3());
        zsDataList.add(zsData.getN4());
        zsDataList.add(zsData.getN5());
        zsDataList.add(zsData.getN6());
        zsDataList.add(zsData.getN7());
        zsDataList.add(zsData.getN8());
        zsDataList.add(zsData.getN9());
        zsDataList.add(zsData.getN10());
        zsDataList.add(zsData.getN11());
        zsDataList.add(zsData.getN12());
        zsDataList.add(zsData.getN13());
        zsDataList.add(zsData.getN14());
        zsDataList.add(zsData.getN15());
        zsDataList.add(zsData.getN16());
        zsDataList.add(zsData.getN17());
        zsDataList.add(zsData.getN18());
        zsDataList.add(zsData.getN19());

        int sumValue = 0;//添加和值
        for (int i = 0; i < zsDataList.size(); i++) {
            if (zsDataList.get(i) == 0) {
                sumValue = i+3;
                break;
            }
        }
        zsDataList.add(sumValue);
        zsDataList.add(zsData.getSUMBIG());
        zsDataList.add(zsData.getSUMSMALL());
        zsDataList.add(zsData.getSUMODD());
        zsDataList.add(zsData.getSUMEVEN());

        return zsDataList;
    }

    /**获得遗漏状态的数据*/
    private List<List<LengthwaysDataBean>> getLYData(WinnerRunnerSumValueBean wrSumDatas){
        List<List<LengthwaysDataBean>> allLengwaysList = new ArrayList<>();

        List<List<LengthwaysDataBean>> lengthwaysData = getLengthwaysData(wrSumDatas);
        for (int i = 0; i < lengthwaysData.size(); i++) {
            boolean showYL = true;
            List<LengthwaysDataBean> lengthwaysDataBeans = new ArrayList<>();
            for (int j = 0; j < lengthwaysData.get(i).size(); j++) {
                LengthwaysDataBean currItemData = lengthwaysData.get(i).get(j);
                if (showYL) {
                    if (currItemData.getNumData() == 0) {
                        showYL = false;
                    }
                }
                LengthwaysDataBean lengthwaysDataBean = new LengthwaysDataBean();
                lengthwaysDataBean.setNumData(currItemData.getNumData());
                lengthwaysDataBean.setShowYl(showYL);
                lengthwaysDataBeans.add(lengthwaysDataBean);
            }
            allLengwaysList.add(lengthwaysDataBeans);
        }
        return allLengwaysList;
    }

    /**纵向数据*/
    private List<List<LengthwaysDataBean>> getLengthwaysData(WinnerRunnerSumValueBean wrSumBean){
        List<List<LengthwaysDataBean>> lengwayList = new ArrayList<>();

        List<WinnerRunnerSumValueBean.ZsBean> zsBean = wrSumBean.getZs();
        for (WinnerRunnerSumValueBean.ZsBean zsDatas : zsBean) {
            getLengthwaysAllData(zsDatas);
        }
        lengwayList.add(lwListData3 );
        lengwayList.add(lwListData4 );
        lengwayList.add(lwListData5 );
        lengwayList.add(lwListData6 );
        lengwayList.add(lwListData7 );
        lengwayList.add(lwListData8 );
        lengwayList.add(lwListData9 );
        lengwayList.add(lwListData10);
        lengwayList.add(lwListData11);
        lengwayList.add(lwListData12);
        lengwayList.add(lwListData13);
        lengwayList.add(lwListData14);
        lengwayList.add(lwListData15);
        lengwayList.add(lwListData16);
        lengwayList.add(lwListData17);
        lengwayList.add(lwListData18);
        lengwayList.add(lwListData19);

        lengwayList.add(lwListDataSum);
        lengwayList.add(lwListDataBig);
        lengwayList.add(lwListDataSmall);
        lengwayList.add(lwListDataOdd);
        lengwayList.add(lwListDataEven);

        return lengwayList;
    }
    private void getLengthwaysAllData(WinnerRunnerSumValueBean.ZsBean zsData){
        LengthwaysDataBean lwData3    = new LengthwaysDataBean();
        LengthwaysDataBean lwData4    = new LengthwaysDataBean();
        LengthwaysDataBean lwData5    = new LengthwaysDataBean();
        LengthwaysDataBean lwData6    = new LengthwaysDataBean();
        LengthwaysDataBean lwData7    = new LengthwaysDataBean();
        LengthwaysDataBean lwData8    = new LengthwaysDataBean();
        LengthwaysDataBean lwData9    = new LengthwaysDataBean();
        LengthwaysDataBean lwData10   = new LengthwaysDataBean();
        LengthwaysDataBean lwData11   = new LengthwaysDataBean();
        LengthwaysDataBean lwData12   = new LengthwaysDataBean();
        LengthwaysDataBean lwData13   = new LengthwaysDataBean();
        LengthwaysDataBean lwData14   = new LengthwaysDataBean();
        LengthwaysDataBean lwData15   = new LengthwaysDataBean();
        LengthwaysDataBean lwData16   = new LengthwaysDataBean();
        LengthwaysDataBean lwData17   = new LengthwaysDataBean();
        LengthwaysDataBean lwData18   = new LengthwaysDataBean();
        LengthwaysDataBean lwData19   = new LengthwaysDataBean();
        LengthwaysDataBean lwDataSum  = new LengthwaysDataBean();//和值
        LengthwaysDataBean lwDataBig  = new LengthwaysDataBean();//大
        LengthwaysDataBean lwDataSmall = new LengthwaysDataBean();//小
        LengthwaysDataBean lwDataOdd   = new LengthwaysDataBean();//单
        LengthwaysDataBean lwDataEven  = new LengthwaysDataBean();//双

        lwData3.setNumData(zsData.getN3());
        lwData4.setNumData(zsData.getN4 ());
        lwData5.setNumData(zsData.getN5 ());
        lwData6.setNumData(zsData.getN6 ());
        lwData7.setNumData(zsData.getN7 ());
        lwData8.setNumData(zsData.getN8 ());
        lwData9.setNumData(zsData.getN9 ());
        lwData10.setNumData(zsData.getN10());
        lwData11.setNumData(zsData.getN11());
        lwData12.setNumData(zsData.getN12());
        lwData13.setNumData(zsData.getN13());
        lwData14.setNumData(zsData.getN14());
        lwData15.setNumData(zsData.getN15());
        lwData16.setNumData(zsData.getN16());
        lwData17.setNumData(zsData.getN17());
        lwData18.setNumData(zsData.getN18());
        lwData19.setNumData(zsData.getN19());
        lwDataSum.setNumData(0);//和值赋值(0:无遗漏分层背景)
        lwDataBig.setNumData(zsData.getSUMBIG());
        lwDataSmall.setNumData(zsData.getSUMSMALL());
        lwDataOdd.setNumData(zsData.getSUMODD());
        lwDataEven.setNumData(zsData.getSUMEVEN());

        lwListData3  .add(lwData3 );
        lwListData4  .add(lwData4 );
        lwListData5  .add(lwData5 );
        lwListData6  .add(lwData6 );
        lwListData7  .add(lwData7 );
        lwListData8  .add(lwData8 );
        lwListData9  .add(lwData9 );
        lwListData10 .add(lwData10);
        lwListData11 .add(lwData11);
        lwListData12 .add(lwData12);
        lwListData13 .add(lwData13);
        lwListData14 .add(lwData14);
        lwListData15 .add(lwData15);
        lwListData16 .add(lwData16);
        lwListData17 .add(lwData17);
        lwListData18 .add(lwData18);
        lwListData19 .add(lwData19);
        lwListDataSum .add(lwDataSum);
        lwListDataBig.add(lwDataBig);
        lwListDataSmall.add(lwDataSmall);
        lwListDataOdd.add(lwDataOdd);
        lwListDataEven.add(lwDataEven);
    }

    /**数据统计数据显示*/
    private void setStatisticData(WinnerRunnerSumValueBean.TjBean tjBean){
        WinnerRunnerSumValueBean.TjBean.tjDetailsBean occ = tjBean.getOcc();//出现次数
        WinnerRunnerSumValueBean.TjBean.tjDetailsBean maxCont = tjBean.getMaxCont();//最大连出
        WinnerRunnerSumValueBean.TjBean.tjDetailsBean maxMiss = tjBean.getMaxMiss();//最大遗漏
        WinnerRunnerSumValueBean.TjBean.tjDetailsBean avgMiss = tjBean.getAvgMiss();//平均遗漏
        WinnerRunnerSumValueBean.TjBean.tjDetailsBean lastMiss = tjBean.getLastMiss();//当前遗漏

        List<BasicTrendStatisticBean> statisticDataList = customData(occ, maxCont, maxMiss, avgMiss, lastMiss);

        BasicTrendAdapter basicTrendAdapter = new BasicTrendAdapter(statisticDataList, getContext());
        statisticRecyclerView.setAdapter(basicTrendAdapter);
    }
    private List<BasicTrendStatisticBean> customData(WinnerRunnerSumValueBean.TjBean.tjDetailsBean occ , WinnerRunnerSumValueBean.TjBean.tjDetailsBean maxCont ,
                                                     WinnerRunnerSumValueBean.TjBean.tjDetailsBean maxMiss , WinnerRunnerSumValueBean.TjBean.tjDetailsBean avgMiss ,
                                                     WinnerRunnerSumValueBean.TjBean.tjDetailsBean lastMiss){

        List<BasicTrendStatisticBean> tjDatas = new ArrayList<>();
        BasicTrendStatisticBean tjBean3 = new BasicTrendStatisticBean();
        tjBean3.setData1(occ.getN3());
        tjBean3.setData2(maxCont.getN3());
        tjBean3.setData3(maxMiss.getN3());
        tjBean3.setData4(avgMiss.getN3());
        tjBean3.setData5(lastMiss.getN3());
        tjDatas.add(tjBean3);
        BasicTrendStatisticBean tjBean4 = new BasicTrendStatisticBean();
        tjBean4.setData1     (occ.getN4());
        tjBean4.setData2 (maxCont.getN4());
        tjBean4.setData3 (maxMiss.getN4());
        tjBean4.setData4 (avgMiss.getN4());
        tjBean4.setData5(lastMiss.getN4());
        tjDatas.add(tjBean4);
        BasicTrendStatisticBean tjBean5 = new BasicTrendStatisticBean();
        tjBean5.setData1     (occ.getN5());
        tjBean5.setData2 (maxCont.getN5());
        tjBean5.setData3 (maxMiss.getN5());
        tjBean5.setData4 (avgMiss.getN5());
        tjBean5.setData5(lastMiss.getN5());
        tjDatas.add(tjBean5);
        BasicTrendStatisticBean tjBean6 = new BasicTrendStatisticBean();
        tjBean6.setData1     (occ.getN6());
        tjBean6.setData2 (maxCont.getN6());
        tjBean6.setData3 (maxMiss.getN6());
        tjBean6.setData4 (avgMiss.getN6());
        tjBean6.setData5(lastMiss.getN6());
        tjDatas.add(tjBean6);
        BasicTrendStatisticBean tjBean7 = new BasicTrendStatisticBean();
        tjBean7.setData1     (occ.getN7());
        tjBean7.setData2 (maxCont.getN7());
        tjBean7.setData3 (maxMiss.getN7());
        tjBean7.setData4 (avgMiss.getN7());
        tjBean7.setData5(lastMiss.getN7());
        tjDatas.add(tjBean7);
        BasicTrendStatisticBean tjBean8 = new BasicTrendStatisticBean();
        tjBean8.setData1     (occ.getN8());
        tjBean8.setData2 (maxCont.getN8());
        tjBean8.setData3 (maxMiss.getN8());
        tjBean8.setData4 (avgMiss.getN8());
        tjBean8.setData5(lastMiss.getN8());
        tjDatas.add(tjBean8);
        BasicTrendStatisticBean tjBean9 = new BasicTrendStatisticBean();
        tjBean9.setData1     (occ.getN9());
        tjBean9.setData2 (maxCont.getN9());
        tjBean9.setData3 (maxMiss.getN9());
        tjBean9.setData4 (avgMiss.getN9());
        tjBean9.setData5(lastMiss.getN9());
        tjDatas.add(tjBean9);
        BasicTrendStatisticBean tjBean10 = new BasicTrendStatisticBean();
        tjBean10.setData1     (occ.getN10());
        tjBean10.setData2 (maxCont.getN10());
        tjBean10.setData3 (maxMiss.getN10());
        tjBean10.setData4 (avgMiss.getN10());
        tjBean10.setData5(lastMiss.getN10());
        tjDatas.add(tjBean10);
        BasicTrendStatisticBean tjBean11 = new BasicTrendStatisticBean();
        tjBean11.setData1     (occ.getN11());
        tjBean11.setData2 (maxCont.getN11());
        tjBean11.setData3 (maxMiss.getN11());
        tjBean11.setData4 (avgMiss.getN11());
        tjBean11.setData5(lastMiss.getN11());
        tjDatas.add(tjBean11);
        BasicTrendStatisticBean tjBean12 = new BasicTrendStatisticBean();
        tjBean12.setData1     (occ.getN12());
        tjBean12.setData2 (maxCont.getN12());
        tjBean12.setData3 (maxMiss.getN12());
        tjBean12.setData4 (avgMiss.getN12());
        tjBean12.setData5(lastMiss.getN12());
        tjDatas.add(tjBean12);
        BasicTrendStatisticBean tjBean13 = new BasicTrendStatisticBean();
        tjBean13.setData1     (occ.getN13());
        tjBean13.setData2 (maxCont.getN13());
        tjBean13.setData3 (maxMiss.getN13());
        tjBean13.setData4 (avgMiss.getN13());
        tjBean13.setData5(lastMiss.getN13());
        tjDatas.add(tjBean13);
        BasicTrendStatisticBean tjBean14 = new BasicTrendStatisticBean();
        tjBean14.setData1     (occ.getN14());
        tjBean14.setData2 (maxCont.getN14());
        tjBean14.setData3 (maxMiss.getN14());
        tjBean14.setData4 (avgMiss.getN14());
        tjBean14.setData5(lastMiss.getN14());
        tjDatas.add(tjBean14);
        BasicTrendStatisticBean tjBean15 = new BasicTrendStatisticBean();
        tjBean15.setData1     (occ.getN15());
        tjBean15.setData2 (maxCont.getN15());
        tjBean15.setData3 (maxMiss.getN15());
        tjBean15.setData4 (avgMiss.getN15());
        tjBean15.setData5(lastMiss.getN15());
        tjDatas.add(tjBean15);
        BasicTrendStatisticBean tjBean16 = new BasicTrendStatisticBean();
        tjBean16.setData1     (occ.getN16());
        tjBean16.setData2 (maxCont.getN16());
        tjBean16.setData3 (maxMiss.getN16());
        tjBean16.setData4 (avgMiss.getN16());
        tjBean16.setData5(lastMiss.getN16());
        tjDatas.add(tjBean16);
        BasicTrendStatisticBean tjBean17 = new BasicTrendStatisticBean();
        tjBean17.setData1     (occ.getN17());
        tjBean17.setData2 (maxCont.getN17());
        tjBean17.setData3 (maxMiss.getN17());
        tjBean17.setData4 (avgMiss.getN17());
        tjBean17.setData5(lastMiss.getN17());
        tjDatas.add(tjBean17);
        BasicTrendStatisticBean tjBean18 = new BasicTrendStatisticBean();
        tjBean18.setData1     (occ.getN18());
        tjBean18.setData2 (maxCont.getN18());
        tjBean18.setData3 (maxMiss.getN18());
        tjBean18.setData4 (avgMiss.getN18());
        tjBean18.setData5(lastMiss.getN18());
        tjDatas.add(tjBean18);
        BasicTrendStatisticBean tjBean19 = new BasicTrendStatisticBean();
        tjBean19.setData1     (occ.getN19());
        tjBean19.setData2 (maxCont.getN19());
        tjBean19.setData3 (maxMiss.getN19());
        tjBean19.setData4 (avgMiss.getN19());
        tjBean19.setData5(lastMiss.getN19());
        tjDatas.add(tjBean19);
        BasicTrendStatisticBean tjBeanSum = new BasicTrendStatisticBean();
        tjBeanSum.setData1     (-1);
        tjBeanSum.setData2 (-1);
        tjBeanSum.setData3 (-1);
        tjBeanSum.setData4 (-1);
        tjBeanSum.setData5(-1);
        tjDatas.add(tjBeanSum);
        BasicTrendStatisticBean tjBeanBig = new BasicTrendStatisticBean();
        tjBeanBig.setData1     (occ.getSUMBIG());
        tjBeanBig.setData2 (maxCont.getSUMBIG());
        tjBeanBig.setData3 (maxMiss.getSUMBIG());
        tjBeanBig.setData4 (avgMiss.getSUMBIG());
        tjBeanBig.setData5(lastMiss.getSUMBIG());
        tjDatas.add(tjBeanBig);
        BasicTrendStatisticBean tjBeanSmall = new BasicTrendStatisticBean();
        tjBeanSmall.setData1     (occ.getSUMSMALL());
        tjBeanSmall.setData2 (maxCont.getSUMSMALL());
        tjBeanSmall.setData3 (maxMiss.getSUMSMALL());
        tjBeanSmall.setData4 (avgMiss.getSUMSMALL());
        tjBeanSmall.setData5(lastMiss.getSUMSMALL());
        tjDatas.add(tjBeanSmall);
        BasicTrendStatisticBean tjBeanOdd = new BasicTrendStatisticBean();
        tjBeanOdd.setData1     (occ.getSUMODD());
        tjBeanOdd.setData2 (maxCont.getSUMODD());
        tjBeanOdd.setData3 (maxMiss.getSUMODD());
        tjBeanOdd.setData4 (avgMiss.getSUMODD());
        tjBeanOdd.setData5(lastMiss.getSUMODD());
        tjDatas.add(tjBeanOdd);
        BasicTrendStatisticBean tjBeanEven = new BasicTrendStatisticBean();
        tjBeanEven.setData1     (occ.getSUMEVEN());
        tjBeanEven.setData2 (maxCont.getSUMEVEN());
        tjBeanEven.setData3 (maxMiss.getSUMEVEN());
        tjBeanEven.setData4 (avgMiss.getSUMEVEN());
        tjBeanEven.setData5(lastMiss.getSUMEVEN());
        tjDatas.add(tjBeanEven);

        return tjDatas;
    }

    @Override
    public void loadFailed(WinnerRunnerSumValueBean winnerRunnerSumValueBean) {
        setStatus(STATUS_LOAD_FAILED);
    }

    @Override
    public void loadError() {
        setStatus(STATUS_SEREVER_ERROR);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.public_img_back:
                getActivity().finish();
                break;
            case R.id.public_img_date:
                showDialog();
                break;
        }
    }
    private void showDialog(){
        TrendFiltrateDialog filtrateDialog = new TrendFiltrateDialog(getActivity() ,checkQSnum , omitType , trendLineType ,lengways, cutOffLine);

        filtrateDialog.setNoOnclickListener(new TrendFiltrateDialog.onNoOnclickListener() {
            @Override
            public void onNoClick() {
                filtrateDialog.dismiss();
            }
        });
        filtrateDialog.setOkOnclickListener(new TrendFiltrateDialog.onOkOnclickListener() {
            @Override
            public void onOkClick(int currQSnum, boolean booType1, boolean booType2, boolean booType3, boolean booType4) {
                checkQSnum = currQSnum;//确定时保留所选

                omitType = booType1;
                trendLineType = booType2;
                lengways = booType3;
                cutOffLine = booType4;

                initData(getPeriod(checkQSnum));
                filtrateDialog.dismiss();
            }
        });

        filtrateDialog.setCanceledOnTouchOutside(true);//设置空白处点击 dialog消失
        filtrateDialog.show();
    }
    private String getPeriod(int cheakNum){
        switch (cheakNum){
            case 0:
                mPeriod = TODAYKJ;
                break;
            case 1:
                mPeriod = ISSUENUM_THIRTY;
                break;
            case 2:
                mPeriod = ISSUENUM_FIFTY;
                break;
            case 3:
                mPeriod = ISSUENUM_ONE_HUNDRED;
                break;
        }
        return mPeriod;
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
