package com.devendra.shaadimatcher.users.view;

import com.devendra.shaadimatcher.users.network.response.User;
import com.devendra.shaadimatcher.utils.StringHelper;

/**
 * Created by Devendra Mehra on 4/21/2019.
 */
public class DisplayableUser {


    private String fullNameAge;
    private String location;
    private String email;
    private String registrationPeriod;
    private String picture;

    public DisplayableUser(User user, StringHelper stringHelper) {
        fullNameAge = user.getName().getFirstName()
                .concat(user.getName().getLastName()
                        .concat(stringHelper.getAge(Integer.parseInt(user
                                .getDateOfBirth().getAge()))));
        location = user.getLocation().getStreet()
                .concat(stringHelper.getComma())
                .concat(user.getLocation().getCity())
                .concat(stringHelper.getComma())
                .concat(user.getLocation().getState())
                .concat(stringHelper.getComma())
                .concat(user.getLocation().getPostcode());
        email = user.getEmail();
        if (user.getRegistration().getPeriod().equals(stringHelper.getZero()) ||
                user.getRegistration().getPeriod().equals(stringHelper.getOne())) {
            registrationPeriod = stringHelper.getToday();
        } else if (user.getRegistration().getPeriod().equals(stringHelper.getTwo())) {
            registrationPeriod = stringHelper.getYesterday();
        } else {
            registrationPeriod = stringHelper.getSomeDaysAgo(
                    Integer.parseInt(user.getRegistration().getPeriod()));
        }
        picture = user.getPicture().getLargeUrl();

    }


    public String getFullNameAge() {
        return fullNameAge;
    }

    public void setFullNameAge(String fullNameAge) {
        this.fullNameAge = fullNameAge;
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

    public String getRegistrationPeriod() {
        return registrationPeriod;
    }

    public void setRegistrationPeriod(String registrationPeriod) {
        this.registrationPeriod = registrationPeriod;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
