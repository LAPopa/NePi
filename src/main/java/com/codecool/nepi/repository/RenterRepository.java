package com.codecool.nepi.repository;

import com.codecool.nepi.model.useraccounts.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RenterRepository extends JpaRepository<Renter,Long> {



    @Query("SELECT a FROM Renter a where a.email = :input_email and a.password = :input_password")
    Renter checkOwnerCredentials(@Param("input_email") String inputEmail, @Param("input_password") String inputPassword);


}
