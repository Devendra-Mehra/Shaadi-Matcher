package com.devendra.shaadimatcher.users.di;

import com.devendra.shaadimatcher.users.contract.UserContract;
import com.devendra.shaadimatcher.users.model.UserModel;
import com.devendra.shaadimatcher.users.network.implementation.UserServiceImpl;
import com.devendra.shaadimatcher.users.presenter.UserPresenter;
import com.devendra.shaadimatcher.users.view.UserActivity;
import com.devendra.shaadimatcher.users.view.UserAdapter;
import com.devendra.shaadimatcher.utils.StringHelper;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Devendra Mehra on 5/6/2019.
 */
@Module
public class UserModule {

    @Provides
    UserContract.View provideUserContractView(UserActivity userActivity) {
        return userActivity;
    }


    @Provides
    UserContract.Model providesUserContractModel(CompositeDisposable compositeDisposable) {
        return new UserModel(compositeDisposable);
    }

    @Provides
    CompositeDisposable providesCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    UserContract.Presenter providesUserContractPresenter(UserContract.View view,
                                                         StringHelper stringHelper, UserModel userModel) {
        return new UserPresenter(view, stringHelper, userModel);
    }


    @Provides
    UserServiceImpl providesUserServiceImp(CompositeDisposable compositeDisposable) {
        return new UserServiceImpl(compositeDisposable);
    }

    @Provides
    UserAdapter providesUserAdapter() {
        return new UserAdapter();
    }


}
