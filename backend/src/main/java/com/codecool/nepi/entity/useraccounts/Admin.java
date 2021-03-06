package com.codecool.nepi.entity.useraccounts;

import com.codecool.nepi.model.types.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Getter @Setter
@Table(name = "admins")
@NoArgsConstructor
public class Admin extends User {
    public Admin(String firstName, String lastName, String phoneNumber, String email, String password) {
        super(firstName, lastName, phoneNumber, email, password);
        setUserType(UserType.ADMIN);
        this.getRoles().add("ROLE_ADMIN");
    }
}
