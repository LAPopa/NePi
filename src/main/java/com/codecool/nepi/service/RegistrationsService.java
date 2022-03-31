package com.codecool.nepi.service;


import com.codecool.nepi.model.companymodels.BaseCompany;
import com.codecool.nepi.model.propertymodels.PropertyObject;
import com.codecool.nepi.model.registrationmodels.OperatorRegistrationModel;
import com.codecool.nepi.model.registrationmodels.OwnerRegistrationModel;
import com.codecool.nepi.model.registrationmodels.RenterRegistrationModel;
import com.codecool.nepi.model.types.UserType;
import com.codecool.nepi.model.useraccounts.Operator;
import com.codecool.nepi.model.useraccounts.Owner;
import com.codecool.nepi.model.useraccounts.Renter;
import com.codecool.nepi.model.useraccounts.User;
import com.codecool.nepi.repository.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aspectj.apache.bcel.generic.Type;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Getter
@Service
@Component
public class RegistrationsService {

    private UserAccountsService userAccountsService;
    private AdminRepository adminRepository;
    private OperatorRepository operatorRepository;
    private OverseerRepository overseerRepository;
    private OwnerRepository ownerRepository;
    private RenterRepository renterRepository;
    private PropertyObjectRepository propertyObjectRepository;
    private EnrolledPropertiesService enrolledPropertiesService;
    private BaseCompanyService baseCompanyService;


    public void registerNewOwner(OwnerRegistrationModel ownerRegistrationModel) {

        if (userAccountsService.checkValidEmail(UserType.OWNER, ownerRegistrationModel.getEmail()) &&
                !propertyObjectRepository.checkIfAccountWasCreated(ownerRegistrationModel.getEnrollmentId()) &&
                Objects.equals(propertyObjectRepository.checkStreetName(ownerRegistrationModel.getEnrollmentId()), ownerRegistrationModel.getStreetName()) &&
                Objects.equals(propertyObjectRepository.checkStreetNumber(ownerRegistrationModel.getEnrollmentId()), ownerRegistrationModel.getStreetNumber()) &&
                Objects.equals(propertyObjectRepository.checkApartmentNumber(ownerRegistrationModel.getEnrollmentId()), ownerRegistrationModel.getApartment())) {

            PropertyObject currentProperty = propertyObjectRepository.getPropertyObjectByEnrollmentId(ownerRegistrationModel.getEnrollmentId());
            Owner newOwner = new Owner(ownerRegistrationModel.getFirstName(), ownerRegistrationModel.getLastName(),
                    ownerRegistrationModel.getPhonenumber(), ownerRegistrationModel.getEmail(), ownerRegistrationModel.getPassword(), currentProperty
            );
            System.out.println("OWNER REGISTRATION : " + ownerRegistrationModel.toString());
            ownerRepository.save(newOwner);
            propertyObjectRepository.save(currentProperty);
            System.out.println("Owner registration successful !");

        } else {
            System.out.println("Owner registration failed, email " + ownerRegistrationModel.getEmail() + " already assigned");
        }

    }

    public void registerNewTenant(RenterRegistrationModel renterRegistrationModel) {

//        List<User> currentlyRegisteredAccounts = userAccountsService.getRegisteredUsersAll();
//        List<Renter> currentlyRegisteredRenters = userAccountsService.getRegisteredRenters();
//
//        for (Renter renter : currentlyRegisteredRenters) {
//            if (Objects.equals(renter.getEmail(), renterRegistrationModel.getEmail())) {
//                System.out.println("RENTER registration failed, email already taken");
//            } else {
//                for (Owner owner : userAccountsService.getRegisteredOwners()) {
//                    for (PropertyObject propertyObject : owner.getCurrentProperties()) {
//
//                        System.out.println("Checking property : " + propertyObject);
//                        System.out.println("is rented? " + !propertyObject.isRented());
//                        System.out.println("Checking ID equals " + propertyObject.getEnrollmentId() + "[   ]" + renterRegistrationModel.getContractId());
//                        System.out.println("check matching " + Objects.equals(propertyObject.getEnrollmentId(), renterRegistrationModel.getContractId()));
//                        System.out.println("CHECK ALL MATCH " + (!propertyObject.isRented() &&
//                                Objects.equals(propertyObject.getEnrollmentId(), renterRegistrationModel.getContractId())));
//
//                        if ((propertyObject.isRented() == false) && Objects.equals(propertyObject.getEnrollmentId(), renterRegistrationModel.getContractId())) {
//                            Renter newRenter = new Renter(renterRegistrationModel.getFirstName(), renterRegistrationModel.getLastName(), renterRegistrationModel.getPhonenumber(),
//                                    renterRegistrationModel.getEmail(), renterRegistrationModel.getPassword(), renterRegistrationModel.getContractId());
//                            currentlyRegisteredRenters.add(newRenter);
//                            currentlyRegisteredAccounts.add(newRenter);
//                            propertyObject.setRented(true);
//
//                            System.out.println("Renter created " + newRenter);
//                            System.out.println("Current renters" + currentlyRegisteredRenters);
//                            System.out.println("Owner's properties list : " + owner.getCurrentProperties());
//                            break;
//                        }
//                    }
//                }
//            }
//
//        }
    }


    public void registerNewOperator(OperatorRegistrationModel operatorRegistrationModel) {

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
    }


}
