package com.devendra.shaadimatcher.users.model;

import com.devendra.shaadimatcher.callback.DataCallback;
import com.devendra.shaadimatcher.users.contract.UserContract;
import com.devendra.shaadimatcher.users.network.implementation.UserServiceImpl;
import com.devendra.shaadimatcher.users.network.response.User;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class UserModel implements UserContract.Model {

    @Inject
    public UserServiceImpl mainServiceImp;
    private CompositeDisposable compositeDisposable;

    @Inject
    public UserModel(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void fetchUsers(DataCallback<List<User>> callback) {
        mainServiceImp.getUsers(new DataCallback<List<User>>() {
            @Override
            public void onSuccess(List<User> data) {
                callback.onSuccess(data);
            }

            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void destroy() {
        compositeDisposable.clear();
    }
}
