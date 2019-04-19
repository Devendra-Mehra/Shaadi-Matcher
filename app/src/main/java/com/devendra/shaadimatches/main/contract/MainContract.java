package com.devendra.shaadimatches.main.contract;

import com.devendra.shaadimatches.base.BasePresenter;
import com.devendra.shaadimatches.callback.DataCallback;
import com.devendra.shaadimatches.main.view.UserEntity;

import java.util.List;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */

public interface MainContract {

    interface View {

        void setUsers(List<UserEntity> userEntities);

        void toggleUsersVisibility(boolean show);

        void toggleLoading(boolean isLoading);

        void toggleErrorVisibility(boolean show);

    }

    interface Presenter extends BasePresenter {
        void onResume(View view);
    }

    interface Model {
        void fetchUsers(DataCallback<List<UserEntity>> callback);
    }
}
