package com.devendra.shaadimatches.singleinstance;

import com.devendra.shaadimatches.network.service.MainService;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */

public class ApiServiceInstance {

    private static volatile MainService mainServiceInstance = null;

    private ApiServiceInstance() {
        if (mainServiceInstance != null) {
            throw new RuntimeException("Can not create this way, " +
                    "please use getMainServiceInstance method to get a instance");
        }
    }

    public static MainService getMainServiceInstance() {
        if (mainServiceInstance == null) {
            synchronized (ApiServiceInstance.class) {
                if (mainServiceInstance == null) {
                    mainServiceInstance = RetrofitInstance.getRetrofitInstance()
                            .create(MainService.class);
                }
            }
        }
        return mainServiceInstance;
    }

}
