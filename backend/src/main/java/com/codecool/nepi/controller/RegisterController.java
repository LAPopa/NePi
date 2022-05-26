package com.codecool.nepi.controller;


import com.codecool.nepi.model.registration.AdminOverseerRegistrationModel;
import com.codecool.nepi.model.registration.OwnerRegistrationModel;
import com.codecool.nepi.model.registration.RenterRegistrationModel;
import com.codecool.nepi.model.registration.OperatorRegistrationModel;
import com.codecool.nepi.service.RegistrationsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController


public class RegisterController {

    RegistrationsService registrationsService;

    public RegisterController(RegistrationsService registrationsService){this.registrationsService = registrationsService;}

    @PostMapping("/registration/admin")
    public void registerAdmin(@RequestBody AdminOverseerRegistrationModel registrationModel){
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