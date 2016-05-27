package com.jason.mvp;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.jason.mvp.Entity.GirlEntity;
import com.jason.mvp.adapter.GirlAdapter2;
import com.jason.mvp.presenter.GirlPresenterV2;
import com.jason.mvp.view.GirlView;

import java.util.List;

/**
 * Created by Administrator on 2016-05-21 0021.
 */
public class GirlGridActivity extends BaseActivity<GirlView, GirlPresenterV2> implements GirlView {

    // public class GirlGridActivity extends AppCompatActivity implements GirlView {
    // View和Moedel没有耦合
    // Model只负责业务逻辑
    // 关联起来靠Presenter桥梁，进行绑定
    private GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gv = (GridView) findViewById(R.id.gv);

        mPresenter.fetch();
    }

    @Override
    protected GirlPresenterV2 createPresenter() {
        return new GirlPresenterV2();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "GirlGridActivity加载中", Toast.LENGTH_SHORT).show();;
    }

    @Override
    public void showGirls(List<GirlEntity> girls) {
        gv.setAdapter(new GirlAdapter2(girls));
    }
}

