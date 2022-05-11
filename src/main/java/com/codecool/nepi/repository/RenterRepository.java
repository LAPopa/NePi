package com.codecool.nepi.repository;

import com.codecool.nepi.entity.useraccounts.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RenterRepository extends JpaRepository<Renter,Long> {



    @Query("SELECT a FROM Renter a where a.email = :input_email and a.password = :input_password")
    Renter checkOwnerCredentials(@Param("input_email") String inputEmail, @Param("input_password") String inputPassword);

    @Query("select a from Renter a where a.email = :email")
    Renter findByEmail(@Param("email") String email);

}
