package com.devendra.shaadimatches.singleinstance;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class RetrofitInstance {
    private static final String BASE_URL = "https://randomuser.me/api/";

    private static volatile Retrofit retrofitInstance = null;

    private RetrofitInstance() {
        if (retrofitInstance != null) {
            throw new RuntimeException("Can not create this way, please use " +
                    "getRetrofitInstance method");
        }
    }


    public static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            synchronized (RetrofitInstance.class) {
                if (retrofitInstance == null) {
                    retrofitInstance = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create(GsonInstance.getGsonInstance()))
                            .client(OkHttpClientInstance.getOkHttpClientInstance())
                            .build();
                }
            }
        }
        return retrofitInstance;
    }
}
