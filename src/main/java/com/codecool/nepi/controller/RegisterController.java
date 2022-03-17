package com.codecool.nepi.controller;


import com.codecool.nepi.model.propertymodels.PropertyObject;
import com.codecool.nepi.model.registrationmodels.OwnerRegistrationModel;
import com.codecool.nepi.model.registrationmodels.RenterRegistrationModel;
import com.codecool.nepi.model.useraccounts.Owner;
import com.codecool.nepi.model.useraccounts.Renter;
import com.codecool.nepi.model.useraccounts.User;
import com.codecool.nepi.service.EnrolledPropertiesService;
import com.codecool.nepi.service.UserAccountsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController


public class RegisterController {

    UserAccountsService userAccountsService = UserAccountsService.getInstance();
    EnrolledPropertiesService enrolledPropertiesService = EnrolledPropertiesService.getInstance();

    @PostMapping("/registration/owners")
    public void registerNewOwner(@RequestBody OwnerRegistrationModel ownerRegistrationModel) {
        List<Owner> currentlyRegisteredOwners = userAccountsService.getRegisteredOwners();
        List<User> currentlyRegisteredAccounts = userAccountsService.getRegisteredUsersAll();
        for (Owner account : currentlyRegisteredOwners) {
            if (Objects.equals(account.getEmail(), ownerRegistrationModel.getEmail()) ||
                    (Objects.equals(account.getRegistrationProperty().getStreetName(), ownerRegistrationModel.getStreetName()) &&
                            Objects.equals(account.getRegistrationProperty().getStreetNumber(), ownerRegistrationModel.getStreetNumber()) &&
                            Objects.equals(account.getRegistrationProperty().getApartmentNumber(), ownerRegistrationModel.getApartment()) &&
                            Objects.equals(account.getRegistrationProperty().getEnrollmentId(), ownerRegistrationModel.getEnrollmentId()))) {
                System.out.println("OWNER ACCOUNT INVALID");
            } else {
                List<PropertyObject> enrolledProperties = enrolledPropertiesService.getCurrentlyEnrolledProperties();
                Optional<PropertyObject> checkEnrolledProperty = enrolledProperties.stream()
                        .filter(streetName -> streetName.getStreetName().equals(ownerRegistrationModel.getStreetName()))
                        .filter(streetNumber -> streetNumber.getStreetNumber().equals(ownerRegistrationModel.getStreetNumber()))
                        .filter(apartmentNumber -> apartmentNumber.getApartmentNumber().equals(ownerRegistrationModel.getApartment()))
                        .filter(isRegistered -> !isRegistered.isAccountCreated()).findFirst();
                PropertyObject foundProperty = checkEnrolledProperty.orElse(null);
                if (foundProperty != null) {
                    Owner newOwner = new Owner(ownerRegistrationModel.getFirstName(), ownerRegistrationModel.getLastName(), ownerRegistrationModel.getPhonenumber(),
                            ownerRegistrationModel.getEmail(), ownerRegistrationModel.getPassword(), foundProperty);
                    currentlyRegisteredOwners.add(newOwner);
                    currentlyRegisteredAccounts.add(newOwner);

                    System.out.println("OWNER REGISTERED SUCCESSFULLY");

                    for (Owner owner : currentlyRegisteredOwners) {
                        System.out.println(owner);
                    }

                }
            }

        }

    }

    @PostMapping("/registration/tenants")
    public void registerNewTenant(@RequestBody RenterRegistrationModel renterRegistrationModel){

        List<User> currentlyRegisteredAccounts = userAccountsService.getRegisteredUsersAll();
        List<Renter> currentlyRegisteredRenters = userAccountsService.getRegisteredRenters();

        for (Renter renter : currentlyRegisteredRenters){
            if (Objects.equals(renter.getEmail(), renterRegistrationModel.getEmail())) {
                System.out.println("RENTER registration failed, email already taken");
            }
        }

        for (Owner owner : userAccountsService.getRegisteredOwners()){
            for (PropertyObject propertyObject : owner.getCurrentProperties()) {

                System.out.println("Checking property : " + propertyObject);
                System.out.println("is rented? " + !propertyObject.isRented());
                System.out.println("Checking ID equals " + propertyObject.getEnrollmentId()+ "[   ]" + renterRegistrationModel.getContractId());
                System.out.println("check matching " + Objects.equals(propertyObject.getEnrollmentId(), renterRegistrationModel.getContractId()));
                System.out.println("CHECK ALL MATCH " + (!propertyObject.isRented() && Objects.equals(propertyObject.getEnrollmentId(), renterRegistrationModel.getContractId())));

                if ((propertyObject.isRented() == false) && Objects.equals(propertyObject.getEnrollmentId(), renterRegistrationModel.getContractId())) {
                    Renter newRenter = new Renter(renterRegistrationModel.getFirstName(), renterRegistrationModel.getLastName(), renterRegistrationModel.getPhonenumber(),
                            renterRegistrationModel.getEmail(), renterRegistrationModel.getPassword(), renterRegistrationModel.getContractId());
                    currentlyRegisteredRenters.add(newRenter);
                    currentlyRegisteredAccounts.add(newRenter);
                    propertyObject.setRented(true);

                    System.out.println("Renter created " + newRenter);
                    System.out.println("Current renters" + currentlyRegisteredRenters);
                    System.out.println("Owner's properties list : " + owner.getCurrentProperties());
                    break;
                }
            }
        }

    }


}
