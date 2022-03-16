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
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class LoginController {

    UserAccountsService userAccountsService = UserAccountsService.getInstance();

    @PostMapping("/")
    public RedirectView validateLogin(@RequestBody LoginModel loginModel) {
        List<User> currentlyRegisteredAccounts = userAccountsService.getRegisteredUsers();
        System.out.println(currentlyRegisteredAccounts.size());
        RedirectView defaultRedirect = new RedirectView();
        for (User account : currentlyRegisteredAccounts) {
            System.out.println(account.toString());
            if (Objects.equals(account.getEmail(), loginModel.getEmail()) && Objects.equals(account.getPassword(), loginModel.getPassword())) {
                System.out.println("VALIDATED");
                defaultRedirect.setUrl("/login-successful");
                break;
            }
            else {
                System.out.println("INVALID");
                System.out.println(loginModel.getEmail() + "  " + loginModel.getPassword());
                defaultRedirect.setUrl("/");
            }
        }
        System.out.println(defaultRedirect.getUrl());
        return defaultRedirect;

    }

}
