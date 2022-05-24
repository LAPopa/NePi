package com.codecool.nepi.entity.useraccounts;

import com.codecool.nepi.entity.Ticket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "renters")
public class Renter extends User {

    private String contractID;
    @OneToMany
    private List<Ticket> ticketList;

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
