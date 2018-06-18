package com.ybf.lottery.dao;

import android.content.Context;

import com.ybf.lottery.gen.DaoMaster;
import com.ybf.lottery.gen.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by Administrator on 2018/6/18.
 */

public class DaoManager {
    private static final String TAG = DaoManager.class.getSimpleName();
    private static final String DB_NAME = "greendaotest";
    private Context context;

    //多线程中要被共享的使用volatile关键字修饰
    private volatile static DaoManager daoManager = new DaoManager();
    private static DaoMaster daoMaster;
    private static DaoMaster.DevOpenHelper devOpenHelper;
    private static DaoSession daoSession;

    /**
     * 单例模式获得操作数据库对象
     * @return
     */
    public static DaoManager getInstance(){
        return daoManager;
    }

    public void init(Context context){
        this.context = context;
    }

    /**
     * 判断是否有存在数据库，如果没有则创建
     * @return
     */
    public DaoMaster getDaoMaster(){
        if (daoMaster == null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 完成对数据库的添加、删除、修改、查询操作，仅仅是一个接口
     * @return
     */
    public DaoSession getDaoSession(){
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    /** 打开输出日志，默认关闭*/
    public void setDebug(){
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    public void closeHelper(){
        if (devOpenHelper == null) {
            devOpenHelper.close();
            devOpenHelper = null;
        }
    }

    public void closeDaoSession(){
        if (daoSession == null) {
            daoSession.clear();
            daoSession = null;
        }
    }

    /**
     * 关闭所有的操作，数据库开启后，使用完毕要关闭
     */
    public void closeConnection(){
        closeHelper();
        closeDaoSession();
    }

}
