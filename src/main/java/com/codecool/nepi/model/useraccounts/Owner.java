package com.codecool.nepi.model.useraccounts;

import com.codecool.nepi.model.propertymodels.PropertyObject;
import com.codecool.nepi.model.types.UserType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Owner extends User {

    private PropertyObject registrationProperty;
    private List<PropertyObject> currentProperties = new ArrayList<>();


    public Owner(String firstName, String lastName, String phoneNumber, String email,String password, PropertyObject registrationProperty) {
        super(firstName, lastName, phoneNumber, email, password);
        this.registrationProperty = registrationProperty;
        this.currentProperties.add(registrationProperty);
        setUserType(UserType.OWNER);
    }

    public void assignProperty (PropertyObject propertyObject) {
        this.currentProperties.add(propertyObject);
    }
}
