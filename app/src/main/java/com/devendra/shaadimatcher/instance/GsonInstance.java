package com.devendra.shaadimatcher.instance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonInstance {
    private static volatile Gson gsonInstance = null;

    private GsonInstance() {
        if (gsonInstance != null) {
            throw new RuntimeException("Can not create this way, please use " +
                    "getGsonInstance method");
        }
    }


    public static Gson getGsonInstance() {
        if (gsonInstance == null) {
            synchronized (GsonInstance.class) {
                if (gsonInstance == null) {
                    gsonInstance = new GsonBuilder()
                            .setLenient()
                            .create();
                }
            }
        }
        return gsonInstance;
    }

}
