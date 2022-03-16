package com.codecool.nepi.service;


import com.codecool.nepi.model.propertymodels.PropertyObject;
import com.codecool.nepi.model.useraccounts.*;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class UserAccountsService {

    private List<User> registeredUsers;
    private static UserAccountsService instance = null;

    public UserAccountsService() {
        this.registeredUsers = new ArrayList<>();
        populateList();
    }

    public static UserAccountsService getInstance(){
        if(instance == null) {
            instance = new UserAccountsService();

        }
        return instance;
    }

    //TODO add new user - ties in with RegistrationService?

    private void populateList(){
        Admin admin = new Admin("Mimi","Moe","0743123123","awesome_mail@meow.com","1234");
        Operator operator = new Operator("Joe","McLane","0789123123","yep@mail.com","123","CD4545");
        Overseer overseer = new Overseer("Jack","Reaper","0799616616","evil@haha.com","123");
        Owner owner = new Owner("Richie", "Rich","0789123456","richguy@money.com","123",
                new PropertyObject("First Street",5,1,true));
        Renter renter = new Renter("Some","Guy","0123456789","irent@here.com","123","XY123");
        this.registeredUsers.add(admin);
        this.registeredUsers.add(operator);
        this.registeredUsers.add(overseer);
        this.registeredUsers.add(owner);
        this.registeredUsers.add(renter);

    }

}
