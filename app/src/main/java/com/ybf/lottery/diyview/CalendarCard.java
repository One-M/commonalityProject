package com.ybf.lottery.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import com.ybf.lottery.R;
import com.ybf.lottery.utils.CustomDate;
import com.ybf.lottery.utils.DateUtil;

/**
 * Created by XQyi on 2018/3/13.
 * Use: 自定义日历卡
 */

public class CalendarCard extends View {
    private static final int TOTAL_COL = 7; // 7列
    private static final int TOTAL_ROW = 5; // 6行

    private Paint mCirclePaint; // 绘制圆形的画笔
    private Paint mTextPaint; // 绘制文本的画笔
//    private int mViewWidth = getResources().getDimensionPixelSize(R.dimen.window_width); // 视图的宽度
//    private int mViewHeight = getResources().getDimensionPixelSize(R.dimen.window_height); // 视图的高度
    private int mViewWidth;
    private int mViewHeight;
    private int mCellSpace; // 单元格间距
    private Row rows[] = new Row[TOTAL_ROW]; // 行数组，每个元素代表一行
    private static CustomDate mShowDate; // 自定义的日期，包括year,month,day
    private OnCellClickListener mCellClickListener; // 单元格点击回调事件
    private int touchSlop; //
    private boolean callBackCellSpace;
    private CustomDate todayDate;//当天；
    private CustomDate currClickDate;//当前所选年月日；
    private CustomDate mShowDateYM;//显示的年月

    private Cell mClickCell;
    private float mDownX;
    private float mDownY;

    /**
     * 单元格点击的回调接口
     *
     * @author wuwenjie
     *
     */
    public interface OnCellClickListener {
        void clickDate(CustomDate date); // 回调点击的日期

        void changeDate(CustomDate date); // 回调滑动ViewPager改变的日期
    }

    public CalendarCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CalendarCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CalendarCard(Context context) {
        super(context);
        init(context);
    }

    /**
     *
     * @param context
     * @param listener
     * @param showDateYM 显示的年月数据
     * @param currClickDate 所选中的年月日数据
     */
    public CalendarCard(Context context, OnCellClickListener listener ,CustomDate showDateYM , CustomDate currClickDate) {
        super(context);
        this.mCellClickListener = listener;
        this.mShowDateYM = showDateYM;
        this.currClickDate = currClickDate;
        init(context);
    }

    private void init(Context context) {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(context.getResources().getColor(R.color.colorPrimary));
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

        initDate();
    }

    private void initDate() {
        todayDate = new CustomDate();//获得当天日期，便于判断所选日期是否可选
        mShowDate = mShowDateYM;
        fillDate(currClickDate);//
    }
//    private CustomDate sxDate;//记录所选日期位置(处理未来日期点击问题)
    private void fillDate(CustomDate clickDate) {

        /*if ((clickDate.year == todayDate.year && clickDate.month == todayDate.month && clickDate.day <= todayDate.day)
                || (clickDate.year == todayDate.year && clickDate.month < todayDate.month)
                || (clickDate.year < todayDate.year) ) {
//            sxDate = clickDate;
        }*/

        int monthDay = DateUtil.getCurrentMonthDay(); // 今天
        int lastMonthDays = DateUtil.getMonthDays(mShowDate.year,
                mShowDate.month - 1); // 上个月的天数
        int currentMonthDays = DateUtil.getMonthDays(mShowDate.year,
                mShowDate.month); // 当前月的天数
        int firstDayWeek = DateUtil.getWeekDayFromDate(mShowDate.year,
                mShowDate.month);
        boolean isCurrentMonth = false;
        if (DateUtil.isCurrentMonth(mShowDate)) {
            isCurrentMonth = true;
        }
        int day = 0;
        for (int j = 0; j < TOTAL_ROW; j++) {
            rows[j] = new Row(j);
            for (int i = 0; i < TOTAL_COL; i++) {
                int position = i + j * TOTAL_COL; // 单元格位置
                // 这个月的
                if (position >= firstDayWeek
                        && position < firstDayWeek + currentMonthDays) {
                    day++;
                    rows[j].cells[i] = new Cell(CustomDate.modifiDayForObject(
                            mShowDate, day), State.CURRENT_MONTH_DAY, i, j , clickDate);
                    // 今天
                    if (isCurrentMonth && day == monthDay ) {
                        CustomDate date = CustomDate.modifiDayForObject(mShowDate, day);
                        rows[j].cells[i] = new Cell(date, State.TODAY, i, j , clickDate);
                    }

                    if (isCurrentMonth && day > monthDay) { // 如果比这个月的今天要大，表示还没到
                        rows[j].cells[i] = new Cell(
                                CustomDate.modifiDayForObject(mShowDate, day),
                                State.UNREACH_DAY, i, j , clickDate);
                    }

                    // 过去一个月
                } else if (position < firstDayWeek) {
                    rows[j].cells[i] = new Cell(new CustomDate(mShowDate.year,
                            mShowDate.month - 1, lastMonthDays
                            - (firstDayWeek - position - 1)),
                            State.PAST_MONTH_DAY, i, j , clickDate);
                    // 下个月
                } else if (position >= firstDayWeek + currentMonthDays) {
                    rows[j].cells[i] = new Cell((new CustomDate(mShowDate.year,
                            mShowDate.month + 1, position - firstDayWeek
                            - currentMonthDays + 1)),
                            State.NEXT_MONTH_DAY, i, j , clickDate);
                }
            }
        }
        mCellClickListener.changeDate(mShowDate);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < TOTAL_ROW; i++) {
            if (rows[i] != null) {
                rows[i].drawCells(canvas);
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mViewWidth = w;
        mViewHeight = h;
        mCellSpace = Math.min(mViewHeight / TOTAL_ROW, mViewWidth / TOTAL_COL);
        if (!callBackCellSpace) {
            callBackCellSpace = true;
        }
        mTextPaint.setTextSize(mCellSpace / 3);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = event.getX();
                mDownY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                float disX = event.getX() - mDownX;
                float disY = event.getY() - mDownY;
                if (Math.abs(disX) < touchSlop && Math.abs(disY) < touchSlop) {
                    int col = (int) (mDownX / mCellSpace);
                    int row = (int) (mDownY / mCellSpace);
                    measureClickCell(col, row);
                }
                break;
            default:
                break;
        }

        return true;
    }

