package com.devendra.shaadimatches.network.response;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class Registered {

    private String date;
    private int age;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Registered{" +
                "date='" + date + '\'' +
                ", age=" + age +
                '}';
    }
}
