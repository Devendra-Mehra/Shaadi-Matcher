package com.devendra.shaadimatches.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class User {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    @SerializedName("dob")
    private DateOfBirth dateOfBirth;
    @SerializedName("registered")
    private Registered createdDay;

    private Picture picture;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Registered getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Registered createdDay) {
        this.createdDay = createdDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "gender='" + gender + '\'' +
                ", name=" + name +
                ", location=" + location +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", createdDay=" + createdDay +
                ", picture=" + picture +
                '}';
    }
}
