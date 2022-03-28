package com.codecool.nepi.model.propertymodels;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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
