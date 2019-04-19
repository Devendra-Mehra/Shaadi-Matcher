package com.devendra.shaadimatches.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class DateOfBirth {

    @SerializedName("date")
    private String dateOfBirth;
    private int age;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
