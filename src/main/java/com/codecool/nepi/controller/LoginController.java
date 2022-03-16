package com.codecool.nepi.controller;


import com.codecool.nepi.model.LoginModel;
import com.codecool.nepi.model.TestModel;
import com.codecool.nepi.model.useraccounts.User;
import com.codecool.nepi.service.UserAccountsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class LoginController {

    UserAccountsService userAccountsService = UserAccountsService.getInstance();

    @PostMapping("/")
    public ResponseEntity<Void> validateLogin(@RequestBody LoginModel loginModel) {
        List<User> currentlyRegisteredAccounts = userAccountsService.getRegisteredUsers();
        System.out.println(currentlyRegisteredAccounts.size());
        ResponseEntity<Void> defaultResponse = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        for (User account : currentlyRegisteredAccounts) {
            System.out.println(account.toString());
            if (Objects.equals(account.getEmail(), loginModel.getEmail()) && Objects.equals(account.getPassword(), loginModel.getPassword())) {
                System.out.println("VALIDATED");
                defaultResponse= ResponseEntity.status(HttpStatus.OK).location(URI.create("http://localhost:3000/login-successful")).build();
                break;
            }
            else {
                System.out.println("INVALID");
                System.out.println(loginModel.getEmail() + "  " + loginModel.getPassword());
                defaultResponse= ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        return defaultResponse;

    }

}
