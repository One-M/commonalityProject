package com.ybf.lottery.function.dragontigertrend;

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
import com.ybf.lottery.model.bean.dragontigertrendbean.DragonTigerTrendBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/4/13.
 * Use:龙虎走势fragment
 */

public class BJRacecarDragonTigerTrendFragment extends BaseMvpFragment<BJRacecarDragonTigerTrendPresenter> implements BJRacecarDragonTigerTrendContract.mView, View.OnClickListener ,ScrollChangeCallback {

    @BindView(R.id.public_img_back)
    ImageView mBackImg;
    @BindView(R.id.public_txt_title)
    TextView titleTxt;
    @BindView(R.id.public_img_date)
    ImageView filterIcon;
    @BindView(R.id.trend_header_dt)
    LinearLayout header_dt;
    @BindViews({R.id.trend_header_2 , R.id.trend_header_3, R.id.trend_header_4, R.id.trend_header_5, R.id.trend_header_6,
                R.id.trend_header_7, R.id.trend_header_8, R.id.trend_header_9})
    List<LinearLayout> headerRanking;//头部 2-9名布局，用于隐藏
    @BindView(R.id.statistic_header_dt)
    LinearLayout statisticHeaderDt;
    @BindViews({R.id.stitistic_header_2, R.id.stitistic_header_3, R.id.stitistic_header_4, R.id.stitistic_header_5, R.id.stitistic_header_6,
                R.id.stitistic_header_7, R.id.stitistic_header_8, R.id.stitistic_header_9,})
    List<LinearLayout> statisticRanking;//统计 2-9名布局，用于隐藏
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

    private static String DTTREND_TYPE = "DTTrendType";//fragment 入口传参 key
    private int dtTrendType;
    private String mFType = "1";
    private String TODAYKJ = "30";
    private String ISSUENUM_THIRTY = "30";
    private String ISSUENUM_FIFTY = "50";
    private String ISSUENUM_ONE_HUNDRED = "100";
    private String mPeriod = TODAYKJ;
    private IssueDataAdapter issueDataAdapter;

    private int checkQSnum = 1;//选择期数(今日开奖:0 ;近30期:1;近50期:2;近100期:3) 默认30期
    private boolean omitType = true;//是否显示遗漏(默认显示)
    private boolean trendLineType = true;//是否显示折线(默认显示)
    private boolean lengways = false;//是否显示遗漏分层(默认不显示)
    private boolean cutOffLine = false;//是否显示分割线(默认不显示)
    //纵向数据(列)
    private List<LengthwaysDataBean> lwData1  = new ArrayList<>();
    private List<LengthwaysDataBean> lwData2  = new ArrayList<>();
    private List<LengthwaysDataBean> lwData3  = new ArrayList<>();
    private List<LengthwaysDataBean> lwData4  = new ArrayList<>();
    private List<LengthwaysDataBean> lwData5  = new ArrayList<>();
    private List<LengthwaysDataBean> lwData6  = new ArrayList<>();
    private List<LengthwaysDataBean> lwData7  = new ArrayList<>();
    private List<LengthwaysDataBean> lwData8  = new ArrayList<>();
    private List<LengthwaysDataBean> lwData9  = new ArrayList<>();
    private List<LengthwaysDataBean> lwData10 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData11 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData12 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData13 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData14 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData15 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData16 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData17 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData18 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData19 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData20 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData21 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData22 = new ArrayList<>();

