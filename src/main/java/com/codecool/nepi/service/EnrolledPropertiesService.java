package com.codecool.nepi.service;


import com.codecool.nepi.model.propertymodels.PropertyObject;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class EnrolledPropertiesService {

    private List<PropertyObject> currentlyEnrolledProperties;
    private static EnrolledPropertiesService instance = null;

    public EnrolledPropertiesService() {

        this.currentlyEnrolledProperties = new ArrayList<>();
        populateList();
    }

    public static EnrolledPropertiesService getInstance(){
        if(instance == null) {
            instance = new EnrolledPropertiesService();

        }
        return instance;
    }

    public void enrollNewProperty(PropertyObject propertyObject) {
        this.currentlyEnrolledProperties.add(propertyObject);
    }

    private void populateList() {
        this.currentlyEnrolledProperties.add(new PropertyObject("First Street", "5", "1",false));
        this.currentlyEnrolledProperties.add(new PropertyObject("First Street", "5", "2",false));
        this.currentlyEnrolledProperties.add(new PropertyObject("Second Street", "6", "1",false));
        this.currentlyEnrolledProperties.add(new PropertyObject("Second Street", "6", "2",false));
    }

}
