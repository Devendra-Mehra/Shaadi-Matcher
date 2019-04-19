package com.devendra.shaadimatches.singleinstance;

import com.facebook.stetho.okhttp3.StethoInterceptor;

public class StethoInterceptorInstance {

    private static volatile StethoInterceptor stethoInterceptorInstance = null;

    private StethoInterceptorInstance() {
        if (stethoInterceptorInstance != null) {
            throw new RuntimeException("Can not create this way, please use " +
                    "getStethoInterceptorInstance method");
        }
    }

    public static StethoInterceptor getStethoInterceptorInstance() {
        if (stethoInterceptorInstance == null) {
            synchronized (StethoInterceptorInstance.class) {
                if (stethoInterceptorInstance == null) {
                    stethoInterceptorInstance = new StethoInterceptor();
                }
            }
        }
        return stethoInterceptorInstance;
    }


}
