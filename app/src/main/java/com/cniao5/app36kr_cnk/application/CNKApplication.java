package com.cniao5.app36kr_cnk.application;

import android.app.Application;

/**
 * 当前类注释:全局Application类,作为全局数据的配置以及相关参数数据初始化工作
 */
public class CNKApplication  extends Application{
    private static CNKApplication instance=null;
    @Override
    public void onCreate() {
        super.onCreate();
        this.instance=this;
    }
    public static CNKApplication getInstance(){
        return instance;
    }
}
