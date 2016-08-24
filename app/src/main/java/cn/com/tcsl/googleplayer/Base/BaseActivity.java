package cn.com.tcsl.googleplayer.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import cn.com.tcsl.googleplayer.utils.AppManager;

/**
 * Created by wjx on 2016/8/2.
 */
public class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{
    private static  BaseActivity activity;
    protected  T mPresenter;
    private Context mContext;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);
        mContext=this;
    }

    @Override
    protected void onDestroy() {
        if(mPresenter!=null){
            mPresenter.destroy();
        }
        AppManager.getInstance().removeActivity(this);
        super.onDestroy();
    }
}
