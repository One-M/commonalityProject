package com.ybf.lottery.function.historykj;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ybf.lottery.R;
import com.ybf.lottery.activity.HistoryKJActivity;
import com.ybf.lottery.adapter.BJRacecarHistoryKJAdapter;
import com.ybf.lottery.adapter.CalendarViewAdapter;
import com.ybf.lottery.adapter.IssueDataAdapter;
import com.ybf.lottery.base.BaseMvpFragment;
import com.ybf.lottery.diyview.CalendarCard;
import com.ybf.lottery.diyview.CanotSlidingViewPager;
import com.ybf.lottery.diyview.CustomTextView;
import com.ybf.lottery.diyview.trend.CustomHistoryKJView;
import com.ybf.lottery.diyview.trend.HeaderHorizontalScrollView;
import com.ybf.lottery.diyview.trend.LeftNumberCustomListView;
import com.ybf.lottery.diyview.trend.LeftNumberSynchScrollView;
import com.ybf.lottery.diyview.trend.ScrollChangeCallback;
import com.ybf.lottery.diyview.trend.TrendScrollViewWidget;
import com.ybf.lottery.eventBusInfo.HistoryKJEvent;
import com.ybf.lottery.model.bean.BJRacecarCountDownBean;
import com.ybf.lottery.model.bean.BJRacecarHistoryKJBean;
import com.ybf.lottery.utils.CustomDate;
import com.ybf.lottery.utils.DateUtil;
import com.ybf.lottery.utils.DisplayUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/3/10.
 * Use:历史开奖页
 */

public class BJRacecarHistoryKJFragment extends BaseMvpFragment<BJRacecarHistoryKJContract.Presenter> implements BJRacecarHistoryKJContract.IView, ScrollChangeCallback, View.OnClickListener {

    //容器区域
    @BindView(R.id.scroll_left)
    LeftNumberSynchScrollView mLeftScroll;
    @BindView(R.id.scroll_content)
    TrendScrollViewWidget mContentScroll;
    @BindView(R.id.trend_header_scroll)
    HeaderHorizontalScrollView mHeadScroll;
    //数据区域
    @BindView(R.id.lv_number)
    LeftNumberCustomListView mListView;
    @BindView(R.id.custom_history_kj_view)
    CustomHistoryKJView historyKJView;
    //加载中提示
    @BindView(R.id.data_login_ll)
    LinearLayout dataLoginll;
    @BindView(R.id.load_text)
    TextView loadText;
    //数据显示
    @BindView(R.id.data_details_ll)
    LinearLayout dataDetailsll;
    @BindView(R.id.custom_ll)
    LinearLayout customll;
    @BindView(R.id.marquee)
    CustomTextView mMarquee;
    @BindView(R.id.cloe_show_ll)
    LinearLayout mCloeShowll;
    @BindView(R.id.public_txt_date)
    TextView mTextDate;
    @BindView(R.id.public_img_back)
    ImageView mBackImg;
    @BindView(R.id.public_txt_title)
    TextView titleTxt;

    private View mView;
    private IssueDataAdapter issueDataAdapter;
    private BJRacecarHistoryKJAdapter historyKJAdapter;
    private List<BJRacecarHistoryKJBean> historyData = new ArrayList<>();
    private List<BJRacecarHistoryKJBean> showData = new ArrayList<>();//显示的数据
    private Timer timer;

    private String issue; //期号
    private int surplusIssue;//剩余期数
    private MyCountDown countDown;
    private CustomDate currClickDate;//记录选中的date
    private CustomDate todayDate;//当天日期

    private Activity mActivity;
    private Context mContext;
    private static String ENTRANCE_TYPE = "entranceType";//fragment 入口传参 key
    private int entranceType;//入口标记，传参标记入口type 导航栏入口传0 其它传l（ps：非导航栏入口 需要显示头部返回按钮）

    @Override
    public BJRacecarHistoryKJContract.Presenter initPresenter() {
        return new BJRacecarHistoryKJPresenter(this);
    }

