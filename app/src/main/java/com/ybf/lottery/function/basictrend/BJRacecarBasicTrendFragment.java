package com.ybf.lottery.function.basictrend;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.ybf.lottery.model.bean.bjscbasictrendbean.BasicTrendBean;
import com.ybf.lottery.model.bean.bjscbasictrendbean.BasicTrendStatisticBean;
import com.ybf.lottery.model.bean.dragontigertrendbean.LengthwaysDataBean;
import com.ybf.lottery.model.bean.dragontigertrendbean.TrendShowBean;
import com.ybf.lottery.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/3/28.
 * Use:北京赛车基本走势的fragment
 */

public class BJRacecarBasicTrendFragment extends BaseMvpFragment<BJRacecarBasicTrendPresenter> implements BJRacecarBasicTrendContract.IView, ScrollChangeCallback, View.OnClickListener {

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
    @BindView(R.id.public_img_date)
    ImageView rightImg;
    @BindView(R.id.data_login_ll)
    LinearLayout data_login_ll;
    @BindView(R.id.data_basic_trend_details_ll)
    LinearLayout data_ll;
    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.load_text)
    TextView loadText;
    @BindView(R.id.public_img_back)
    ImageView mBackImg;
    @BindView(R.id.public_txt_title)
    TextView titleTxt;

    private IssueDataAdapter issueDataAdapter;
    private static String BASICTREND_TYPE = "BasicTrendType";//fragment 入口传参 key
    private int basicTrendType;

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
    private List<LengthwaysDataBean> lwData23 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData24 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData25 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData26 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData27 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData28 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData29 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData30 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData31 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData32 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData33 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData34 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData35 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData36 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData37 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData38 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData39 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData40 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData41 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData42 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData43 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData44 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData45 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData46 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData47 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData48 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData49 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData50 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData51 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData52 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData53 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData54 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData55 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData56 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData57 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData58 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData59 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData60 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData61 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData62 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData63 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData64 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData65 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData66 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData67 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData68 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData69 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData70 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData71 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData72 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData73 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData74 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData75 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData76 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData77 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData78 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData79 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData80 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData81 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData82 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData83 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData84 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData85 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData86 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData87 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData88 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData89 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData90 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData91 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData92 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData93 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData94 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData95 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData96 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData97 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData98 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData99 = new ArrayList<>();
    private List<LengthwaysDataBean> lwData100 = new ArrayList<>();
    @Override
    public BJRacecarBasicTrendPresenter initPresenter() {
        return new BJRacecarBasicTrendPresenter(this);
    }

    public static BJRacecarBasicTrendFragment newInstance(int basicTrendType) {

        Bundle args = new Bundle();
        args.putInt(BASICTREND_TYPE , basicTrendType);

        BJRacecarBasicTrendFragment fragment = new BJRacecarBasicTrendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            basicTrendType = getArguments().getInt(BASICTREND_TYPE);
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
        if (basicTrendType == 1) {
            mBackImg.setVisibility(View.VISIBLE);
            mBackImg.setOnClickListener(this);
        }else{
            mBackImg.setVisibility(View.GONE);
        }
        titleTxt.setText("基本走势");

        LinearLayoutManager manager = new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL ,false);
        statisticRecyclerView.setLayoutManager(manager);

        mLeftScroll.setScrollViewListener(this);
        mHeadScroll.setScrollViewListener(this);
        mContentScroll.setScrollViewListener(this);
        rightImg.setVisibility(View.VISIBLE);
        rightImg.setOnClickListener(this);
    }

    private void initData(String period){
        setStatus(STATUS_LOADING);
        mPresenter.loadData(period);
    }

    @Override
    public void loginSuccess(BasicTrendBean basicTrendBean) {
        Log.d("loginSuccess ",basicTrendBean.getCode()+"");
        if (basicTrendBean == null) {
            return;
        }
        setStatus(STATUS_LOAD_SUCCESS);
        List<BasicTrendBean.ZsBean> zsList = basicTrendBean.getZs();
        //期号显示
        bindQiHaoData(getIssueList(zsList));
        //走势号码区域
        customTrendView.setShowDatas(getTrendNumData(basicTrendBean) ,getLYData(basicTrendBean) , 0 , omitType , trendLineType ,lengways, cutOffLine);

        BasicTrendBean.TjBean tj = basicTrendBean.getTj();
        setStatisticData(tj);
    }
    /**
     * 走势区域数据封装
     * @param dtTrendBean
     */
    private List<TrendShowBean> getTrendNumData(BasicTrendBean dtTrendBean){
        List<TrendShowBean> dtShowDataList = new ArrayList<>();

        List<BasicTrendBean.ZsBean> zs = dtTrendBean.getZs();
        for (int i = 0; i < zs.size(); i++) {
            TrendShowBean showBean = new TrendShowBean();
            showBean.setDRAWCODE(zs.get(i).getDRAWCODE());
            showBean.setZsData(getSingleData(zs.get(i)));
            dtShowDataList.add(showBean);
        }
        return dtShowDataList;
    }
    /**1-10显示数据封装*/
    private List<Integer> getSingleData(BasicTrendBean.ZsBean zsData){
        List<Integer> zsList = new ArrayList<>();
        //N11
        zsList.add(zsData.getN11());
        zsList.add(zsData.getN12());
        zsList.add(zsData.getN13());
        zsList.add(zsData.getN14());
        zsList.add(zsData.getN15());
        zsList.add(zsData.getN16());
        zsList.add(zsData.getN17());
        zsList.add(zsData.getN18());
        zsList.add(zsData.getN19());
        zsList.add(zsData.getN110());
        //N21
        zsList.add(zsData.getN21());
        zsList.add(zsData.getN22());
        zsList.add(zsData.getN23());
        zsList.add(zsData.getN24());
        zsList.add(zsData.getN25());
        zsList.add(zsData.getN26());
        zsList.add(zsData.getN27());
        zsList.add(zsData.getN28());
        zsList.add(zsData.getN29());
        zsList.add(zsData.getN210());
        //31
        zsList.add(zsData.getN31());
        zsList.add(zsData.getN32());
        zsList.add(zsData.getN33());
        zsList.add(zsData.getN34());
        zsList.add(zsData.getN35());
        zsList.add(zsData.getN36());
        zsList.add(zsData.getN37());
        zsList.add(zsData.getN38());
        zsList.add(zsData.getN39());
        zsList.add(zsData.getN310());
        //41
        zsList.add(zsData.getN41());
        zsList.add(zsData.getN42());
        zsList.add(zsData.getN43());
        zsList.add(zsData.getN44());
        zsList.add(zsData.getN45());
        zsList.add(zsData.getN46());
        zsList.add(zsData.getN47());
        zsList.add(zsData.getN48());
        zsList.add(zsData.getN49());
        zsList.add(zsData.getN410());
        //51
        zsList.add(zsData.getN51());
        zsList.add(zsData.getN52());
        zsList.add(zsData.getN53());
        zsList.add(zsData.getN54());
        zsList.add(zsData.getN55());
        zsList.add(zsData.getN56());
        zsList.add(zsData.getN57());
        zsList.add(zsData.getN58());
        zsList.add(zsData.getN59());
        zsList.add(zsData.getN510());
        //61
        zsList.add(zsData.getN61());
        zsList.add(zsData.getN62());
        zsList.add(zsData.getN63());
        zsList.add(zsData.getN64());
        zsList.add(zsData.getN65());
        zsList.add(zsData.getN66());
        zsList.add(zsData.getN67());
        zsList.add(zsData.getN68());
        zsList.add(zsData.getN69());
        zsList.add(zsData.getN610());
        //71
        zsList.add(zsData.getN71());
        zsList.add(zsData.getN72());
        zsList.add(zsData.getN73());
        zsList.add(zsData.getN74());
        zsList.add(zsData.getN75());
        zsList.add(zsData.getN76());
        zsList.add(zsData.getN77());
        zsList.add(zsData.getN78());
        zsList.add(zsData.getN79());
        zsList.add(zsData.getN710());
        //81
        zsList.add(zsData.getN81());
        zsList.add(zsData.getN82());
        zsList.add(zsData.getN83());
        zsList.add(zsData.getN84());
        zsList.add(zsData.getN85());
        zsList.add(zsData.getN86());
        zsList.add(zsData.getN87());
        zsList.add(zsData.getN88());
        zsList.add(zsData.getN89());
        zsList.add(zsData.getN810());
        //91
        zsList.add(zsData.getN91());
        zsList.add(zsData.getN92());
        zsList.add(zsData.getN93());
        zsList.add(zsData.getN94());
        zsList.add(zsData.getN95());
        zsList.add(zsData.getN96());
        zsList.add(zsData.getN97());
        zsList.add(zsData.getN98());
        zsList.add(zsData.getN99());
        zsList.add(zsData.getN910());
        //101
        zsList.add(zsData.getN101());
        zsList.add(zsData.getN102());
        zsList.add(zsData.getN103());
        zsList.add(zsData.getN104());
        zsList.add(zsData.getN105());
        zsList.add(zsData.getN106());
        zsList.add(zsData.getN107());
        zsList.add(zsData.getN108());
        zsList.add(zsData.getN109());
        zsList.add(zsData.getN1010());
        return zsList;
    }

    /**获得遗漏状态的数据*/
    private List<List<LengthwaysDataBean>> getLYData(BasicTrendBean dtTrendBean){
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
    private List<List<LengthwaysDataBean>> getLengthwaysData(BasicTrendBean dtTrendBean){
        List<List<LengthwaysDataBean>> lengthwaysDataList = new ArrayList<>();

        List<BasicTrendBean.ZsBean> zsBean = dtTrendBean.getZs();
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
        lengthwaysDataList.add(lwData23);
        lengthwaysDataList.add(lwData24);
        lengthwaysDataList.add(lwData25);
        lengthwaysDataList.add(lwData26);
        lengthwaysDataList.add(lwData27);
        lengthwaysDataList.add(lwData28);
        lengthwaysDataList.add(lwData29);

        lengthwaysDataList.add(lwData30);
        lengthwaysDataList.add(lwData31);
        lengthwaysDataList.add(lwData32);
        lengthwaysDataList.add(lwData33);
        lengthwaysDataList.add(lwData34);
        lengthwaysDataList.add(lwData35);
        lengthwaysDataList.add(lwData36);
        lengthwaysDataList.add(lwData37);
        lengthwaysDataList.add(lwData38);
        lengthwaysDataList.add(lwData39);

        lengthwaysDataList.add(lwData40);
        lengthwaysDataList.add(lwData41);
        lengthwaysDataList.add(lwData42);
        lengthwaysDataList.add(lwData43);
        lengthwaysDataList.add(lwData44);
        lengthwaysDataList.add(lwData45);
        lengthwaysDataList.add(lwData46);
        lengthwaysDataList.add(lwData47);
        lengthwaysDataList.add(lwData48);
        lengthwaysDataList.add(lwData49);

        lengthwaysDataList.add(lwData50);
        lengthwaysDataList.add(lwData51);
        lengthwaysDataList.add(lwData52);
        lengthwaysDataList.add(lwData53);
        lengthwaysDataList.add(lwData54);
        lengthwaysDataList.add(lwData55);
        lengthwaysDataList.add(lwData56);
        lengthwaysDataList.add(lwData57);
        lengthwaysDataList.add(lwData58);
        lengthwaysDataList.add(lwData59);

        lengthwaysDataList.add(lwData60);
        lengthwaysDataList.add(lwData61);
        lengthwaysDataList.add(lwData62);
        lengthwaysDataList.add(lwData63);
        lengthwaysDataList.add(lwData64);
        lengthwaysDataList.add(lwData65);
        lengthwaysDataList.add(lwData66);
        lengthwaysDataList.add(lwData67);
        lengthwaysDataList.add(lwData68);
        lengthwaysDataList.add(lwData69);

        lengthwaysDataList.add(lwData70);
        lengthwaysDataList.add(lwData71);
        lengthwaysDataList.add(lwData72);
        lengthwaysDataList.add(lwData73);
        lengthwaysDataList.add(lwData74);
        lengthwaysDataList.add(lwData75);
        lengthwaysDataList.add(lwData76);
        lengthwaysDataList.add(lwData77);
        lengthwaysDataList.add(lwData78);
        lengthwaysDataList.add(lwData79);

        lengthwaysDataList.add(lwData80);
        lengthwaysDataList.add(lwData81);
        lengthwaysDataList.add(lwData82);
        lengthwaysDataList.add(lwData83);
        lengthwaysDataList.add(lwData84);
        lengthwaysDataList.add(lwData85);
        lengthwaysDataList.add(lwData86);
        lengthwaysDataList.add(lwData87);
        lengthwaysDataList.add(lwData88);
        lengthwaysDataList.add(lwData89);

        lengthwaysDataList.add(lwData90);
        lengthwaysDataList.add(lwData91);
        lengthwaysDataList.add(lwData92);
        lengthwaysDataList.add(lwData93);
        lengthwaysDataList.add(lwData94);
        lengthwaysDataList.add(lwData95);
        lengthwaysDataList.add(lwData96);
        lengthwaysDataList.add(lwData97);
        lengthwaysDataList.add(lwData98);
        lengthwaysDataList.add(lwData99);

        lengthwaysDataList.add(lwData100);

        return lengthwaysDataList;
    }
    private void getLengthwaysAllData(BasicTrendBean.ZsBean zsBean){
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
        LengthwaysDataBean lengthData23 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData24 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData25 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData26 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData27 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData28 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData29 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData30 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData31 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData32 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData33 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData34 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData35 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData36 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData37 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData38 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData39 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData40 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData41 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData42 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData43 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData44 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData45 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData46 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData47 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData48 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData49 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData50 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData51 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData52 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData53 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData54 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData55 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData56 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData57 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData58 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData59 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData60 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData61 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData62 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData63 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData64 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData65 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData66 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData67 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData68 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData69 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData70 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData71 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData72 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData73 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData74 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData75 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData76 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData77 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData78 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData79 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData80 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData81 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData82 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData83 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData84 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData85 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData86 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData87 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData88 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData89 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData90 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData91 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData92 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData93 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData94 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData95 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData96 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData97 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData98 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData99 = new LengthwaysDataBean();
        LengthwaysDataBean lengthData100 = new LengthwaysDataBean();

        lengthData1 .setNumData(zsBean.getN11 ());
        lengthData2 .setNumData(zsBean.getN12 ());
        lengthData3 .setNumData(zsBean.getN13 ());
        lengthData4 .setNumData(zsBean.getN14 ());
        lengthData5 .setNumData(zsBean.getN15 ());
        lengthData6 .setNumData(zsBean.getN16 ());
        lengthData7 .setNumData(zsBean.getN17 ());
        lengthData8 .setNumData(zsBean.getN18 ());
        lengthData9 .setNumData(zsBean.getN19 ());
        lengthData10.setNumData(zsBean.getN110());

        lengthData11.setNumData(zsBean.getN21 ());
        lengthData12.setNumData(zsBean.getN22 ());
        lengthData13.setNumData(zsBean.getN23 ());
        lengthData14.setNumData(zsBean.getN24 ());
        lengthData15.setNumData(zsBean.getN25 ());
        lengthData16.setNumData(zsBean.getN26 ());
        lengthData17.setNumData(zsBean.getN27 ());
        lengthData18.setNumData(zsBean.getN28 ());
        lengthData19.setNumData(zsBean.getN29 ());
        lengthData20.setNumData(zsBean.getN210());

        lengthData21.setNumData(zsBean.getN31 ());
        lengthData22.setNumData(zsBean.getN32 ());
        lengthData23.setNumData(zsBean.getN33 ());
        lengthData24.setNumData(zsBean.getN34 ());
        lengthData25.setNumData(zsBean.getN35 ());
        lengthData26.setNumData(zsBean.getN36 ());
        lengthData27.setNumData(zsBean.getN37 ());
        lengthData28.setNumData(zsBean.getN38 ());
        lengthData29.setNumData(zsBean.getN39 ());
        lengthData30.setNumData(zsBean.getN310());

        lengthData31.setNumData(zsBean.getN41 ());
        lengthData32.setNumData(zsBean.getN42 ());
        lengthData33.setNumData(zsBean.getN43 ());
        lengthData34.setNumData(zsBean.getN44 ());
        lengthData35.setNumData(zsBean.getN45 ());
        lengthData36.setNumData(zsBean.getN46 ());
        lengthData37.setNumData(zsBean.getN47 ());
        lengthData38.setNumData(zsBean.getN48 ());
        lengthData39.setNumData(zsBean.getN49 ());
        lengthData40.setNumData(zsBean.getN410());

        lengthData41.setNumData(zsBean.getN51 ());
        lengthData42.setNumData(zsBean.getN52 ());
        lengthData43.setNumData(zsBean.getN53 ());
        lengthData44.setNumData(zsBean.getN54 ());
        lengthData45.setNumData(zsBean.getN55 ());
        lengthData46.setNumData(zsBean.getN56 ());
        lengthData47.setNumData(zsBean.getN57 ());
        lengthData48.setNumData(zsBean.getN58 ());
        lengthData49.setNumData(zsBean.getN59 ());
        lengthData50.setNumData(zsBean.getN510());

        lengthData51.setNumData(zsBean.getN61 ());
        lengthData52.setNumData(zsBean.getN62 ());
        lengthData53.setNumData(zsBean.getN63 ());
        lengthData54.setNumData(zsBean.getN64 ());
        lengthData55.setNumData(zsBean.getN65 ());
        lengthData56.setNumData(zsBean.getN66 ());
        lengthData57.setNumData(zsBean.getN67 ());
        lengthData58.setNumData(zsBean.getN68 ());
        lengthData59.setNumData(zsBean.getN69 ());
        lengthData60.setNumData(zsBean.getN610());

        lengthData61.setNumData(zsBean.getN71 ());
        lengthData62.setNumData(zsBean.getN72 ());
        lengthData63.setNumData(zsBean.getN73 ());
        lengthData64.setNumData(zsBean.getN74 ());
        lengthData65.setNumData(zsBean.getN75 ());
        lengthData66.setNumData(zsBean.getN76 ());
        lengthData67.setNumData(zsBean.getN77 ());
        lengthData68.setNumData(zsBean.getN78 ());
        lengthData69.setNumData(zsBean.getN79 ());
        lengthData70.setNumData(zsBean.getN710());

        lengthData71.setNumData(zsBean.getN81 ());
        lengthData72.setNumData(zsBean.getN82 ());
        lengthData73.setNumData(zsBean.getN83 ());
        lengthData74.setNumData(zsBean.getN84 ());
        lengthData75.setNumData(zsBean.getN85 ());
        lengthData76.setNumData(zsBean.getN86 ());
        lengthData77.setNumData(zsBean.getN87 ());
        lengthData78.setNumData(zsBean.getN88 ());
        lengthData79.setNumData(zsBean.getN89 ());
        lengthData80.setNumData(zsBean.getN810());

        lengthData81.setNumData(zsBean.getN91 ());
        lengthData82.setNumData(zsBean.getN92 ());
        lengthData83.setNumData(zsBean.getN93 ());
        lengthData84.setNumData(zsBean.getN94 ());
        lengthData85.setNumData(zsBean.getN95 ());
        lengthData86.setNumData(zsBean.getN96 ());
        lengthData87.setNumData(zsBean.getN97 ());
        lengthData88.setNumData(zsBean.getN98 ());
        lengthData89.setNumData(zsBean.getN99 ());
        lengthData90.setNumData(zsBean.getN910());

        lengthData91.setNumData(zsBean.getN101 ());
        lengthData92.setNumData(zsBean.getN102 ());
        lengthData93.setNumData(zsBean.getN103 ());
        lengthData94.setNumData(zsBean.getN104 ());
        lengthData95.setNumData(zsBean.getN105 ());
        lengthData96.setNumData(zsBean.getN106 ());
        lengthData97.setNumData(zsBean.getN107 ());
        lengthData98.setNumData(zsBean.getN108 ());
        lengthData99.setNumData(zsBean.getN109 ());
        lengthData100.setNumData(zsBean.getN1010());

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
        lwData23.add(lengthData23);
        lwData24.add(lengthData24);
        lwData25.add(lengthData25);
        lwData26.add(lengthData26);
        lwData27.add(lengthData27);
        lwData28.add(lengthData28);
        lwData29.add(lengthData29);

        lwData30.add(lengthData30);
        lwData31.add(lengthData31);
        lwData32.add(lengthData32);
        lwData33.add(lengthData33);
        lwData34.add(lengthData34);
        lwData35.add(lengthData35);
        lwData36.add(lengthData36);
        lwData37.add(lengthData37);
        lwData38.add(lengthData38);
        lwData39.add(lengthData39);

        lwData40.add(lengthData40);
        lwData41.add(lengthData41);
        lwData42.add(lengthData42);
        lwData43.add(lengthData43);
        lwData44.add(lengthData44);
        lwData45.add(lengthData45);
        lwData46.add(lengthData46);
        lwData47.add(lengthData47);
        lwData48.add(lengthData48);
        lwData49.add(lengthData49);

        lwData50.add(lengthData50);
        lwData51.add(lengthData51);
        lwData52.add(lengthData52);
        lwData53.add(lengthData53);
        lwData54.add(lengthData54);
        lwData55.add(lengthData55);
        lwData56.add(lengthData56);
        lwData57.add(lengthData57);
        lwData58.add(lengthData58);
        lwData59.add(lengthData59);

        lwData60.add(lengthData60);
        lwData61.add(lengthData61);
        lwData62.add(lengthData62);
        lwData63.add(lengthData63);
        lwData64.add(lengthData64);
        lwData65.add(lengthData65);
        lwData66.add(lengthData66);
        lwData67.add(lengthData67);
        lwData68.add(lengthData68);
        lwData69.add(lengthData69);

        lwData70.add(lengthData70);
        lwData71.add(lengthData71);
        lwData72.add(lengthData72);
        lwData73.add(lengthData73);
        lwData74.add(lengthData74);
        lwData75.add(lengthData75);
        lwData76.add(lengthData76);
        lwData77.add(lengthData77);
        lwData78.add(lengthData78);
        lwData79.add(lengthData79);

        lwData80.add(lengthData80);
        lwData81.add(lengthData81);
        lwData82.add(lengthData82);
        lwData83.add(lengthData83);
        lwData84.add(lengthData84);
        lwData85.add(lengthData85);
        lwData86.add(lengthData86);
        lwData87.add(lengthData87);
        lwData88.add(lengthData88);
        lwData89.add(lengthData89);

        lwData90.add(lengthData90);
        lwData91.add(lengthData91);
        lwData92.add(lengthData92);
        lwData93.add(lengthData93);
        lwData94.add(lengthData94);
        lwData95.add(lengthData95);
        lwData96.add(lengthData96);
        lwData97.add(lengthData97);
        lwData98.add(lengthData98);
        lwData99.add(lengthData99);

        lwData100.add(lengthData100);
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
        setStatus(STATUS_LOAD_FAILED);
    }

    @Override
    public void loginError() {
        Log.d("loginError ","接口异常");
        setStatus(STATUS_SEREVER_ERROR);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.public_img_date:
                Log.d("filtratePopupVindow ","点击了弹窗");
                showDialog();
                break;
            case R.id.public_img_back:
                getActivity().finish();
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

//    private void filtratePopupVindow(){
//        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.bjsc_basic_trend_filtrate, null);
//        PopupWindow popupWindow = new PopupWindow(getContext());
//
//        popupWindow.setBackgroundDrawable(new BitmapDrawable());
//        popupWindow.setOutsideTouchable(true);
//        popupWindow.setFocusable(true);
//
//        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        popupWindow.setContentView(contentView);
//        popupWindow.showAsDropDown(rightImg);
//        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                DisplayUtil.backgroundAlpha(getActivity(), 1f);
//            }
//        });
//    }
}
