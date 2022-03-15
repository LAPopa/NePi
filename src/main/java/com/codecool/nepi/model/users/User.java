package com.codecool.nepi.model.users;


import com.codecool.nepi.model.types.UserType;

import java.util.UUID;

public abstract class User {

    protected UUID id;
    protected String userName;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String email;
    protected UserType userType;


    public User(String userName, String firstName, String lastName, String phoneNumber, String email) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = UUID.randomUUID();
    }

    protected void setUserType(UserType userType){
        this.userType = userType;
    }
}
