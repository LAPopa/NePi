package com.codecool.nepi.model.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminOverseerRegistrationModel {
    private String email;
    private String firstName;
    private String lastName;
    private String phonenumber;
    private String password;
}
