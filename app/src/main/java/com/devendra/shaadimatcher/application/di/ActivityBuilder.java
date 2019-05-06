package com.devendra.shaadimatcher.application.di;

/**
 * Created by Devendra Mehra on 5/6/2019.
 */

import com.devendra.shaadimatcher.users.di.UserModule;
import com.devendra.shaadimatcher.users.view.UserActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = UserModule.class)
    abstract UserActivity contributeUserActivityInjector();
}
