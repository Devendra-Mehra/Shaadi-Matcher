package com.devendra.shaadimatches.main.view;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class UserEntity {

    private String gender;
    private String fullName;
    private String location;
    private String email;
    private int age;
    private String registered;
    private String picture;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "gender='" + gender + '\'' +
                ", fullName='" + fullName + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", registered='" + registered + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
