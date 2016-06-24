package com.shbd;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * Created by yh on 2016/6/2.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xutils
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
