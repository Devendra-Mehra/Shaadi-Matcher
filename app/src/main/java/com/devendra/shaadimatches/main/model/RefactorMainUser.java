package com.devendra.shaadimatches.main.model;

import android.util.Log;

import com.devendra.shaadimatches.callback.DataCallback;
import com.devendra.shaadimatches.constants.Constants;
import com.devendra.shaadimatches.main.view.UserEntity;
import com.devendra.shaadimatches.network.response.MainResponse;
import com.devendra.shaadimatches.network.response.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devendra Mehra on 4/19/2019.
 */
public class RefactorMainUser {

    private MainResponse mainResponse;

    public RefactorMainUser(MainResponse mainResponse) {
        this.mainResponse = mainResponse;
    }

    public void refactorUserResponse(DataCallback<List<UserEntity>> callback) {
        if (mainResponse.getUsers().size() > 0) {
            try {
                List<UserEntity> userEntities = new ArrayList<>();
                for (User user : mainResponse.getUsers()) {
                    UserEntity entity = new UserEntity();

                    entity.setGender(user.getGender());
                    String firstName = "";
                    String lastName = "";

                    if (user.getName().getFirstName() != null) {
                        firstName = user.getName().getFirstName();
                    }
                    if (user.getName().getLastName() != null) {
                        lastName = user.getName().getLastName();
                    }
                    entity.setFullName(firstName.concat(Constants.COMA).concat(lastName));

                    String street = "";
                    String city = "";
                    String state = "";
                    int postalCode = user.getLocation().getPostcode();
                    if (user.getLocation().getStreet() != null) {
                        street = user.getLocation().getStreet();
                    }
                    if (user.getLocation().getCity() != null) {
                        city = user.getLocation().getStreet();
                    }
                    if (user.getLocation().getCity() != null) {
                        state = user.getLocation().getState();
                    }
                    entity.setLocation(street.concat(Constants.COMA)
                            .concat(city).concat(Constants.COMA)
                            .concat(state).concat(Constants.COMA)
                            .concat(city).concat(Constants.COMA)
                            .concat(String.valueOf(postalCode)));
                    entity.setEmail(user.getEmail());
                    entity.setAge(user.getDateOfBirth().getAge());

                    String createdStatus;
                    if (user.getCreatedDay().getAge() == 1) {
                        createdStatus = "today";
                    } else if (user.getCreatedDay().getAge() == 2) {
                        createdStatus = "yesterday";
                    } else {
                        createdStatus = user.getCreatedDay().getAge() + " days ago";
                    }
                    entity.setRegistered(createdStatus);
                    entity.setPicture(user.getPicture().getLargeUrl());
                    userEntities.add(entity);
                }
                callback.onSuccess(userEntities);
            } catch (Exception e) {
                Log.d("Log20", "Exception " + e);
                callback.onError(e.getMessage());
            }

        } else {
            callback.onError("Did not find any users data");
        }
    }

}
