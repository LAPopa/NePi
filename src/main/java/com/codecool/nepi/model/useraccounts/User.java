package com.codecool.nepi.model.useraccounts;


import com.codecool.nepi.model.types.UserType;
import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class User {

    protected UUID id;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;
    protected String password;
    protected UserType userType;


    public User(String firstName, String lastName, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.id = UUID.randomUUID();
    }

    protected void setUserType(UserType userType){
        this.userType = userType;
    }
}
