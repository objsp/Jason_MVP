package com.jason.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jason.mvp.presenter.BasePresenter;

/**
 * Created by Administrator on 2016-05-21 0021.
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建Presenter，模板模式
        // 具体的实现在子类中
        mPresenter = createPresenter();

        // 内存泄漏的问题
        // Activity和Presenter交互
        // P到M，异步加载，Activity内存不足销毁
        // 由于M还在请求网络，而P还持有的引用
        // 当M干完活，而P拿V去显示，就会报错
        // 引用一个被回收的内存引用
        // 所以当V被收回，P就要解除关联
        mPresenter.attachView((V) this);
    }

    // 解除关联
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();

}
