package com.ybf.lottery.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.ybf.lottery.R;
import com.ybf.lottery.base.BaseActivity;
import com.ybf.lottery.dao.PersonUtils;
import com.ybf.lottery.daobean.Person;

import java.util.List;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/6/18.
 */

public class DaoTestActivity extends BaseActivity{

    @BindViews({R.id.button1 , R.id.button2 , R.id.button3 , R.id.button4 , R.id.button5})
    List<Button> buttonList;
    private PersonUtils personUtils;
    private Long id = 99L;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_dao_test_lay);
        ButterKnife.bind(this);

        personUtils = new PersonUtils(this);
    }
    @OnClick({R.id.button1 , R.id.button2 , R.id.button3 , R.id.button4 , R.id.button5})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button1://添加
                Person person = new Person();
                person.setPId(null);
                person.setSource("aaa " + id);
                person.setUrl("www.baidu.com");
                personUtils.insertPerson(person);
                break;
            case R.id.button2://删除
                Person p2 = new Person();
                p2.setPId(100L);
                personUtils.deletePerson(p2);
                break;
            case R.id.button3://修改
                Person p1 = new Person();
                p1.setPId(101L);
                p1.setUrl("www.jd.com");
                personUtils.updataPerson(p1);

                break;
            case R.id.button4://查询all
                List<Person> people = personUtils.queryAllPerson();
                for (Person p : people) {
                    Log.d("DaoTestActivity " , p.toString());
                }
                break;
            case R.id.button5://查询id
                Log.i("DaoTestActivity ", personUtils.queryPersonId(101l).toString());
                break;
        }
    }
}
