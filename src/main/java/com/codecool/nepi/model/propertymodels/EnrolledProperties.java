package com.codecool.nepi.model.propertymodels;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class EnrolledProperties {

    private List<PropertyObject> currentlyEnrolledProperties;
    private static EnrolledProperties instance = null;

    public EnrolledProperties() {
        this.currentlyEnrolledProperties = new ArrayList<>();
    }

    public static EnrolledProperties getInstance(){
        if(instance == null) {
            instance = new EnrolledProperties();

        }
        return instance;
    }

}
