package com.ybf.lottery.function.datastatistics;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ybf.lottery.R;
import com.ybf.lottery.adapter.bjscstatisticadapter.SMZSAdapter;
import com.ybf.lottery.adapter.bjscstatisticadapter.YGStatisticAdapter;
import com.ybf.lottery.base.BaseMvpFragment;
import com.ybf.lottery.eventBusInfo.StatisticKJEvent;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticSMTJBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticSumBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.BJRacecarStatisticYDDLBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.SMTJBean;
import com.ybf.lottery.model.bean.bjscstatisticbean.StatisticalBean;
import com.ybf.lottery.utils.DisplayUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/3/22.
 * Use:北京赛车数据统计
 */

public class BJRacecarDataStatisticsFragment extends BaseMvpFragment<BJRacecarDataStatisticsContract.Presenter> implements BJRacecarDataStatisticsContract.IView, View.OnClickListener {

    @BindView(R.id.public_txt_date)
    TextView mTextDate;
    /**请求期数*/
    private int currPeriod = 30;
    //亚冠统计
    @BindView(R.id.recyclerView_ygtj)
    RecyclerView ygtjRecycleView;
    //大小统计
    @BindView(R.id.recyclerView_dxtj)
    RecyclerView dxtjRecycleView;
    //单双统计
    @BindView(R.id.recyclerView_dstj)
    RecyclerView dstjRecycleView;
    //龙虎统计
    @BindView(R.id.recyclerView_lhtj)
    RecyclerView lhtjRecycleView;
    //双面走势
    @BindView(R.id.smzs_a)
    ImageView smzsA;
    @BindView(R.id.smzs_b)
    ImageView smzsB;
    @BindView(R.id.recyclerView_smzs)
    RecyclerView smzsRecycleView;
    //和值龙虎
    @BindView(R.id.lhzh_gyh_statistic_3)
    TextView gjhStatistic3;
    @BindView(R.id.lhzh_gyh_statistic_4)
    TextView gjhStatistic4;
    @BindView(R.id.lhzh_gyh_statistic_5)
    TextView gjhStatistic5;
    @BindView(R.id.lhzh_gyh_statistic_6)
    TextView gjhStatistic6;
    @BindView(R.id.lhzh_gyh_statistic_7)
    TextView gjhStatistic7;
    @BindView(R.id.lhzh_gyh_statistic_8)
    TextView gjhStatistic8;
    @BindView(R.id.lhzh_gyh_statistic_9)
    TextView gjhStatistic9;
    @BindView(R.id.lhzh_gyh_statistic_10)
    TextView gjhStatistic10;
    @BindView(R.id.lhzh_gyh_statistic_11)
    TextView gjhStatistic11;
    @BindView(R.id.lhzh_gyh_statistic_12)
    TextView gjhStatistic12;
    @BindView(R.id.lhzh_gyh_statistic_13)
    TextView gjhStatistic13;
    @BindView(R.id.lhzh_gyh_statistic_14)
    TextView gjhStatistic14;
    @BindView(R.id.lhzh_gyh_statistic_15)
    TextView gjhStatistic15;
    @BindView(R.id.lhzh_gyh_statistic_16)
    TextView gjhStatistic16;
    @BindView(R.id.lhzh_gyh_statistic_17)
    TextView gjhStatistic17;
    @BindView(R.id.lhzh_gyh_statistic_18)
    TextView gjhStatistic18;
    @BindView(R.id.lhzh_gyh_statistic_19)
    TextView gjhStatistic19;

    @BindView(R.id.lhzh_gyh_num_3)
    TextView gyhNum3;
    @BindView(R.id.lhzh_gyh_num_4)
    TextView gyhNum4;
    @BindView(R.id.lhzh_gyh_num_5)
    TextView gyhNum5;
    @BindView(R.id.lhzh_gyh_num_6)
    TextView gyhNum6;
    @BindView(R.id.lhzh_gyh_num_7)
    TextView gyhNum7;
    @BindView(R.id.lhzh_gyh_num_8)
    TextView gyhNum8;
    @BindView(R.id.lhzh_gyh_num_9)
    TextView gyhNum9;
    @BindView(R.id.lhzh_gyh_num_10)
    TextView gyhNum10;
    @BindView(R.id.lhzh_gyh_num_11)
    TextView gyhNum11;
    @BindView(R.id.lhzh_gyh_num_12)
    TextView gyhNum12;
    @BindView(R.id.lhzh_gyh_num_13)
    TextView gyhNum13;
    @BindView(R.id.lhzh_gyh_num_14)
    TextView gyhNum14;
    @BindView(R.id.lhzh_gyh_num_15)
    TextView gyhNum15;
    @BindView(R.id.lhzh_gyh_num_16)
    TextView gyhNum16;
    @BindView(R.id.lhzh_gyh_num_17)
    TextView gyhNum17;
    @BindView(R.id.lhzh_gyh_num_18)
    TextView gyhNum18;
    @BindView(R.id.lhzh_gyh_num_19)
    TextView gyhNum19;

    @BindView(R.id.lhzh_gyh_leaveout_3)
    TextView gyhLeaveout3;
    @BindView(R.id.lhzh_gyh_leaveout_4)
    TextView gyhLeaveout4;
    @BindView(R.id.lhzh_gyh_leaveout_5)
    TextView gyhLeaveout5;
    @BindView(R.id.lhzh_gyh_leaveout_6)
    TextView gyhLeaveout6;
    @BindView(R.id.lhzh_gyh_leaveout_7)
    TextView gyhLeaveout7;
    @BindView(R.id.lhzh_gyh_leaveout_8)
    TextView gyhLeaveout8;
    @BindView(R.id.lhzh_gyh_leaveout_9)
    TextView gyhLeaveout9;
    @BindView(R.id.lhzh_gyh_leaveout_10)
    TextView gyhLeaveout10;
    @BindView(R.id.lhzh_gyh_leaveout_11)
    TextView gyhLeaveout11;
    @BindView(R.id.lhzh_gyh_leaveout_12)
    TextView gyhLeaveout12;
    @BindView(R.id.lhzh_gyh_leaveout_13)
    TextView gyhLeaveout13;
    @BindView(R.id.lhzh_gyh_leaveout_14)
    TextView gyhLeaveout14;
    @BindView(R.id.lhzh_gyh_leaveout_15)
    TextView gyhLeaveout15;
    @BindView(R.id.lhzh_gyh_leaveout_16)
    TextView gyhLeaveout16;
    @BindView(R.id.lhzh_gyh_leaveout_17)
    TextView gyhLeaveout17;
    @BindView(R.id.lhzh_gyh_leaveout_18)
    TextView gyhLeaveout18;
    @BindView(R.id.lhzh_gyh_leaveout_19)
    TextView gyhLeaveout19;

    @BindView(R.id.lhzh_gj_statistic_dragon)
    TextView gjStatisticDragon;
    @BindView(R.id.lhzh_gj_statistic_tiger)
    TextView gjStatisticTiger;
    @BindView(R.id.lhzh_gj_num_dragon)
    TextView gjNumDragon;
    @BindView(R.id.lhzh_gj_num_tiger)
    TextView gjNumtiger;
    @BindView(R.id.lhzh_gj_leaveout_dragon)
    TextView gjLeaveoutDragon;
    @BindView(R.id.lhzh_gj_leaveout_tiger)
    TextView gjLeaveoutTiger;

    @BindView(R.id.lhzh_yj_statistic_dragon)
    TextView yjStatisticDragon;
    @BindView(R.id.lhzh_yj_statistic_tiger)
    TextView yjStatisticTiger;
    @BindView(R.id.lhzh_yj_num_dragon)
    TextView yjNumDragon;
    @BindView(R.id.lhzh_yj_num_tiger)
    TextView yjNumtiger;
    @BindView(R.id.lhzh_yj_leaveout_dragon)
    TextView yjLeaveoutDragon;
    @BindView(R.id.lhzh_yj_leaveout_tiger)
    TextView yjLeaveoutTiger;

