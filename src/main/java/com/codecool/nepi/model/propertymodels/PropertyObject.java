package com.codecool.nepi.model.propertymodels;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PropertyObject {

    private String streetName;
    private int streetNumber;
    private int apartmentNumber;
    private boolean accountCreated = false;







}
