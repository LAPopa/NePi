package com.codecool.nepi.controller;


import com.codecool.nepi.service.UserAccountsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserDetailsController {

    UserAccountsService userAccountsService;

    public UserDetailsController(UserAccountsService userAccountsService) {
        this.userAccountsService = userAccountsService;
    }


    @GetMapping("/get-user-details")
    public List<String> getUserDetails(@RequestParam String userId) {

        return userAccountsService.getUserDetailsFromId(userId);

    }
}
