package com.codecool.nepi.entity.useraccounts;

import com.codecool.nepi.model.types.UserType;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "overseers")
@NoArgsConstructor
public class Overseer extends User {
    public Overseer(String firstName, String lastName, String phoneNumber, String email, String password) {
        super(firstName, lastName, phoneNumber, email, password);
        setUserType(UserType.OVERSEER);
    }
}
