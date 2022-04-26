package com.codecool.nepi.repository;

import com.codecool.nepi.entity.useraccounts.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {



    @Query("SELECT a FROM Owner a where a.email = :input_email and a.password = :input_password")
    Owner checkOwnerCredentials(@Param("input_email") String inputEmail, @Param("input_password") String inputPassword);

    @Query("select a from Owner a where a.email = :email")
    Owner findByEmail(@Param("email") String email);
}
