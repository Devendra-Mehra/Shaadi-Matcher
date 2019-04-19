package com.devendra.shaadimatches.singleinstance;

import okhttp3.OkHttpClient;

public class OkHttpClientInstance {
    private static volatile OkHttpClient okHttpClientInstance = null;

    private OkHttpClientInstance() {
        if (okHttpClientInstance != null) {
            throw new RuntimeException("Can not create this way, " +
                    "please use getOkHttpClientInstance method");
        }
    }


    public static OkHttpClient getOkHttpClientInstance() {
        if (okHttpClientInstance == null) {
            synchronized (OkHttpClientInstance.class) {
                if (okHttpClientInstance == null) {
                    okHttpClientInstance = new OkHttpClient.Builder()
                            .addNetworkInterceptor(StethoInterceptorInstance.
                                    getStethoInterceptorInstance())
                            .build();
                }
            }
        }
        return okHttpClientInstance;
    }
}
