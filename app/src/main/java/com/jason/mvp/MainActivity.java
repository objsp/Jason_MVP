package com.jason.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.jason.mvp.Entity.GirlEntity;
import com.jason.mvp.adapter.GirlAdapter1;
import com.jason.mvp.presenter.GirlPresenterV1;
import com.jason.mvp.view.GirlView;

import java.util.List;

/**
 * MVC：Model View Controller
 * MVP：Model View Presenter
 * 移动端处理的业务越来越复杂，对系统的扩展性要求越来越高
 * Model 数据，逻辑
 * View 试图展示
 * Controller 控制访问
 * MVC：没有严格的规范
 * 有时候在View层需要修改Model，Presenter中间者的决策
 * Model：数据（网络加载），包括业务逻辑
 * View：负责显示（Activity）
 * Presenter：中间者，桥梁。负责Model和View交互，绑定
 */
public class MainActivity extends AppCompatActivity implements GirlView {

    // 重新继承一个新的业务类，不需要修改Activity，比如主界面
    // OCP OPEN CLOSE
    // 可以把ui和逻辑分开，搞界面的直接搞界面，逻辑数据的搞数据
    private GirlPresenterV1 presenter;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);

        // 会有内存泄漏问题
        presenter = new GirlPresenterV1(this);
        presenter.fetch();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "MainActivity加载中", Toast.LENGTH_SHORT).show();;
    }

    @Override
    public void showGirls(List<GirlEntity> girls) {
        // 负责显示
        lv.setAdapter(new GirlAdapter1(girls));
    }

}
