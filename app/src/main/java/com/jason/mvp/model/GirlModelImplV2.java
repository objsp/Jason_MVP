package com.jason.mvp.model;

import android.os.SystemClock;
import android.util.Log;

import com.jason.mvp.Entity.GirlEntity;
import com.jason.mvp.utils.DatasUtils;

import java.util.List;

/**
 * Created by Administrator on 2016-05-21 0021.
 */
public class GirlModelImplV2 implements GirlModel {

    private List<GirlEntity> list;

    @Override
    public void loadGirl(GirlOnLoadListener listener) {
        Log.e("simon", "loadGirl() V2");
        // 模拟加载网络数据，模拟网络延时
        SystemClock.sleep(1000);

        list = DatasUtils.getDatas();
        listener.onComplete(list);
    }

}
