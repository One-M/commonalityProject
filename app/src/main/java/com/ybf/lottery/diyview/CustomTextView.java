package com.ybf.lottery.diyview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.ybf.lottery.R;

/**
 * Created by XQyi on 2018/3/10.
 * Use: 自定义跑马灯textView
 */

@SuppressLint("AppCompatCustomView")
public class CustomTextView extends TextView implements View.OnClickListener{

    public final static String TAG = CustomTextView.class.getSimpleName();

    private float textLength = 0f;//文本长度
    private float viewWidth = 0f;
    private float step = 0f;//文字的横坐标(当前滚动位置)
    private float y = 0f;//文字的纵坐标
    private float temp_view_plus_text_length = 0.0f;//用于计算的临时变量
    private float temp_view_plus_two_text_length = 0.0f;//用于计算的临时变量
    public boolean isStarting = false;//是否开始滚动
    private Paint paint = null;//绘图样式
    private String text = "";//文本内容
    private boolean isInvalidate = true;//是否重新开始滚动（滚动位置是否重置）

    public void setInvalidate(boolean isinvalidate){
        this.isInvalidate = isinvalidate;
    }

    public CustomTextView(Context context) {
        super(context);
        initView();
        paint = getPaint();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        paint = getPaint();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
        paint = getPaint();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /** *//**
     * 初始化控件
     */
    private void initView() {
       /* setOnClickListener(this);*/ //自身点击事件
    }

    /** *//**
     * 文本初始化，每次更改文本内容或者文本效果等之后都需要重新初始化一下
     */
    public void init(WindowManager windowManager)
    {
        paint.setColor(getResources().getColor(R.color.manage_text_color));
        text = getText().toString();
        textLength = paint.measureText(text);
        viewWidth = getWidth();
        if(viewWidth == 0)
        {
            if(windowManager != null)
            {
                Display display = windowManager.getDefaultDisplay();
                viewWidth = display.getWidth();
            }
        }
        if (isInvalidate) {//true 初始化一次 起始位置
            step = textLength;
            isInvalidate = false;
        }
        temp_view_plus_text_length = viewWidth + textLength;
        temp_view_plus_two_text_length = viewWidth + textLength * 2;
        y = getTextSize() + getPaddingTop()+15;
    }
    @Override
    public Parcelable onSaveInstanceState()
    {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);

        ss.step = step;
        ss.isStarting = isStarting;

        return ss;

    }
    @Override
    public void onRestoreInstanceState(Parcelable state)
    {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState)state;
        super.onRestoreInstanceState(ss.getSuperState());

        step = ss.step;
        isStarting = ss.isStarting;

    }

    public static class SavedState extends BaseSavedState {
        public boolean isStarting = false;
        public float step = 0.0f;
        SavedState(Parcelable superState) {
            super(superState);
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeBooleanArray(new boolean[]{isStarting});
            out.writeFloat(step);
        }


        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }

            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }
        };

        private SavedState(Parcel in) {
            super(in);
            boolean[] b = null;
            in.readBooleanArray(b);
            if(b != null && b.length > 0)
                isStarting = b[0];
            step = in.readFloat();
        }
    }

    /** *//**
     * 开始滚动
     */
    public void startScroll()
    {
        isStarting = true;
        invalidate();//重绘
    }

    /** *//**
     * 停止滚动
     */
    public void stopScroll()
    {
        isStarting = false;
        invalidate();
    }


    @Override
    public void onDraw(Canvas canvas) {
        if (text!=null) {
            canvas.drawText(text, temp_view_plus_text_length - step, y, paint);
        }else {
            Log.i("info", "**************CustomTextView.text  is  null************");
        }
        if(!isStarting)
        {
            return;
        }
        step += 3; //滚动速度 "+"表示往左 "-"表示往右
        if(step > temp_view_plus_two_text_length)
            step = textLength;

        invalidate();
    }

    @Override
    public void onClick(View v) {
        if(isStarting)
            stopScroll();
        else
            startScroll();

    }
}
