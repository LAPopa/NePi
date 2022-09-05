package com.codecool.nepi.controller;

import com.codecool.nepi.model.registration.AdminOverseerRegistrationModel;
import com.codecool.nepi.model.registration.OwnerRegistrationModel;
import com.codecool.nepi.model.registration.RenterRegistrationModel;
import com.codecool.nepi.model.registration.OperatorRegistrationModel;
import com.codecool.nepi.service.EnrolledPropertiesCompaniesService;
import com.codecool.nepi.service.RegistrationsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController

public class RegisterController {
    RegistrationsService registrationsService;
    EnrolledPropertiesCompaniesService enrolledPropertiesCompaniesService;

    public RegisterController(RegistrationsService registrationsService, EnrolledPropertiesCompaniesService enrolledPropertiesCompaniesService) {
        this.registrationsService = registrationsService;
        this.enrolledPropertiesCompaniesService = enrolledPropertiesCompaniesService;
    }

    @GetMapping("/registration/check-enrolledPropertyIds")
    public List<String> getEnrolledPropertyIds() {
        return  enrolledPropertiesCompaniesService.getEnrolledPropertyIds();
    }

    @GetMapping("/registration/check-companyAllocatedIds")
    public List<String> getCompanyAllocatedIds() {
        return enrolledPropertiesCompaniesService.getBaseCompanyAllocatedIds();
    }

    @PostMapping("/registration/admin")
    public void registerAdmin(@RequestBody AdminOverseerRegistrationModel registrationModel) {
        registrationsService.registerAdmin(registrationModel);
    }

    @PostMapping("/registration/overseer")
    public void registerOverseer(@RequestBody AdminOverseerRegistrationModel registrationModel) {
        registrationsService.registerOverseer(registrationModel);
    }

    @PostMapping("/registration/owners")
    public void registerNewOwner(@RequestBody OwnerRegistrationModel ownerRegistrationModel) {
        registrationsService.registerNewOwner(ownerRegistrationModel);

    }

    @PostMapping("/registration/tenants")
    public void registerNewRenter(@RequestBody RenterRegistrationModel renterRegistrationModel) {
        registrationsService.registerNewRenter(renterRegistrationModel);
    }

    @PostMapping("/registration/utilities")
    public void registerNewOperator(@RequestBody OperatorRegistrationModel operatorRegistrationModel) {
        registrationsService.registerNewOperator(operatorRegistrationModel);
    }

}
