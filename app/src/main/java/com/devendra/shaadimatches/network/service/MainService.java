package com.devendra.shaadimatches.network.service;

import com.devendra.shaadimatches.network.response.MainResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public interface MainService {

    @GET("?results=10")
    Single<MainResponse> getUsersResponse();
}
