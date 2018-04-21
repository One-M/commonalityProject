package com.ybf.lottery.function.firstsecondtrend;


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
import com.ybf.lottery.base.BaseMvpFragment;
import com.ybf.lottery.diyview.TrendFiltrateDialog;
import com.ybf.lottery.diyview.trend.CustomTrendLineView;
import com.ybf.lottery.diyview.trend.HeaderHorizontalScrollView;
import com.ybf.lottery.diyview.trend.LeftNumberCustomListView;
import com.ybf.lottery.diyview.trend.LeftNumberSynchScrollView;
import com.ybf.lottery.diyview.trend.ScrollChangeCallback;
import com.ybf.lottery.diyview.trend.TrendScrollViewWidget;
import com.ybf.lottery.function.locationtrend.LocationTrendContract;
import com.ybf.lottery.function.locationtrend.LocationTrendPresenter;
import com.ybf.lottery.model.bean.firstsecondtrendbean.FirstSecondTrendBean;
import com.ybf.lottery.model.bean.locationtrendbean.LocationTrendBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/4/21.
 * Use:冠亚走势fragment
 */

public class BJRacecarFirstSecondTrendFragment extends BaseMvpFragment<FirstSecondPresenter> implements FirstSecondContract.IView, View.OnClickListener, ScrollChangeCallback {

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
    @BindView(R.id.trend_header_ll)
    LinearLayout headerll;
    @BindView(R.id.statistic_basic_headerll)
    LinearLayout basicHeaderll;
    @BindView(R.id.gaunya_trend_ll)
    LinearLayout guanyall;
    @BindView(R.id.statistic_gaunya_trend_ll)
    LinearLayout statisticGuanYall;

    private static String TREND_TYPE = "TrendType";//fragment 入口传参 key
    private int trendType;
    private String mFType = "1";
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

    @Override
    public FirstSecondPresenter initPresenter() {
        return new FirstSecondPresenter(this);
    }

    public static BJRacecarFirstSecondTrendFragment newInstance(int trendType) {
        Bundle args = new Bundle();
        args.putInt(TREND_TYPE , trendType);
        BJRacecarFirstSecondTrendFragment fragment = new BJRacecarFirstSecondTrendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            trendType = getArguments().getInt(TREND_TYPE);
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
        if (trendType == 1) {
            mBackImg.setVisibility(View.VISIBLE);
            mBackImg.setOnClickListener(this);
        }else{
            mBackImg.setVisibility(View.GONE);
        }

        headerll.setVisibility(View.GONE);
        basicHeaderll.setVisibility(View.GONE);

        guanyall.setVisibility(View.VISIBLE);
        statisticGuanYall.setVisibility(View.VISIBLE);

        titleTxt.setText("冠亚走势");

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
        mPresenter.loadData(mPeriod); // TODO=============================
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
    private List<String> getIssueNumData(List<FirstSecondTrendBean.ZsBean> zsData){
        List<String> issueNum = new ArrayList<>();
        for (FirstSecondTrendBean.ZsBean zs : zsData) {
            issueNum.add(zs.getISSUE());
        }
        return issueNum;
    }


    @Override
    public void loginSuccess(FirstSecondTrendBean firstSecondTrendBean) {
        setStatus(STATUS_LOAD_SUCCESS);
        if (firstSecondTrendBean == null) {
            return;
        }
        List<FirstSecondTrendBean.ZsBean> zsData = firstSecondTrendBean.getZs();
        //期号设置
        bindQiHaoData(getIssueNumData(zsData));
    }

    @Override
    public void loginFailed(FirstSecondTrendBean firstSecondTrendBean) {

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
