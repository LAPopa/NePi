package com.codecool.nepi.model.users;

import com.codecool.nepi.model.types.UserType;

public class Admin extends User {
    public Admin(String userName, String firstName, String lastName, String phoneNumber, String email) {
        super(userName, firstName, lastName, phoneNumber, email);
        setUserType(UserType.ADMIN);
    }
}
