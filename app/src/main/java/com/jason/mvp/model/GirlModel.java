package com.jason.mvp.model;

import com.jason.mvp.Entity.GirlEntity;

import java.util.List;

/**
 * Created by Administrator on 2016-05-21 0021.
 */
public interface GirlModel {

    void loadGirl(GirlOnLoadListener listener);

    interface  GirlOnLoadListener {
        void onComplete(List<GirlEntity> girls);
    }

}
