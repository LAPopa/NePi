package com.codecool.nepi.controller;


import com.codecool.nepi.model.companymodels.BaseCompany;
import com.codecool.nepi.model.registrationmodels.OwnerRegistrationModel;
import com.codecool.nepi.model.registrationmodels.RenterRegistrationModel;
import com.codecool.nepi.model.registrationmodels.OperatorRegistrationModel;
import com.codecool.nepi.model.useraccounts.Operator;
import com.codecool.nepi.model.useraccounts.User;
import com.codecool.nepi.service.RegistrationsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController


public class RegisterController {

    RegistrationsService registrationsService = RegistrationsService.getInstance();

    @PostMapping("/registration/owners")
    public void registerNewOwner(@RequestBody OwnerRegistrationModel ownerRegistrationModel) {
        registrationsService.registerNewOwner(ownerRegistrationModel);

    }

    @PostMapping("/registration/tenants")
    public void registerNewRenter(@RequestBody RenterRegistrationModel renterRegistrationModel) {
        registrationsService.registerNewTenant(renterRegistrationModel);
    }


    @PostMapping("/registration/utilities")
    public void registerNewOperator(@RequestBody OperatorRegistrationModel operatorRegistrationModel) {
        registrationsService.registerNewOperator(operatorRegistrationModel);
    }


}
