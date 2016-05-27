package com.jason.mvp.presenter;

import com.jason.mvp.Entity.GirlEntity;
import com.jason.mvp.model.GirlModel;
import com.jason.mvp.model.GirlModelImplV2;
import com.jason.mvp.view.GirlView;

import java.util.List;

/**
 * Created by Administrator on 2016-05-21 0021.
 */
public class GirlPresenterV2 extends BasePresenter<GirlView> {

    // View不需要了，关联View抽取到了父类
    // GirlView gView;

    // Model
    GirlModel gModel = new GirlModelImplV2();

    public void fetch() {
        getView().showLoading();
        // gView.showLoading();
        gModel.loadGirl(new GirlModel.GirlOnLoadListener() {

            @Override
            public void onComplete(List<GirlEntity> girls) {
                getView().showGirls(girls);
            }
        });
    }

}
