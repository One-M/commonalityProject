package com.ybf.lottery.diyview.trend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
/**
 * Created by XQyi on 2018/3/13.
 * 走势图的头部的ScrollView
 */
public class HeaderHorizontalScrollView extends HorizontalScrollView {

    private ScrollChangeCallback mCallback = null;

    public HeaderHorizontalScrollView(Context context, AttributeSet attrs) {
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
        //顶部的的scrollView,同步的时候只改变在x轴方向....
        mCallback.changeXScroll(x);
    }
}
