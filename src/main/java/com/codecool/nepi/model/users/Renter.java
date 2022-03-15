package com.codecool.nepi.model.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Renter extends User {

    private String contractID;

    public Renter(String userName, String firstName, String lastName, String phoneNumber, String email, String contractID) {
        super(userName, firstName, lastName, phoneNumber, email);
        this.contractID = contractID;
    }
}
