package com.jiek.jmvp.model;

import android.os.SystemClock;

import com.jiek.jmvp.beans.Goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsModel implements IGoodsModel {
    OnLoadListener listener;

    @Override
    public void loadDatas(final OnLoadListener listener) {
        this.listener = listener;
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                listener.onSuccess(fetchData());
            }
        }).start();
    }

    private List<Goods> fetchData() {
        //可以使用子线程去获取数据
        List<Goods> goodsList = new ArrayList<>();

        goodsList.add(new Goods("name 1", "https://attach.bbs.miui.com/forum/month_1012/10120514509c7244b23f4a2fa5.jpg"));
        goodsList.add(new Goods("name 2", "https://attach.bbs.miui.com/forum/201205/07/200343cx0b5wwqdp0wbdb3.jpg"));
        goodsList.add(new Goods("name 3", "https://files.bbs.tl.changyou.com/data/attachment/forum/201507/20/161520i5zwef38nnnh1c5e.jpeg"));
        goodsList.add(new Goods("name 4", "https://attach.bbs.miui.com/forum/month_1012/10120514509c7244b23f4a2fa5.jpg"));
        goodsList.add(new Goods("name 5", "https://attach.bbs.miui.com/forum/201205/07/200343cx0b5wwqdp0wbdb3.jpg"));
        goodsList.add(new Goods("name 6", "https://files.bbs.tl.changyou.com/data/attachment/forum/201507/20/161520i5zwef38nnnh1c5e.jpeg"));
        goodsList.add(new Goods("name 7", "https://attach.bbs.miui.com/forum/month_1012/10120514509c7244b23f4a2fa5.jpg"));
        goodsList.add(new Goods("name 8", "https://attach.bbs.miui.com/forum/201205/07/200343cx0b5wwqdp0wbdb3.jpg"));
        goodsList.add(new Goods("name 9", "https://files.bbs.tl.changyou.com/data/attachment/forum/201507/20/161520i5zwef38nnnh1c5e.jpeg"));
        return goodsList;
    }


}
