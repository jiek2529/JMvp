package com.jiek.jmvp.model;

import com.jiek.jmvp.beans.Goods;

import java.util.List;

public interface IGoodsModel {
    void loadDatas(OnLoadListener listener);

    interface OnLoadListener {
        void onSuccess(List<Goods> list);

        void onFail(String msg);
    }
}
