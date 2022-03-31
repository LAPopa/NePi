package com.codecool.nepi.model.useraccounts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "renters")
public class Renter extends User {

    private String contractID;

    public Renter(String firstName, String lastName, String phoneNumber, String email, String password, String contractID) {
        super(firstName, lastName, phoneNumber, email, password);
        this.contractID = contractID;
    }

    @Override
    public String toString() {
        return "Renter{" +
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
