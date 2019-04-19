package com.devendra.shaadimatches.main.model;

import com.devendra.shaadimatches.callback.DataCallback;
import com.devendra.shaadimatches.main.contract.MainContract;
import com.devendra.shaadimatches.main.view.UserEntity;
import com.devendra.shaadimatches.network.implementing.MainServiceImpl;
import com.devendra.shaadimatches.network.response.MainResponse;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class MainModel implements MainContract.Model {
    private MainServiceImpl mainServiceImp;
    private RefactorMainUser refactorMainUser;

    public MainModel(CompositeDisposable compositeDisposable) {
        mainServiceImp = new MainServiceImpl(compositeDisposable);
    }

    @Override
    public void fetchUsers(DataCallback<List<UserEntity>> callback) {
        mainServiceImp.getUsers(new DataCallback<MainResponse>() {
            @Override
            public void onSuccess(MainResponse data) {
                refactorMainUser = new RefactorMainUser(data);
                refactorMainUser.refactorUserResponse(new DataCallback<List<UserEntity>>() {
                    @Override
                    public void onSuccess(List<UserEntity> data) {
                        callback.onSuccess(data);
                    }

                    @Override
                    public void onError(String error) {
                        callback.onError(error);
                    }
                });
            }

            @Override
            public void onError(String error) {
                callback.onError(error);
            }
        });
    }


}