    /**
     * 计算点击的单元格
     * @param col
     * @param row
     */
    private void measureClickCell(int col, int row) {
        if (col >= TOTAL_COL || row >= TOTAL_ROW)
            return;
        if (mClickCell != null) {
            rows[mClickCell.j].cells[mClickCell.i] = mClickCell;
        }
        if (rows[row] != null) {
            mClickCell = new Cell(rows[row].cells[col].date,
                    rows[row].cells[col].state, rows[row].cells[col].i,
                    rows[row].cells[col].j , null);

            CustomDate date = rows[row].cells[col].date;
            date.week = col;

            if ((date.year == todayDate.year && date.month == todayDate.month && date.day <= todayDate.day)
                    || (date.year == todayDate.year && date.month < todayDate.month)
                    || (date.year < todayDate.year) ) {
                mCellClickListener.clickDate(date);
                // 刷新界面
                update(date);
            }
        }
    }

    /**
     * 组元素
     *
     * @author
     *
     */
    class Row {
        public int j;

        Row(int j) {
            this.j = j;
        }

        public Cell[] cells = new Cell[TOTAL_COL];

        // 绘制单元格
        public void drawCells(Canvas canvas) {
            for (int i = 0; i < cells.length; i++) {
                if (cells[i] != null) {
                    cells[i].drawSelf(canvas);
                }
            }
        }

    }

    /**
     * 单元格元素
     *
     * @author
     *
     */
    class Cell {
        public CustomDate date;
        public State state;
        public int i;
        public int j;
        public CustomDate clickDate;

        public Cell(CustomDate date, State state, int i, int j , CustomDate clickDate) {
            super();
            this.date = date;
            this.state = state;
            this.i = i;
            this.j = j;
            this.clickDate = clickDate;
        }

        public void drawSelf(Canvas canvas) {
            switch (state) {
                case TODAY: // 今天
                    mTextPaint.setColor(Color.BLACK);
                    /*mTextPaint.setColor(Color.parseColor("#fffffe"));
                    canvas.drawCircle((float) (mCellSpace * (i + 0.5)),
                            (float) ((j + 0.5) * mCellSpace), mCellSpace / 3,
                            mCirclePaint);*/
                    break;
                case CURRENT_MONTH_DAY: // 当前月日期
                    mTextPaint.setColor(Color.BLACK);
                    break;
                case PAST_MONTH_DAY: // 过去一个月
                    mTextPaint.setColor(Color.parseColor("#fffffe"));
                    break;
                case NEXT_MONTH_DAY: // 下一个月
                case UNREACH_DAY: // 还未到的天
                    mTextPaint.setColor(Color.GRAY);
                    break;
                default:
                    break;
            }

            //选中状态处理（点击日期改变状态）
            if (clickDate != null) {
                if (date.year == clickDate.year && date.month == clickDate.month && date.day == clickDate.day) {
                    mTextPaint.setColor(Color.parseColor("#fffffe"));
                    canvas.drawCircle((float) (mCellSpace * (i + 0.5)),
                            (float) ((j + 0.5) * mCellSpace), mCellSpace / 3,
                            mCirclePaint);
                }
            }

            // 绘制文字
            String content = date.day + "";
            canvas.drawText(content,
                    (float) ((i + 0.5) * mCellSpace - mTextPaint
                            .measureText(content) / 2), (float) ((j + 0.7)
                            * mCellSpace - mTextPaint
                            .measureText(content, 0, 1) / 2), mTextPaint);
        }
    }

    /**
     *
     * @author 单元格的状态 当前月日期，过去的月的日期，下个月的日期
     */
    enum State {
        TODAY,CURRENT_MONTH_DAY, PAST_MONTH_DAY, NEXT_MONTH_DAY, UNREACH_DAY;
    }

    // 从左往右划，上一个月
    public void leftSlide(CustomDate clickDate) {
        if (mShowDate.month == 1) {
            mShowDate.month = 12;
            mShowDate.year -= 1;
        } else {
            mShowDate.month -= 1;
        }
        update(clickDate);
    }

    // 从右往左划，下一个月
    public void rightSlide(CustomDate clickDate) {
        if (mShowDate.month == 12) {
            mShowDate.month = 1;
            mShowDate.year += 1;
        } else {
            mShowDate.month += 1;
        }
        update(clickDate);
    }

    public void update(CustomDate clickDate) {
        fillDate(clickDate);
        invalidate();
    }
}
