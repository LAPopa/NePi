package com.codecool.nepi.entity;


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
    private boolean accountCreated;
    @Column(unique = true)
    private String enrollmentId;
    private boolean isRented;

    public PropertyObject(String streetName, String streetNumber, String apartmentNumber,String enrollmentId) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.apartmentNumber = apartmentNumber;
        this.accountCreated = false;
        this.enrollmentId = enrollmentId;
        this.isRented = false;
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
