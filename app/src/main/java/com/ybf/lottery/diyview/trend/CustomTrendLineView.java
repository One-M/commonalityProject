package com.ybf.lottery.diyview.trend;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.ybf.lottery.R;
import com.ybf.lottery.model.bean.bjscbasictrendbean.BasicTrendBean;
import com.ybf.lottery.model.bean.dragontigertrendbean.LengthwaysDataBean;
import com.ybf.lottery.model.bean.dragontigertrendbean.TrendShowBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XQyi on 2018/3/30.
 * Use: 绘制走势图的view
 */

public class CustomTrendLineView extends View{

    //表格线画笔
    private Paint mPaintLine = null;
    //文字画笔
    private Paint mPaintText = null;
    //数字背景色画笔
    private Paint mPaintNumBg = null;
    //走势连线的画笔
    private Paint mPaintTrrenLine = null;
    //表格背景画笔(遗漏分层)
    private Paint mPaintBg = null;

    /**绘制开奖号码的单元格宽度(十个开奖号码，后面单个号码显示宽度不一样，区分计算)*/
    private int kjNumWidth = 0;

    /**单个号码显示的宽度（默认网格宽度）*/
    private int singleNumWidth = 0;

    /**绘制的小单元格高度 h*/
    private int mItemH =0;

    /**网格的水平间距*/
    private float mDeltaX;

    /**网格垂直间距*/
    private float mDeltaY;
    //当前View的宽度
    private int mWidth;
    //用于号码背景设置时计算
    private float mBgX;

    //当前View的高度
    private int mHeight;

    //需要显示的全部数据
    private List<TrendShowBean> showDatas;
    //带遗漏分层状态的数据
    private List<List<LengthwaysDataBean>> mLengthData;
    //纵向(列)条数 ps:除开奖号码外的等框列数
    private int NumY;
    private int mTrendType;//走势类型(用于控制走势数据和view绘制计算) [基本走势:0, 龙虎走势:1]
    private boolean mOmitShow;//是否显示遗漏
    private boolean mTrendLineType; // 是否显示折线
    private boolean mCutOffLine; // 是否显示分割线
    private boolean mLengways;//遗漏分层

