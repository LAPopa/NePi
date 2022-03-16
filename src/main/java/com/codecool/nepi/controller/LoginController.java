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

    UserAccountsService userAccountsService = UserAccountsService.getInstance();

    @PostMapping("/")
    public RedirectView validateLogin(@RequestBody LoginModel loginModel) {
        List<User> currentlyRegisteredAccounts = userAccountsService.getRegisteredUsersAll();
        RedirectView defaultRedirect = new RedirectView();
        for (User account : currentlyRegisteredAccounts) {
            if (Objects.equals(account.getEmail(), loginModel.getEmail()) && Objects.equals(account.getPassword(), loginModel.getPassword())) {
                defaultRedirect.setUrl("/login-successful");
                break;
            }
            else {
                defaultRedirect.setUrl("/");
            }
        }
        return defaultRedirect;

    }

}
