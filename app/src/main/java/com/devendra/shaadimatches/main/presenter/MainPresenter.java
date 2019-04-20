package com.devendra.shaadimatches.main.presenter;

import com.devendra.shaadimatches.callback.DataCallback;
import com.devendra.shaadimatches.main.contract.MainContract;
import com.devendra.shaadimatches.main.model.MainModel;
import com.devendra.shaadimatches.main.view.UserEntity;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private MainContract.Model model;
    private CompositeDisposable compositeDisposable;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        compositeDisposable = new CompositeDisposable();
        this.model = new MainModel(compositeDisposable);
    }


    @Override
    public void create() {
        if (isViewAvailable()) {
            view.toggleLoading(true);
            view.toggleUsersVisibility(false);
            view.toggleErrorVisibility(false);
        }

        model.fetchUsers(new DataCallback<List<UserEntity>>() {
            @Override
            public void onSuccess(List<UserEntity> data) {
                if (isViewAvailable()) {
                    view.toggleUsersVisibility(true);
                    view.toggleErrorVisibility(false);
                    view.toggleLoading(false);
                    view.setUsers(data);
                }
            }

            @Override
            public void onError(String error) {
                if (isViewAvailable()) {
                    view.toggleUsersVisibility(false);
                    view.toggleErrorVisibility(true);
                    view.toggleLoading(false);
                    view.setError(error);
                }
            }
        });

    }

    @Override
    public boolean isViewAvailable() {
        return view != null;

    }

    @Override
    public void onResume(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onPause() {
        view = null;
    }

    @Override
    public void onDestroy() {
        view = null;
        compositeDisposable.clear();
    }
}
