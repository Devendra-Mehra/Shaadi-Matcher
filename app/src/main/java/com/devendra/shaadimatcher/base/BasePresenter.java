package com.devendra.shaadimatcher.base;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public interface BasePresenter {

    void create();

    boolean isViewAvailable();

    void onPause();

    void onDestroy();
}
