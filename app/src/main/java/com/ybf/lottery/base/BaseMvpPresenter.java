package com.ybf.lottery.base;

import com.ybf.lottery.MyApplication;
import com.ybf.lottery.di.manager.DataManager;
import com.ybf.lottery.utils.MyRxUtils;
import com.ybf.lottery.utils.MySubscriber;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by XQyi on 2018/3/3.
 * Use:prestener基类（带MVP）
 */

public class BaseMvpPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T baseView;
    private CompositeDisposable disposables;
    public DataManager dataManager;

    public BaseMvpPresenter(T view){
        dataManager = MyApplication.getDataMamager();
        attachView(view);
    }

    /**
     * 绑定view
     * @param baseView
     */
    @Override
    public void attachView(T baseView) {
        this.baseView = baseView;
    }

    /**
     * 在ondestory方法里面解除绑定
     * 保证P层的生命周期和V层同步，避免了，当V层销毁的时候，P层仍然存在造成的内存泄漏。
     */
    @Override
    public void detachView() {
        this.baseView = null;
        unSubscribe();
    }
    private void unSubscribe() {
        if (null != disposables) {
            disposables.clear();
            disposables = null;
        }
    }

    protected <T> void addSubscribe(Flowable<T> flowable , MySubscriber<T> subscriber){
        Disposable disposable =
                flowable.compose(MyRxUtils.toMain(Schedulers.io())) //Transformer实际上就是一个Func1<Observable<T>, Observable<R>>，换言之就是：可以通过它将一种类型的Observable转换成另一种类型的Observable，和调用一系列的内联操作符是一模一样的
                        .subscribeOn(Schedulers.io()) // 指定订阅发生的线程(事件产生的线程) 网络请求
                        .observeOn(AndroidSchedulers.mainThread()) // 运行在的线程(事件消费的线程) 回调处理
                        .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(subscriber);

        if (null == disposables) {
            disposables = new CompositeDisposable();
        }
        disposables.add(disposable);
    }
}
