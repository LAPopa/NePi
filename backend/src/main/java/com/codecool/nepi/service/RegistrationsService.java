package com.codecool.nepi.service;

import com.codecool.nepi.entity.BaseCompany;
import com.codecool.nepi.entity.PropertyObject;
import com.codecool.nepi.entity.useraccounts.Admin;
import com.codecool.nepi.entity.useraccounts.Operator;
import com.codecool.nepi.entity.useraccounts.Overseer;
import com.codecool.nepi.entity.useraccounts.Owner;
import com.codecool.nepi.entity.useraccounts.Renter;
import com.codecool.nepi.model.registration.AdminOverseerRegistrationModel;
import com.codecool.nepi.model.registration.OperatorRegistrationModel;
import com.codecool.nepi.model.registration.OwnerRegistrationModel;
import com.codecool.nepi.model.registration.RenterRegistrationModel;
import com.codecool.nepi.model.types.UserType;
import com.codecool.nepi.repository.AdminRepository;
import com.codecool.nepi.repository.BaseCompanyRepository;
import com.codecool.nepi.repository.OperatorRepository;
import com.codecool.nepi.repository.OverseerRepository;
import com.codecool.nepi.repository.OwnerRepository;
import com.codecool.nepi.repository.PropertyObjectRepository;
import com.codecool.nepi.repository.RenterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Service
@Component
public class RegistrationsService {
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    private UserAccountsService userAccountsService;
    private AdminRepository adminRepository;
    private OperatorRepository operatorRepository;
    private OverseerRepository overseerRepository;
    private OwnerRepository ownerRepository;
    private RenterRepository renterRepository;
    private PropertyObjectRepository propertyObjectRepository;
    private EnrolledPropertiesCompaniesService enrolledPropertiesCompaniesService;
    private BaseCompanyRepository baseCompanyRepository;

    public void registerAdmin(AdminOverseerRegistrationModel registrationModel) {
        if (userAccountsService.checkValidEmail(UserType.ADMIN, registrationModel.getEmail())) {
            Admin newAdmin = new Admin(registrationModel.getFirstName(), registrationModel.getLastName(),
                    registrationModel.getPhonenumber(), registrationModel.getEmail(), passwordEncoder.encode(registrationModel.getPassword()));
            adminRepository.save(newAdmin);
        } else {
            System.out.println("EMAIL " + registrationModel.getEmail() + " already registered as ADMIN");
        }
    }

    public void registerOverseer(AdminOverseerRegistrationModel registrationModel) {
        if (userAccountsService.checkValidEmail(UserType.OVERSEER, registrationModel.getEmail())) {
            Overseer newOverseer = new Overseer(registrationModel.getFirstName(), registrationModel.getLastName(),
                    registrationModel.getPhonenumber(), registrationModel.getEmail(), passwordEncoder.encode(registrationModel.getPassword()));
            overseerRepository.save(newOverseer);
        } else {
            System.out.println("EMAIL " + registrationModel.getEmail() + " already registered as OVERSEER");
        }
    }

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
            newOwner.setPassword(passwordEncoder.encode(ownerRegistrationModel.getPassword()));
            ownerRepository.save(newOwner);
            propertyObjectRepository.save(currentProperty);
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
            currentProperty.setRented(true);
            propertyObjectRepository.save(currentProperty);
            newRenter.setPassword(passwordEncoder.encode(renterRegistrationModel.getPassword()));
            renterRepository.save(newRenter);
        }
    }

    public void registerNewOperator(OperatorRegistrationModel operatorRegistrationModel) {
        List<String> currentIds = baseCompanyRepository.findByCompanyName(operatorRegistrationModel.getCompanyName()).getAllocatedIds();
        if (userAccountsService.checkValidEmail(UserType.OPERATOR, operatorRegistrationModel.getEmail()) &&
                baseCompanyRepository.findByCompanyName(operatorRegistrationModel.getCompanyName()) != null &&
                currentIds.contains(operatorRegistrationModel.getContractId())) {
            BaseCompany currentCompany = baseCompanyRepository.findByCompanyName(operatorRegistrationModel.getCompanyName());
            currentCompany.getAllocatedIds().remove(operatorRegistrationModel.getContractId());
            Operator newOperator = new Operator(operatorRegistrationModel.getFirstName(), operatorRegistrationModel.getLastName(),
                    operatorRegistrationModel.getPhonenumber(), operatorRegistrationModel.getEmail(), operatorRegistrationModel.getPassword(),
                    operatorRegistrationModel.getContractId());
            newOperator.setPassword(passwordEncoder.encode(operatorRegistrationModel.getPassword()));
            operatorRepository.save(newOperator);
            baseCompanyRepository.save(currentCompany);
        }
    }
}
