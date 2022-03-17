package com.codecool.nepi.model.propertymodels;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PropertyObject {

    private String streetName;
    private String streetNumber;
    private String apartmentNumber;
    private boolean accountCreated = false;
    private String enrollmentId;
    private boolean isRented = false;



    @Override
    public String toString() {
        return "PropertyObject{" +
                "streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", accountCreated=" + accountCreated +
                ", enrollmentId='" + enrollmentId + '\'' +
                ", isRented=" + isRented +
                '}';
    }
}
