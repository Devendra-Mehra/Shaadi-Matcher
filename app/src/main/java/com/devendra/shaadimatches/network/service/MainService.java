package com.devendra.shaadimatches.network.service;

import com.devendra.shaadimatches.network.response.MainResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public interface MainService {

    @GET("?results={results_count}")
    Single<MainResponse> getMainResponse(@Path("results_count") String resultsCount);
}
