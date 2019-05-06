package com.devendra.shaadimatcher.application.di;

import android.app.Application;
import android.content.Context;

import com.devendra.shaadimatcher.users.network.service.UserService;
import com.devendra.shaadimatcher.utils.Constants;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Devendra Mehra on 5/6/2019.
 */
@Module
public class ApplicationModule {

    @Provides
    @Singleton
    Context providesContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    UserService providesApiService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(GsonConverterFactory gsonConverterFactory,
                              OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);

        client.addNetworkInterceptor(new StethoInterceptor());

        return client.build();
    }

    @Provides
    @Singleton
    Cache providesOkhttpCache(Context context) {
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        return new Cache(context.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    GsonConverterFactory providesGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

}
