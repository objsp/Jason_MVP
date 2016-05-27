package com.jason.mvp.model;

import android.util.Log;

import com.jason.mvp.Entity.GirlEntity;
import com.jason.mvp.utils.DatasUtils;

import java.util.List;

/**
 * Created by Administrator on 2016-05-21 0021.
 */
public class GirlModelImplV1 implements GirlModel {

    private GirlOnLoadListener listener;
    private List<GirlEntity> list;

    @Override
    public void loadGirl(GirlOnLoadListener listener) {
        Log.e("simon", "loadGirl() V1");
        // 模拟加载数据
        list = DatasUtils.getDatas();

        if (listener != null) {
            listener.onComplete(list);
        }
    }

}
