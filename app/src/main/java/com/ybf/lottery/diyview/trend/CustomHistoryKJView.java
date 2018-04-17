package com.ybf.lottery.diyview.trend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.ybf.lottery.R;
import com.ybf.lottery.model.bean.BJRacecarHistoryKJBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XQyi on 2018/3/22.
 * Use: 自定义历史开奖的view(画布)
 * ps:这里需要嵌套在TrendScrollViewWidget实现可360度拖动效果，
 *    如果使用recycleview展示数据，需要一次性展示全部数据(recycleview嵌套在scrollview中，需要全部显示)数据过多时渲染时间过长，页面延时严重
 *    so：这里自定义view，页面数据用Paint绘制实现。
 */

public class CustomHistoryKJView extends View{
    //文字画笔
    private Paint mPaintText = null;

    //背景色画笔
    private Paint mBallPaint=null;

    //网格线画笔
    private Paint mPaintLine=null;

    //网格的水平间距
    private float mDeltaX;

    //网格垂直间距
    private float mDeltaY;

    //当前View的宽度
    private int mWidth;

    //当前View的高度
    private int mHeight;

    //需要显示的全部数据
    private List<BJRacecarHistoryKJBean> showDatas;

    /**绘制的小单元格高度 h*/
    private int mItemH =0;
    /**绘制龙虎数据的小单元格宽度 w*/
    private int mLongHuW =0;
    /**绘制开奖号码的单元格宽度(不同于龙虎数据的宽度)*/
    private int kjNumWidth = 0;


    public CustomHistoryKJView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mItemH =getResources().getDimensionPixelSize(R.dimen.trend_ball_wh);
        mLongHuW =getResources().getDimensionPixelSize(R.dimen.kj_history_itemw);
        kjNumWidth=getResources().getDimensionPixelSize(R.dimen.kj_num_item_w);

