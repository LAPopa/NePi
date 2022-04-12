package com.codecool.nepi.service;


import com.codecool.nepi.model.propertymodels.PropertyObject;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
@Component

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
        PropertyObject fStreet1 = new PropertyObject("First Street", "5", "1",false,"ID123",false);
        PropertyObject fStreet2 = new PropertyObject("First Street", "5", "2",false,"ID456",false);
        PropertyObject sStreet1 = new PropertyObject("Second Street", "6", "1",false,"ID000",false);
        PropertyObject sStreet2 = new PropertyObject("Second Street", "6", "2",false,"ID111",false);
        PropertyObject testStreet = new PropertyObject("Test Street", "1", "1",false,"ID111",false);
        PropertyObject testRent1 = new PropertyObject("Test Rent 1", "1", "1",false,"ID222",false);
        PropertyObject testRent2 = new PropertyObject("Test Rent 2", "1", "2",false,"ID223",false);

        this.currentlyEnrolledProperties.add(fStreet1);
        this.currentlyEnrolledProperties.add(fStreet2);
        this.currentlyEnrolledProperties.add(sStreet1);
        this.currentlyEnrolledProperties.add(sStreet2);
        this.currentlyEnrolledProperties.add(testStreet);
        this.currentlyEnrolledProperties.add(testRent1);
        this.currentlyEnrolledProperties.add(testRent2);
    }

}
