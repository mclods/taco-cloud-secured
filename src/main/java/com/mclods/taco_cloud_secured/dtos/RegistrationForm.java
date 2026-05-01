package com.mclods.taco_cloud_secured.dtos;

import com.mclods.taco_cloud_secured.entities.User;
import lombok.Data;

@Data
public class RegistrationForm {
    private String username;

    private String password;

    private String fullName;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String phoneNumber;

    public User toUser() {
        return new User(null, username, password, fullName, street, city, state, zip, phoneNumber);
    }
}
