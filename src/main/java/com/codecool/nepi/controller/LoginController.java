package com.codecool.nepi.controller;


import com.codecool.nepi.model.loginmodel.LoginModel;
import com.codecool.nepi.model.useraccounts.User;
import com.codecool.nepi.service.UserAccountsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class LoginController {

    UserAccountsService userAccountsService;

    public LoginController(UserAccountsService userAccountsService) {this.userAccountsService = userAccountsService;}

    @PostMapping("/")
    public void validateLogin(@RequestBody LoginModel loginModel) {
        userAccountsService.validateLogin(loginModel);

    }

}
