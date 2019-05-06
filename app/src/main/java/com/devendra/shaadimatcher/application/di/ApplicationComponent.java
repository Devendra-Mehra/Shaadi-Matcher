package com.devendra.shaadimatcher.application.di;

import android.app.Application;

import com.devendra.shaadimatcher.application.ShaadiMacherApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Devendra Mehra on 5/6/2019.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class,
        ApplicationModule.class,
        ActivityBuilder.class})
public interface ApplicationComponent {


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();

    }

    void inject(ShaadiMacherApplication shaadiMacherApplication);
}
