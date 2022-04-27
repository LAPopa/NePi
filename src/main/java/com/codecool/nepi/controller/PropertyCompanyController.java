package com.codecool.nepi.controller;


import com.codecool.nepi.model.registrationmodels.CompanyRegistrationModel;
import com.codecool.nepi.model.registrationmodels.PropertyRegistrationModel;
import com.codecool.nepi.service.EnrolledPropertiesCompaniesService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController

public class PropertyCompanyController {

    EnrolledPropertiesCompaniesService enrolledPropertiesCompaniesService;

    public PropertyCompanyController(EnrolledPropertiesCompaniesService enrolledPropertiesCompaniesService) {
        this.enrolledPropertiesCompaniesService = enrolledPropertiesCompaniesService;
    }

    @PostMapping("/registration/new-property")
    public void registerNewProperty(@RequestBody PropertyRegistrationModel propertyRegistrationModel) {
        enrolledPropertiesCompaniesService.enrollNewProperty(propertyRegistrationModel);
    }

    @PostMapping("/registration/new-company")
    public void registerNewCompany(@RequestBody CompanyRegistrationModel companyRegistrationModel) {
        enrolledPropertiesCompaniesService.registerNewCompany(companyRegistrationModel);
    }

    @PostMapping("/registration/company/{companyName}/add-id")
    public void addNewIdToCompany(@PathVariable String companyName, @RequestBody String id) {
        enrolledPropertiesCompaniesService.addNewCompanyId(companyName, id);
    }

    @PostMapping("/registration/owner/{ownerId}/add-property")
    public void assignProperty(@PathVariable String ownerId, @RequestBody PropertyRegistrationModel propertyRegistrationModel) {
        enrolledPropertiesCompaniesService.registerNewPropertyByOwner(propertyRegistrationModel, ownerId);
    }
}
