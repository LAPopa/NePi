package com.codecool.nepi.repository;

import com.codecool.nepi.entity.useraccounts.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator,Long> {
    @Query("SELECT a FROM Operator a where a.email = :input_email and a.password = :input_password")
    Operator checkOperatorCredentials(@Param("input_email") String inputEmail, @Param("input_password") String inputPassword);
    @Query("select a from Operator a where a.email = :email")
    Operator findByEmail(@Param("email") String email);
    Operator findByContractID(String contractId);
}
