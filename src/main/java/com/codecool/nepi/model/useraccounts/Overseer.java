package com.codecool.nepi.model.useraccounts;

import com.codecool.nepi.model.types.UserType;

public class Overseer extends User {
    public Overseer(String firstName, String lastName, String phoneNumber, String email, String password) {
        super(firstName, lastName, phoneNumber, email, password);
        setUserType(UserType.OVERSEER);
    }
}
