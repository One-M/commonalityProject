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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XQyi on 2018/3/30.
 * Use: 绘制走势图的view
 */

public class CustomTrendView extends View{

    //表格线画笔
    private Paint mPaintLine = null;
    //文字画笔
    private Paint mPaintText = null;
    //数字背景色画笔
    private Paint mPaintBg = null;
    //走势连线的画笔
    private Paint mPaintTrrenLine = null;

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
    private List<BasicTrendBean.ZsBean> showDatas;
    //纵向(列)条数 ps:除开奖号码外的等框列数
    private int NumY = 100;

    public CustomTrendView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        kjNumWidth=getResources().getDimensionPixelSize(R.dimen.kj_num_item_w);
        mItemH =getResources().getDimensionPixelSize(R.dimen.trend_ball_wh);
        singleNumWidth =getResources().getDimensionPixelSize(R.dimen.kj_history_itemw);
        mBgX = getResources().getDimensionPixelSize(R.dimen.bjsc_statistic_title1_w);
        initSource();
        showDatas = new ArrayList<>();
    }

    public void setShowDatas(List<BasicTrendBean.ZsBean> trendBeans){
        this.showDatas.clear();
        this.showDatas = trendBeans;
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

        //背景色画笔
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
        drawXYLine(canvas);
        drawKJNum(canvas);
        drawSingleNum(canvas);
        drawNumLine(canvas);
    }
    /**XY轴网格线绘制*/
    private void drawXYLine(Canvas canvas){
        //绘制X轴
        for (int i = 0; i < showDatas.size(); i++) {
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
            BasicTrendBean.ZsBean zsBean = showDatas.get(i);
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

    /**绘制1-10区域数据*/
    private void drawSingleNum(Canvas canvas){
        for (int i = 0; i < showDatas.size(); i++) {
            BasicTrendBean.ZsBean zsBean = showDatas.get(i);
            List<Integer> zsDataList = getSingleData(zsBean);
            //初始位置
            Rect initialRect = new Rect();
            //最终位置
            Rect resultRect =  new Rect();
            //用于背景色
            Rect allRace =  new Rect();
            for (int j = 0; j < zsDataList.size(); j++) {
                float[] xy = translateSingleNumXY(i , j);
                //重新定位蓝球在x轴的位置;在红球后面;
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

                allRace.left = (int) (xy[0]+mDeltaX* 0.15f);
                allRace.top = (int)(xy[1]+ mDeltaY*0.15f);
                allRace.right = (int) (allRace.left + mDeltaX * 0.65f);
                allRace.bottom = (int) (allRace.top + mDeltaY * 0.75f);
                RectF rf2=new RectF(allRace.left,allRace.top,allRace.right,allRace.bottom);

                if (zsDataList.get(j) == 0) {
                    //画圆
                    setPaintColor(mPaintBg , j/10);
                    canvas.drawOval(rf2 , mPaintBg);
                    mPaintText.setColor(getResources().getColor(R.color.white));
                }else{
                    mPaintText.setColor(getResources().getColor(R.color.txt_color666));
                }
                //文字(居中处理)
                Paint.FontMetrics fontMetrics=mPaintText.getFontMetrics();
                float distance=(fontMetrics.bottom - fontMetrics.top)/2 - fontMetrics.bottom;
                float baseline= rf.centerY()+distance;
                mPaintText.setTextAlign(Paint.Align.CENTER);
                int showValue = zsDataList.get(j) == 0 ? j%10 +1 : zsDataList.get(j);
                canvas.drawText(String.valueOf(showValue), rf.centerX(), baseline, mPaintText);
            }
        }
    }

    /**1-10显示数据封装*/
    private List<Integer> getSingleData(BasicTrendBean.ZsBean zsData){
        List<Integer> zsList = new ArrayList<>();
        //N11
        zsList.add(zsData.getN11());
        zsList.add(zsData.getN12());
        zsList.add(zsData.getN13());
        zsList.add(zsData.getN14());
        zsList.add(zsData.getN15());
        zsList.add(zsData.getN16());
        zsList.add(zsData.getN17());
        zsList.add(zsData.getN18());
        zsList.add(zsData.getN19());
        zsList.add(zsData.getN110());
        //N21
        zsList.add(zsData.getN21());
        zsList.add(zsData.getN22());
        zsList.add(zsData.getN23());
        zsList.add(zsData.getN24());
        zsList.add(zsData.getN25());
        zsList.add(zsData.getN26());
        zsList.add(zsData.getN27());
        zsList.add(zsData.getN28());
        zsList.add(zsData.getN29());
        zsList.add(zsData.getN210());
        //31
        zsList.add(zsData.getN31());
        zsList.add(zsData.getN32());
        zsList.add(zsData.getN33());
        zsList.add(zsData.getN34());
        zsList.add(zsData.getN35());
        zsList.add(zsData.getN36());
        zsList.add(zsData.getN37());
        zsList.add(zsData.getN38());
        zsList.add(zsData.getN39());
        zsList.add(zsData.getN310());
        //41
        zsList.add(zsData.getN41());
        zsList.add(zsData.getN42());
        zsList.add(zsData.getN43());
        zsList.add(zsData.getN44());
        zsList.add(zsData.getN45());
        zsList.add(zsData.getN46());
        zsList.add(zsData.getN47());
        zsList.add(zsData.getN48());
        zsList.add(zsData.getN49());
        zsList.add(zsData.getN410());
        //51
        zsList.add(zsData.getN51());
        zsList.add(zsData.getN52());
        zsList.add(zsData.getN53());
        zsList.add(zsData.getN54());
        zsList.add(zsData.getN55());
        zsList.add(zsData.getN56());
        zsList.add(zsData.getN57());
        zsList.add(zsData.getN58());
        zsList.add(zsData.getN59());
        zsList.add(zsData.getN510());
        //61
        zsList.add(zsData.getN61());
        zsList.add(zsData.getN62());
        zsList.add(zsData.getN63());
        zsList.add(zsData.getN64());
        zsList.add(zsData.getN65());
        zsList.add(zsData.getN66());
        zsList.add(zsData.getN67());
        zsList.add(zsData.getN68());
        zsList.add(zsData.getN69());
        zsList.add(zsData.getN610());
        //71
        zsList.add(zsData.getN71());
        zsList.add(zsData.getN72());
        zsList.add(zsData.getN73());
        zsList.add(zsData.getN74());
        zsList.add(zsData.getN75());
        zsList.add(zsData.getN76());
        zsList.add(zsData.getN77());
        zsList.add(zsData.getN78());
        zsList.add(zsData.getN79());
        zsList.add(zsData.getN710());
        //81
        zsList.add(zsData.getN81());
        zsList.add(zsData.getN82());
        zsList.add(zsData.getN83());
        zsList.add(zsData.getN84());
        zsList.add(zsData.getN85());
        zsList.add(zsData.getN86());
        zsList.add(zsData.getN87());
        zsList.add(zsData.getN88());
        zsList.add(zsData.getN89());
        zsList.add(zsData.getN810());
        //91
        zsList.add(zsData.getN91());
        zsList.add(zsData.getN92());
        zsList.add(zsData.getN93());
        zsList.add(zsData.getN94());
        zsList.add(zsData.getN95());
        zsList.add(zsData.getN96());
        zsList.add(zsData.getN97());
        zsList.add(zsData.getN98());
        zsList.add(zsData.getN99());
        zsList.add(zsData.getN910());
        //101
        zsList.add(zsData.getN101());
        zsList.add(zsData.getN102());
        zsList.add(zsData.getN103());
        zsList.add(zsData.getN104());
        zsList.add(zsData.getN105());
        zsList.add(zsData.getN106());
        zsList.add(zsData.getN107());
        zsList.add(zsData.getN108());
        zsList.add(zsData.getN109());
        zsList.add(zsData.getN1010());
        return zsList;
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
        for (int i = 0; i < showDatas.size(); i++) {
            BasicTrendBean.ZsBean zsBean = showDatas.get(i);
            List<Integer> zsDataList = getSingleData(zsBean);
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
        return lineNumList;
    }
    /**绘制数字连线*/
    private void drawNumLine(Canvas canvas){
        List<List<Integer>> trendLindNum = getTrendLineNumList();
        for (int i = 0; i < trendLindNum.size(); i++) {
            setPaintColor(mPaintTrrenLine , i);
            List<Integer> numList = getTrendLineNumList().get(i);
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
