package com.ybf.lottery.base;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.widget.ProgressBar;

import com.gyf.barlibrary.ImmersionBar;
import com.ybf.lottery.R;
import com.ybf.lottery.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by XQyi on 2018/3/2.
 * Use:activity 基类
 */

public abstract class BaseActivity extends SupportActivity implements BaseView{
    private AlertDialog loadingDialog;
    /**
     * 保存当前activity对象，在OnCreate里面添加，记得在OnDestroy里面移除
     * 作用：
     * 比方说有一个需求，让你在任意位置弹出对话框，弹对话框又需要一个context对象，这个时候，
     * 你就只用传当前list的最上层的activity对象就可以了
     */
    public static List<BaseActivity> activities = new ArrayList<>();
    private ImmersionBar immersionBar;
    private boolean isImmersionBarEnabled = true;//是否使用base类的沉浸式(ps:默认true使用，子类中设置为false后可以自行设置不同颜色bar，记得destroy防止泄露)

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities.add(this);
        //强制竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (isImmersionBarEnabled) {
            initImmersionBar();
        }

    }
    //沉浸式设置
    protected void initImmersionBar(){
        immersionBar = ImmersionBar.with(this);
        immersionBar.init();
    }
    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    public boolean isImmersionBarEnabled() {
        return isImmersionBarEnabled;
    }
    public  void setIsImmersionBarEnabled(boolean isImmersionBarEnabled){
        this.isImmersionBarEnabled=isImmersionBarEnabled;
    }
    /**
     * Toast 提示用户
     * @param msg 提示内容String
     */
    @Override
    public void showTipMsg(String msg) {
        ToastUtils.showTipMsg(msg);
    }

    /**
     * Toast 提示用户
     * @param msg 提示内容res目录下面的String的int值
     */
    @Override
    public void showTipMsg(int msg) {
        ToastUtils.showTipMsg(msg);
    }

    /**
     * 网络请求的时候显示正在加载的对话框
     */
    @Override
    public void showLoading() {
        if (null == loadingDialog) {
            loadingDialog = new AlertDialog.Builder(this).setView(new ProgressBar(this)).create();
            loadingDialog.setCanceledOnTouchOutside(false);
            Window window = loadingDialog.getWindow();
            if (null != window) {
                window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    /**
     * 网络请求完成时隐藏加载对话框
     */
    @Override
    public void hideLoading() {
        if (null != loadingDialog) {
            if (loadingDialog.isShowing()) {
                loadingDialog.dismiss();
            }
            loadingDialog = null;
        }
    }

    @Override
    public void invalidToken() {
        //用于检测你当前用户的token是否有效，无效就返回登录界面，具体的业务逻辑你自己实现
        //如果需要做到实时检测，推荐用socket长连接，每隔10秒发送一个验证当前登录用户token是否过期的请求
    }

    /**
     * Finish当前页面，实现onBackPressedSupport()，这个方法会有一个退栈操作，
     * 开源框架实现的，我们不用管
     */
    @Override
    public void myFinish() {
        onBackPressedSupport();
    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }

    @Override
    protected void onDestroy() {
        activities.remove(this);
        super.onDestroy();
        if (immersionBar != null) {
            immersionBar.destroy();//必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下 退出此界面再进入将记忆最后一次bar改变的状态
        }
    }
}
