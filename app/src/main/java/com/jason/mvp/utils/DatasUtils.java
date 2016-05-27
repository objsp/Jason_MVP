package com.jason.mvp.utils;

import com.jason.mvp.Entity.GirlEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-05-21 0021.
 */
public class DatasUtils {

    // 加载数据
    public static List<GirlEntity> getDatas() {
        List<GirlEntity> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            GirlEntity gile = new GirlEntity("simon-" + (i + 1));
            list.add(gile);
        }
        return list;
    }

}
