package com.devendra.shaadimatcher.users.presenter;

import com.devendra.shaadimatcher.callback.DataCallback;
import com.devendra.shaadimatcher.users.contract.UserContract;
import com.devendra.shaadimatcher.users.model.UserModel;
import com.devendra.shaadimatcher.users.network.response.User;
import com.devendra.shaadimatcher.users.view.DisplayableUser;
import com.devendra.shaadimatcher.utils.StringHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class UserPresenter implements UserContract.Presenter {

    private UserContract.View view;
    private UserContract.Model model;
    private CompositeDisposable compositeDisposable;
    private StringHelper stringHelper;

    public UserPresenter(UserContract.View view, StringHelper stringHelper) {
        this.view = view;
        this.stringHelper = stringHelper;
        compositeDisposable = new CompositeDisposable();
        model = new UserModel(compositeDisposable);
    }


    @Override
    public void create() {
        if (isViewAvailable()) {
            view.toggleLoading(true);
            view.toggleUsersVisibility(false);
            view.toggleErrorVisibility(false);
        }

        model.fetchUsers(new DataCallback<List<User>>() {
            @Override
            public void onSuccess(List<User> data) {

                List<DisplayableUser> displayableUser = new ArrayList<>();

                for (User user : data) {
                    displayableUser.add(new DisplayableUser(user, stringHelper));
                }

                if (isViewAvailable()) {
                    view.toggleUsersVisibility(true);
                    view.toggleErrorVisibility(false);
                    view.toggleLoading(false);
                    view.setUsers(displayableUser);
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
    public void onResume(UserContract.View view) {
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