    @BindView(R.id.lhzh_third_statistic_dragon)
    TextView thirdStatisticDragon;
    @BindView(R.id.lhzh_third_statistic_tiger)
    TextView thirdStatisticTiger;
    @BindView(R.id.lhzh_third_num_dragon)
    TextView thirdNumDragon;
    @BindView(R.id.lhzh_third_num_tiger)
    TextView thirdNumtiger;
    @BindView(R.id.lhzh_third_leaveout_dragon)
    TextView thirdLeaveoutDragon;
    @BindView(R.id.lhzh_third_leaveout_tiger)
    TextView thirdLeaveoutTiger;

    @BindView(R.id.lhzh_fourth_statistic_dragon)
    TextView fourthStatisticDragon;
    @BindView(R.id.lhzh_fourth_statistic_tiger)
    TextView fourthStatisticTiger;
    @BindView(R.id.lhzh_fourth_num_dragon)
    TextView fourthNumDragon;
    @BindView(R.id.lhzh_fourth_num_tiger)
    TextView fourthNumtiger;
    @BindView(R.id.lhzh_fourth_leaveout_dragon)
    TextView fourthLeaveoutDragon;
    @BindView(R.id.lhzh_fourth_leaveout_tiger)
    TextView fourthLeaveoutTiger;

    @BindView(R.id.lhzh_fifth_statistic_dragon)
    TextView fifthStatisticDragon;
    @BindView(R.id.lhzh_fifth_statistic_tiger)
    TextView fifthStatisticTiger;
    @BindView(R.id.lhzh_fifth_num_dragon)
    TextView fifthNumDragon;
    @BindView(R.id.lhzh_fifth_num_tiger)
    TextView fifthNumtiger;
    @BindView(R.id.lhzh_fifth_leaveout_dragon)
    TextView fifthLeaveoutDragon;
    @BindView(R.id.lhzh_fifth_leaveout_tiger)
    TextView fifthLeaveoutTiger;

    @BindView(R.id.nestsroll)
    NestedScrollView nestedScrollView;
    @BindView(R.id.statistic_data_login_ll)
    LinearLayout login_ll;
    @BindView(R.id.statistic_login_progress)
    ProgressBar login_progress;
    @BindView(R.id.statistic_status_txt)
    TextView statusText;

    @BindView(R.id.yg_statis_title_total_points)
    TextView yg_statis_title_total_points;
    @BindView(R.id.yg_type_total_points)
    TextView yg_type_total_points;
    @BindView(R.id.public_img_back)
    ImageView mBackImg;
    @BindView(R.id.public_txt_title)
    TextView titleTxt;

    private YGStatisticAdapter ygStatisticAdapter;
    private YGStatisticAdapter dxAdapter;
    private YGStatisticAdapter dsAdapter;
    private YGStatisticAdapter lhAdapter;
    private View mView;
    private SMZSAdapter smzsAdapter;
    private static String STATISTIC_TYPE = "StatisticType";//fragment 入口传参 key
    private int statisticType;

    @Override
    public BJRacecarDataStatisticsContract.Presenter initPresenter() {
        return new BJRacecarDataStatisticsPresenter(this);
    }

