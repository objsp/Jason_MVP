package com.jason.mvp.presenter;

import com.jason.mvp.Entity.GirlEntity;
import com.jason.mvp.model.GirlModel;
import com.jason.mvp.model.GirlModelImplV1;
import com.jason.mvp.view.GirlView;

import java.util.List;

/**
 * Created by Administrator on 2016-05-21 0021.
 * 负责model和view进行绑定
 */
public class GirlPresenterV1 {

    // view
    GirlView gView;

    // model，如果要改成V2实现，new V2
    GirlModel gModel = new GirlModelImplV1();

    // 初始化View
    public GirlPresenterV1(GirlView view) {
        this.gView = view;
    }

    // 以上是对象的组合

    // 绑定，拉去数据。由view告诉它要干嘛
    public void fetch() {
        // 加载进度
        gView.showLoading();

        // model获取数据
        if (gModel != null) {
            // 内部类
            // 得到了数据
            // 给view去显示
            gModel.loadGirl(new GirlModel.GirlOnLoadListener() {

                @Override
                public void onComplete(List<GirlEntity> girls) {
                    gView.showGirls(girls);
                }
            });
        }
    }

}
