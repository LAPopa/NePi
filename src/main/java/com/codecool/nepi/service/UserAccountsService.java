package com.codecool.nepi.service;


import com.codecool.nepi.model.loginmodel.LoginModel;
import com.codecool.nepi.model.useraccounts.*;
import com.codecool.nepi.repository.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class UserAccountsService {

    private List<User> registeredUsersAll;
    private List<Admin> registeredAdmins;
    private List<Operator> registeredOperators;
    private List<Overseer> registeredOverseers;
    private List<Owner> registeredOwners;
    private List<Renter> registeredRenters;
    private AdminRepository adminRepository;
    private OperatorRepository operatorRepository;
    private OverseerRepository overseerRepository;
    private OwnerRepository ownerRepository;
    private RenterRepository renterRepository;

    public UserAccountsService(AdminRepository adminRepository, OperatorRepository operatorRepository, OverseerRepository overseerRepository,
                               OwnerRepository ownerRepository, RenterRepository renterRepository) {
        this.registeredUsersAll = new ArrayList<>();
        this.registeredAdmins = new ArrayList<>();
        this.registeredOperators = new ArrayList<>();
        this.registeredOverseers = new ArrayList<>();
        this.registeredOwners = new ArrayList<>();
        this.registeredRenters = new ArrayList<>();
        this.adminRepository = adminRepository;
        this.operatorRepository = operatorRepository;
        this.overseerRepository = overseerRepository;
        this.ownerRepository = ownerRepository;
        this.renterRepository = renterRepository;
    }


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


    //TODO add new user - ties in with RegistrationService?

//    private void populateList(){
//        Admin admin = new Admin("Mimi","Moe","0743123123","awesome_mail@meow.com","1234");
//        Operator operator = new Operator("Joe","McLane","0789123123","yep@mail.com","123","CD4545");
//        Overseer overseer = new Overseer("Jack","Reaper","0799616616","evil@haha.com","123");
//        Owner owner = new Owner("Richie", "Rich","0789123456","richguy@money.com","123",
//                EnrolledPropertiesService.getInstance().getCurrentlyEnrolledProperties().get(0));
//
//
//        Renter renter = new Renter("Some","Guy","0123456789","irent@here.com","123","XY123");
//
//        owner.assignProperty(EnrolledPropertiesService.getInstance().getCurrentlyEnrolledProperties().get(5));
//        owner.assignProperty(EnrolledPropertiesService.getInstance().getCurrentlyEnrolledProperties().get(6));
//        owner.rentProperty(EnrolledPropertiesService.getInstance().getCurrentlyEnrolledProperties().get(6));
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
