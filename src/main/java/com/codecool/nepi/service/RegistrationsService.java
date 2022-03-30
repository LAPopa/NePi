package com.codecool.nepi.service;


import com.codecool.nepi.model.companymodels.BaseCompany;
import com.codecool.nepi.model.propertymodels.PropertyObject;
import com.codecool.nepi.model.registrationmodels.OperatorRegistrationModel;
import com.codecool.nepi.model.registrationmodels.OwnerRegistrationModel;
import com.codecool.nepi.model.registrationmodels.RenterRegistrationModel;
import com.codecool.nepi.model.useraccounts.Operator;
import com.codecool.nepi.model.useraccounts.Owner;
import com.codecool.nepi.model.useraccounts.Renter;
import com.codecool.nepi.model.useraccounts.User;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@Service
@Component
public class RegistrationsService {

//    UserAccountsService userAccountsService = UserAccountsService.getInstance();
    UserAccountsService userAccountsService;
    EnrolledPropertiesService enrolledPropertiesService = EnrolledPropertiesService.getInstance();
//    BaseCompanyService baseCompanyService = BaseCompanyService.getInstance();
    private static RegistrationsService instance = null;

    public static RegistrationsService getInstance() {
        if (instance == null) {
            instance = new RegistrationsService();

        }
        return instance;
    }


    public void registerNewOwner(OwnerRegistrationModel ownerRegistrationModel) {
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

    public void registerNewTenant(RenterRegistrationModel renterRegistrationModel) {

        List<User> currentlyRegisteredAccounts = userAccountsService.getRegisteredUsersAll();
        List<Renter> currentlyRegisteredRenters = userAccountsService.getRegisteredRenters();

        for (Renter renter : currentlyRegisteredRenters) {
            if (Objects.equals(renter.getEmail(), renterRegistrationModel.getEmail())) {
                System.out.println("RENTER registration failed, email already taken");
            } else {
                for (Owner owner : userAccountsService.getRegisteredOwners()) {
                    for (PropertyObject propertyObject : owner.getCurrentProperties()) {

                        System.out.println("Checking property : " + propertyObject);
                        System.out.println("is rented? " + !propertyObject.isRented());
                        System.out.println("Checking ID equals " + propertyObject.getEnrollmentId() + "[   ]" + renterRegistrationModel.getContractId());
                        System.out.println("check matching " + Objects.equals(propertyObject.getEnrollmentId(), renterRegistrationModel.getContractId()));
                        System.out.println("CHECK ALL MATCH " + (!propertyObject.isRented() &&
                                Objects.equals(propertyObject.getEnrollmentId(), renterRegistrationModel.getContractId())));

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
    }


//    public void registerNewOperator(OperatorRegistrationModel operatorRegistrationModel) {
//
//        List<User> currentlyRegisteredAccounts = userAccountsService.getRegisteredUsersAll();
//        List<Operator> currentlyRegisteredOperators = userAccountsService.getRegisteredOperators();
//        List<BaseCompany> currentlyEnrolledCompanies = baseCompanyService.getEnrolledCompanies();
//
//        System.out.println("current operators : " + currentlyRegisteredOperators);
//
//
//        for (Operator operator : currentlyRegisteredOperators) {
//            System.out.println("current operator " + operator);
//            if (Objects.equals(operator.getEmail(), operatorRegistrationModel.getEmail())) {
//                System.out.println("OPERATOR REGISTRATION FAILED, DUPLICATE EMAIL");
//            } else {
//                for (BaseCompany company : currentlyEnrolledCompanies) {
//
//                    System.out.println("CHECKING NAMES " + company.getCompanyName() + " [] " + operatorRegistrationModel.getCompanyName());
//                    System.out.println("CHECKING KEY " + company.getIdAvailability().containsKey(operatorRegistrationModel.getContractId()));
//                    System.out.println("CHECKING if AVAILABLE " + company.getIdAvailability().get(operatorRegistrationModel.getContractId()));
//                    System.out.println("ALL CHECK " + (Objects.equals(company.getCompanyName(), operatorRegistrationModel.getCompanyName()) &&
//                            company.getIdAvailability().containsKey(operatorRegistrationModel.getContractId()) &&
//                            company.getIdAvailability().get(operatorRegistrationModel.getContractId()) == true));
//
//                    if (Objects.equals(company.getCompanyName(), operatorRegistrationModel.getCompanyName()) &&
//                            company.getIdAvailability().containsKey(operatorRegistrationModel.getContractId()) &&
//                            company.getIdAvailability().get(operatorRegistrationModel.getContractId()) == true) {
//                        Operator newOperator = new Operator(operatorRegistrationModel.getFirstName(), operatorRegistrationModel.getLastName(),
//                                operatorRegistrationModel.getPhonenumber(), operatorRegistrationModel.getEmail(), operatorRegistrationModel.getPassword(),
//                                operatorRegistrationModel.getContractId());
//                        currentlyRegisteredAccounts.add(newOperator);
//                        currentlyRegisteredOperators.add(newOperator);
//                        company.assignId(operatorRegistrationModel.getContractId());
//
//                        System.out.println("updated operators " + currentlyRegisteredOperators);
//                        System.out.println("company id list : " + company.getIdAvailability());
//                        break;
//
//                    } else {
//                        System.out.println("OPERATOR REGISTRATION FAILED");
//                    }
//                }
//            }
//        }
//    }


}
