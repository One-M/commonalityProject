package com.ybf.lottery.diyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.ybf.lottery.R;

/**
 * Created by XQyi on 2018/4/11.
 * Use:自定义的圆角颜色textview
 */

public class ColorTextView extends View{
    /**
     * 文本内容
     */
    private String mText;
    /**
     * 文本的颜色
     */
    private int mTextColor;
    /**
     * 文本的大小
     */
    private int mTextSize;

    private int ctvBackgroundColor;

    /**
     * 圆角大小
     */
    private int mCornerSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mtitleBound;
    private Paint mtitlePaint;

    public ColorTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorTextView(Context context) {
        this(context, null);
    }

    public void setCtvBackgroundColor(int ctvBackgroundColor) {
        this.ctvBackgroundColor = ctvBackgroundColor;
        invalidate();
    }
    public void setCtvText(String text){
        this.mText = text;
        invalidate();
    }

    /**
     * 获得我自定义的样式属性
     *
     * @param context
     * @param attrs
     * @param defStyle
     */
    public ColorTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ColorTextView, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.ColorTextView_ctvText:
                    mText = a.getString(attr);
                    break;
                case R.styleable.ColorTextView_ctvTextColor:
                    // 默认颜色设置为黑色
                    mTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.ColorTextView_ctvTextSize:
                    // 默认设置为15sp，TypeValue也可以把sp转化为px
                    mTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 15, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.ColorTextView_ctvBackground:
                    //默认为白色
                    ctvBackgroundColor = a.getColor(attr, Color.WHITE);
                    break;
                case R.styleable.ColorTextView_ctvCornerSize:
                    //默认圆角为0
                    mCornerSize = a.getInteger(attr, 0);
                    break;

            }

        }
        a.recycle();
        mtitlePaint = new Paint();
        mtitlePaint.setTextSize(mTextSize);
        mtitleBound = new Rect();
        mtitlePaint.getTextBounds(mText, 0, mText.length(), mtitleBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mtitlePaint.setTextSize(mTextSize);
            mtitlePaint.getTextBounds(mText, 0, mText.length(), mtitleBound);

            int desired = getPaddingLeft() + mtitleBound.width() + getPaddingRight();
            width = desired <= widthSize ? desired : widthSize;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mtitlePaint.setTextSize(mTextSize);
            mtitlePaint.getTextBounds(mText, 0, mText.length(), mtitleBound);
            int desired = getPaddingTop() + mtitleBound.height() + getPaddingBottom();
            height = desired <= heightSize ? desired : heightSize;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
        paint.setAntiAlias(true);
        paint.setColor(ctvBackgroundColor);
        RectF rec = new RectF(0, 0, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawRoundRect(rec, mCornerSize, mCornerSize, paint);

        mtitlePaint.setColor(mTextColor);
        //文字(居中处理)
        Paint.FontMetrics fontMetrics=mtitlePaint.getFontMetrics();
        float distance=(fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
        float baseline= rec.centerY()+distance;
        mtitlePaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(mText, rec.centerY(), baseline, mtitlePaint);
    }
}
