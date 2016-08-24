package cn.com.tcsl.googleplayer.ui.main;

/**
 * Created by wjx on 2016/8/24.
 */
public class MainPresenter implements MainContract.Presenter {
    MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.initToolbar();
        mView.initNavigation();
    }

    @Override
    public void destroy() {

    }
}
