package com.codecool.nepi.model.useraccounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class Renter extends User {

    private String contractID;

    public Renter(String firstName, String lastName, String phoneNumber, String email, String password, String contractID) {
        super(firstName, lastName, phoneNumber, email, password);
        this.contractID = contractID;
    }
}
