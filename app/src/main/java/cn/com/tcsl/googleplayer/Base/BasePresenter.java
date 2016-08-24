package cn.com.tcsl.googleplayer.Base;

/**
 * Created by wjx on 2016/8/2.
 */
public interface BasePresenter {
    /**
     * 初始化相关数据，在activity中初始化
     */
    void start();

    /**
     * 数据销毁，当activity销毁的时候，销毁相关数据的操作
     */
    void destroy();
}
