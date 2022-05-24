package com.codecool.nepi.entity.useraccounts;

import com.codecool.nepi.model.types.UserType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Getter @Setter
@Table(name = "overseers")
@NoArgsConstructor
public class Overseer extends User {
    public Overseer(String firstName, String lastName, String phoneNumber, String email, String password) {
        super(firstName, lastName, phoneNumber, email, password);
        setUserType(UserType.OVERSEER);
        this.getRoles().add("ROLE_OVERSEER");
    }
}
