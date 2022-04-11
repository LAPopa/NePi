package com.codecool.nepi.entity.useraccounts;

import com.codecool.nepi.model.types.UserType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Operator extends User {

    private String contractID;

    public Operator(String firstName, String lastName, String phoneNumber, String email, String password, String contractID) {
        super(firstName, lastName, phoneNumber, email, password);
        this.contractID = contractID;
        setUserType(UserType.OPERATOR);
    }

    @Override
    public String toString() {
        return "Operator{" +
                "contractID='" + contractID + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
