package com.devendra.shaadimatches.callback;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public interface DataCallback<D> {

    void onSuccess(D data);

    void onError(String error);
}
