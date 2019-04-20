package com.devendra.shaadimatches.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class MainResponse {

    @SerializedName("results")
    private List<User> users;

    @SerializedName("info")
    private Info info;

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "MainResponse{" +
                "users=" + users +
                ", info=" + info +
                '}';
    }
}
