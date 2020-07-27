package com.jiek.jmvp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.jiek.jmvp.presenter.BasePresenter;

public abstract class BaseActivity<T extends BasePresenter> extends FragmentActivity {

    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView((IBaseView) this);
    }

    protected abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettach();
    }
}
