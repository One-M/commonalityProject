package com.ybf.lottery.diyview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.TextView;

import com.ybf.lottery.R;

/**
 * Created by XQyi on 2018/4/17.
 * Use: 走势筛选的dialog弹框
 */

public class TrendFiltrateDialog extends Dialog {

    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButtonA;
    private RadioButton radioButtonB;
    private RadioButton radioButtonC;
    private RadioButton radioButtonD;
    private TextView checkQX;
    private TextView checkOK;
    private int currQSnum;
    private boolean booType1;
    private boolean booType2;
    private boolean booType3;
    private boolean booType4;
    private Activity mActivity;

    public TrendFiltrateDialog(@NonNull Context context , int currQSnum , boolean booType1 , boolean booType2 , boolean booType3 , boolean booType4) {
        super(context, R.style.AlertDialog);
        this.mActivity = (Activity) context;
        this.currQSnum = currQSnum;
        this.booType1 = booType1;
        this.booType2 = booType2;
        this.booType3 = booType3;
        this.booType4 = booType4;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bjsc_basic_trend_filtrate);

        initView();
        initData();
    }

    private void initView(){
        radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton)findViewById(R.id.radioButton4);
        radioButtonA = (RadioButton)findViewById(R.id.radioButtonA);
        radioButtonB = (RadioButton)findViewById(R.id.radioButtonB);
        radioButtonC = (RadioButton)findViewById(R.id.radioButtonC);
        radioButtonD = (RadioButton)findViewById(R.id.radioButtonD);
        checkQX = (TextView)findViewById(R.id.check_qx);
        checkOK = (TextView)findViewById(R.id.check_ok);

    }

    private void initData(){

        setQScheck(currQSnum);
        radioButtonA.setChecked(!booType1);
        radioButtonB.setChecked(!booType2);
        radioButtonC.setChecked(booType3);
        radioButtonD.setChecked(booType4);

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currQSnum = 0;
                setQScheck(currQSnum);
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currQSnum = 1;
                setQScheck(currQSnum);
            }
        });
        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currQSnum = 2;
                setQScheck(currQSnum);
            }
        });
        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currQSnum = 3;
                setQScheck(currQSnum);
            }
        });

        radioButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booType1 = !booType1;
                radioButtonA.setChecked(!booType1);
            }
        });
        radioButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booType2 = !booType2;
                radioButtonB.setChecked(!booType2);
            }
        });
        radioButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booType3 = !booType3;
                radioButtonC.setChecked(booType3);
            }
        });
        radioButtonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booType4 = !booType4;
                radioButtonD.setChecked(booType4);
            }
        });


        checkQX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onNoOnclickListener != null) {
                    onNoOnclickListener.onNoClick();
                }
            }
        });

        checkOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (okOnclickListener != null) {
                    okOnclickListener.onOkClick(currQSnum ,booType1,booType2,booType3,booType4);
                }
            }
        });
    }

    private void initEvent(){

    }
    public void setOkOnclickListener(onOkOnclickListener okClick){
        this.okOnclickListener = okClick;
    }
    public void setNoOnclickListener(onNoOnclickListener noClick){
        this.onNoOnclickListener = noClick;
    }

    /**确定按钮接口*/
    private onOkOnclickListener okOnclickListener;
    public interface onOkOnclickListener{
        void onOkClick(int currQSnum , boolean booType1 , boolean booType2 , boolean booType3 , boolean booType4);
    }
    /**取消按钮接口*/
    private onNoOnclickListener onNoOnclickListener;
    public interface onNoOnclickListener{
        void onNoClick();
    }

    private void setQScheck(int qsNym){
        switch (qsNym){
            case 0:
                radioButton1.setChecked(true);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);
                break;
            case 1:
                radioButton1.setChecked(false);
                radioButton2.setChecked(true);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);
                break;
            case 2:
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(true);
                radioButton4.setChecked(false);
                break;
            case 3:
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(true);
                break;
        }
    }
}
