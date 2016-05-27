package com.jason.mvp.view;

import com.jason.mvp.Entity.GirlEntity;

import java.util.List;

/**
 * Created by Administrator on 2016-05-21 0021.
 */
public interface GirlView {

    // 显示进度条
    void showLoading();

    // 显示Girl
    void showGirls(List<GirlEntity> girls);

}
