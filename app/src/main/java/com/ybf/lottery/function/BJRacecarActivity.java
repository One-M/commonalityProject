package com.ybf.lottery.function;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.constraint.Group;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ybf.lottery.R;
import com.ybf.lottery.adapter.CalendarViewAdapter;
import com.ybf.lottery.adapter.TabsAdapter;
import com.ybf.lottery.base.BaseMvpActivity;
import com.ybf.lottery.diyview.CalendarCard;
import com.ybf.lottery.diyview.CanotSlidingViewPager;
import com.ybf.lottery.diyview.CustomTextView;
import com.ybf.lottery.eventBusInfo.HistoryKJEvent;
import com.ybf.lottery.function.datastatistics.BJRacecarDataStatisticsFragment;
import com.ybf.lottery.function.historykj.BJRacecarHistoryKJFragment;
import com.ybf.lottery.model.bean.BJRacecarCountDownBean;
import com.ybf.lottery.utils.CustomDate;
import com.ybf.lottery.utils.DateUtil;
import com.ybf.lottery.utils.DisplayUtil;
import org.greenrobot.eventbus.EventBus;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/3/10.
 * Use: 北京赛车
 */
public class BJRacecarActivity extends BaseMvpActivity<BJRacecarContract.Presenter> implements BJRacecarContract.IView, View.OnClickListener {

    @BindView(R.id.marquee)
    CustomTextView mMarquee;
    @BindView(R.id.cloe_show_ll)
    LinearLayout mCloeShowll;
    @BindView(R.id.public_txt_date)
    TextView mTextDate;
    @BindView(R.id.marquee_ll)
    LinearLayout marqueell;
    @BindView(R.id.public_img_back)
    ImageView backimg;
    @BindView(R.id.group)
    Group group;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;


    private MyCountDown countDown;

    private CustomDate currClickDate;//记录选中的date
    private CustomDate todayDate;//当天日期
    private int pagesize = 100;
    private String issue; //期号
    private int surplusIssue;//剩余期数

    @Override
    protected BJRacecarContract.Presenter initInject() {
        return new BJRacecarPresenter(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bj_racecar_lay);
        ButterKnife.bind(this);

        initView();
        currClickDate = new CustomDate();
        todayDate = new CustomDate();
        initData();
    }

    private void initView(){
        String[] titles = {"历史开奖" , "数据统计" , "基本走势" , "定位走势" , "龙虎走势" , "亚冠走势"};//
        FragmentManager manager = getSupportFragmentManager();
        TabsAdapter tabsAdapter = new TabsAdapter(manager);
        tabsAdapter.setTitles(titles);
        BJRacecarDataStatisticsFragment fragment = new BJRacecarDataStatisticsFragment();
        tabsAdapter.addFragments(new BJRacecarHistoryKJFragment() , fragment , new BJRacecarDataStatisticsFragment(), new BJRacecarDataStatisticsFragment()
                , new BJRacecarDataStatisticsFragment(), new BJRacecarDataStatisticsFragment());

        viewPager.setOffscreenPageLimit(5);//设置预加载页面的个数。
        viewPager.setAdapter(tabsAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }


    private void initData(){
        basePresenter.loadData();
    }

    private void setData(BJRacecarCountDownBean countDownBean){

        long endTime = countDownBean.getInfo().getSaleEndTime();
        long serverTime = countDownBean.getInfo().getServerTime();
        long time = endTime - serverTime;

        String timeStr = formatLongToTimeStr(time);

        issue = countDownBean.getInfo().getIssue();
        surplusIssue = 179 - countDownBean.getIssue();

        countDown = new MyCountDown(time , 1000);
        countDown.start();

        mMarquee.setText("第" + issue + "期开奖倒计时:" + timeStr + " 每日售179期,今日剩余" + surplusIssue + "期");
        mMarquee.init(getWindowManager());
        mMarquee.startScroll();

        mTextDate.setText(getDateString(currClickDate));

        mCloeShowll.setOnClickListener(this);
        backimg.setOnClickListener(this);
        mTextDate.setOnClickListener(this);

        Log.d("qwer==> " , countDownBean.getCode() + " success" + time);
    }

    @Override
    public void loadSuccess(BJRacecarCountDownBean countDownBean) {
        setData(countDownBean);
    }

    @Override
    public void loadFailed(BJRacecarCountDownBean failedData) {
        Log.d("qwer==> " , failedData.getCode() + "");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cloe_show_ll:
                group.setVisibility(View.GONE);
                countDown.cancel();
                break;
            case R.id.public_img_back:
                countDown.cancel();
                finish();
                break;
            case R.id.public_txt_date:
                if (showPopup) {
                    calendarPopupWindow();
                }
                break;
        }
    }

    class MyCountDown extends CountDownTimer{

        public MyCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            String timeStr = formatLongToTimeStr(l);
            mMarquee.setText("第" + issue + "期开奖倒计时:" + timeStr + " 每日售179期,今日剩余" + surplusIssue + "期");
            mMarquee.init(getWindowManager());
        }

        @Override
        public void onFinish() {
            mMarquee.setText("开奖啦！");
            mMarquee.init(getWindowManager());
            countDown.cancel();
            initData();
        }
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

    /**
     * 日历弹框
     */
    private boolean showPopup = true;//是否可弹窗
    private void calendarPopupWindow(){
        showPopup = false;
        final PopupWindow popupWindow = new PopupWindow(mCloeShowll);
        popupWindow.setWidth(getResources().getDimensionPixelSize(R.dimen.window_width));
        popupWindow.setHeight(getResources().getDimensionPixelSize(R.dimen.window_height));

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        DisplayUtil.backgroundAlpha(this, 0.7f);
        popupWindow.setFocusable(true);

        CalendarAct calendarAct = new CalendarAct(this , popupWindow);
        // 设置所在布局
        popupWindow.setContentView(calendarAct.getLayout());
        // 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏移
        popupWindow.showAsDropDown(mTextDate);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                showPopup = true;
                DisplayUtil.backgroundAlpha(BJRacecarActivity.this, 1f);
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

//        private SildeDirection mDirection = SildeDirection.NO_SILDE;
        private LinearLayout layout;
        private CanotSlidingViewPager mViewPager;
        private ImageButton preImgBtn;
        private ImageButton nextImgBtn;
        private TextView monthText;
//        private ImageButton closeImgBtn;
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
//            closeImgBtn = (ImageButton) layout.findViewById(R.id.btnClose);
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
            EventBus.getDefault().post(new HistoryKJEvent(dStr));
            mTextDate.setText(dStr);
            showPopup = true;
            mPopupWindow.dismiss();
        }
        @Override
        public void changeDate(CustomDate date) {
        monthText.setText(date.year + "年" + date.month + "月");
//        Log.d("datesss: " , date.day + "");
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

    private String getDateString(CustomDate customDate){
        return customDate.getYear() + "-" + customDate.getMonth() + "-" + customDate.getDay();
    }
}
