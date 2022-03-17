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







}