    @Override
    public BJRacecarDragonTigerTrendPresenter initPresenter() {
        return new BJRacecarDragonTigerTrendPresenter(this);
    }
    public static BJRacecarDragonTigerTrendFragment newInstance(int dtTrendType) {
        Bundle args = new Bundle();
        args.putInt(DTTREND_TYPE , dtTrendType);
        BJRacecarDragonTigerTrendFragment fragment = new BJRacecarDragonTigerTrendFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dtTrendType = getArguments().getInt(DTTREND_TYPE);
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
    private void initView(){
        if (dtTrendType == 1) {
            mBackImg.setVisibility(View.VISIBLE);
            mBackImg.setOnClickListener(this);
        }else{
            mBackImg.setVisibility(View.GONE);
        }
        titleTxt.setText("龙虎走势");
        //隐藏2-9名
        for (int i = 0; i < headerRanking.size(); i++) {
            headerRanking.get(i).setVisibility(View.GONE);
        }
        for (int i = 0; i < statisticRanking.size(); i++) {
            statisticRanking.get(i).setVisibility(View.GONE);
        }
        LinearLayoutManager manager = new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL ,false);
        statisticRecyclerView.setLayoutManager(manager);

        filterIcon.setVisibility(View.VISIBLE);
        filterIcon.setOnClickListener(this);
        //显示龙虎
        header_dt.setVisibility(View.VISIBLE);
        statisticHeaderDt.setVisibility(View.VISIBLE);
        mLeftScroll.setScrollViewListener(this);
        mHeadScroll.setScrollViewListener(this);
        mContentScroll.setScrollViewListener(this);
    }