    public static BJRacecarDataStatisticsFragment newInstance(int statisticType) {

        Bundle args = new Bundle();
        args.putInt(STATISTIC_TYPE , statisticType);

        BJRacecarDataStatisticsFragment fragment = new BJRacecarDataStatisticsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            statisticType = getArguments().getInt(STATISTIC_TYPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.bjsc_data_statistics_lay, container, false);

        ButterKnife.bind(this , mView);
        EventBus.getDefault().register(this);
        initView();
        initData();
        return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView(){
        if (statisticType == 1) {
            mBackImg.setVisibility(View.VISIBLE);
            mBackImg.setOnClickListener(this);
        }else{
            mBackImg.setVisibility(View.GONE);
        }
        titleTxt.setText("数据统计");

        mTextDate.setText("近30期");
        mTextDate.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        mTextDate.setOnClickListener(this);

        LinearLayoutManager ygtjManager = new LinearLayoutManager(getContext());
        ygtjManager.setSmoothScrollbarEnabled(true);
        ygtjManager.setAutoMeasureEnabled(true);
        ygtjRecycleView.setLayoutManager(ygtjManager);
        ygtjRecycleView.setHasFixedSize(true);//处理滑动不流畅问题(手指移动距离就是滑动距离时，体验不佳)
        ygtjRecycleView.setNestedScrollingEnabled(false);

        LinearLayoutManager dxtjManager = new LinearLayoutManager(getContext());
        dxtjManager.setSmoothScrollbarEnabled(true);
        dxtjManager.setAutoMeasureEnabled(true);
        dxtjRecycleView.setLayoutManager(dxtjManager);
        dxtjRecycleView.setHasFixedSize(true);
        dxtjRecycleView.setNestedScrollingEnabled(false);

        LinearLayoutManager dstjManager = new LinearLayoutManager(getContext());
        dstjManager.setSmoothScrollbarEnabled(true);
        dstjManager.setAutoMeasureEnabled(true);
        dstjRecycleView.setLayoutManager(dstjManager);
        dstjRecycleView.setHasFixedSize(true);
        dstjRecycleView.setNestedScrollingEnabled(false);

        LinearLayoutManager lhtjManager = new LinearLayoutManager(getContext());
        lhtjManager.setSmoothScrollbarEnabled(true);
        lhtjManager.setAutoMeasureEnabled(true);
        lhtjRecycleView.setLayoutManager(lhtjManager);
        lhtjRecycleView.setHasFixedSize(true);
        lhtjRecycleView.setNestedScrollingEnabled(false);

        LinearLayoutManager smzsManager = new LinearLayoutManager(getContext());
        smzsManager.setSmoothScrollbarEnabled(true);
        smzsManager.setAutoMeasureEnabled(true);
        smzsRecycleView.setLayoutManager(smzsManager);
        smzsRecycleView.setHasFixedSize(true);
        smzsRecycleView.setNestedScrollingEnabled(false);

        smzsA.setOnClickListener(this);
        smzsB.setOnClickListener(this);
    }

    private void initData(){
        setStatus(STATUS_LOADING);
        mPresenter.yddlLoad(currPeriod + "");
        mPresenter.smLoad(currPeriod + "");
        mPresenter.sumLoad(currPeriod + "");
    }

    private final int STATUS_LOADING = 0;//加载中
    private final int STATUS_LOAD_SUCCESS = 1;//加载成功
    private final int STATUS_LOAD_FAILED = 2;//加载失败
    private final int STATUS_SEREVER_ERROR = 3;//接口异常

    private void setStatus(int statu){
        switch (statu){
            case STATUS_LOADING:
                nestedScrollView.setVisibility(View.GONE);
                login_ll.setVisibility(View.VISIBLE);
                login_progress.setVisibility(View.VISIBLE);
                statusText.setText("加载中...");
                break;
            case STATUS_LOAD_SUCCESS:
                nestedScrollView.setVisibility(View.VISIBLE);
                login_ll.setVisibility(View.GONE);
                break;
            case STATUS_LOAD_FAILED:
                nestedScrollView.setVisibility(View.GONE);
                login_ll.setVisibility(View.VISIBLE);
                login_progress.setVisibility(View.GONE);
                statusText.setText("加载失败");
                break;
            case STATUS_SEREVER_ERROR:
                nestedScrollView.setVisibility(View.GONE);
                login_ll.setVisibility(View.VISIBLE);
                login_progress.setVisibility(View.GONE);
                statusText.setText("暂无数据");
                break;
        }
    }

    /**
     * 亚冠、大小、单双、龙虎统计赋值
     * @param yddlBean
     */
    private void setStatisticData(BJRacecarStatisticYDDLBean yddlBean){
        if (yddlBean.getData() == null) {
            return;
        }
        BJRacecarStatisticYDDLBean.DataBean dataBean = yddlBean.getData();
        //亚冠总分
        BJRacecarStatisticYDDLBean.DataBean.SumBean ygSum = dataBean.getSum();
        setYGData(ygSum);
        //大小统计
        setDxtjData(dataBean);
        //单双统计
        setDstjData(dataBean);
        //龙虎统计
        setLhtjData(dataBean);
    }

    //亚冠总分
    private void setYGData(BJRacecarStatisticYDDLBean.DataBean.SumBean sumBean){
        if(sumBean == null){
            return;
        }
        List<StatisticalBean> sumData = new ArrayList<>();

        StatisticalBean sBeanDa = new StatisticalBean();
        sBeanDa.setStatisticalItem("总分大");
        sBeanDa.setOccurrenceNum(sumBean.getSUMBIG()+"");
        sBeanDa.setOccurrenceProbability(getProbability(sumBean.getSUMBIG()));
        sBeanDa.setTheoryProbability("概率:50%,共5个号码");

        StatisticalBean sBeanXiao = new StatisticalBean();
        sBeanXiao.setStatisticalItem("总分小");
        sBeanXiao.setOccurrenceNum(sumBean.getSUMSMALL() + "");
        sBeanXiao.setOccurrenceProbability(getProbability(sumBean.getSUMSMALL()));
        sBeanXiao.setTheoryProbability("概率:50%,共5个号码");

        StatisticalBean sBeanDan = new StatisticalBean();
        sBeanDan.setStatisticalItem("总分单");
        sBeanDan.setOccurrenceNum(sumBean.getSUMODD() + "");
        sBeanDan.setOccurrenceProbability(getProbability(sumBean.getSUMODD()));
        sBeanDan.setTheoryProbability("概率:50%,共5个号码");

        StatisticalBean sBeanShuang = new StatisticalBean();
        sBeanShuang.setStatisticalItem("总分双");
        sBeanShuang.setOccurrenceNum(sumBean.getSUMEVEN() + "");
        sBeanShuang.setOccurrenceProbability(getProbability(sumBean.getSUMEVEN()));
        sBeanShuang.setTheoryProbability("概率:50%,共5个号码");

        sumData.add(sBeanDa);
        sumData.add(sBeanXiao);
        sumData.add(sBeanDan);
        sumData.add(sBeanShuang);

        if (ygStatisticAdapter == null) {
            ygStatisticAdapter = new YGStatisticAdapter(sumData , getContext());
            ygtjRecycleView.setAdapter(ygStatisticAdapter);
        }else{
            ygStatisticAdapter.setNewData(sumData);
            ygStatisticAdapter.notifyDataSetChanged();
        }
    }
    //大小统计
    private void setDxtjData(BJRacecarStatisticYDDLBean.DataBean dxtjBean){
        List<StatisticalBean> dxData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            StatisticalBean staBean = new StatisticalBean();
            dxData.add(staBean);
        }

        for (int i = 0; i < dxData.size(); i++) {
            dxData.get(i).setStatisticalItem(setItemString(i , true));
            dxData.get(i).setOccurrenceNum(setOccurrenceNum(i , dxtjBean , true));
            dxData.get(i).setOccurrenceProbability(dxdsProbability(i , dxtjBean , true));
            dxData.get(i).setTheoryProbability("概率:50%,共5个号码");
        }
        if (dxAdapter == null) {
            dxAdapter = new YGStatisticAdapter(dxData , getContext());
            dxtjRecycleView.setAdapter(dxAdapter);
        }else{
            dxAdapter.setNewData(dxData);
            dxAdapter.notifyDataSetChanged();
        }

    }
    //单双统计
    private void setDstjData(BJRacecarStatisticYDDLBean.DataBean dstjBean){
        List<StatisticalBean> dsData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            StatisticalBean staBean = new StatisticalBean();
            dsData.add(staBean);
        }
        for (int i = 0; i < dsData.size(); i++) {
            dsData.get(i).setStatisticalItem(setItemString(i , false));
            dsData.get(i).setOccurrenceNum(setOccurrenceNum(i , dstjBean , false));
            dsData.get(i).setOccurrenceProbability(dxdsProbability(i , dstjBean ,false));
            dsData.get(i).setTheoryProbability("概率:50%,共5个号码");
        }
        if (dsAdapter == null) {
            dsAdapter = new YGStatisticAdapter(dsData , getContext());
            dstjRecycleView.setAdapter(dsAdapter);
        }else{
            dsAdapter.setNewData(dsData);
            dsAdapter.notifyDataSetChanged();
        }
    }
    //龙虎统计
    private void setLhtjData(BJRacecarStatisticYDDLBean.DataBean lhtjBean){
        List<StatisticalBean> lhData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StatisticalBean lh = new StatisticalBean();
            lhData.add(lh);
        }
        for (int i = 0; i < lhData.size(); i++) {
            lhData.get(i).setStatisticalItem(setLHItemString(i));
            lhData.get(i).setOccurrenceNum(setLHNumString(i , lhtjBean));
            lhData.get(i).setOccurrenceProbability(probability(i , lhtjBean));
            lhData.get(i).setTheoryProbability("概率:50%,共45个号码");
        }
        if (lhAdapter == null) {
            lhAdapter = new YGStatisticAdapter(lhData , getContext());
            lhtjRecycleView.setAdapter(lhAdapter);
        }else{
            lhAdapter.setNewData(lhData);
            lhAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 亚冠大小单双概率
     * @return
     */
    private String dxdsProbability(int index , BJRacecarStatisticYDDLBean.DataBean bean , boolean isDx){
        String probability = "";
        switch (index){
            case 0:
                probability = isDx ? getProbability(bean.getBnum1().getBIG()) : getProbability(bean.getBnum1().getODD());
                break;
            case 1:
                probability = isDx ? getProbability(bean.getBnum2().getBIG()) : getProbability(bean.getBnum2().getODD());
                break;
            case 2:
                probability = isDx ? getProbability(bean.getBnum3().getBIG()) : getProbability(bean.getBnum3().getODD());
                break;
            case 3:
                probability = isDx ? getProbability(bean.getBnum4().getBIG()) : getProbability(bean.getBnum4().getODD());
                break;
            case 4:
                probability = isDx ? getProbability(bean.getBnum5().getBIG()) : getProbability(bean.getBnum5().getODD());
                break;
            case 5:
                probability = isDx ? getProbability(bean.getBnum6().getBIG()) : getProbability(bean.getBnum6().getODD());
                break;
            case 6:
                probability = isDx ? getProbability(bean.getBnum7().getBIG()) : getProbability(bean.getBnum7().getODD());
                break;
            case 7:
                probability = isDx ? getProbability(bean.getBnum8().getBIG()) : getProbability(bean.getBnum8().getODD());
                break;
            case 8:
                probability = isDx ? getProbability(bean.getBnum9().getBIG()) : getProbability(bean.getBnum9().getODD());
                break;
            case 9:
                probability = isDx ? getProbability(bean.getBnum10().getBIG()) : getProbability(bean.getBnum10().getODD());
                break;
            case 10:
                probability = isDx ? getProbability(bean.getBnum1().getSMALL()) : getProbability(bean.getBnum1().getEVEN());
                break;
            case 11:
                probability = isDx ? getProbability(bean.getBnum2().getSMALL()) : getProbability(bean.getBnum2().getEVEN());
                break;
            case 12:
                probability = isDx ? getProbability(bean.getBnum3().getSMALL()) : getProbability(bean.getBnum3().getEVEN());
                break;
            case 13:
                probability = isDx ? getProbability(bean.getBnum4().getSMALL()) : getProbability(bean.getBnum4().getEVEN());
                break;
            case 14:
                probability = isDx ? getProbability(bean.getBnum5().getSMALL()) : getProbability(bean.getBnum5().getEVEN());
                break;
            case 15:
                probability = isDx ? getProbability(bean.getBnum6().getSMALL()) : getProbability(bean.getBnum6().getEVEN());
                break;
            case 16:
                probability = isDx ? getProbability(bean.getBnum7().getSMALL()) : getProbability(bean.getBnum7().getEVEN());
                break;
            case 17:
                probability = isDx ? getProbability(bean.getBnum8().getSMALL()) : getProbability(bean.getBnum8().getEVEN());
                break;
            case 18:
                probability = isDx ? getProbability(bean.getBnum9().getSMALL()) : getProbability(bean.getBnum9().getEVEN());
                break;
            case 19:
                probability = isDx ? getProbability(bean.getBnum10().getSMALL()) : getProbability(bean.getBnum10().getEVEN());
                break;
        }
        return probability;
    }

    /**
     * 龙虎概率
     * @param index
     * @param bean
     * @return
     */
    private String probability(int index , BJRacecarStatisticYDDLBean.DataBean bean){
        String numbai = "";
        switch (index){
            case 0:
                numbai = getProbability(bean.getGragonTiger_bnum1().getDRAGON());
                break;
            case 1:
                numbai = getProbability(bean.getGragonTiger_bnum2().getDRAGON());
                break;
            case 2:
                numbai = getProbability(bean.getGragonTiger_bnum3().getDRAGON());
                break;
            case 3:
                numbai = getProbability(bean.getGragonTiger_bnum4().getDRAGON());
                break;
            case 4:
                numbai = getProbability(bean.getGragonTiger_bnum5().getDRAGON());
                break;
            case 5:
                numbai = getProbability(bean.getGragonTiger_bnum1().getTIGER());
                break;
            case 6:
                numbai = getProbability(bean.getGragonTiger_bnum2().getTIGER());
                break;
            case 7:
                numbai = getProbability(bean.getGragonTiger_bnum3().getTIGER());
                break;
            case 8:
                numbai = getProbability(bean.getGragonTiger_bnum4().getTIGER());
                break;
            case 9:
                numbai = getProbability(bean.getGragonTiger_bnum5().getTIGER());
                break;
        }
        return numbai;
    }

    /**
     * 概率计算
     * @return
     */
    private String getProbability(int currNum){
        String currProbability = "";
        double dCurrNum = currNum * 1.0;
        double dSumNum = currPeriod * 1.0;
        double vNum = dCurrNum / dSumNum;

//        DecimalFormat d = new DecimalFormat("##.00%");
        DecimalFormat d = new DecimalFormat("##%");
        currProbability = d.format(vNum);
        return currProbability;
    }

    /**
     * 龙虎统计项赋值
     * @return
     */
    private String setLHItemString(int currIndex){
        String lhStr = "";
        switch (currIndex){
            case 0:
                lhStr = "第一球龙";
                break;
            case 1:
                lhStr = "第二球龙";
                break;
            case 2:
                lhStr = "第三球龙";
                break;
            case 3:
                lhStr = "第四球龙";
                break;
            case 4:
                lhStr = "第五球龙";
                break;
            case 5:
                lhStr = "第一球虎";
                break;
            case 6:
                lhStr = "第二球虎";
                break;
            case 7:
                lhStr = "第三球虎";
                break;
            case 8:
                lhStr = "第四球虎";
                break;
            case 9:
                lhStr = "第五球虎";
                break;
        }
        return lhStr;
    }

    /**
     * 龙虎次数赋值
     * @param currIndex
     * @return
     */
    private String setLHNumString(int currIndex , BJRacecarStatisticYDDLBean.DataBean lhBean){
        String lhNumStr = "";
        switch (currIndex){
            case 0:
                lhNumStr = lhBean.getGragonTiger_bnum1().getDRAGON()+"";
                break;
            case 1:
                lhNumStr = lhBean.getGragonTiger_bnum2().getDRAGON()+"";
                break;
            case 2:
                lhNumStr = lhBean.getGragonTiger_bnum3().getDRAGON()+"";
                break;
            case 3:
                lhNumStr = lhBean.getGragonTiger_bnum4().getDRAGON()+"";
                break;
            case 4:
                lhNumStr = lhBean.getGragonTiger_bnum5().getDRAGON()+"";
                break;
            case 5:
                lhNumStr = lhBean.getGragonTiger_bnum1().getTIGER()+"";
                break;
            case 6:
                lhNumStr = lhBean.getGragonTiger_bnum2().getTIGER()+"";
                break;
            case 7:
                lhNumStr = lhBean.getGragonTiger_bnum3().getTIGER()+"";
                break;
            case 8:
                lhNumStr = lhBean.getGragonTiger_bnum4().getTIGER()+"";
                break;
            case 9:
                lhNumStr = lhBean.getGragonTiger_bnum5().getTIGER()+"";
                break;
        }
        return lhNumStr;
    }

    /**
     * 赋值统计项
     * @param currIndex
     * @param isdx
     * @return
     */
    private String setItemString(int currIndex , boolean isdx){
        String itemStr = "";
        switch (currIndex){
            case 0:
                itemStr = isdx ? "第一球大" : "第一球单";
                break;
            case 1:
                itemStr = isdx ? "第二球大" : "第二球单";
                break;
            case 2:
                itemStr = isdx ? "第三球大" : "第三球单";
                break;
            case 3:
                itemStr = isdx ? "第四球大" : "第四球单";
                break;
            case 4:
                itemStr = isdx ? "第五球大" : "第五球单";
                break;
            case 5:
                itemStr = isdx ? "第六球大" : "第六球单";
                break;
            case 6:
                itemStr = isdx ? "第七球大" : "第七球单";
                break;
            case 7:
                itemStr = isdx ? "第八球大" : "第八球单";
                break;
            case 8:
                itemStr = isdx ? "第九球大" : "第九球单";
                break;
            case 9:
                itemStr = isdx ? "第十球大" : "第十球单";
                break;
            case 10:
                itemStr = isdx ? "第一球小" : "第一球双";
                break;
            case 11:
                itemStr = isdx ? "第二球小" : "第二球双";
                break;
            case 12:
                itemStr = isdx ? "第三球小" : "第三球双";
                break;
            case 13:
                itemStr = isdx ? "第四球小" : "第四球双";
                break;
            case 14:
                itemStr = isdx ? "第五球小" : "第五球双";
                break;
            case 15:
                itemStr = isdx ? "第六球小" : "第六球双";
                break;
            case 16:
                itemStr = isdx ? "第七球小" : "第七球双";
                break;
            case 17:
                itemStr = isdx ? "第八球小" : "第八球双";
                break;
            case 18:
                itemStr = isdx ? "第九球小" : "第九球双";
                break;
            case 19:
                itemStr = isdx ? "第十球小" : "第十球双";
                break;
        }
        return itemStr;
    }

    /**
     * 出现次数赋值
     * @param currIndex
     * @param dxtjBean
     * @param isdx
     * @return
     */
    private String setOccurrenceNum(int currIndex , BJRacecarStatisticYDDLBean.DataBean dxtjBean , boolean isdx){
        String numStr = "";
        switch (currIndex){
            case 0:
                numStr = isdx ? dxtjBean.getBnum1().getBIG()+"" : dxtjBean.getBnum1().getODD()+"";
                break;
            case 1:
                numStr = isdx ? dxtjBean.getBnum2().getBIG()+"" : dxtjBean.getBnum2().getODD()+"";
                break;
            case 2:
                numStr = isdx ? dxtjBean.getBnum3().getBIG()+"" : dxtjBean.getBnum3().getODD()+"";
                break;
            case 3:
                numStr = isdx ? dxtjBean.getBnum4().getBIG()+"" : dxtjBean.getBnum4().getODD()+"";
                break;
            case 4:
                numStr = isdx ? dxtjBean.getBnum5().getBIG()+"" : dxtjBean.getBnum5().getODD()+"";
                break;
            case 5:
                numStr = isdx ? dxtjBean.getBnum6().getBIG()+"" : dxtjBean.getBnum6().getODD()+"";
                break;
            case 6:
                numStr = isdx ? dxtjBean.getBnum7().getBIG()+"" : dxtjBean.getBnum7().getODD()+"";
                break;
            case 7:
                numStr = isdx ? dxtjBean.getBnum8().getBIG()+"" : dxtjBean.getBnum8().getODD()+"";
                break;
            case 8:
                numStr = isdx ? dxtjBean.getBnum9().getBIG()+"" : dxtjBean.getBnum9().getODD()+"";
                break;
            case 9:
                numStr = isdx ? dxtjBean.getBnum10().getBIG()+"" : dxtjBean.getBnum10().getODD()+"";
                break;
            case 10:
                numStr = isdx ? dxtjBean.getBnum1().getSMALL()+"" : dxtjBean.getBnum1().getEVEN()+"";
                break;
            case 11:
                numStr = isdx ? dxtjBean.getBnum2().getSMALL()+"" : dxtjBean.getBnum2().getEVEN()+"";
                break;
            case 12:
                numStr = isdx ? dxtjBean.getBnum3().getSMALL()+"" : dxtjBean.getBnum3().getEVEN()+"";
                break;
            case 13:
                numStr = isdx ? dxtjBean.getBnum4().getSMALL()+"" : dxtjBean.getBnum4().getEVEN()+"";
                break;
            case 14:
                numStr = isdx ? dxtjBean.getBnum5().getSMALL()+"" : dxtjBean.getBnum5().getEVEN()+"";
                break;
            case 15:
                numStr = isdx ? dxtjBean.getBnum6().getSMALL()+"" : dxtjBean.getBnum6().getEVEN()+"";
                break;
            case 16:
                numStr = isdx ? dxtjBean.getBnum7().getSMALL()+"" : dxtjBean.getBnum7().getEVEN()+"";
                break;
            case 17:
                numStr = isdx ? dxtjBean.getBnum8().getSMALL()+"" : dxtjBean.getBnum8().getEVEN()+"";
                break;
            case 18:
                numStr = isdx ? dxtjBean.getBnum9().getSMALL()+"" : dxtjBean.getBnum9().getEVEN()+"";
                break;
            case 19:
                numStr = isdx ? dxtjBean.getBnum10().getSMALL()+"" : dxtjBean.getBnum10().getEVEN()+"";
                break;
        }
        return numStr;
    }


    @Override
    public void yddlSuccess(BJRacecarStatisticYDDLBean yddlBean) {
        Log.d("yddlSuccess:" , "亚冠龙虎统计请求成功");
        setStatisticData(yddlBean);
        setStatus(STATUS_LOAD_SUCCESS);
    }

    @Override
    public void yddlFailed(BJRacecarStatisticYDDLBean yddlBean) {
        Log.d("yddlFailed:" , "亚冠龙虎统计接口异常");
    }

    @Override
    public void yddlError() {
        Log.d("yddlError:" , "亚冠龙虎统计请求失败");
    }

    /***
     * 双面走势赋值
     */
    private List<SMTJBean> smListShowData = new ArrayList<>();
    private void setSMZSData(BJRacecarStatisticSMTJBean dataBean){
        if (dataBean == null) {
            return;
        }
        BJRacecarStatisticSMTJBean.DataBean smzsData = dataBean.getData();
        List<SMTJBean> smzsList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SMTJBean smtjBean = new SMTJBean();
            smzsList.add(smtjBean);
        }
        for (int i = 0; i < smzsList.size(); i++) {
            smzsList.get(i).setNumList(setSmPrice(i , smzsData , true , false));
            smzsList.get(i).setLastMissList(setSmPrice(i , smzsData , false , true));
            smzsList.get(i).setMaxMissList(setSmPrice(i , smzsData , false , false));
            smzsList.get(i).setTitleName(setSmTitleString(i));
        }

        smListShowData.clear();
        smListShowData = smzsList;

        if (smzsAdapter == null) {
            smzsAdapter = new SMZSAdapter(getSMTJShowList(smzsList , 0) , getContext());
            smzsRecycleView.setAdapter(smzsAdapter);
        }else{
            smzsAdapter.setNewData(getSMTJShowList(smzsList , 0));
            smzsAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 双面走势数据处理
     * @param index list下标
     * @param smzsData 走势数据
     * @param isOcc 是否出现次数
     * @param lastMiss 是否当前遗漏
     * @return
     */
    private SMTJBean.BNumBean setSmPrice(int index , BJRacecarStatisticSMTJBean.DataBean smzsData , boolean isOcc , boolean lastMiss){
        SMTJBean.BNumBean priceList = new SMTJBean.BNumBean();
        String big = "";
        String small = "";
        String odd = "";
        String even = "";
        switch (index){
            case 0:
                big =   isOcc ? smzsData.getBnum1().getOcc().getBIG()+"" : (lastMiss ? smzsData.getBnum1().getLastMiss().getBIG()+"" : smzsData.getBnum1().getMaxMiss().getBIG()+"");
                small = isOcc ? smzsData.getBnum1().getOcc().getSMALL()+"" : (lastMiss ? smzsData.getBnum1().getLastMiss().getSMALL()+"" : smzsData.getBnum1().getMaxMiss().getSMALL()+"");
                odd =   isOcc ? smzsData.getBnum1().getOcc().getODD()+"" : (lastMiss ? smzsData.getBnum1().getLastMiss().getODD()+"" : smzsData.getBnum1().getMaxMiss().getODD()+"");
                even =  isOcc ? smzsData.getBnum1().getOcc().getEVEN()+"" : (lastMiss ? smzsData.getBnum1().getLastMiss().getEVEN()+"" : smzsData.getBnum1().getMaxMiss().getEVEN()+"");
                break;
            case 1:
                big =   isOcc ? smzsData.getBnum2().getOcc().getBIG()+"" : (lastMiss ? smzsData.getBnum2().getLastMiss().getBIG()+"" : smzsData.getBnum2().getMaxMiss().getBIG()+"");
                small = isOcc ? smzsData.getBnum2().getOcc().getSMALL()+"" : (lastMiss ? smzsData.getBnum2().getLastMiss().getSMALL()+"" : smzsData.getBnum2().getMaxMiss().getSMALL()+"");
                odd =   isOcc ? smzsData.getBnum2().getOcc().getODD()+"" : (lastMiss ? smzsData.getBnum2().getLastMiss().getODD()+"" : smzsData.getBnum2().getMaxMiss().getODD()+"");
                even =  isOcc ? smzsData.getBnum2().getOcc().getEVEN()+"" : (lastMiss ? smzsData.getBnum2().getLastMiss().getEVEN()+"" : smzsData.getBnum2().getMaxMiss().getEVEN()+"");
                break;
            case 2:
                big =   isOcc ? smzsData.getBnum3().getOcc().getBIG()+"" : (lastMiss ? smzsData.getBnum3().getLastMiss().getBIG()+"" : smzsData.getBnum3().getMaxMiss().getBIG()+"");
                small = isOcc ? smzsData.getBnum3().getOcc().getSMALL()+"" : (lastMiss ? smzsData.getBnum3().getLastMiss().getSMALL()+"" : smzsData.getBnum3().getMaxMiss().getSMALL()+"");
                odd =   isOcc ? smzsData.getBnum3().getOcc().getODD()+"" : (lastMiss ? smzsData.getBnum3().getLastMiss().getODD()+"" : smzsData.getBnum3().getMaxMiss().getODD()+"");
                even =  isOcc ? smzsData.getBnum3().getOcc().getEVEN()+"" : (lastMiss ? smzsData.getBnum3().getLastMiss().getEVEN()+"" : smzsData.getBnum3().getMaxMiss().getEVEN()+"");
                break;
            case 3:
                big =   isOcc ? smzsData.getBnum4().getOcc().getBIG()+"" : (lastMiss ? smzsData.getBnum4().getLastMiss().getBIG()+"" : smzsData.getBnum4().getMaxMiss().getBIG()+"");
                small = isOcc ? smzsData.getBnum4().getOcc().getSMALL()+"" : (lastMiss ? smzsData.getBnum4().getLastMiss().getSMALL()+"" : smzsData.getBnum4().getMaxMiss().getSMALL()+"");
                odd =   isOcc ? smzsData.getBnum4().getOcc().getODD()+"" : (lastMiss ? smzsData.getBnum4().getLastMiss().getODD()+"" : smzsData.getBnum4().getMaxMiss().getODD()+"");
                even =  isOcc ? smzsData.getBnum4().getOcc().getEVEN()+"" : (lastMiss ? smzsData.getBnum4().getLastMiss().getEVEN()+"" : smzsData.getBnum4().getMaxMiss().getEVEN()+"");
                break;
            case 4:
                big =   isOcc ? smzsData.getBnum5().getOcc().getBIG()+"" : (lastMiss ? smzsData.getBnum5().getLastMiss().getBIG()+"" : smzsData.getBnum5().getMaxMiss().getBIG()+"");
                small = isOcc ? smzsData.getBnum5().getOcc().getSMALL()+"" : (lastMiss ? smzsData.getBnum5().getLastMiss().getSMALL()+"" : smzsData.getBnum5().getMaxMiss().getSMALL()+"");
                odd =   isOcc ? smzsData.getBnum5().getOcc().getODD()+"" : (lastMiss ? smzsData.getBnum5().getLastMiss().getODD()+"" : smzsData.getBnum5().getMaxMiss().getODD()+"");
                even =  isOcc ? smzsData.getBnum5().getOcc().getEVEN()+"" : (lastMiss ? smzsData.getBnum5().getLastMiss().getEVEN()+"" : smzsData.getBnum5().getMaxMiss().getEVEN()+"");
                break;
            case 5:
                big =   isOcc ? smzsData.getBnum6().getOcc().getBIG()+"" : (lastMiss ? smzsData.getBnum6().getLastMiss().getBIG()+"" : smzsData.getBnum6().getMaxMiss().getBIG()+"");
                small = isOcc ? smzsData.getBnum6().getOcc().getSMALL()+"" : (lastMiss ? smzsData.getBnum6().getLastMiss().getSMALL()+"" : smzsData.getBnum6().getMaxMiss().getSMALL()+"");
                odd =   isOcc ? smzsData.getBnum6().getOcc().getODD()+"" : (lastMiss ? smzsData.getBnum6().getLastMiss().getODD()+"" : smzsData.getBnum6().getMaxMiss().getODD()+"");
                even =  isOcc ? smzsData.getBnum6().getOcc().getEVEN()+"" : (lastMiss ? smzsData.getBnum6().getLastMiss().getEVEN()+"" : smzsData.getBnum6().getMaxMiss().getEVEN()+"");
                break;
            case 6:
                big =   isOcc ? smzsData.getBnum7().getOcc().getBIG()+"" : (lastMiss ? smzsData.getBnum7().getLastMiss().getBIG()+"" : smzsData.getBnum7().getMaxMiss().getBIG()+"");
                small = isOcc ? smzsData.getBnum7().getOcc().getSMALL()+"" : (lastMiss ? smzsData.getBnum7().getLastMiss().getSMALL()+"" : smzsData.getBnum7().getMaxMiss().getSMALL()+"");
                odd =   isOcc ? smzsData.getBnum7().getOcc().getODD()+"" : (lastMiss ? smzsData.getBnum7().getLastMiss().getODD()+"" : smzsData.getBnum7().getMaxMiss().getODD()+"");
                even =  isOcc ? smzsData.getBnum7().getOcc().getEVEN()+"" : (lastMiss ? smzsData.getBnum7().getLastMiss().getEVEN()+"" : smzsData.getBnum7().getMaxMiss().getEVEN()+"");
                break;
            case 7:
                big =   isOcc ? smzsData.getBnum8().getOcc().getBIG()+"" : (lastMiss ? smzsData.getBnum8().getLastMiss().getBIG()+"" : smzsData.getBnum8().getMaxMiss().getBIG()+"");
                small = isOcc ? smzsData.getBnum8().getOcc().getSMALL()+"" : (lastMiss ? smzsData.getBnum8().getLastMiss().getSMALL()+"" : smzsData.getBnum8().getMaxMiss().getSMALL()+"");
                odd =   isOcc ? smzsData.getBnum8().getOcc().getODD()+"" : (lastMiss ? smzsData.getBnum8().getLastMiss().getODD()+"" : smzsData.getBnum8().getMaxMiss().getODD()+"");
                even =  isOcc ? smzsData.getBnum8().getOcc().getEVEN()+"" : (lastMiss ? smzsData.getBnum8().getLastMiss().getEVEN()+"" : smzsData.getBnum8().getMaxMiss().getEVEN()+"");
                break;
            case 8:
                big =   isOcc ? smzsData.getBnum9().getOcc().getBIG()+"" : (lastMiss ? smzsData.getBnum9().getLastMiss().getBIG()+"" : smzsData.getBnum9().getMaxMiss().getBIG()+"");
                small = isOcc ? smzsData.getBnum9().getOcc().getSMALL()+"" : (lastMiss ? smzsData.getBnum9().getLastMiss().getSMALL()+"" : smzsData.getBnum9().getMaxMiss().getSMALL()+"");
                odd =   isOcc ? smzsData.getBnum9().getOcc().getODD()+"" : (lastMiss ? smzsData.getBnum9().getLastMiss().getODD()+"" : smzsData.getBnum9().getMaxMiss().getODD()+"");
                even =  isOcc ? smzsData.getBnum9().getOcc().getEVEN()+"" : (lastMiss ? smzsData.getBnum9().getLastMiss().getEVEN()+"" : smzsData.getBnum9().getMaxMiss().getEVEN()+"");
                break;
            case 9:
                big =   isOcc ? smzsData.getBnum10().getOcc().getBIG()+"" : (lastMiss ? smzsData.getBnum10().getLastMiss().getBIG()+"" : smzsData.getBnum10().getMaxMiss().getBIG()+"");
                small = isOcc ? smzsData.getBnum10().getOcc().getSMALL()+"" : (lastMiss ? smzsData.getBnum10().getLastMiss().getSMALL()+"" : smzsData.getBnum10().getMaxMiss().getSMALL()+"");
                odd =   isOcc ? smzsData.getBnum10().getOcc().getODD()+"" : (lastMiss ? smzsData.getBnum10().getLastMiss().getODD()+"" : smzsData.getBnum10().getMaxMiss().getODD()+"");
                even =  isOcc ? smzsData.getBnum10().getOcc().getEVEN()+"" : (lastMiss ? smzsData.getBnum10().getLastMiss().getEVEN()+"" : smzsData.getBnum10().getMaxMiss().getEVEN()+"");
                break;
        }
        priceList.setBig(big);
        priceList.setSmall(small);
        priceList.setOdd(odd);
        priceList.setEven(even);
        return priceList;
    }

    /**
     * 双面走势数据标题
     * @param index
     * @return
     */
    private String setSmTitleString(int index){
        String smTitle = "";
        switch (index){
            case 0:
                smTitle = "冠军双面走势";
                break;
            case 1:
                smTitle = "亚军双面走势";
                break;
            case 2:
                smTitle = "第三名双面走势";
                break;
            case 3:
                smTitle = "第四名双面走势";
                break;
            case 4:
                smTitle = "第五名双面走势";
                break;
            case 5:
                smTitle = "第六名双面走势";
                break;
            case 6:
                smTitle = "第七名双面走势";
                break;
            case 7:
                smTitle = "第八名双面走势";
                break;
            case 8:
                smTitle = "第九名双面走势";
                break;
            case 9:
                smTitle = "第十名双面走势";
                break;
        }
        return smTitle;
    }

    /**
     * 双面走势显示数据
     * @param allList
     * @param showType
     * @return
     */
    private List<SMTJBean> getSMTJShowList(List<SMTJBean> allList , int showType){
        List<SMTJBean> showList = new ArrayList<>();

        switch (showType){
            case 0:
                for (int i = 0; i < 5; i++) { //前五
                    showList.add(allList.get(i));
                }
                break;
            case 1:
                for (int i = 5; i < allList.size(); i++) {
                    showList.add(allList.get(i));
                }
                break;
        }
        return showList;
    }

    @Override
    public void smSuccess(BJRacecarStatisticSMTJBean smtjBean) {
        Log.d("smSuccess:" , "双面统计请求成功");
        setSMZSData(smtjBean);
        setStatus(STATUS_LOAD_SUCCESS);
    }

    @Override
    public void smFailed(BJRacecarStatisticSMTJBean smtjBean) {
        Log.d("smFailed:" , "双面统计接口异常");
    }

    @Override
    public void smError() {
        Log.d("smError:" , "双面统计请求失败");
    }

    /**
     * 龙虎和值显示
     */
    private void setSumData(BJRacecarStatisticSumBean sumBean){
        if (sumBean == null) {
            return;
        }
        BJRacecarStatisticSumBean.DataBean.SumBean sumData = sumBean.getData().getSum();
        setSumgyData(sumData);

        setSumGJData(sumBean.getData());

    }

    /**
     * 冠亚和值
     * @param sumData
     */
    @SuppressLint("SetTextI18n")
    private void setSumgyData(BJRacecarStatisticSumBean.DataBean.SumBean sumData){
        gjhStatistic3 .setText(sumData.getOcc().getN3() + "");
        gjhStatistic4 .setText(sumData.getOcc().getN4() + "");
        gjhStatistic5 .setText(sumData.getOcc().getN5() + "");
        gjhStatistic6 .setText(sumData.getOcc().getN6() + "");
        gjhStatistic7 .setText(sumData.getOcc().getN7() + "");
        gjhStatistic8 .setText(sumData.getOcc().getN8() + "");
        gjhStatistic9 .setText(sumData.getOcc().getN9() + "");
        gjhStatistic10.setText(sumData.getOcc().getN10() + "");
        gjhStatistic11.setText(sumData.getOcc().getN11() + "");
        gjhStatistic12.setText(sumData.getOcc().getN12() + "");
        gjhStatistic13.setText(sumData.getOcc().getN13() + "");
        gjhStatistic14.setText(sumData.getOcc().getN14() + "");
        gjhStatistic15.setText(sumData.getOcc().getN15() + "");
        gjhStatistic16.setText(sumData.getOcc().getN16() + "");
        gjhStatistic17.setText(sumData.getOcc().getN17() + "");
        gjhStatistic18.setText(sumData.getOcc().getN18() + "");
        gjhStatistic19.setText(sumData.getOcc().getN19() + "");

        gyhNum3 .setText(sumData.getLastMiss().getN3 () + "");
        gyhNum4 .setText(sumData.getLastMiss().getN4 () + "");
        gyhNum5 .setText(sumData.getLastMiss().getN5 () + "");
        gyhNum6 .setText(sumData.getLastMiss().getN6 () + "");
        gyhNum7 .setText(sumData.getLastMiss().getN7 () + "");
        gyhNum8 .setText(sumData.getLastMiss().getN8 () + "");
        gyhNum9 .setText(sumData.getLastMiss().getN9 () + "");
        gyhNum10.setText(sumData.getLastMiss().getN10() + "");
        gyhNum11.setText(sumData.getLastMiss().getN11() + "");
        gyhNum12.setText(sumData.getLastMiss().getN12() + "");
        gyhNum13.setText(sumData.getLastMiss().getN13() + "");
        gyhNum14.setText(sumData.getLastMiss().getN14() + "");
        gyhNum15.setText(sumData.getLastMiss().getN15() + "");
        gyhNum16.setText(sumData.getLastMiss().getN16() + "");
        gyhNum17.setText(sumData.getLastMiss().getN17() + "");
        gyhNum18.setText(sumData.getLastMiss().getN18() + "");
        gyhNum19.setText(sumData.getLastMiss().getN19() + "");

        gyhLeaveout3 .setText(sumData.getMaxMiss().getN3 ()+ "");
        gyhLeaveout4 .setText(sumData.getMaxMiss().getN4 ()+ "");
        gyhLeaveout5 .setText(sumData.getMaxMiss().getN5 ()+ "");
        gyhLeaveout6 .setText(sumData.getMaxMiss().getN6 ()+ "");
        gyhLeaveout7 .setText(sumData.getMaxMiss().getN7 ()+ "");
        gyhLeaveout8 .setText(sumData.getMaxMiss().getN8 ()+ "");
        gyhLeaveout9 .setText(sumData.getMaxMiss().getN9 ()+ "");
        gyhLeaveout10.setText(sumData.getMaxMiss().getN10()+ "");
        gyhLeaveout11.setText(sumData.getMaxMiss().getN11()+ "");
        gyhLeaveout12.setText(sumData.getMaxMiss().getN12()+ "");
        gyhLeaveout13.setText(sumData.getMaxMiss().getN13()+ "");
        gyhLeaveout14.setText(sumData.getMaxMiss().getN14()+ "");
        gyhLeaveout15.setText(sumData.getMaxMiss().getN15()+ "");
        gyhLeaveout16.setText(sumData.getMaxMiss().getN16()+ "");
        gyhLeaveout17.setText(sumData.getMaxMiss().getN17()+ "");
        gyhLeaveout18.setText(sumData.getMaxMiss().getN18()+ "");
        gyhLeaveout19.setText(sumData.getMaxMiss().getN19()+ "");
    }

    /**
     * 1-5龙虎
     * @param dataBean
     */
    @SuppressLint("SetTextI18n")
    private void setSumGJData(BJRacecarStatisticSumBean.DataBean dataBean){

        gjStatisticDragon.setText(dataBean.getBnum1().getOcc().getDRAGON() + "");
        gjStatisticTiger.setText(dataBean.getBnum1().getOcc().getTIGER() + "");
        gjNumDragon.setText(dataBean.getBnum1().getLastMiss().getDRAGON() + "");
        gjNumtiger.setText(dataBean.getBnum1().getLastMiss().getTIGER() + "");
        gjLeaveoutDragon.setText(dataBean.getBnum1().getLastMiss().getDRAGON() + "");
        gjLeaveoutTiger.setText(dataBean.getBnum1().getLastMiss().getTIGER() + "");

        yjStatisticDragon.setText(dataBean.getBnum2().getOcc().getDRAGON() + "");
        yjStatisticTiger.setText(dataBean.getBnum2().getOcc().getTIGER() + "");
        yjNumDragon.setText(dataBean.getBnum2().getLastMiss().getDRAGON() + "");
        yjNumtiger.setText(dataBean.getBnum2().getLastMiss().getTIGER() + "");
        yjLeaveoutDragon.setText(dataBean.getBnum2().getLastMiss().getDRAGON() + "");
        yjLeaveoutTiger.setText(dataBean.getBnum2().getLastMiss().getTIGER() + "");

        thirdStatisticDragon.setText(dataBean.getBnum3().getOcc().getDRAGON() + "");
        thirdStatisticTiger.setText(dataBean.getBnum3().getOcc().getTIGER() + "");
        thirdNumDragon.setText(dataBean.getBnum3().getLastMiss().getDRAGON() + "");
        thirdNumtiger.setText(dataBean.getBnum3().getLastMiss().getTIGER() + "");
        thirdLeaveoutDragon.setText(dataBean.getBnum3().getLastMiss().getDRAGON() + "");
        thirdLeaveoutTiger.setText(dataBean.getBnum3().getLastMiss().getTIGER() + "");

        fourthStatisticDragon.setText(dataBean.getBnum4().getOcc().getDRAGON() + "");
        fourthStatisticTiger.setText(dataBean.getBnum4().getOcc().getTIGER() + "");
        fourthNumDragon.setText(dataBean.getBnum4().getLastMiss().getDRAGON() + "");
        fourthNumtiger.setText(dataBean.getBnum4().getLastMiss().getTIGER() + "");
        fourthLeaveoutDragon.setText(dataBean.getBnum4().getLastMiss().getDRAGON() + "");
        fourthLeaveoutTiger.setText(dataBean.getBnum4().getLastMiss().getTIGER() + "");

        fifthStatisticDragon.setText(dataBean.getBnum5().getOcc().getDRAGON() + "");
        fifthStatisticTiger.setText(dataBean.getBnum5().getOcc().getTIGER() + "");
        fifthNumDragon.setText(dataBean.getBnum5().getLastMiss().getDRAGON() + "");
        fifthNumtiger.setText(dataBean.getBnum5().getLastMiss().getTIGER() + "");
        fifthLeaveoutDragon.setText(dataBean.getBnum5().getLastMiss().getDRAGON() + "");
        fifthLeaveoutTiger.setText(dataBean.getBnum5().getLastMiss().getTIGER() + "");

    }

    @Override
    public void sumSuccess(BJRacecarStatisticSumBean sumBean) {
        Log.d("sumSuccess:" , "和值龙虎请求成功");
        setSumData(sumBean);
        setStatus(STATUS_LOAD_SUCCESS);
    }

    @Override
    public void sumFailed(BJRacecarStatisticSumBean sumBean) {
        Log.d("sumFailed:" , "和值龙虎接口异常");
    }

    @Override
    public void sumError() {
        Log.d("sumError:" , "和值龙虎请求失败");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.smzs_a:
                smzsA.setBackgroundResource(R.mipmap.sjtj_smzs_c);
                smzsB.setBackgroundResource(R.mipmap.sjtj_smzs_unc);

                smzsAdapter.setNewData(getSMTJShowList(smListShowData , 0));
                smzsAdapter.notifyDataSetChanged();
                break;
            case R.id.smzs_b:
                smzsA.setBackgroundResource(R.mipmap.sjtj_smzs_unc);
                smzsB.setBackgroundResource(R.mipmap.sjtj_smzs_c);

                smzsAdapter.setNewData(getSMTJShowList(smListShowData , 1));
                smzsAdapter.notifyDataSetChanged();
                break;
            case R.id.public_txt_date:
                if (showIssuePopu) {
                    issuePopupVindow();
                }
                break;
            case R.id.public_img_back:
                getActivity().finish();
                break;
        }
    }
    @SuppressLint({"LongLogTag", "SetTextI18n"})
    @Subscribe()
    public void event(StatisticKJEvent statisticKJEvent){
        if (statisticKJEvent != null) {
            Log.d("BJRacecarDataStatisticsFragment_Even: " , statisticKJEvent.getEventIssue() + "");
            yg_statis_title_total_points.setText("近" + statisticKJEvent.getEventIssue()+"期");
            yg_type_total_points.setText("近" + statisticKJEvent.getEventIssue()+"期");
            currPeriod = statisticKJEvent.getEventIssue();
            initData();
        }
    }

    @SuppressLint("SetTextI18n")
    private void setIssueText(int issueType){
        switch (issueType){
            case 0:
                mTextDate.setText("近30期");
                break;
            case 1:
                mTextDate.setText("近50期");
                break;
            case 2:
                mTextDate.setText("近100期");
                break;
            case 3:
                mTextDate.setText("近150期");
                break;
            case 4:
                mTextDate.setText("近300期");
                break;
        }
    }
    /**期数弹框*/
    private int issueChoose = 0;//选中期数位置
    private boolean showIssuePopu = true;//是否弹框(期数选择)
    private void issuePopupVindow(){
        showIssuePopu = false;
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.bjsc_statistic_issue_check_popup_lay, null);
        PopupWindow popupWindow = new PopupWindow(getContext());

        TextView issuePopup1 = contentView.findViewById(R.id.bjsc_issue_popup_item1);
        TextView issuePopup2 = contentView.findViewById(R.id.bjsc_issue_popup_item2);
        TextView issuePopup3 = contentView.findViewById(R.id.bjsc_issue_popup_item3);
        TextView issuePopup4 = contentView.findViewById(R.id.bjsc_issue_popup_item4);
        TextView issuePopup5 = contentView.findViewById(R.id.bjsc_issue_popup_item5);
        issuePopup1.setBackgroundColor(getResources().getColor(issueChoose == 0 ? R.color.colorPrimary : R.color.white));
        issuePopup1.setTextColor(getResources().getColor(issueChoose == 0 ? R.color.white : R.color.history_kj_tab_color));
        issuePopup2.setBackgroundColor(getResources().getColor(issueChoose == 1 ? R.color.colorPrimary : R.color.white));
        issuePopup2.setTextColor(getResources().getColor(issueChoose == 1 ? R.color.white : R.color.history_kj_tab_color));
        issuePopup3.setBackgroundColor(getResources().getColor(issueChoose == 2 ? R.color.colorPrimary : R.color.white));
        issuePopup3.setTextColor(getResources().getColor(issueChoose == 2 ? R.color.white : R.color.history_kj_tab_color));
        issuePopup4.setBackgroundColor(getResources().getColor(issueChoose == 3 ? R.color.colorPrimary : R.color.white));
        issuePopup4.setTextColor(getResources().getColor(issueChoose == 3 ? R.color.white : R.color.history_kj_tab_color));
        issuePopup5.setBackgroundColor(getResources().getColor(issueChoose == 4 ? R.color.colorPrimary : R.color.white));
        issuePopup5.setTextColor(getResources().getColor(issueChoose == 4 ? R.color.white : R.color.history_kj_tab_color));

        popupWindow.setWidth(getResources().getDimensionPixelSize(R.dimen.bjsc_statistic_issue_check_w));
        popupWindow.setHeight(getResources().getDimensionPixelSize(R.dimen.bjsc_statistic_issue_check_h));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
//        DisplayUtil.backgroundAlpha(this, 0.7f);
        popupWindow.setFocusable(true);

        popupWindow.setContentView(contentView);
        popupWindow.showAsDropDown(mTextDate);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                showIssuePopu = true;
                DisplayUtil.backgroundAlpha(getActivity(), 1f);
            }
        });
        issuePopup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIssuePopu = true;
                issueChoose = 0;
                setIssueText(issueChoose);
                EventBus.getDefault().post(new StatisticKJEvent(30));
                popupWindow.dismiss();
            }
        });
        issuePopup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIssuePopu = true;
                issueChoose = 1;
                setIssueText(issueChoose);
                EventBus.getDefault().post(new StatisticKJEvent(50));
                popupWindow.dismiss();
            }
        });
        issuePopup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIssuePopu = true;
                issueChoose = 2;
                setIssueText(issueChoose);
                EventBus.getDefault().post(new StatisticKJEvent(100));
                popupWindow.dismiss();
            }
        });
        issuePopup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIssuePopu = true;
                issueChoose = 3;
                setIssueText(issueChoose);
                EventBus.getDefault().post(new StatisticKJEvent(150));
                popupWindow.dismiss();
            }
        });
        issuePopup5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIssuePopu = true;
                issueChoose = 4;
                setIssueText(issueChoose);
                EventBus.getDefault().post(new StatisticKJEvent(300));
                popupWindow.dismiss();
            }
        });
    }
}
