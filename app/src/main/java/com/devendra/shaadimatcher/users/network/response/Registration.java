package com.devendra.shaadimatcher.users.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class Registration {

    @SerializedName("date")
    private String date;
    @SerializedName("age")
    private String period;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "date='" + date + '\'' +
                ", period='" + period + '\'' +
                '}';
    }
}
