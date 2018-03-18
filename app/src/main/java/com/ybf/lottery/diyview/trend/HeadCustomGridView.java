package com.ybf.lottery.diyview.trend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by XQyi on 2018/3/10.
 * 水平的gridView
 */
public class HeadCustomGridView extends GridView {
    public HeadCustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }
//todo:使用下面的测量，在240dpi的手机上会出现多余的列....
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int widthExpand=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>1,MeasureSpec.AT_MOST);
//        super.onMeasure(widthExpand, heightMeasureSpec);
//    }
}
