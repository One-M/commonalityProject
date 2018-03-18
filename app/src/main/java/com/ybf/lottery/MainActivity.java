package com.ybf.lottery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.ybf.lottery.base.BaseMvpActivity;
import com.ybf.lottery.contract.MainContract;
import com.ybf.lottery.function.BJRacecarActivity;
import com.ybf.lottery.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.IView {

    @BindView(R.id.to_lottery)
    TextView world;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData(){
        world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , BJRacecarActivity.class));
            }
        });
    }

    @Override
    protected MainPresenter initInject() {
        return new MainPresenter(this);
    }

}
