package com.ybf.lottery.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.ybf.lottery.R;
import com.ybf.lottery.base.BaseMvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XQyi on 2018/3/9.
 * Use:
 */

public class RaceCarActivity extends BaseMvpActivity<RaceCarPresenter> implements RaceCarContract.IView{

    @BindView(R.id.button)
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_race_car_lay);
        ButterKnife.bind(this);
        initData();
    }

    private void initData(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basePresenter.loadData();
            }
        });
    }
    @Override
    protected RaceCarPresenter initInject() {
        return new RaceCarPresenter(this);
    }
}
