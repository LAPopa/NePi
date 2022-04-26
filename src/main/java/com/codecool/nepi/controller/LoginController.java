package com.codecool.nepi.controller;


import com.codecool.nepi.entity.useraccounts.*;
import com.codecool.nepi.model.loginmodel.LoginModel;
import com.codecool.nepi.security.JwtTokenServices;
import com.codecool.nepi.service.UserAccountsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class LoginController {

    UserAccountsService userAccountsService;
    AuthenticationManager authenticationManager;
    JwtTokenServices jwtTokenServices;

    public LoginController(UserAccountsService userAccountsService, AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices) {
        this.userAccountsService = userAccountsService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

//    @PostMapping("/")
//    public void validateLogin(@RequestBody LoginModel loginModel) {
//        if (userAccountsService.validateLogin(loginModel))
//        {
//            System.out.println("Login successful for the following credentials : " + loginModel.getEmail() + "    " + loginModel.getPassword());
//        } else {
//            System.out.println("No account with the following credentials : " + loginModel.getEmail() + "    " + loginModel.getPassword());
//        }
//
//    }

    @PostMapping("/")
    public ResponseEntity<Object> validateLogin(@RequestBody LoginModel loginModel) {
        try {
            String email = loginModel.getEmail();
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, loginModel.getPassword()));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            String token = jwtTokenServices.createToken(email, roles);
            String loginType = userAccountsService.checkLoginType(email);

            switch (loginType) {
                case "ADMIN":
                    Admin admin = userAccountsService.findAdminByEmail(email);
                    Map<Object, Object> modelAdmin = new HashMap<>();
                    modelAdmin.put("userID", admin.getId());
                    modelAdmin.put("firstName", admin.getFirstName());
                    modelAdmin.put("lastName", admin.getLastName());
                    modelAdmin.put("email", admin.getEmail());
                    modelAdmin.put("roles", roles);
                    modelAdmin.put("token", token);
                    modelAdmin.put("status",200);
                    return ResponseEntity.ok(modelAdmin);
                    break;

                case "OVERSEER":
                    Overseer overseer = userAccountsService.findOverseerByEmail(email);
                    Map<Object, Object> modelOverseer = new HashMap<>();
                    modelOverseer.put("userID", overseer.getId());
                    modelOverseer.put("firstName", overseer.getFirstName());
                    modelOverseer.put("lastName", overseer.getLastName());
                    modelOverseer.put("email", overseer.getEmail());
                    modelOverseer.put("roles", roles);
                    modelOverseer.put("token", token);
                    modelOverseer.put("status",200);
                    return ResponseEntity.ok(modelOverseer);
                    break;

                case "OPERATOR":
                    Operator operator = userAccountsService.findOperatorByEmail(email);
                    Map<Object, Object> modelOperator = new HashMap<>();
                    modelOperator.put("userID", operator.getId());
                    modelOperator.put("firstName", operator.getFirstName());
                    modelOperator.put("lastName", operator.getLastName());
                    modelOperator.put("email", operator.getEmail());
                    modelOperator.put("roles", roles);
                    modelOperator.put("token", token);
                    modelOperator.put("status",200);
                    return ResponseEntity.ok(modelOperator);
                    break;

                case "OWNER":
                    Owner owner = userAccountsService.findOwnerByEmail(email);
                    Map<Object, Object> modelOwner = new HashMap<>();
                    modelOwner.put("userID", owner.getId());
                    modelOwner.put("firstName", owner.getFirstName());
                    modelOwner.put("lastName", owner.getLastName());
                    modelOwner.put("email", owner.getEmail());
                    modelOwner.put("roles", roles);
                    modelOwner.put("token", token);
                    modelOwner.put("status",200);
                    return ResponseEntity.ok(modelOwner);
                    break;

                case "RENTER":
                    Renter renter = userAccountsService.findRenterByEmail(email);
                    Map<Object, Object> modelRenter = new HashMap<>();
                    modelRenter.put("userID", renter.getId());
                    modelRenter.put("firstName", renter.getFirstName());
                    modelRenter.put("lastName", renter.getLastName());
                    modelRenter.put("email", renter.getEmail());
                    modelRenter.put("roles", roles);
                    modelRenter.put("token", token);
                    modelRenter.put("status",200);
                    return ResponseEntity.ok(modelRenter);
                    break;

            }

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid credentials. ");
        }
    }

}
