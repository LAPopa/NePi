package com.codecool.nepi.service;


import com.codecool.nepi.entity.PropertyObject;
import com.codecool.nepi.model.login.LoginModel;
import com.codecool.nepi.model.types.UserType;
import com.codecool.nepi.entity.useraccounts.*;
import com.codecool.nepi.repository.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@AllArgsConstructor
public class UserAccountsService {

    private AdminRepository adminRepository;
    private OperatorRepository operatorRepository;
    private OverseerRepository overseerRepository;
    private OwnerRepository ownerRepository;
    private RenterRepository renterRepository;


    public boolean validateLogin(LoginModel loginModel) {
        String email = loginModel.getEmail();
        String password = loginModel.getPassword();

        return (adminRepository.checkAdminCredentials(email, password) != null ||
                overseerRepository.checkOverseerCredentials(email, password) != null ||
                operatorRepository.checkOperatorCredentials(email, password) != null ||
                ownerRepository.checkOwnerCredentials(email, password) != null ||
                renterRepository.checkOwnerCredentials(email, password) != null
        );

    }

    public String checkLoginType(String email) {
        String role = "";

        if (adminRepository.findByEmail(email) != null) role = "ADMIN";
        else if (overseerRepository.findByEmail(email) != null) role = "OVERSEER";
        else if (operatorRepository.findByEmail(email) != null) role = "OPERATOR";
        else if (ownerRepository.findByEmail(email) != null) role = "OWNER";
        else if (renterRepository.findByEmail(email) != null) role = "RENTER";

        return role;

    }

    public List<String> getUserDetailsFromId(String id) {

        List<String> userDetails = new ArrayList<>();

        if (findAdminById(id).isPresent()) {
            Optional<Admin> admin = findAdminById(id);
            userDetails.add(admin.get().getEmail());
            userDetails.add(admin.get().getPhoneNumber());
        } else if (findOverseerById(id).isPresent()) {
            Optional<Overseer> overseer = findOverseerById(id);
            userDetails.add(overseer.get().getEmail());
            userDetails.add(overseer.get().getPhoneNumber());
        } else if (findOperatorById(id).isPresent()) {
            Optional<Operator> operator = findOperatorById(id);
            userDetails.add(operator.get().getEmail());
            userDetails.add(operator.get().getPhoneNumber());
        } else if (findOwnerById(id).isPresent()) {
            Optional<Owner> owner = findOwnerById(id);
            userDetails.add(owner.get().getEmail());
            userDetails.add(owner.get().getPhoneNumber());
            List<PropertyObject> properties = owner.get().getCurrentProperties();
            String propertiesString = "";
            for(PropertyObject property : properties) {
//                userDetails.add(property.getEnrollmentId());
                propertiesString = propertiesString +" "+ property.getEnrollmentId();
            }
            userDetails.add(propertiesString);
        } else if (findRenterById(id).isPresent()) {
            Optional<Renter> renter = findRenterById(id);
            userDetails.add(renter.get().getEmail());
            userDetails.add(renter.get().getPhoneNumber());
            userDetails.add(renter.get().getContractID());
        } else {
            System.out.println("NO USER FOUND WITH THAT ID : " + id);
        }

        return userDetails;
    }


    public Admin findAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public Overseer findOverseerByEmail(String email){
        return overseerRepository.findByEmail(email);
    }

    public Operator findOperatorByEmail(String email) {
        return operatorRepository.findByEmail(email);
    }

    public Owner findOwnerByEmail(String email) {
        return ownerRepository.findByEmail(email);
    }

    public Renter findRenterByEmail(String email) {
        return renterRepository.findByEmail(email);
    }

    public Optional<Admin> findAdminById(String id) {return adminRepository.findById(Long.parseLong(id));}

    public Optional<Overseer> findOverseerById(String id) {return overseerRepository.findById(Long.parseLong(id));}

    public Optional<Operator> findOperatorById(String id) {return operatorRepository.findById(Long.parseLong(id));}

    public Optional<Owner> findOwnerById(String id) {return ownerRepository.findById(Long.parseLong(id));}

    public Optional<Renter> findRenterById(String id) {return renterRepository.findById(Long.parseLong(id));}

    public boolean checkValidEmail(UserType userType, String email) {
        switch (userType) {
            case OWNER -> {

                return (ownerRepository.findByEmail(email) == null);
            }
            case RENTER -> {
                return (renterRepository.findByEmail(email) == null);
            }
            case OVERSEER -> {
                return (overseerRepository.findByEmail(email) == null);
            }
            case OPERATOR -> {
                return (operatorRepository.findByEmail(email) == null);
            }
            case ADMIN -> {
                return (adminRepository.findByEmail(email) == null);
            }
            default -> {
                return false;
            }

        }

    }

    public List<Operator> getAllOperators() {return operatorRepository.findAll();}


    //TODO add new user - ties in with RegistrationService?

//    private void populateList(){
//        Admin admin = new Admin("Mimi","Moe","0743123123","awesome_mail@meow.com","1234");
//        Operator operator = new Operator("Joe","McLane","0789123123","yep@mail.com","123","CD4545");
//        Overseer overseer = new Overseer("Jack","Reaper","0799616616","evil@haha.com","123");
//        Owner owner = new Owner("Richie", "Rich","0789123456","richguy@money.com","123",
//                EnrolledPropertiesCompaniesService.getInstance().getCurrentlyEnrolledProperties().get(0));
//
//
//        Renter renter = new Renter("Some","Guy","0123456789","irent@here.com","123","XY123");
//
//        owner.assignProperty(EnrolledPropertiesCompaniesService.getInstance().getCurrentlyEnrolledProperties().get(5));
//        owner.assignProperty(EnrolledPropertiesCompaniesService.getInstance().getCurrentlyEnrolledProperties().get(6));
//        owner.rentProperty(EnrolledPropertiesCompaniesService.getInstance().getCurrentlyEnrolledProperties().get(6));
//
//
//
//
//        this.registeredUsersAll.add(admin);
//        this.registeredUsersAll.add(operator);
//        this.registeredUsersAll.add(overseer);
//        this.registeredUsersAll.add(owner);
//        this.registeredUsersAll.add(renter);
//
//        this.registeredAdmins.add(admin);
//        this.registeredOperators.add(operator);
//        this.registeredOverseers.add(overseer);
//        this.registeredOwners.add(owner);
//        this.registeredRenters.add(renter);
//
//    }
//
//    public void addNewAdmin(Admin admin){
//        this.registeredUsersAll.add(admin);
//    }
//    public void addNewOperator(Operator operator){
//        this.registeredUsersAll.add(operator);
//    }
//    public void addNewOverseer(Overseer overseer){
//        this.registeredUsersAll.add(overseer);
//    }
//    public void addNewOwner(Owner owner){
//        this.registeredUsersAll.add(owner);
//    }
//    public void addNewRenter(Renter renter){
//        this.registeredUsersAll.add(renter);
//    }

}
