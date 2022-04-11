package com.codecool.nepi.service;


import com.codecool.nepi.entity.PropertyObject;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
@Component

@Scope
public class EnrolledPropertiesService {

    private List<PropertyObject> currentlyEnrolledProperties;
    private static EnrolledPropertiesService instance = null;

    public EnrolledPropertiesService() {

        this.currentlyEnrolledProperties = new ArrayList<>();
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



}
