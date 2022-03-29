package com.codecool.nepi.model.useraccounts;

import com.codecool.nepi.model.types.UserType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "admins")
@NoArgsConstructor
//@AllArgsConstructor
public class Admin extends User {
    public Admin(String firstName, String lastName, String phoneNumber, String email, String password) {
        super(firstName, lastName, phoneNumber, email, password);
        setUserType(UserType.ADMIN);
    }
}
