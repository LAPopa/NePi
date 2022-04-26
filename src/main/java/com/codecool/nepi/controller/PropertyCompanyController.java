package com.codecool.nepi.controller;


import com.codecool.nepi.model.registrationmodels.CompanyRegistrationModel;
import com.codecool.nepi.model.registrationmodels.PropertyRegistrationModel;
import com.codecool.nepi.service.EnrolledPropertiesCompaniesService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController

public class PropertyCompanyController {

    EnrolledPropertiesCompaniesService enrolledPropertiesCompaniesService;


    @PostMapping("/registration/new-property")
    public void registerNewProperty(@RequestBody PropertyRegistrationModel propertyRegistrationModel){
        enrolledPropertiesCompaniesService.registerNewProperty(propertyRegistrationModel);
    }

    @PostMapping("/registration/new-company")
    public void registerNewCompany(@RequestBody CompanyRegistrationModel companyRegistrationModel) {
        enrolledPropertiesCompaniesService.registerNewCompany(companyRegistrationModel);
    }

    @PostMapping("/registration/company/{companyName}/add-id")
    public void addNewIdToCompany(@PathVariable String companyName, @RequestBody String id) {
        enrolledPropertiesCompaniesService.addNewCompanyId(companyName, id);
    }
}
