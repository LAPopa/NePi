package com.codecool.nepi.controller;

import com.codecool.nepi.entity.useraccounts.*;
import com.codecool.nepi.model.login.LoginModel;
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
                case "ADMIN" -> {
                    Admin admin = userAccountsService.findAdminByEmail(email);
                    return getObjectResponseEntity(roles, token, admin.getId(), admin.getFirstName(), admin.getLastName(), admin.getEmail());
                }
                case "OVERSEER" -> {
                    Overseer overseer = userAccountsService.findOverseerByEmail(email);
                    return getObjectResponseEntity(roles, token, overseer.getId(), overseer.getFirstName(), overseer.getLastName(), overseer.getEmail());
                }
                case "OPERATOR" -> {
                    Operator operator = userAccountsService.findOperatorByEmail(email);
                    return getObjectResponseEntity(roles, token, operator.getId(), operator.getFirstName(), operator.getLastName(), operator.getEmail());
                }
                case "OWNER" -> {
                    Owner owner = userAccountsService.findOwnerByEmail(email);
                    return getObjectResponseEntity(roles, token, owner.getId(), owner.getFirstName(), owner.getLastName(), owner.getEmail());
                }
                case "RENTER" -> {
                    Renter renter = userAccountsService.findRenterByEmail(email);
                    return getObjectResponseEntity(roles, token, renter.getId(), renter.getFirstName(), renter.getLastName(), renter.getEmail());
                }
            }
            return ResponseEntity.of(null);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid credentials. ");
        }
    }

    private ResponseEntity<Object> getObjectResponseEntity(List<String> roles, String token, Long id, String firstName, String lastName, String email2) {
        Map<Object, Object> model = new HashMap<>();
        model.put("userID", id);
        model.put("firstName", firstName);
        model.put("lastName", lastName);
        model.put("email", email2);
        model.put("roles", roles);
        model.put("token", token);
        model.put("status", 200);
        return ResponseEntity.ok(model);
    }

}