        initSource();
        showDatas=new ArrayList<>();
    }
    public void setShowDatas(List<BJRacecarHistoryKJBean> kjData){
        this.showDatas.clear();
        this.showDatas = kjData;

        Log.i("trendtag","行数:"+showDatas.size());

        /** 由于显示数据的大小可能与上一次数据不一致，这里要用 requestLayout()实现重绘，直接使用invalidate()无法改变view本身大小
         * requestLayout：当view确定自身已经不再适合现有的区域时，该view本身调用这个方法要求parent view重新调用他的onMeasure onLayout来对重新设置自己位置。
         特别的当view的layoutparameter发生改变，并且它的值还没能应用到view上，这时候适合调用这个方法。
         invalidate：View本身调用迫使view重画。 刷新视图，相当于View.OnDraw()方法*/
        requestLayout();
    }

    /***
     * 初始化资源
     */
    private void initSource(){
        int dpValue=getScreenDenisty();
        //网格线画笔
        mPaintLine=new Paint();
        mPaintLine.setColor(getResources().getColor(R.color.form_line_color));
        mPaintLine.setAntiAlias(true);
        mPaintLine.setStrokeWidth(dpValue*0.6f/120);

        //文字画笔
        mPaintText=new Paint();
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize((dpValue*12/150));
        mPaintText.setAntiAlias(true);
        mPaintText.setStrokeWidth(2f);

        //开奖号码背景色画笔
        mBallPaint=new Paint();
        mBallPaint.setAntiAlias(true);

        //设置单个网格的水平和垂直间距
        this.mDeltaY= mItemH *2f;
        this.mDeltaX= mLongHuW;//网格初始宽度设为龙虎数据宽度，开奖号码部分需要单独计算
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //设置测量View的大小:宽度和高度
        setMeasuredDimension((int) ((10 * kjNumWidth) + (8 * mDeltaX)), (int) (showDatas.size() * mDeltaY));
        //取得测量之后当前View的宽度
        this.mWidth = getMeasuredWidth();
        //取得测量之后当前View的高度
        this.mHeight = getMeasuredHeight();
        //重新绘制,不重绘,不会生效;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**画表格线*/
        drawXYLine(canvas);
        /**开奖号码数据绘制*/
        drawKJNum(canvas);
        /**龙虎总分数据绘制*/
        drawDragonTiger(canvas);
    }

    /**
     * 绘制开奖号码
     * @param canvas
     */
    private void drawKJNum(Canvas canvas){
        mPaintText.setColor(getResources().getColor(R.color.white));
        //外层(期数)
        for (int i = 0; i < showDatas.size(); i++) {
            BJRacecarHistoryKJBean kjNumData = showDatas.get(i);
            String kjNum = kjNumData.getDrawCode();
            //拆分号码
            String[] kjNumArr=kjNum.split(",");
            //源图矩形位置left,top,right,bottom
            Rect src = new Rect();
            //目标位置left,top,right,bottom
            Rect dst = new Rect();
            //里层(单个开奖号码显示)
            for (int j = 0; j < kjNumArr.length; j++) {
                float[] xy = this.translateNumXY(i, j);
                src.left = 0;
                src.top = 0;
                src.right = kjNumWidth;
                src.bottom = mLongHuW;

                dst.left = (int) (xy[0] + this.kjNumWidth * 0.05f);
                dst.top = (int)(xy[1]+ this.mDeltaY * 0.1f);
                dst.right = (int) (dst.left + kjNumWidth * 0.85f);
                dst.bottom = (int) (dst.top + mDeltaY * 0.8f);
                RectF rf=new RectF(dst.left,dst.top,dst.right,dst.bottom);
                //修改画笔颜色
                setKJNumColor(mBallPaint , String.valueOf(kjNumArr[j]));
                //圆角矩形
                canvas.drawRoundRect(rf , 10 , 10 , mBallPaint);
                //文字(居中处理)
                Paint.FontMetrics fontMetrics=mPaintText.getFontMetrics();
                float distance=(fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
                float baseline= rf.centerY()+distance;
                mPaintText.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(String.valueOf(kjNumArr[j]), rf.centerX(), baseline, mPaintText);
            }
        }
    }

    /**
     * 绘制总分&龙虎数据
     * @param canvas
     */
    private void drawDragonTiger(Canvas canvas){
        mPaintText.setColor(getResources().getColor(R.color.txt_color666));
        for (int i = 0; i < showDatas.size(); i++) {
            BJRacecarHistoryKJBean kjDTData = showDatas.get(i);
            List<String> dtDataList = new ArrayList<>();
            dtDataList.add(kjDTData.getSumVal()+"");
            dtDataList.add(setDTData(kjDTData.getDaXiao()));
            dtDataList.add(setDTData(kjDTData.getDanShuang()));
            dtDataList.add(setDTData(kjDTData.getLonghu1()));
            dtDataList.add(setDTData(kjDTData.getLonghu2()));
            dtDataList.add(setDTData(kjDTData.getLonghu3()));
            dtDataList.add(setDTData(kjDTData.getLonghu4()));
            dtDataList.add(setDTData(kjDTData.getLonghu5()));

            Rect src = new Rect();
            Rect dst = new Rect();
            Rect allRace = new Rect();//原矩形(外层小方格)，用于设置背景颜色

            for (int j = 0; j < dtDataList.size(); j++) {
                float[] xy = this.translateDTxy(i, j);
                //重新定位蓝球在x轴的位置;在红球后面;
                xy[0]=xy[0] + 10*kjNumWidth;
                src.left = 0;
                src.top = 0;
                src.right = mItemH;
                src.bottom = mItemH;

                dst.left = (int) (xy[0] + this.mDeltaX * 0.05f);
                dst.top = (int)(xy[1]+ this.mDeltaY * 0.1f);
                dst.bottom = (int) (dst.top + mDeltaY * 0.8f);
                dst.right = (int) (dst.left + mDeltaX * 0.85f);
                RectF rf=new RectF(dst.left,dst.top,dst.right,dst.bottom);

                allRace.left = (int) (xy[0]);
                allRace.top = (int)(xy[1]);
                allRace.bottom = (int) (allRace.top + mDeltaY * 0.98f);
                allRace.right = (int) (allRace.left + mDeltaX * 0.98f);
                RectF rf2=new RectF(allRace.left,allRace.top,allRace.right,allRace.bottom);

                //修改背景画笔颜色
                if (i%2 == 0){
                    mBallPaint.setColor(getResources().getColor(R.color.white));
                }else{
                    mBallPaint.setColor(getResources().getColor(R.color.bg_white));
                }
                canvas.drawRect(rf2,mBallPaint);
                //文字(居中处理)
                Paint.FontMetrics fontMetrics=mPaintText.getFontMetrics();
                float distance=(fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
                float baseline= rf.centerY()+distance;
                mPaintText.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(String.valueOf(dtDataList.get(j)), rf.centerX(), baseline, mPaintText);
            }
        }
    }

    /***
     * 绘制X轴和Y轴的网格线
     * @param canvas 画布
     */
    private void drawXYLine(Canvas canvas) {
        //期号数:X轴;含顶部和底部的边角线;
        for (int i = 0;i <= showDatas.size();i ++) {
            canvas.drawLine(0, this.mDeltaY * i, this.mWidth, this.mDeltaY * i, mPaintLine);
        }
        //Y轴;含最左边的边角和最右边的边角线;
        for (int i = 0; i <= 8; i++) {
            if (i == 0) {
                canvas.drawLine(this.kjNumWidth * 10 , 0, this.kjNumWidth * 10, this.mHeight, mPaintLine);
            }else{
                canvas.drawLine((this.kjNumWidth * 10) + (this.mDeltaX * i) , 0, (this.kjNumWidth * 10) + (this.mDeltaX * i), this.mHeight, mPaintLine);
            }
        }
    }

    /**
     * 返回开奖号码坐标
     * @param rowIndex 行索引X轴;
     * @param valueIndex  当前中奖号码数字:相当于在哪个位置处:Y轴的索引.
     * @return
     */
    private float[] translateNumXY(int rowIndex, int valueIndex) {
        float[] xy = new float[2];
        xy[0] = this.kjNumWidth* valueIndex ;
        xy[1] = this.mDeltaY * rowIndex;
        return xy;
    }
    /**
     * 返回龙虎值坐标
     * @param rowIndex 行索引X轴;
     * @param valueIndex  当前中奖号码数字:相当于在哪个位置处:Y轴的索引.
     * @return
     */
    private float[] translateDTxy(int rowIndex, int valueIndex) {
        float[] xy = new float[2];
        xy[0] = this.mDeltaX* valueIndex ;
        xy[1] = this.mDeltaY * rowIndex;
        return xy;
    }

    /**
     * 获取当前屏幕的密度
     * @return
     */
    public int getScreenDenisty(){
        DisplayMetrics dm=getResources().getDisplayMetrics();
        return dm.densityDpi;
    }

    /**设置开奖号码背景色*/
    private void setKJNumColor(Paint paint , String num){
        switch (num){
            case "01":
                paint.setColor(getResources().getColor(R.color.num_1));
                break;
            case "02":
                paint.setColor(getResources().getColor(R.color.num_2));
                break;
            case "03":
                paint.setColor(getResources().getColor(R.color.num_3));
                break;
            case "04":
                paint.setColor(getResources().getColor(R.color.num_4));
                break;
            case "05":
                paint.setColor(getResources().getColor(R.color.num_5));
                break;
            case "06":
                paint.setColor(getResources().getColor(R.color.num_6));
                break;
            case "07":
                paint.setColor(getResources().getColor(R.color.num_7));
                break;
            case "08":
                paint.setColor(getResources().getColor(R.color.num_8));
                break;
            case "09":
                paint.setColor(getResources().getColor(R.color.num_9));
                break;
            case "10":
                paint.setColor(getResources().getColor(R.color.num_10));
                break;
        }
    }

    private String filterStr(String str){
        return str == null ? "" : str;
    }
    /**
     * 北京赛车历史开奖英文字符串
     * @param s
     * @param start
     * @param end
     */
    private String splitString(String s , int start , int end){
        return start < end ? s.substring(start , end) : "";
    }
    /**
     * 英==>中
     * @return
     */
    private String toChineseString(String str){
        String chineseStr = "";
        switch (str){
            case "small":
                chineseStr = "小";
                break;
            case "big":
                chineseStr = "大";
                break;
            case "odd":
                chineseStr = "单";
                break;
            case "even":
                chineseStr = "双";
                break;
            case "tiger":
                chineseStr = "虎";
                break;
            case "dragon":
                chineseStr = "龙";
                break;
        }
        return chineseStr;
    }

    /**
     * 设置龙虎数据值
     * @param s
     * @return
     */
    private String setDTData(String s){
        return  toChineseString(splitString(filterStr(s) , 13 , filterStr(s).length()));
    }
}