    private void initData(String period){
        setStatus(STATUS_LOADING);
        mPresenter.loadData(period , mFType);
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

    @Override
    public void loginSuccess(DragonTigerTrendBean dragonTigerTrendBean) {
        if (dragonTigerTrendBean == null) {
            return;
        }
        setStatus(STATUS_LOAD_SUCCESS);
        //期号设置
        bindQiHaoData(getIssueList(dragonTigerTrendBean.getZs()));
        //走势号码区域
        customTrendView.setShowDatas(getTrendNumData(dragonTigerTrendBean) ,getLYData(dragonTigerTrendBean) , 1 , omitType , trendLineType ,lengways, cutOffLine);

        DragonTigerTrendBean.TjBean tj = dragonTigerTrendBean.getTj();
        setStatisticData(tj);
    }

    /**
     * 走势区域数据封装
     * @param dtTrendBean
     */
    private List<TrendShowBean> getTrendNumData(DragonTigerTrendBean dtTrendBean){
        List<TrendShowBean> dtShowDataList = new ArrayList<>();
        List<DragonTigerTrendBean.ZsBean> zs = dtTrendBean.getZs();
        for (int i = 0; i < zs.size(); i++) {
            TrendShowBean showBean = new TrendShowBean();
            showBean.setDRAWCODE(zs.get(i).getDRAWCODE());
            showBean.setZsData(getZsData(zs.get(i)));
            dtShowDataList.add(showBean);
        }
        return dtShowDataList;
    }
    private List<Integer> getZsData(DragonTigerTrendBean.ZsBean zsBean){
        List<Integer> zsList = new ArrayList<>();
        zsList.add(zsBean.getF01());
        zsList.add(zsBean.getF02());
        zsList.add(zsBean.getF03());
        zsList.add(zsBean.getF04());
        zsList.add(zsBean.getF05());
        zsList.add(zsBean.getF06());
        zsList.add(zsBean.getF07());
        zsList.add(zsBean.getF08());
        zsList.add(zsBean.getF09());
        zsList.add(zsBean.getF10());
        zsList.add(zsBean.getS01());
        zsList.add(zsBean.getS02());
        zsList.add(zsBean.getS03());
        zsList.add(zsBean.getS04());
        zsList.add(zsBean.getS05());
        zsList.add(zsBean.getS06());
        zsList.add(zsBean.getS07());
        zsList.add(zsBean.getS08());
        zsList.add(zsBean.getS09());
        zsList.add(zsBean.getS10());
        zsList.add(zsBean.getDRAGON());
        zsList.add(zsBean.getTIGER());
        return zsList;
    }

    /**获得遗漏状态的数据*/
    private List<List<LengthwaysDataBean>> getLYData(DragonTigerTrendBean dtTrendBean){
        List<List<LengthwaysDataBean>> allLengwaysList = new ArrayList<>();

        List<List<LengthwaysDataBean>> lengthwaysData = getLengthwaysData(dtTrendBean);
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

    /**纵向数据封装(遗漏分层处理)*/
    private List<List<LengthwaysDataBean>> getLengthwaysData(DragonTigerTrendBean dtTrendBean){
        List<List<LengthwaysDataBean>> lengthwaysDataList = new ArrayList<>();

        List<DragonTigerTrendBean.ZsBean> zsBean = dtTrendBean.getZs();
        for (int i = 0; i < zsBean.size(); i++) {
            getLengthwaysAllData(zsBean.get(i));
        }
        lengthwaysDataList.add(lwData1 );
        lengthwaysDataList.add(lwData2 );
        lengthwaysDataList.add(lwData3 );
        lengthwaysDataList.add(lwData4 );
        lengthwaysDataList.add(lwData5 );
        lengthwaysDataList.add(lwData6 );
        lengthwaysDataList.add(lwData7 );
        lengthwaysDataList.add(lwData8 );
        lengthwaysDataList.add(lwData9 );
        lengthwaysDataList.add(lwData10);
        lengthwaysDataList.add(lwData11);
        lengthwaysDataList.add(lwData12);
        lengthwaysDataList.add(lwData13);
        lengthwaysDataList.add(lwData14);
        lengthwaysDataList.add(lwData15);
        lengthwaysDataList.add(lwData16);
        lengthwaysDataList.add(lwData17);
        lengthwaysDataList.add(lwData18);
        lengthwaysDataList.add(lwData19);
        lengthwaysDataList.add(lwData20);
        lengthwaysDataList.add(lwData21);
        lengthwaysDataList.add(lwData22);

        return lengthwaysDataList;
    }

    private void getLengthwaysAllData(DragonTigerTrendBean.ZsBean zsBean){
        LengthwaysDataBean lengthData1 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData2 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData3 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData4 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData5 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData6 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData7 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData8 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData9 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData10 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData11 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData12 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData13 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData14 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData15 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData16 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData17 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData18 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData19 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData20 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData21 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData22 = new LengthwaysDataBean();
        lengthData1 .setNumData(zsBean.getF01());
        lengthData2 .setNumData(zsBean.getF02());
        lengthData3 .setNumData(zsBean.getF03());
        lengthData4 .setNumData(zsBean.getF04());
        lengthData5 .setNumData(zsBean.getF05());
        lengthData6 .setNumData(zsBean.getF06());
        lengthData7 .setNumData(zsBean.getF07());
        lengthData8 .setNumData(zsBean.getF08());
        lengthData9 .setNumData(zsBean.getF09());
        lengthData10.setNumData(zsBean.getF10());
        lengthData11.setNumData(zsBean.getS01());
        lengthData12.setNumData(zsBean.getS02());
        lengthData13.setNumData(zsBean.getS03());
        lengthData14.setNumData(zsBean.getS04());
        lengthData15.setNumData(zsBean.getS05());
        lengthData16.setNumData(zsBean.getS06());
        lengthData17.setNumData(zsBean.getS07());
        lengthData18.setNumData(zsBean.getS08());
        lengthData19.setNumData(zsBean.getS09());
        lengthData20.setNumData(zsBean.getS10());
        lengthData21.setNumData(zsBean.getDRAGON());
        lengthData22.setNumData(zsBean.getTIGER());

        lwData1.add( lengthData1 );
        lwData2.add( lengthData2 );
        lwData3.add( lengthData3 );
        lwData4.add( lengthData4 );
        lwData5.add( lengthData5 );
        lwData6.add( lengthData6 );
        lwData7.add( lengthData7 );
        lwData8.add( lengthData8 );
        lwData9.add( lengthData9 );
        lwData10.add(lengthData10);
        lwData11.add(lengthData11);
        lwData12.add(lengthData12);
        lwData13.add(lengthData13);
        lwData14.add(lengthData14);
        lwData15.add(lengthData15);
        lwData16.add(lengthData16);
        lwData17.add(lengthData17);
        lwData18.add(lengthData18);
        lwData19.add(lengthData19);
        lwData20.add(lengthData20);
        lwData21.add(lengthData21);
        lwData22.add(lengthData22);
    }


    /**数据统计数据显示*/
    private void setStatisticData(DragonTigerTrendBean.TjBean tjBean){
        DragonTigerTrendBean.TjBean.tjDataBean occ = tjBean.getOcc();//出现次数
        DragonTigerTrendBean.TjBean.tjDataBean maxCont = tjBean.getMaxCont();//最大连出
        DragonTigerTrendBean.TjBean.tjDataBean maxMiss = tjBean.getMaxMiss();//最大遗漏
        DragonTigerTrendBean.TjBean.tjDataBean avgMiss = tjBean.getAvgMiss();//平均遗漏
        DragonTigerTrendBean.TjBean.tjDataBean lastMiss = tjBean.getLastMiss();//当前遗漏

        List<BasicTrendStatisticBean> statisticDataList = customData(occ, maxCont, maxMiss, avgMiss, lastMiss);

        BasicTrendAdapter basicTrendAdapter = new BasicTrendAdapter(statisticDataList, getContext());
        statisticRecyclerView.setAdapter(basicTrendAdapter);
    }

    private List<BasicTrendStatisticBean> customData(DragonTigerTrendBean.TjBean.tjDataBean occ, DragonTigerTrendBean.TjBean.tjDataBean maxCont,
                                                     DragonTigerTrendBean.TjBean.tjDataBean maxMiss, DragonTigerTrendBean.TjBean.tjDataBean avgMiss, DragonTigerTrendBean.TjBean.tjDataBean lastMiss){
        List<BasicTrendStatisticBean> statisticDataList = new ArrayList<>();

        BasicTrendStatisticBean statisticBeanA1 = new BasicTrendStatisticBean();
        statisticBeanA1.setData1(occ.getF01());
        statisticBeanA1.setData2(maxCont.getF01());
        statisticBeanA1.setData3(maxMiss.getF01());
        statisticBeanA1.setData4(avgMiss.getF01());
        statisticBeanA1.setData5(lastMiss.getF01());
        statisticDataList.add(statisticBeanA1);
        BasicTrendStatisticBean statisticBeanA2 = new BasicTrendStatisticBean();
        statisticBeanA2.setData1(occ.getF02());
        statisticBeanA2.setData2(maxCont.getF02());
        statisticBeanA2.setData3(maxMiss.getF02());
        statisticBeanA2.setData4(avgMiss.getF02());
        statisticBeanA2.setData5(lastMiss.getF02());
        statisticDataList.add(statisticBeanA2);
        BasicTrendStatisticBean statisticBeanA3 = new BasicTrendStatisticBean();
        statisticBeanA3.setData1     (occ.getF03());
        statisticBeanA3.setData2 (maxCont.getF03());
        statisticBeanA3.setData3 (maxMiss.getF03());
        statisticBeanA3.setData4 (avgMiss.getF03());
        statisticBeanA3.setData5(lastMiss.getF03());
        statisticDataList.add(statisticBeanA3);
        BasicTrendStatisticBean statisticBeanA4 = new BasicTrendStatisticBean();
        statisticBeanA4.setData1     (occ.getF04());
        statisticBeanA4.setData2 (maxCont.getF04());
        statisticBeanA4.setData3 (maxMiss.getF04());
        statisticBeanA4.setData4 (avgMiss.getF04());
        statisticBeanA4.setData5(lastMiss.getF04());
        statisticDataList.add(statisticBeanA4);
        BasicTrendStatisticBean statisticBeanA5 = new BasicTrendStatisticBean();
        statisticBeanA5.setData1     (occ.getF05());
        statisticBeanA5.setData2 (maxCont.getF05());
        statisticBeanA5.setData3 (maxMiss.getF05());
        statisticBeanA5.setData4 (avgMiss.getF05());
        statisticBeanA5.setData5(lastMiss.getF05());
        statisticDataList.add(statisticBeanA5);
        BasicTrendStatisticBean statisticBeanA6 = new BasicTrendStatisticBean();
        statisticBeanA6.setData1     (occ.getF06());
        statisticBeanA6.setData2 (maxCont.getF06());
        statisticBeanA6.setData3 (maxMiss.getF06());
        statisticBeanA6.setData4 (avgMiss.getF06());
        statisticBeanA6.setData5(lastMiss.getF06());
        statisticDataList.add(statisticBeanA6);
        BasicTrendStatisticBean statisticBeanA7 = new BasicTrendStatisticBean();
        statisticBeanA7.setData1     (occ.getF07());
        statisticBeanA7.setData2 (maxCont.getF07());
        statisticBeanA7.setData3 (maxMiss.getF07());
        statisticBeanA7.setData4 (avgMiss.getF07());
        statisticBeanA7.setData5(lastMiss.getF07());
        statisticDataList.add(statisticBeanA7);
        BasicTrendStatisticBean statisticBeanA8 = new BasicTrendStatisticBean();
        statisticBeanA8.setData1     (occ.getF08());
        statisticBeanA8.setData2 (maxCont.getF08());
        statisticBeanA8.setData3 (maxMiss.getF08());
        statisticBeanA8.setData4 (avgMiss.getF08());
        statisticBeanA8.setData5(lastMiss.getF08());
        statisticDataList.add(statisticBeanA8);
        BasicTrendStatisticBean statisticBeanA9 = new BasicTrendStatisticBean();
        statisticBeanA9.setData1     (occ.getF09());
        statisticBeanA9.setData2 (maxCont.getF09());
        statisticBeanA9.setData3 (maxMiss.getF09());
        statisticBeanA9.setData4 (avgMiss.getF09());
        statisticBeanA9.setData5(lastMiss.getF09());
        statisticDataList.add(statisticBeanA9);
        BasicTrendStatisticBean statisticBeanA10 = new BasicTrendStatisticBean();
        statisticBeanA10.setData1     (occ.getF10());
        statisticBeanA10.setData2 (maxCont.getF10());
        statisticBeanA10.setData3 (maxMiss.getF10());
        statisticBeanA10.setData4 (avgMiss.getF10());
        statisticBeanA10.setData5(lastMiss.getF10());
        statisticDataList.add(statisticBeanA10);

        BasicTrendStatisticBean statisticBeanB1 = new BasicTrendStatisticBean();
        statisticBeanB1.setData1(occ.getF01());
        statisticBeanB1.setData2(maxCont.getF01());
        statisticBeanB1.setData3(maxMiss.getF01());
        statisticBeanB1.setData4(avgMiss.getF01());
        statisticBeanB1.setData5(lastMiss.getF01());
        statisticDataList.add(statisticBeanB1);
        BasicTrendStatisticBean statisticBeanB2 = new BasicTrendStatisticBean();
        statisticBeanB2.setData1(occ.getF02());
        statisticBeanB2.setData2(maxCont.getF02());
        statisticBeanB2.setData3(maxMiss.getF02());
        statisticBeanB2.setData4(avgMiss.getF02());
        statisticBeanB2.setData5(lastMiss.getF02());
        statisticDataList.add(statisticBeanB2);
        BasicTrendStatisticBean statisticBeanB3 = new BasicTrendStatisticBean();
        statisticBeanB3.setData1     (occ.getF03());
        statisticBeanB3.setData2 (maxCont.getF03());
        statisticBeanB3.setData3 (maxMiss.getF03());
        statisticBeanB3.setData4 (avgMiss.getF03());
        statisticBeanB3.setData5(lastMiss.getF03());
        statisticDataList.add(statisticBeanB3);
        BasicTrendStatisticBean statisticBeanB4 = new BasicTrendStatisticBean();
        statisticBeanB4.setData1     (occ.getF04());
        statisticBeanB4.setData2 (maxCont.getF04());
        statisticBeanB4.setData3 (maxMiss.getF04());
        statisticBeanB4.setData4 (avgMiss.getF04());
        statisticBeanB4.setData5(lastMiss.getF04());
        statisticDataList.add(statisticBeanB4);
        BasicTrendStatisticBean statisticBeanB5 = new BasicTrendStatisticBean();
        statisticBeanB5.setData1     (occ.getF05());
        statisticBeanB5.setData2 (maxCont.getF05());
        statisticBeanB5.setData3 (maxMiss.getF05());
        statisticBeanB5.setData4 (avgMiss.getF05());
        statisticBeanB5.setData5(lastMiss.getF05());
        statisticDataList.add(statisticBeanB5);
        BasicTrendStatisticBean statisticBeanB6 = new BasicTrendStatisticBean();
        statisticBeanB6.setData1     (occ.getF06());
        statisticBeanB6.setData2 (maxCont.getF06());
        statisticBeanB6.setData3 (maxMiss.getF06());
        statisticBeanB6.setData4 (avgMiss.getF06());
        statisticBeanB6.setData5(lastMiss.getF06());
        statisticDataList.add(statisticBeanB6);
        BasicTrendStatisticBean statisticBeanB7 = new BasicTrendStatisticBean();
        statisticBeanB7.setData1     (occ.getF07());
        statisticBeanB7.setData2 (maxCont.getF07());
        statisticBeanB7.setData3 (maxMiss.getF07());
        statisticBeanB7.setData4 (avgMiss.getF07());
        statisticBeanB7.setData5(lastMiss.getF07());
        statisticDataList.add(statisticBeanB7);
        BasicTrendStatisticBean statisticBeanB8 = new BasicTrendStatisticBean();
        statisticBeanB8.setData1     (occ.getF08());
        statisticBeanB8.setData2 (maxCont.getF08());
        statisticBeanB8.setData3 (maxMiss.getF08());
        statisticBeanB8.setData4 (avgMiss.getF08());
        statisticBeanB8.setData5(lastMiss.getF08());
        statisticDataList.add(statisticBeanB8);
        BasicTrendStatisticBean statisticBeanB9 = new BasicTrendStatisticBean();
        statisticBeanB9.setData1     (occ.getF09());
        statisticBeanB9.setData2 (maxCont.getF09());
        statisticBeanB9.setData3 (maxMiss.getF09());
        statisticBeanB9.setData4 (avgMiss.getF09());
        statisticBeanB9.setData5(lastMiss.getF09());
        statisticDataList.add(statisticBeanB9);
        BasicTrendStatisticBean statisticBeanB10 = new BasicTrendStatisticBean();
        statisticBeanB10.setData1     (occ.getF10());
        statisticBeanB10.setData2 (maxCont.getF10());
        statisticBeanB10.setData3 (maxMiss.getF10());
        statisticBeanB10.setData4 (avgMiss.getF10());
        statisticBeanB10.setData5(lastMiss.getF10());
        statisticDataList.add(statisticBeanB10);

        BasicTrendStatisticBean statisticBeanC1 = new BasicTrendStatisticBean();
        statisticBeanC1.setData1     (occ.getDRAGON());
        statisticBeanC1.setData2 (maxCont.getDRAGON());
        statisticBeanC1.setData3 (maxMiss.getDRAGON());
        statisticBeanC1.setData4 (avgMiss.getDRAGON());
        statisticBeanC1.setData5(lastMiss.getDRAGON());
        statisticDataList.add(statisticBeanC1);
        BasicTrendStatisticBean statisticBeanC2 = new BasicTrendStatisticBean();
        statisticBeanC2.setData1     (occ.getTIGER());
        statisticBeanC2.setData2 (maxCont.getTIGER());
        statisticBeanC2.setData3 (maxMiss.getTIGER());
        statisticBeanC2.setData4 (avgMiss.getTIGER());
        statisticBeanC2.setData5(lastMiss.getTIGER());
        statisticDataList.add(statisticBeanC2);

        return statisticDataList;
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
    private List<String> getIssueList(List<DragonTigerTrendBean.ZsBean> zsBeanList){
        List<String> issueList = new ArrayList<>();
        for (DragonTigerTrendBean.ZsBean zsData : zsBeanList) {
            issueList.add(zsData.getISSUE());
        }
        return issueList;
    }

    @Override
    public void loginFailed(DragonTigerTrendBean dragonTigerTrendBean) {
        setStatus(STATUS_LOAD_FAILED);
    }

    @Override
    public void loginError() {
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
