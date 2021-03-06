package com.codecool.nepi.model.registration;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OwnerRegistrationModel {

    private String email;
    private String firstName;
    private String lastName;
    private String phonenumber;
    private String streetName;
    private String streetNumber;
    private String apartment;
    private String password;
    private String enrollmentId;

    @Override
    public String toString() {
        return "OwnerRegistrationModel{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", apartment='" + apartment + '\'' +
                ", password='" + password + '\'' +
                ", enrollmentId='" + enrollmentId + '\'' +
                '}';
    }
}
