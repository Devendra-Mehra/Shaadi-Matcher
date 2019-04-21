package com.devendra.shaadimatcher.users.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class DateOfBirth {

    @SerializedName("date")
    private String dateOfBirth;
    @SerializedName("age")
    private String age;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DateOfBirth{" +
                "dateOfBirth='" + dateOfBirth + '\'' +
                ", age=" + age +
                '}';
    }
}
