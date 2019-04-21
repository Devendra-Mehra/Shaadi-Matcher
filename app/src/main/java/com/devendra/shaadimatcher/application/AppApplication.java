package com.devendra.shaadimatcher.application;

import android.app.Application;

import com.devendra.shaadimatcher.BuildConfig;
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
