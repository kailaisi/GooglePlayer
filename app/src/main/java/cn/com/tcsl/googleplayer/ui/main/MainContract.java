package cn.com.tcsl.googleplayer.ui.main;

import cn.com.tcsl.googleplayer.Base.BaseModel;
import cn.com.tcsl.googleplayer.Base.BasePresenter;
import cn.com.tcsl.googleplayer.Base.BaseView;

/**
 * Created by wjx on 2016/8/18.
 */
public interface MainContract {
    interface View extends BaseView{
        /**
         * 初始化toolbar
         */
        void initToolbar();

        /**
         * 初始化导航栏
         */
        void initNavigation();
        void showNavigation();
        void hideNavigation();
    }

    interface Presenter extends BasePresenter{

    }

    interface Model extends BaseModel{

    }
}
