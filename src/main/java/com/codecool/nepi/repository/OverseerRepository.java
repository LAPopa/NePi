package com.codecool.nepi.repository;

import com.codecool.nepi.model.useraccounts.Overseer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OverseerRepository extends JpaRepository<Overseer,Long> {



    @Query("SELECT a FROM Overseer a where a.email = :input_email and a.password = :input_password")
    Overseer checkOverseerCredentials(@Param("input_email") String inputEmail, @Param("input_password") String inputPassword);


}
