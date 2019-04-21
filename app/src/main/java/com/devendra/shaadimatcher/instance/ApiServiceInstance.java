package com.devendra.shaadimatcher.instance;

import com.devendra.shaadimatcher.users.network.service.UserService;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */

public class ApiServiceInstance {

    private static volatile UserService userServiceInstance = null;

    private ApiServiceInstance() {
        if (userServiceInstance != null) {
            throw new RuntimeException("Can not create this way, " +
                    "please use getUserServiceInstance method to get a instance");
        }
    }

    public static UserService getUserServiceInstance() {
        if (userServiceInstance == null) {
            synchronized (ApiServiceInstance.class) {
                if (userServiceInstance == null) {
                    userServiceInstance = RetrofitInstance.getRetrofitInstance()
                            .create(UserService.class);
                }
            }
        }
        return userServiceInstance;
    }

}
