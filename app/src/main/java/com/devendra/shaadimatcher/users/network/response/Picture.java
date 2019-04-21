package com.devendra.shaadimatcher.users.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class Picture {

    @SerializedName("large")
    private String largeUrl;

    public String getLargeUrl() {
        return largeUrl;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "largeUrl='" + largeUrl + '\'' +
                '}';
    }
}
