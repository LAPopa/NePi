package com.codecool.nepi.model.useraccounts;

import com.codecool.nepi.model.types.UserType;

public class Operator extends User {

    private String contractID;

    public Operator(String firstName, String lastName, String phoneNumber, String email, String password, String contractID) {
        super(firstName, lastName, phoneNumber, email, password);
        this.contractID = contractID;
        setUserType(UserType.OPERATOR);
    }
}
