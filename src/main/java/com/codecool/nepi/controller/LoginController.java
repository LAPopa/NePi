package com.codecool.nepi.controller;


import com.codecool.nepi.model.loginmodel.LoginModel;
import com.codecool.nepi.service.UserAccountsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class LoginController {

    UserAccountsService userAccountsService;

    public LoginController(UserAccountsService userAccountsService) {this.userAccountsService = userAccountsService;}

    @PostMapping("/")
    public void validateLogin(@RequestBody LoginModel loginModel) {
        if (userAccountsService.validateLogin(loginModel))
        {
            System.out.println("Login successful for the following credentials : " + loginModel.getEmail() + "    " + loginModel.getPassword());
        } else {
            System.out.println("No account with the following credentials : " + loginModel.getEmail() + "    " + loginModel.getPassword());
        }

    }

}