    public static BJRacecarHistoryKJFragment newInstance(int entranceType) {

        Bundle args = new Bundle();
        args.putInt(ENTRANCE_TYPE , entranceType);

        BJRacecarHistoryKJFragment fragment = new BJRacecarHistoryKJFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            entranceType = getArguments().getInt(ENTRANCE_TYPE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.kaijiang_history, container, false);
        mContext = mActivity;

        ButterKnife.bind(this , mView);
        EventBus.getDefault().register(this);

        currClickDate = new CustomDate();
        todayDate = new CustomDate();

        initView();
        CustomDate cuDate = new CustomDate();
        String cyString = DateUtil.getDateFormattingString(cuDate.getYear() , cuDate.getMonth() , cuDate.getDay());
        initDatas(cyString);
        initTimeData();
       return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView(){
        if (entranceType == 1) {
            mBackImg.setVisibility(View.VISIBLE);
            mBackImg.setOnClickListener(this);
        }else{
            mBackImg.setVisibility(View.GONE);
        }
        titleTxt.setText("历史开奖");

        mLeftScroll.setScrollViewListener(this);
        //中间走势图的监听器
        mContentScroll.setScrollViewListener(this);
        //走势图顶部的监听器
        mHeadScroll.setScrollViewListener(this);

        mTextDate.setText(getDateString(currClickDate));
        mTextDate.setVisibility(View.VISIBLE);

    }

    private final int STATUS_LOADING = 0;//加载中
    private final int STATUS_LOAD_SUCCESS = 1;//加载成功
    private final int STATUS_LOAD_FAILED = 2;//加载失败
    private final int STATUS_SEREVER_ERROR = 3;//接口异常

    private void setStatus(int status){
        switch (status){
            case STATUS_LOADING:
                dataLoginll.setVisibility(View.VISIBLE);
                dataDetailsll.setVisibility(View.GONE);
                loadText.setText("加载中...");
                break;
            case STATUS_LOAD_SUCCESS:
                dataLoginll.setVisibility(View.GONE);
                dataDetailsll.setVisibility(View.VISIBLE);
                break;
            case STATUS_LOAD_FAILED:
                dataLoginll.setVisibility(View.VISIBLE);
                dataDetailsll.setVisibility(View.GONE);
                loadText.setText("加载失败");
                break;
            case STATUS_SEREVER_ERROR:
                dataLoginll.setVisibility(View.VISIBLE);
                dataDetailsll.setVisibility(View.GONE);
                loadText.setText("暂无数据");
                break;
        }
    }

    private void initDatas(String dateStr){
        setStatus(STATUS_LOADING);
        mPresenter.loadData(dateStr);
    }
    private void initTimeData(){
        mPresenter.loadTimeData();
    }
    @Override
    public void loadSuccess(List<BJRacecarHistoryKJBean> historyKJBeanList) {

        /**显示的数据，在请求数据后先clear 再赋值新数据*/
        showData.clear();
        showData = historyKJBeanList;

        /**期号数据设置*/
        bindQiHaoData(getIssueNum(showData));
        bindNeiRongData(showData);

    }

    @Override
    public void loadFailed() {
        Log.d("retrofit==> " , "failed");
        setStatus(STATUS_LOAD_FAILED);
    }

    @Override
    public void sereverError() {
        setStatus(STATUS_SEREVER_ERROR);
    }

    @Override
    public void loadTimeSuccess(BJRacecarCountDownBean countDownBean) {
        setTimeData(countDownBean);
    }

    @Override
    public void loadTimeFailed(BJRacecarCountDownBean failedData) {
        Log.d("qwer==> " , failedData.getCode() + "");
    }

    /**
     * 期号的数据显示
     */
    private void bindQiHaoData(List<String> numList) {
        if (issueDataAdapter == null) {
            issueDataAdapter = new IssueDataAdapter(R.layout.items , getContext());
            issueDataAdapter.bindData(numList);
            mListView.setAdapter(issueDataAdapter);
        }else{
            issueDataAdapter.bindData(numList);
            issueDataAdapter.notifyDataSetChanged();
            //复位
            mLeftScroll.scrollTo(0, 0);
            mHeadScroll.scrollTo(0,0);
        }
    }

    /**
     * 添加内容数据
     */
    private void bindNeiRongData(final List<BJRacecarHistoryKJBean> dataBean){
        historyKJView.setShowDatas(dataBean);
        setStatus(STATUS_LOAD_SUCCESS);
    }

    /***
     * 同步X轴位置
     * @param left
     */
    @Override
    public void changeXScroll(int left) {
        //顶部和底部容器滑动的回调;
        //此时需要同步中间走势的View的位置;
        mContentScroll.scrollTo(left, mContentScroll.getScrollY());
        //同步顶部自身的位置;
        mHeadScroll.scrollTo(left,0);
    }
    /***
     * 同步Y轴的位置
     * @param top
     */
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

    /**
     * 获得开奖期号的list
     * @param datas
     */
    private List<String> getIssueNum(List<BJRacecarHistoryKJBean> datas){
        List<String> qihaoList = new ArrayList<>();

        for (BJRacecarHistoryKJBean d : datas) {
            qihaoList.add(d.getIssue());
        }
        return qihaoList;
    }

    @SuppressLint("LongLogTag")
    @Subscribe() // threadMode 设置 onEven的执行线程
    public void onEven(HistoryKJEvent event){
        if (event.getEventDate().equals("-1")) {
            if (customll.getVisibility() == View.GONE) {
                initTimeData();
            }
        }
    }

    private void setTimeData(BJRacecarCountDownBean countDownBean){

        customll.setVisibility(View.VISIBLE);

        long endTime = countDownBean.getInfo().getSaleEndTime();
        long serverTime = countDownBean.getInfo().getServerTime();
        long time = endTime - serverTime;

        String timeStr = formatLongToTimeStr(time);

        issue = countDownBean.getInfo().getIssue();
        surplusIssue = 179 - countDownBean.getIssue();

        countDown = new MyCountDown(time , 1000);
        countDown.start();

        mMarquee.setText("第" + issue + "期开奖倒计时:" + timeStr + " 每日售179期,今日剩余" + surplusIssue + "期");
        mMarquee.init(mActivity.getWindowManager());
        mMarquee.startScroll();

        mTextDate.setVisibility(View.VISIBLE);
        mTextDate.setText(getDateString(currClickDate));
        mTextDate.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线

        mCloeShowll.setOnClickListener(this);
        mTextDate.setOnClickListener(this);

        Log.d("qwer==> " , countDownBean.getCode() + " success" + time);
    }
    /**
     * long ==> 分秒显示,
     * @param l
     * @return
     */
    private String formatLongToTimeStr(long l){
        int minute = 0;//分
        int second = 0;//秒
        second = (int) (l/1000);
        if (second >= 60) {
            minute = second/60;//取整
            second = second%60;//取余
        }

        String m = "";
        String s = "";
        m = minute < 10 ? "0" + minute : "" + minute;
        s = second < 10 ? "0" + second : "" + second;

        String strTime = m + "分" + s + "秒";
        return strTime;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cloe_show_ll:
                customll.setVisibility(View.GONE);
                countDown.cancel();
                break;
            case R.id.public_txt_date:
                if (showPopup) {
                    calendarPopupWindow();
                }
                break;
            case R.id.public_img_back:
                mActivity.finish();
                break;
        }
    }

