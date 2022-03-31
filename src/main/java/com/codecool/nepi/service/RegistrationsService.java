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
import com.codecool.nepi.repository.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    private BaseCompanyRepository baseCompanyRepository;
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

    public void registerNewRenter(RenterRegistrationModel renterRegistrationModel) {

        if (userAccountsService.checkValidEmail(UserType.RENTER, renterRegistrationModel.getEmail()) &&
                propertyObjectRepository.checkIfAccountWasCreated(renterRegistrationModel.getContractId()) &&
                !propertyObjectRepository.checkIsRented(renterRegistrationModel.getContractId())) {

            PropertyObject currentProperty = propertyObjectRepository.getPropertyObjectByEnrollmentId(renterRegistrationModel.getContractId());
            Renter newRenter = new Renter(renterRegistrationModel.getFirstName(), renterRegistrationModel.getLastName(),
                    renterRegistrationModel.getPhonenumber(), renterRegistrationModel.getEmail(), renterRegistrationModel.getPassword(),
                    renterRegistrationModel.getContractId());

            System.out.println("RENTER  " + newRenter.toString());

            currentProperty.setRented(true);
            propertyObjectRepository.save(currentProperty);
            renterRepository.save(newRenter);
        }
    }


    public void registerNewOperator(OperatorRegistrationModel operatorRegistrationModel) {

        System.out.println("Company found : " + baseCompanyRepository.findByCompanyName(operatorRegistrationModel.getCompanyName()));
        System.out.println("Current ids : " + baseCompanyRepository.getAllocatedIds(operatorRegistrationModel.getCompanyName()));

        if (userAccountsService.checkValidEmail(UserType.OPERATOR, operatorRegistrationModel.getEmail()) &&
                baseCompanyRepository.findByCompanyName(operatorRegistrationModel.getCompanyName()) != null &&
                baseCompanyRepository.getAllocatedIds(operatorRegistrationModel.getCompanyName()).contains(operatorRegistrationModel.getContractId())) {

            String newIds = baseCompanyRepository.getAllocatedIds(operatorRegistrationModel.getCompanyName()).replace(operatorRegistrationModel.getContractId(), "");
            BaseCompany currentCompany = baseCompanyRepository.findByAllocatedId(operatorRegistrationModel.getContractId());


            System.out.println("NEW IDS " + newIds);

            currentCompany.setAllocatedIds(newIds);
            System.out.println("MODIFIED COMPANY : " + currentCompany.toString());

            Operator newOperator = new Operator(operatorRegistrationModel.getFirstName(), operatorRegistrationModel.getLastName(),
                    operatorRegistrationModel.getPhonenumber(), operatorRegistrationModel.getEmail(), operatorRegistrationModel.getPassword(),
                    operatorRegistrationModel.getContractId());

            System.out.println("OPERATOR " + newOperator.toString());

            operatorRepository.save(newOperator);
            baseCompanyRepository.save(currentCompany);
        }

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
