package com.ybf.lottery.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ybf.lottery.R;
import com.ybf.lottery.adapter.CalendarViewAdapter;
import com.ybf.lottery.diyview.CalendarCard;
import com.ybf.lottery.utils.CustomDate;

/**
 * Created by XQyi on 2018/3/13.
 * Use: 日历activity
 */

public class CalendarActivity extends Activity implements View.OnClickListener , CalendarCard.OnCellClickListener {

    private ViewPager mViewPager;
    private int mCurrentIndex = 498;
    private CalendarCard[] mShowViews;
    private CalendarViewAdapter<CalendarCard> adapter;
    private SildeDirection mDirection = SildeDirection.NO_SILDE;
    private LinearLayout preImgBtn_ll;
    private LinearLayout nextImgBtn_ll;
    private CustomDate clickDate = new CustomDate(2018 , 03 , 13);//选中的date

    enum SildeDirection {
        RIGHT, LEFT, NO_SILDE;
    }

    private ImageButton preImgBtn, nextImgBtn;
    private TextView monthText;
//    private ImageButton closeImgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.calendar_lay);
        mViewPager = (ViewPager) this.findViewById(R.id.vp_calendar);
        preImgBtn = (ImageButton) this.findViewById(R.id.btnPreMonth);
        nextImgBtn = (ImageButton) this.findViewById(R.id.btnNextMonth);
        monthText = (TextView) this.findViewById(R.id.tvCurrentMonth);
//        closeImgBtn = (ImageButton) this.findViewById(R.id.btnClose);

        preImgBtn_ll = (LinearLayout) this.findViewById(R.id.btnPreMonth_ll);
        nextImgBtn_ll = (LinearLayout) this.findViewById(R.id.btnNextMonth_ll);
        preImgBtn_ll.setOnClickListener(this);
        nextImgBtn_ll.setOnClickListener(this);

        preImgBtn.setOnClickListener(this);
        nextImgBtn.setOnClickListener(this);
//        closeImgBtn.setOnClickListener(this);

        CalendarCard[] views = new CalendarCard[3];//上月 当月 下月
        for (int i = 0; i < 3; i++) {
//            views[i] = new CalendarCard(this, this , clickDate);
        }
        adapter = new CalendarViewAdapter<>(views);
        setViewPager();

    }

    private void setViewPager() {
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(mCurrentIndex);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                measureDirection(position);
                updateCalendarView(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPreMonth_ll:
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
                break;
            case R.id.btnNextMonth_ll:
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                break;
//            case R.id.btnClose:
//                finish();
//                break;
            default:
                break;
        }
    }

    @Override
    public void clickDate(CustomDate date) {
        Log.d("date: " , date.year + "-" + date.month + "-" + date.day);
        clickDate = date;
    }

    @Override
    public void changeDate(CustomDate date) {
        monthText.setText(date.year + "年" + date.month + "月");
//        Log.d("datesss: " , date.day + "");
    }

    /**
     * 计算方向
     *
     * @param arg0
     */
    private void measureDirection(int arg0) {

        if (arg0 > mCurrentIndex) {
            mDirection = SildeDirection.RIGHT;

        } else if (arg0 < mCurrentIndex) {
            mDirection = SildeDirection.LEFT;
        }
        mCurrentIndex = arg0;
    }

    // 更新日历视图
    private void updateCalendarView(int arg0) {
        mShowViews = adapter.getAllItems();
        if (mDirection == SildeDirection.RIGHT) {
            mShowViews[arg0 % mShowViews.length].rightSlide(clickDate);
        } else if (mDirection == SildeDirection.LEFT) {
            mShowViews[arg0 % mShowViews.length].leftSlide(clickDate);
        }
        mDirection = SildeDirection.NO_SILDE;
    }
}
