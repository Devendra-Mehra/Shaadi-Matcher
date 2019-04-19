package com.devendra.shaadimatches.main.contract;

import com.devendra.shaadimatches.base.BasePresenter;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */

public interface MainContract {

    interface View {

        void setData();

        void toggleVisibility(boolean show);

        void toggleLoading(boolean isLoading);

        void toggleErrorVisibility(boolean show);

    }

    interface Presenter extends BasePresenter {
        void onResume(View view);
    }

    interface Model {
        void fetchData();
    }
}