    public CustomTrendLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        kjNumWidth=getResources().getDimensionPixelSize(R.dimen.kj_num_item_w);
        mItemH =getResources().getDimensionPixelSize(R.dimen.trend_ball_wh);
        singleNumWidth =getResources().getDimensionPixelSize(R.dimen.kj_history_itemw);
        mBgX = getResources().getDimensionPixelSize(R.dimen.bjsc_statistic_title1_w);
        initSource();
        showDatas = new ArrayList<>();
    }

    public void setShowDatas(List<TrendShowBean> trendBeans , List<List<LengthwaysDataBean>> lengthData, int trendType ,
                             boolean omitShow , boolean trendLineType ,boolean lengways, boolean cutOffLine){
        this.showDatas.clear();
        this.showDatas = trendBeans;
        this.mTrendType = trendType;
        this.mLengthData = lengthData;
        this.mOmitShow = omitShow;
        this.mTrendLineType = trendLineType;
        this.mLengways = lengways;
        this.mCutOffLine = cutOffLine;

        switch (mTrendType){
            case 0:
                NumY = 100;
                break;
            case 1:
                NumY = 22;
                break;
            case 2:
                NumY = 22;
                break;
        }
        requestLayout();
    }

    /**初始化资源*/
    private void initSource(){
        int dpValue = getScreenDenisty();
        //网格线画笔
        mPaintLine=new Paint();
        mPaintLine.setColor(getResources().getColor(R.color.form_line_color));
        mPaintLine.setAntiAlias(true);
        mPaintLine.setStrokeWidth(dpValue*0.6f/120);
        //文字画笔
        mPaintText=new Paint();
        mPaintText.setTextSize((dpValue*12/150));
        mPaintText.setAntiAlias(true);
        mPaintText.setStrokeWidth(2f);

        //数字背景色画笔
        mPaintNumBg = new Paint();
        mPaintNumBg.setAntiAlias(true);

        //表格背景色画笔
        mPaintBg = new Paint();
        mPaintBg.setAntiAlias(true);

        //走势连线画笔
        mPaintTrrenLine=new Paint();
        mPaintTrrenLine.setAntiAlias(true);
        mPaintTrrenLine.setStrokeWidth(dpValue*0.6f/80);

        //设置单个网格的水平和垂直间距
        this.mDeltaY= mItemH *2f;
        this.mDeltaX= singleNumWidth;//网格初始宽度设为默认宽度，开奖号码部分需要单独计算
    }
    //设置画笔颜色
    private void setPaintColor(Paint paint , int currType){
        switch (currType){
            case 0:
                paint.setColor(getResources().getColor(R.color.basic_trend_line_color1));
                break;
            case 1:
                paint.setColor(getResources().getColor(R.color.basic_trend_line_color2));
                break;
            case 2:
                paint.setColor(getResources().getColor(R.color.basic_trend_line_color3));
                break;
            case 3:
                paint.setColor(getResources().getColor(R.color.basic_trend_line_color4));
                break;
            case 4:
                paint.setColor(getResources().getColor(R.color.basic_trend_line_color5));
                break;
            case 5:
                paint.setColor(getResources().getColor(R.color.basic_trend_line_color1));
                break;
            case 6:
                paint.setColor(getResources().getColor(R.color.basic_trend_line_color2));
                break;
            case 7:
                paint.setColor(getResources().getColor(R.color.basic_trend_line_color3));
                break;
            case 8:
                paint.setColor(getResources().getColor(R.color.basic_trend_line_color4));
                break;
            case 9:
                paint.setColor(getResources().getColor(R.color.basic_trend_line_color5));
                break;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int)((kjNumWidth*10) + (mDeltaX * NumY)) , (int)(showDatas.size() * mDeltaY));
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawKJNum(canvas);//开奖号码
        drawYLbg(canvas);//遗漏分层
        drawSingleNum(canvas);//区域数据
        drawXYLine(canvas);//网格线
        drawNumLine(canvas);//走势连线
    }
    /**XY轴网格线绘制*/
    private void drawXYLine(Canvas canvas){
        //绘制X轴
        for (int i = 0; i < showDatas.size(); i++) {
            if (mCutOffLine) {
                if (i%5 == 0) {
                    mPaintLine.setStrokeWidth(getScreenDenisty()*0.6f/50);
                }else{
                    mPaintLine.setStrokeWidth(getScreenDenisty()*0.6f/120);
                }
            }
            canvas.drawLine(0 , this.mDeltaY*i , mWidth , this.mDeltaY*i , mPaintLine);
        }
        //绘制Y轴
        for (int i = 0; i <= NumY ; i++) {
            if (i == 0) {
                canvas.drawLine(kjNumWidth*10 , 0 , kjNumWidth*10 , mHeight , mPaintLine);
            }else{
                canvas.drawLine((kjNumWidth*10 + mDeltaX*i) , 0 , (kjNumWidth*10 + mDeltaX*i) , mHeight , mPaintLine);
            }
        }
    }

    /**开奖号码绘制*/
    private void drawKJNum(Canvas canvas){
        mPaintText.setColor(getResources().getColor(R.color.statistic_percentage_color));
        for (int i = 0; i < showDatas.size(); i++) {
            TrendShowBean zsBean = showDatas.get(i);
            String kjNumStr = zsBean.getDRAWCODE();
            String[] numStrAttay = kjNumStr.split(",");
            //初始位置
            Rect initialRect = new Rect();
            //最终位置
            Rect resultRect =  new Rect();

            for (int j = 0; j < numStrAttay.length; j++) {
                float[] xy = translateNumXY(i , j);
                initialRect.left = 0;
                initialRect.top = 0;
                initialRect.right = kjNumWidth;
                initialRect.bottom = (int) mDeltaY;

                resultRect.left = (int) (xy[0]+kjNumWidth* 0.05f);
                resultRect.top = (int) (xy[1] + mDeltaY*0.1f);
                resultRect.right = (int) (resultRect.left + kjNumWidth*0.85f);
                resultRect.bottom = (int) (resultRect.top + mDeltaY*0.8f);
                RectF rf = new RectF(resultRect.left , resultRect.top , resultRect.right , resultRect.bottom);
                //文字(居中处理)
                Paint.FontMetrics fontMetrics=mPaintText.getFontMetrics();
                float distance=(fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
                float baseline= rf.centerY()+distance;
                mPaintText.setTextAlign(Paint.Align.CENTER);
                canvas.drawText(String.valueOf(numStrAttay[j]) , rf.centerX() , baseline , mPaintText);
            }
        }
    }
    /**遗漏分层*/
    private void drawYLbg(Canvas canvas){
        if (mLengways){
            for (int i = 0; i < mLengthData.size(); i++){
                List<LengthwaysDataBean> lengthwaysDataBeans = mLengthData.get(i);
                //用于表格背景色(遗漏分层)
                Rect allRace =  new Rect();
                float filstXY[] = translateSingleNumXY(0 , 0);
                filstXY[0] = filstXY[0] + kjNumWidth*10 + mDeltaX*10*i;
                for (int j = 0; j < lengthwaysDataBeans.size(); j++){
                    float[] xy = translateSingleNumXY(j , i);
                    xy[0]=xy[0] + 10*kjNumWidth;

                    allRace.left = (int) (xy[0]);
                    allRace.top = (int)(xy[1]);
                    allRace.right = (int) (allRace.left + mDeltaX);
                    allRace.bottom = (int) (allRace.top + mDeltaY);
                    RectF rfBg=new RectF(allRace.left,allRace.top,allRace.right,allRace.bottom);

                    LengthwaysDataBean dataBean = lengthwaysDataBeans.get(j);
                    if (dataBean.isShowYl()) {
                        //遗漏分层(表格背景色)
                        mPaintBg.setColor(getResources().getColor(R.color.bjsc_ylfc_color));
                        canvas.drawRect(rfBg , mPaintBg);
                    }
                }
            }
        }
    }
    /**绘制1-10区域数据*/
    private void drawSingleNum(Canvas canvas){
        for (int i = 0; i < showDatas.size(); i++) {
            TrendShowBean zsBean = showDatas.get(i);
//            List<Integer> zsDataList = getSingleData(zsBean);
            List<Integer> zsDataList = zsBean.getZsData();
            //初始位置
            Rect initialRect = new Rect();
            //最终位置
            Rect resultRect =  new Rect();
            //用于数字背景色
            Rect allNumRace =  new Rect();

            for (int j = 0; j < zsDataList.size(); j++) {
                float[] xy = translateSingleNumXY(i , j);
                //重新定位x轴的位置;在开奖号码后面;
                xy[0]=xy[0] + 10*kjNumWidth;
                initialRect.left = 0;
                initialRect.top = 0;
                initialRect.right = mItemH;
                initialRect.bottom = (int) mDeltaY;

                resultRect.left = (int) (xy[0]+mDeltaX* 0.05f);
                resultRect.top = (int) (xy[1] + mDeltaY*0.1f);
                resultRect.right = (int) (resultRect.left + mDeltaX*0.85f);
                resultRect.bottom = (int) (resultRect.top + mDeltaY*0.8f);
                RectF rf=new RectF(resultRect.left,resultRect.top,resultRect.right,resultRect.bottom);

                allNumRace.left = (int) (xy[0]+mDeltaX* 0.15f);
                allNumRace.top = (int)(xy[1]+ mDeltaY*0.15f);
                allNumRace.right = (int) (allNumRace.left + mDeltaX * 0.65f);
                allNumRace.bottom = (int) (allNumRace.top + mDeltaY * 0.75f);
                RectF rf2=new RectF(allNumRace.left,allNumRace.top,allNumRace.right,allNumRace.bottom);

//                if (zsDataList.get(j) == 0) {
//                    //画圆
//                    setBgPaintColor(j);
//                    canvas.drawOval(rf2 , mPaintNumBg);
//                    mPaintText.setColor(getResources().getColor(R.color.white));
//                }else{
//                    mPaintText.setColor(getResources().getColor(R.color.txt_color666));
//                }

                setNumData(canvas , zsDataList , j ,rf2 , rf);
//                //文字(居中处理)
//                Paint.FontMetrics fontMetrics=mPaintText.getFontMetrics();
//                float distance=(fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
//                float baseline= rf.centerY()+distance;
//                mPaintText.setTextAlign(Paint.Align.CENTER);
//                switch (mTrendType){
//                    case 0:
//                        String showValue = (zsDataList.get(j) == 0) ? (j%10 +1)+"" : (mOmitShow ? zsDataList.get(j)+"" : "");
//                        canvas.drawText(showValue, rf.centerX(), baseline, mPaintText);
//                        break;
//                    case 1:
//                        String dtStr = "";
//                        if ( zsDataList.get(j) == 0) {
//                            dtStr = (j == (zsDataList.size()-2)) ? "龙" : (j == (zsDataList.size()-1) ? "虎" : (j%10 +1)+"");
//                        }else{
//                            dtStr = mOmitShow ? zsDataList.get(j)+"" : "";
//                        }
//                        canvas.drawText(dtStr, rf.centerX(), baseline, mPaintText);
//                        break;
//                    case 2:
//                        String sumStr = "";
//                        if ( zsDataList.get(j) == 0) {
//                            sumStr = (j == zsDataList.size()-4) ? "大" : ((j == zsDataList.size()-3) ? "小" : ((j == zsDataList.size()-2) ?
//                                    "单" : ((j == zsDataList.size()-1) ? "双" : (j%18 +3)+"")));
//                        }else{
//                            sumStr = mOmitShow ? zsDataList.get(j)+"" : "";
//                        }
//                        canvas.drawText(sumStr, rf.centerX(), baseline, mPaintText);
//                        break;
//                }

            }
        }
    }

    /**
     * 走势数据显示
     * @param canvas
     * @param zsList 横向数据集
     * @param pos 当前位置
     * @param rfBg 背景绘制的RectF
     * @param rfTxt 文字绘制的RectF
     */
    private void setNumData(Canvas canvas , List<Integer> zsList , int pos ,RectF rfBg , RectF rfTxt){
        //画圆
        if (zsList.get(pos) == 0) {
            setBgPaintColor(pos);
            canvas.drawOval(rfBg , mPaintNumBg);
            mPaintText.setColor(getResources().getColor(R.color.white));
        }else{
            mPaintText.setColor(getResources().getColor(R.color.txt_color666));
        }

        //文字(居中处理)
        Paint.FontMetrics fontMetrics=mPaintText.getFontMetrics();
        float distance=(fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
        float baseline= rfTxt.centerY()+distance;
        mPaintText.setTextAlign(Paint.Align.CENTER);

        switch (mTrendType){
            case 0:
                String showValue = (zsList.get(pos) == 0) ? (pos%10 +1)+"" : (mOmitShow ? zsList.get(pos)+"" : "");
                canvas.drawText(showValue, rfTxt.centerX(), baseline, mPaintText);
                break;
            case 1:
                String dtStr = "";
                if ( zsList.get(pos) == 0) {
                    dtStr = (pos == (zsList.size()-2)) ? "龙" : (pos == (zsList.size()-1) ? "虎" : (pos%10 +1)+"");
                }else{
                    dtStr = mOmitShow ? zsList.get(pos)+"" : "";
                }
                canvas.drawText(dtStr, rfTxt.centerX(), baseline, mPaintText);
                break;
            case 2:
                String sumStr = "";
                if ( zsList.get(pos) == 0) {
                    sumStr = (pos == zsList.size()-4) ? "大" : ((pos == zsList.size()-3) ? "小" : ((pos == zsList.size()-2) ?
                            "单" : ((pos == zsList.size()-1) ? "双" : (pos%18 +3)+"")));
                }else{
                    sumStr = mOmitShow ? zsList.get(pos)+"" : "";
                }
                canvas.drawText(sumStr, rfTxt.centerX(), baseline, mPaintText);
                break;
        }
    }
    private void setBgPaintColor(int position){
        switch (mTrendType){
            case 0:
                setPaintColor(mPaintNumBg, position/10);
                break;
            case 1:
                setPaintColor(mPaintNumBg, position/10);
                break;
            case 2:
                if (position < 18) {
                    setPaintColor(mPaintNumBg, 0);
                }else{
                    setPaintColor(mPaintNumBg, (position - 18)/2 + 1);
                }
                break;
        }
    }

    /**数据封装,获得走势连线的数值集合*/
    private List<List<Integer>> getTrendLineNumList(){
        List<List<Integer>> lineNumList = new ArrayList<>();
        List<Integer> listList1 = new ArrayList<>();
        List<Integer> listList2 = new ArrayList<>();
        List<Integer> listList3 = new ArrayList<>();
        List<Integer> listList4 = new ArrayList<>();
        List<Integer> listList5 = new ArrayList<>();
        List<Integer> listList6 = new ArrayList<>();
        List<Integer> listList7 = new ArrayList<>();
        List<Integer> listList8 = new ArrayList<>();
        List<Integer> listList9 = new ArrayList<>();
        List<Integer> listList10 = new ArrayList<>();

        switch (mTrendType){
            case 0:
                for (int i = 0; i < showDatas.size(); i++) {
                    TrendShowBean zsBean = showDatas.get(i);
                    List<Integer> zsDataList = zsBean.getZsData();
                    for (int j = 0; j < zsDataList.size(); j++) {
                        if (j < 10) {
                            if (zsDataList.get(j) == 0) {listList1.add(j +1);}
                        }else if (10 <= j && j < 20) {
                            if (zsDataList.get(j) == 0) {listList2.add(j%10 +1);}
                        }else if (20 <= j && j < 30) {
                            if (zsDataList.get(j) == 0) {listList3.add(j%10 +1);}
                        }else if (30 <= j && j < 40) {
                            if (zsDataList.get(j) == 0) {listList4.add(j%10 +1);}
                        }else if (40 <= j && j < 50) {
                            if (zsDataList.get(j) == 0) {listList5.add(j%10 +1);}
                        }else if (50 <= j && j < 60) {
                            if (zsDataList.get(j) == 0) {listList6.add(j%10 +1);}
                        }else if (60 <= j && j < 70) {
                            if (zsDataList.get(j) == 0) {listList7.add(j%10 +1);}
                        }else if (70 <= j && j < 80) {
                            if (zsDataList.get(j) == 0) {listList8.add(j%10 +1);}
                        }else if (80 <= j && j < 90) {
                            if (zsDataList.get(j) == 0) {listList9.add(j%10 +1);}
                        }else if (j >= 90) {
                            if (zsDataList.get(j) == 0) {listList10.add(j%10 +1);}
                        }
                    }
                }
                lineNumList.add(listList1);
                lineNumList.add(listList2);
                lineNumList.add(listList3);
                lineNumList.add(listList4);
                lineNumList.add(listList5);
                lineNumList.add(listList6);
                lineNumList.add(listList7);
                lineNumList.add(listList8);
                lineNumList.add(listList9);
                lineNumList.add(listList10);
                break;
            case 1:
                for (int i = 0; i < showDatas.size(); i++) {
                    TrendShowBean zsBean = showDatas.get(i);
                    List<Integer> zsDataList = zsBean.getZsData();
                    for (int j = 0; j < zsDataList.size(); j++) {
                        if (j < 10) {
                            if (zsDataList.get(j) == 0) {listList1.add(j +1);}
                        }else if (10 <= j && j < 20) {
                            if (zsDataList.get(j) == 0) {listList2.add(j%10 +1);}
                        }else if (20 <= j && j < 30) {
                            if (zsDataList.get(j) == 0) {listList3.add(j%10 +1);}
                        }
                    }
                }
                lineNumList.add(listList1);
                lineNumList.add(listList2);
                lineNumList.add(listList3);
                break;
            case 2:
                for (int i = 0; i < showDatas.size(); i++) {
                    TrendShowBean zsBean = showDatas.get(i);
                    List<Integer> zsDataList = zsBean.getZsData();
                    for (int j = 0; j < zsDataList.size(); j++) {
                        if (j < 18) {
                            if (zsDataList.get(j) == 0) {listList1.add(j +1);}
                        }else if (18 <= j && j < 20) {
                            if (zsDataList.get(j) == 0) {listList2.add(j-18 +1);}
                        }else if (20 <= j && j < 22) {
                            if (zsDataList.get(j) == 0) {listList3.add(j-20 +1);}
                        }
                    }
                }
                lineNumList.add(listList1);
                lineNumList.add(listList2);
                lineNumList.add(listList3);
                break;
        }
        return lineNumList;
    }
    /**绘制数字连线*/
    private void drawNumLine(Canvas canvas){
        if (mTrendLineType) {
            switch (mTrendType){
                case 0:
                    linePaint(canvas);
                    break;
                case 1:
                    linePaint(canvas);
                    break;
                case 2:
                    sumValueLinePaint(canvas);
                    break;
            }
//            List<List<Integer>> trendLindNum = getTrendLineNumList();
//            for (int i = 0; i < trendLindNum.size(); i++) {
//                setPaintColor(mPaintTrrenLine , i);
//                List<Integer> numList = trendLindNum.get(i);
//                float filstXY[] = translateSingleNumXY(0 , numList.get(0) - 1);
//                filstXY[0] = filstXY[0] + kjNumWidth*10 + mDeltaX*10*i;
//                for (int j = 1; j < numList.size(); j++) {
//                    float[] currXY = translateSingleNumXY(j , numList.get(j)-1);
//                    currXY[0] = currXY[0] + kjNumWidth*10 + mDeltaX*10*i;
//                    canvas.drawLine(filstXY[0]+mDeltaX*0.5f , filstXY[1] + mDeltaY*0.7f ,
//                            currXY[0] + mDeltaX*0.5f , currXY[1] + mDeltaY*0.3f , mPaintTrrenLine);
//                    filstXY[0] = currXY[0];
//                    filstXY[1] = currXY[1];
//                }
//            }
        }
    }
    /**折线绘制(走势 10格折线)*/
    private void linePaint(Canvas canvas){
        List<List<Integer>> trendLindNum = getTrendLineNumList();
        for (int i = 0; i < trendLindNum.size(); i++) {
            setPaintColor(mPaintTrrenLine , i);
            List<Integer> numList = trendLindNum.get(i);
            float filstXY[] = translateSingleNumXY(0 , numList.get(0) - 1);
            filstXY[0] = filstXY[0] + kjNumWidth*10 + mDeltaX*10*i;
            for (int j = 1; j < numList.size(); j++) {
                float[] currXY = translateSingleNumXY(j , numList.get(j)-1);
                currXY[0] = currXY[0] + kjNumWidth*10 + mDeltaX*10*i;
                canvas.drawLine(filstXY[0]+mDeltaX*0.5f , filstXY[1] + mDeltaY*0.7f ,
                        currXY[0] + mDeltaX*0.5f , currXY[1] + mDeltaY*0.3f , mPaintTrrenLine);
                filstXY[0] = currXY[0];
                filstXY[1] = currXY[1];
            }
        }
    }
    /**冠亚和值折线*/
    private void sumValueLinePaint(Canvas canvas){
        List<List<Integer>> trendLindNum = getTrendLineNumList();
        for (int i = 0; i < trendLindNum.size(); i++) {
            setPaintColor(mPaintTrrenLine , i);
            List<Integer> numList = trendLindNum.get(i);
            float filstXY[] = translateSingleNumXY(0 , numList.get(0) - 1);
            if (i == 0) {
                filstXY[0] = filstXY[0] + kjNumWidth*10 + mDeltaX*18*i;
            }else{
                filstXY[0] = filstXY[0] + kjNumWidth*10 + mDeltaX*18 + mDeltaX*2*(i-1);
            }
            for (int j = 1; j < numList.size(); j++) {
                float[] currXY = translateSingleNumXY(j , numList.get(j)-1);

                currXY[0] = (i == 0) ? currXY[0] + kjNumWidth*10 : currXY[0] + kjNumWidth*10 + mDeltaX*18 + mDeltaX*2*(i-1);

                canvas.drawLine(filstXY[0]+mDeltaX*0.5f , filstXY[1] + mDeltaY*0.7f ,
                        currXY[0] + mDeltaX*0.5f , currXY[1] + mDeltaY*0.3f , mPaintTrrenLine);
                filstXY[0] = currXY[0];
                filstXY[1] = currXY[1];
            }
        }
    }

    /**
     * 获取当前屏幕的密度
     * @return
     */
    public int getScreenDenisty(){
        DisplayMetrics dm=getResources().getDisplayMetrics();
        return dm.densityDpi;
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
     * 返回单个号码显示的值坐标
     * @param XIndex 行索引X轴;
     * @param YIndex  当前中奖号码数字:相当于在哪个位置处:Y轴的索引.
     * @return
     */
    private float[] translateSingleNumXY(int YIndex, int XIndex) {
        float[] xy = new float[2];
        xy[0] = this.mDeltaX* XIndex ;
        xy[1] = this.mDeltaY * YIndex;
        return xy;
    }
}
