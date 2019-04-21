package com.devendra.shaadimatcher.users.network.implementation;

import com.devendra.shaadimatcher.callback.DataCallback;
import com.devendra.shaadimatcher.users.network.response.UserResponse;
import com.devendra.shaadimatcher.users.network.response.User;
import com.devendra.shaadimatcher.users.network.service.UserService;
import com.devendra.shaadimatcher.instance.ApiServiceInstance;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class UserServiceImpl {

    private UserService userService;
    private CompositeDisposable compositeDisposable;

    public UserServiceImpl(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
        userService = ApiServiceInstance.getUserServiceInstance();
    }

    public void getUsers(DataCallback<List<User>> callBack) {
        userService.getUsersResponse(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<UserResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(UserResponse userResponse) {
                        callBack.onSuccess(userResponse.getUsers());
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }
                });
    }
}
