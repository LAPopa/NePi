package com.codecool.nepi.model.users;

import com.codecool.nepi.model.types.UserType;

public class Overseer extends User {
    public Overseer(String userName, String firstName, String lastName, String phoneNumber, String email) {
        super(userName, firstName, lastName, phoneNumber, email);
        setUserType(UserType.OVERSEER);
    }
}
