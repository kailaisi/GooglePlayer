package cn.com.tcsl.googleplayer.Base;

import android.support.v4.app.Fragment;

/**
 * Created by wjx on 2016/8/18.
 */
public class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
    T mPresenter;
}
