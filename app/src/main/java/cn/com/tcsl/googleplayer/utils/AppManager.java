package cn.com.tcsl.googleplayer.utils;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wjx on 2016/8/24.
 */
public class AppManager {
    private static List<Activity> activities=new LinkedList<Activity>();
    private static AppManager ourInstance = new AppManager();
    private AppManager() {
    }
    public static AppManager getInstance() {
        return ourInstance;
    }

    /**
     * 获取指定类名的activity
     * @param cls 类名
     * @return 具体的activity
     */
    public static Activity getActivity(Class<?> cls) {
        if(activities!=null){
            for (Activity activity: activities) {
                if(activity.getClass().equals(cls)){
                    return activity;
                }
            }
        }
        return  null;
    }

    /**
     * 列表中增加某个activity
     * @param act 要增加的activity
     */
    public  void addActivity(Activity act){
        if(activities!=null){
            activities.add(act);
        }
    }

    /**
     *移除acitivity
     * @param act activity
     */
    public void removeActivity(Activity act){
        if(activities!=null && activities.contains(act)){
            activities.remove(act);
        }
    }

    /**
     * 结束指定activity
     * @param act 要结束的activity
     */
    public void finishActivity(Activity act){
        if(activities!=null && activities.contains(act)){
            activities.remove(act);
            act.finish();
        }
    }

    /**
     * 结束指定类名的activity
     * @param clazz 类名
     */
    public void finishActivity(Class clazz){
        if(activities!=null){
            for(Activity act:activities){
                if(act.getClass().equals(clazz)){
                    finishActivity(act);
                }
            }
        }
    }

    /**
     * 移除所有activity.
     * not support now.
     */
    @Deprecated
    public void finishAll(){

    }
}
