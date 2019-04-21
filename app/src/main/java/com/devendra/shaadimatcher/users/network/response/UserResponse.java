package com.devendra.shaadimatcher.users.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class UserResponse {

    @SerializedName("results")
    private List<User> users;

    @SerializedName("info")
    private Info info;

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "users=" + users +
                ", info=" + info +
                '}';
    }
}
