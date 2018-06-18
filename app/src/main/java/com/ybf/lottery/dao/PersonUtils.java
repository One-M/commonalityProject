package com.ybf.lottery.dao;

import android.content.Context;
import android.util.Log;

import com.ybf.lottery.daobean.Person;
import com.ybf.lottery.gen.PersonDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2018/6/18.
 */

public class PersonUtils {

    private static final String TAG = PersonUtils.class.getSimpleName();
    private DaoManager daoManager;

    public PersonUtils(Context context){
        daoManager = DaoManager.getInstance();
        daoManager.init(context);
    }

    /**
     * 完成person记录的插入，如果表未创建，先创建Meizi表
     * @param person
     * @return
     */
    public boolean insertPerson(Person person){
        boolean flag = false;
        flag = !(daoManager.getDaoSession().getPersonDao().insert(person) == -1);
        Log.i(TAG, "insert Person :" + flag + "-->" + person.toString());
        return flag;
    }

    /**
     * 插入多条数据，在子线程操作
     * @param personList
     * @return
     */
    public boolean inserMultPerson(final List<Person> personList){
        boolean flag = false;
        try {
            daoManager.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (Person person : personList) {
                        daoManager.getDaoSession().insertOrReplace(person);
                    }
                }
            });
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**修改单条数据*/
    public boolean updataPerson(Person person){
        boolean flag = false;
        try {
            daoManager.getDaoSession().update(person);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    /**删除单条记录*/
    public boolean deletePerson(Person person){
        boolean flag = false;
        try {
            daoManager.getDaoSession().delete(person);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    /**删除所有记录*/
    public boolean deleteAll(){
        boolean flag = false;

        try {
            daoManager.getDaoSession().deleteAll(Person.class);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**查询所有记录*/
    public List<Person> queryAllPerson(){
        return daoManager.getDaoSession().loadAll(Person.class);
    }

    /**根据主键id查询记录*/
    public Person queryPersonId(long key){
        return daoManager.getDaoSession().load(Person.class , key);
    }

    /**使用native sql 查询(原生sql)*/
    public List<Person> queryPersonByNativeSql(String sql , String[] conditions){
        return daoManager.getDaoSession().queryRaw(Person.class , sql , conditions);
    }
    /**使用queryBuilder*/
    public List<Person> queryPersonByQueryBuilder(long id){
        QueryBuilder<Person> personQueryBuilder = daoManager.getDaoSession().queryBuilder(Person.class);
        return personQueryBuilder.where(PersonDao.Properties.PId.eq(id)).list();
    }
}















