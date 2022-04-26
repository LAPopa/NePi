package com.codecool.nepi.model.registrationmodels;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyRegistrationModel {
    String companyName;
    String companyType;
    String description;

}
