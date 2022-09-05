package com.codecool.nepi.entity.useraccounts;

import com.codecool.nepi.entity.PropertyObject;
import com.codecool.nepi.entity.Ticket;
import com.codecool.nepi.model.types.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "owners")
@NoArgsConstructor
@Getter
@Setter
public class Owner extends User {
    @OneToOne
    private PropertyObject registrationProperty;
    @OneToMany(fetch = FetchType.EAGER)
    private List<PropertyObject> currentProperties = new ArrayList<>();
    @OneToMany
    private List<Ticket> ticketList;

    public Owner(String firstName, String lastName, String phoneNumber, String email, String password, PropertyObject registrationProperty) {
        super(firstName, lastName, phoneNumber, email, password);
        registrationProperty.setAccountCreated(true);
        this.registrationProperty = registrationProperty;
        this.currentProperties.add(registrationProperty);
        setUserType(UserType.OWNER);
        this.getRoles().add("ROLE_OWNER");
        this.ticketList = new ArrayList<>();
    }

    public void assignProperty(PropertyObject propertyObject) {
        propertyObject.setAccountCreated(true);
        this.currentProperties.add(propertyObject);
    }

    public void rentProperty(PropertyObject propertyObject) {
        propertyObject.setRented(true);
    }

    @Override
    public String toString() {
        return "Owner{" +
                getFirstName() +
                getLastName() +
                "registrationProperty=" + registrationProperty +
                ", currentProperties=" + currentProperties +
                '}';
    }
}
