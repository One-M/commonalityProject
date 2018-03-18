package com.ybf.lottery.diyview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by XQyi on 2018/3/17.
 * Use:可以设置禁止滑动的 ViewPager(单向禁止：左滑动/右滑动)
 * 核心方法：setScrollble()
 */

public class CanotSlidingViewPager extends ViewPager{

    /**
     * 上一次x坐标
     */
    private float beforeX;
    /**
     * 是否可以滑动
     * true：可滑
     */
    private boolean isCanScroll = true;

    public CanotSlidingViewPager(Context context) {
        super(context);
    }

    public CanotSlidingViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isScrollble() {
        return isCanScroll;
    }
    /**
     * 设置 是否可以滑动
     * @param isCanScroll
     */
    public void setScrollble(boolean isCanScroll) {
        this.isCanScroll = isCanScroll;
    }

//----------禁止左右滑动------------------
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        if (isCanScroll) {
//            return super.onTouchEvent(ev);
//        } else {
//            return false;
//        }
//
//    }
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent arg0) {
//        // TODO Auto-generated method stub
//        if (isCanScroll) {
//            return super.onInterceptTouchEvent(arg0);
//        } else {
//            return false;
//        }
//
//    }
//-----------禁止左右滑动----------------------

    /**-----禁止左滑-------左滑：上一次坐标 > 当前坐标  */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (isCanScroll) {
            return super.dispatchTouchEvent(ev);
        }else{
            switch (ev.getAction()){
                case MotionEvent.ACTION_DOWN:
                    /**这里有个问题:如果按下时的坐标‘仅’作为‘上次坐标’，可能存在还可左滑，motionValue大于0的情况（来回滑，只要停止坐标在按下坐标的右边，左滑仍然能滑过去）*/
                    beforeX = ev.getX();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float motionValue = ev.getX() - beforeX;
                    //控制不可左滑（ps:右滑就把motionValue判断改成大于0）
                    if (motionValue < 0) {
                        return true;
                    }
                    /**手指移动时，再把当前的坐标作为下一次的‘上次坐标’，解决上述问题*/
                    beforeX = ev.getX();
                    break;
                default:
                    break;
            }
            return super.dispatchTouchEvent(ev);
        }
    }
}
