package com.codecool.nepi.model.propertymodels;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "property_objects")
public class PropertyObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String streetName;
    private String streetNumber;
    private String apartmentNumber;
    private boolean accountCreated = false;
    private String enrollmentId;
    private boolean isRented = false;

    public PropertyObject(String streetName, String streetNumber, String apartmentNumber, boolean accountCreated, String enrollmentId, boolean isRented) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.accountCreated = accountCreated;
        this.enrollmentId = enrollmentId;
        this.isRented = isRented;
    }

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
