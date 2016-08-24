package cn.com.tcsl.googleplayer.ui.main;

/**
 * 主界面
 * Created by wjx on 2016/8/24.
 */
public class MainPresenter implements MainContract.Presenter {
    MainContract.View mView;
    MainModel mModel;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mModel = new MainModel();
    }

    @Override
    public void start() {
        mView.initToolbar();
        mView.initNavigation();
    }

    @Override
    public void destroy() {
        mView.closeApp();
        if(mView!=null){
            mView=null;
        }
    }
}
