package com.muxistudio.jinyixin.query.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by jinyixin on 15/3/14.
 */
public class QueryApplication extends Application {
    private static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();}

    public static Context getContext(){
        return context;
    }
}
