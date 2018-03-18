package com.ybf.lottery.diyview.trend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by XQyi on 2018/3/13.
 * 同步scrollView:左边期号对应的列
 */
public class LeftNumberSynchScrollView extends ScrollView {
    private ScrollChangeCallback mCallback = null;

    public LeftNumberSynchScrollView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public void setScrollViewListener(ScrollChangeCallback callback) {
        this.mCallback = callback;
    }

    /**
     * ScrollView改变的监听
     */
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        //期号的scrollView,同步的时候只改变在Y轴方向....
        mCallback.changeYScoll(y);
    }
}