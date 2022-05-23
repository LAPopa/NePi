package com.codecool.nepi.entity.useraccounts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "renters")
public class Renter extends User {

    private String contractID;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> ticketList;

    public Renter(String firstName, String lastName, String phoneNumber, String email, String password, String contractID) {
        super(firstName, lastName, phoneNumber, email, password);
        this.contractID = contractID;
        this.getRoles().add("ROLE_RENTER");
        this.ticketList = new ArrayList<>();
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
