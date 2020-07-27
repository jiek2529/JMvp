package com.jiek.jmvp.presenter;

import androidx.lifecycle.LifecycleOwner;

import com.jiek.jmvp.beans.Goods;
import com.jiek.jmvp.model.GoodsModel;
import com.jiek.jmvp.model.IGoodsModel;
import com.jiek.jmvp.view.IGoodsView;

import java.util.List;

public class GoodsPresenter<T extends IGoodsView> extends BasePresenter {
    //
    IGoodsModel iGoodsModel = new GoodsModel();
//    IGoodsView iGoodsView;

    public GoodsPresenter(/*IGoodsView goodsView*/) {
//        this.iGoodsView = goodsView;
    }

    public void fetchData() {
        if (iGoodsView.get() != null && iGoodsModel != null) {
            iGoodsModel.loadDatas(new IGoodsModel.OnLoadListener() {
                @Override
                public void onSuccess(final List<Goods> list) {
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            ((IGoodsView) iGoodsView.get()).showGoods(list);
                        }
                    });
                }

                @Override
                public void onFail(String msg) {

                }
            });
        }
    }

    @Override
    void onCreate(LifecycleOwner owner) {
        super.onCreate(owner);
    }

    @Override
    void onDestory(LifecycleOwner owner) {
        super.onDestory(owner);
    }
}
