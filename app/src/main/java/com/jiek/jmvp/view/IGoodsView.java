package com.jiek.jmvp.view;

import com.jiek.jmvp.beans.Goods;

import java.util.List;

public interface IGoodsView extends IBaseView {
    void showGoods(List<Goods> list);
}
