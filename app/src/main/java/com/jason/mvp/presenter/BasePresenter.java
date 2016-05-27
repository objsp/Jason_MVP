package com.jason.mvp.presenter;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016-05-21 0021.
 */
public abstract class BasePresenter<T> {

    // 持有View的引用
    // 弱引用，当内存不足，可释放内存
    // 加载数据的东西可以回收
    protected WeakReference<T> nViewRef;

    // 绑定P和V
    public void attachView(T view) {
        nViewRef = new WeakReference<T>(view);
    }

    // View被销毁时候解除关联
    public void detachView() {
        if (nViewRef != null) {
            nViewRef.clear();
            nViewRef = null;
        }
    }

    // 获取View
    protected T getView() {
        return nViewRef.get();
    }

}
