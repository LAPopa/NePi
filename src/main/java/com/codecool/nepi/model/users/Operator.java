package com.codecool.nepi.model.users;

import com.codecool.nepi.model.types.UserType;

public class Operator extends User {

    private String contractID;

    public Operator(String userName, String firstName, String lastName, String phoneNumber, String email, String contractID) {
        super(userName, firstName, lastName, phoneNumber, email);
        this.contractID = contractID;
        setUserType(UserType.OPERATOR);
    }
}
