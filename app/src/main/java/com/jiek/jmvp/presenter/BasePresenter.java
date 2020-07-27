package com.jiek.jmvp.presenter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.jiek.jmvp.view.IBaseView;

import java.lang.ref.WeakReference;

public class BasePresenter<T extends IBaseView> implements LifecycleObserver {

    protected WeakReference<T> iGoodsView;
    protected Handler myHandler = new Handler(Looper.getMainLooper());
    public static final String TAG = "BasePresenter";

    public void attachView(T view) {
        iGoodsView = new WeakReference<>(view);
    }

    public void dettach() {
        if (iGoodsView != null) {
            iGoodsView.clear();
            iGoodsView = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate(LifecycleOwner owner) {
//        子类实现事件任务
        l("onCreate: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestory(LifecycleOwner owner) {
//        子类实现事件任务
        l("onDestory: ");
//        myHandler.getLooper().quit();//因为在主线程，所以无法退出
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart(LifecycleOwner owner) {
        l("onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume(LifecycleOwner owner) {
        l("onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause(LifecycleOwner owner) {
        l("onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop(LifecycleOwner owner) {
        l("onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner) {
        l("onany");
    }

    private void l(String msg) {
        Log.e(TAG, msg + " ; " + Thread.currentThread());
    }


}
