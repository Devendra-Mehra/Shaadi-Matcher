package com.devendra.shaadimatcher.users.contract;

import com.devendra.shaadimatcher.base.BasePresenter;
import com.devendra.shaadimatcher.callback.DataCallback;
import com.devendra.shaadimatcher.users.network.response.User;
import com.devendra.shaadimatcher.users.view.DisplayableUser;

import java.util.List;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */

public interface UserContract {

    interface View {

        void setUsers(List<DisplayableUser> userEntities);

        void toggleUsersVisibility(boolean show);

        void toggleLoading(boolean isLoading);

        void toggleErrorVisibility(boolean show);

        void setError(String error);

    }

    interface Presenter extends BasePresenter {
        void onResume(View view);
    }

    interface Model {
        void fetchUsers(DataCallback<List<User>> callback);
    }
}
