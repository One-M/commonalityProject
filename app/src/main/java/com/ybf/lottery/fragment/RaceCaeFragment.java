package com.ybf.lottery.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ybf.lottery.R;
import com.ybf.lottery.activity.RaceCarContract;
import com.ybf.lottery.activity.RaceCarPresenter;
import com.ybf.lottery.base.BaseMvpFragment;

/**
 * Created by XQyi on 2018/3/9.
 * Use:
 */

public class RaceCaeFragment extends BaseMvpFragment<RaceCarPresenter> implements RaceCarContract.IView {

    private View mView;
    private Button button;

    @Override
    public RaceCarPresenter initPresenter() {
        return new RaceCarPresenter(this);
    }

    public static RaceCaeFragment newInstance() {
        Bundle args = new Bundle();
        RaceCaeFragment fragment = new RaceCaeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.frag_race_car_lay, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = mView.findViewById(R.id.race_car);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initdatas();
            }
        });
    }

    private void initdatas(){
        mPresenter.loadData();
    }

}
