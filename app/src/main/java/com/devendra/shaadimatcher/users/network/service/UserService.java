package com.devendra.shaadimatcher.users.network.service;

import com.devendra.shaadimatcher.users.network.response.UserResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public interface UserService {

    @GET(".")
    Single<UserResponse> getUsersResponse(@Query("results") int value);
}
