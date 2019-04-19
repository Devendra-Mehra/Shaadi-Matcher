package com.devendra.shaadimatches.network.implementing;

import com.devendra.shaadimatches.callback.DataCallback;
import com.devendra.shaadimatches.constants.Constants;
import com.devendra.shaadimatches.network.response.MainResponse;
import com.devendra.shaadimatches.network.service.MainService;
import com.devendra.shaadimatches.singleinstance.ApiServiceInstance;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class MainServiceImpl {

    private MainService mainService;
    private CompositeDisposable compositeDisposable;

    public MainServiceImpl(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
        mainService = ApiServiceInstance.getMainServiceInstance();
    }

    public void getUsers(DataCallback<MainResponse> callBack) {
        Single<MainResponse> single = mainService.getUsersResponse();

        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<MainResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(MainResponse mainResponse) {
                        callBack.onSuccess(mainResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError(e.getMessage());
                    }
                });

    }
}
