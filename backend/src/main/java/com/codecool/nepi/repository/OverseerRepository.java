package com.codecool.nepi.repository;

import com.codecool.nepi.entity.useraccounts.Overseer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OverseerRepository extends JpaRepository<Overseer,Long> {



    @Query("SELECT a FROM Overseer a where a.email = :input_email and a.password = :input_password")
    Overseer checkOverseerCredentials(@Param("input_email") String inputEmail, @Param("input_password") String inputPassword);

    @Query("select a from Overseer a where a.email = :email")
    Overseer findByEmail(@Param("email") String email);
}