    class MyCountDown extends CountDownTimer {

        public MyCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            String timeStr = formatLongToTimeStr(l);
            mMarquee.setText("第" + issue + "期开奖倒计时:" + timeStr + " 每日售179期,今日剩余" + surplusIssue + "期");
            mMarquee.init(mActivity.getWindowManager());
        }

        @Override
        public void onFinish() {
            mMarquee.setText("开奖啦！");
            mMarquee.init(mActivity.getWindowManager());
            countDown.cancel();
            initTimeData();
        }
    }
    private String getDateString(CustomDate customDate){
        return customDate.getYear() + "-" + customDate.getMonth() + "-" + customDate.getDay();
    }

    /**
     * 日历弹框
     */
    private boolean showPopup = true;//是否可弹窗(日期选择)
    private void calendarPopupWindow(){
        showPopup = false;
        final PopupWindow popupWindow = new PopupWindow(mCloeShowll);
        popupWindow.setWidth(getResources().getDimensionPixelSize(R.dimen.window_width));
        popupWindow.setHeight(getResources().getDimensionPixelSize(R.dimen.window_height));

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        DisplayUtil.backgroundAlpha(getContext(), 0.7f);
        popupWindow.setFocusable(true);

        CalendarAct calendarAct = new CalendarAct(getContext() , popupWindow);
        // 设置所在布局
        popupWindow.setContentView(calendarAct.getLayout());
        // 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏移
        popupWindow.showAsDropDown(mTextDate);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                showPopup = true;
                DisplayUtil.backgroundAlpha(getContext(), 1f);
            }
        });
        calendarAct.preImgBtn_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarAct.mViewPager.setCurrentItem(calendarAct.mViewPager.getCurrentItem() - 1);
            }
        });
        calendarAct.nextImgBtn_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (calendarAct.isScorllnext) {//不在当前月 有下月
                    calendarAct.mViewPager.setCurrentItem(calendarAct.mViewPager.getCurrentItem() + 1);
                }
            }
        });
    }

    /**
     * 自定义日历弹框类
     */
    class CalendarAct implements CalendarCard.OnCellClickListener {

        public boolean isScorllnext = false;//是否可左滑(下月)
        private Context context;
        private CalendarViewAdapter adapter;
        private CalendarViewAdapter calendarViewAdapter;
        private CalendarCard[] mShowViews;

        private LinearLayout layout;
        private CanotSlidingViewPager mViewPager;
        private ImageButton preImgBtn;
        private ImageButton nextImgBtn;
        private TextView monthText;
        private LinearLayout preImgBtn_ll;
        private LinearLayout nextImgBtn_ll;

        private int LEFT = -1;
        private int NO_SILDE = 0;
        private int RIGHT = 1;
        private int direction = NO_SILDE;
        private PopupWindow mPopupWindow;
        private int mCurrentIndex = 100;

        public CalendarAct(Context context , PopupWindow popupWindow){
            this.context = context;
            this.mPopupWindow = popupWindow;
            getCalendarCard();
        }

        private void getCalendarCard(){
            // 找到布局文件
            layout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.calendar_lay, null);

            mViewPager = (CanotSlidingViewPager) layout.findViewById(R.id.vp_calendar);
            preImgBtn = (ImageButton) layout.findViewById(R.id.btnPreMonth);
            nextImgBtn = (ImageButton) layout.findViewById(R.id.btnNextMonth);
            monthText = (TextView) layout.findViewById(R.id.tvCurrentMonth);
            preImgBtn_ll = (LinearLayout) layout.findViewById(R.id.btnPreMonth_ll);
            nextImgBtn_ll = (LinearLayout) layout.findViewById(R.id.btnNextMonth_ll);

            CalendarCard[] views = new CalendarCard[3];//上月 当月 下月
            for (int i = 0; i < 3; i++) {
                //这里需要标记的年月日和显示的年月要区分
                CustomDate customYM = new CustomDate();
                customYM.setYear(currClickDate.getYear());
                customYM.setMonth(currClickDate.getMonth());

                views[i] = new CalendarCard(context, this ,customYM , currClickDate);
            }
            setPagerScorll(currClickDate);
            adapter = new CalendarViewAdapter<>(views);
            setViewPager();
        }
        private void setViewPager() {
            mViewPager.setAdapter(adapter);
            mViewPager.setCurrentItem(mCurrentIndex);
            mViewPager.setScrollble(isScorllnext);//禁止左滑(下月)
            mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    measureDirection(position);
                    updateCalendarView(position);
                    mViewPager.setScrollble(isScorllnext);
                }
                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {}
                @Override
                public void onPageScrollStateChanged(int arg0) {}
            });
        }
        @Override
        public void clickDate(CustomDate date) {
            String dStr = DateUtil.getDateFormattingString(date.getYear() , date.getMonth() , date.getDay());
            Log.d("date: " , dStr);
            currClickDate = date;

            initDatas(dStr);

            mTextDate.setText(dStr);
            showPopup = true;
            mPopupWindow.dismiss();
        }
        @Override
        public void changeDate(CustomDate date) {
            monthText.setText(date.year + "年" + date.month + "月");
            setPagerScorll(date);
        }

        /**
         * 是否可左滑（下月）状态更新
         * @param currScollData
         */
        private void setPagerScorll(CustomDate currScollData){
            isScorllnext = todayDate.getMonth() != currScollData.getMonth() ;
        }
        /**
         * 计算方向
         *
         * @param arg0
         */
        private void measureDirection(int arg0) {

            if (arg0 > mCurrentIndex) {
                direction = RIGHT;

            } else if (arg0 < mCurrentIndex) {
                direction = LEFT;
            }
            mCurrentIndex = arg0;
        }
        // 更新日历视图
        private void updateCalendarView(int arg0) {
            mShowViews = (CalendarCard[]) adapter.getAllItems();
            if (direction == RIGHT) {
                mShowViews[arg0 % mShowViews.length].rightSlide(currClickDate);
            } else if (direction == LEFT) {
                mShowViews[arg0 % mShowViews.length].leftSlide(currClickDate);
            }
            direction = NO_SILDE;
        }
        public LinearLayout getLayout(){
            return layout;
        }
    }

}
