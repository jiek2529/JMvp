package com.jiek.jmvp;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jiek.jmvp.adapter.GoodsAdapter;
import com.jiek.jmvp.beans.Goods;
import com.jiek.jmvp.presenter.GoodsPresenter;
import com.jiek.jmvp.view.BaseActivity;
import com.jiek.jmvp.view.IGoodsView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<GoodsPresenter<IGoodsView>/*, IGoodsView*/> implements IGoodsView {

    private static final String TAG = "JIEK MainActivity";
    private TextView tv;

    private RecyclerView recyclerView;
    private List<Goods> goodsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(new GoodsAdapter(goodsList));

        new Thread(new Runnable() {
            @Override
            public void run() {
                presenter.fetchData();
            }
        }).start();

        init();
    }

    void init() {
        getLifecycle().addObserver(presenter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected GoodsPresenter<IGoodsView> createPresenter() {
        return new GoodsPresenter();
    }

    @Override
    public void showGoods(List<Goods> list) {
        l("showGoods: " + list.size());
        StringBuilder sb = new StringBuilder();
        for (Goods goods : list) {
            sb.append(goods + "\n");
        }
        tv.setText("加载了【" + list.size() + "】条数据");
        goodsList.clear();
        goodsList.addAll(list);
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    private void l(String msg) {
        Log.d(TAG, msg);
    }

    @Override
    public void showMsg() {

    }

    @Override
    public void showErr() {

    }

}
