package com.codecool.nepi.controller;


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
    public ResponseEntity<Void> validateLogin(@RequestBody String email, @RequestBody String password) {
        List<User> currentlyRegisteredAccounts = userAccountsService.getRegisteredUsers();
        for (User account : currentlyRegisteredAccounts) {
            if (Objects.equals(account.getEmail(), email) && Objects.equals(account.getPassword(), password)) {
                System.out.println("VALIDATED");
                return ResponseEntity.status(HttpStatus.OK).location(URI.create("http://localhost:3000/")).build();
            }
            else {
                System.out.println("INVALID");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }
        }
        return null;

    }

}
