package com.codecool.nepi.model.useraccounts;

import com.codecool.nepi.model.propertymodels.PropertyObject;
import com.codecool.nepi.model.types.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
public class Owner extends User {

    @OneToOne
    private PropertyObject registrationProperty;
    @OneToMany
    private List<PropertyObject> currentProperties = new ArrayList<>();


    public Owner(String firstName, String lastName, String phoneNumber, String email, String password, PropertyObject registrationProperty) {
        super(firstName, lastName, phoneNumber, email, password);
        registrationProperty.setAccountCreated(true);
        this.registrationProperty = registrationProperty;
        this.currentProperties.add(registrationProperty);
        setUserType(UserType.OWNER);
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
