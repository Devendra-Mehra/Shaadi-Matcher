package com.devendra.shaadimatches.application;

import android.app.Application;

import com.devendra.shaadimatches.BuildConfig;
import com.facebook.stetho.Stetho;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
