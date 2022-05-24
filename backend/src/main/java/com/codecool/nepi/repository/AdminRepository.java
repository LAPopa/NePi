package com.codecool.nepi.repository;

import com.codecool.nepi.entity.useraccounts.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {



    @Query("SELECT a FROM Admin a where a.email = :input_email and a.password = :input_password")
    Admin checkAdminCredentials(@Param("input_email") String inputEmail, @Param("input_password") String inputPassword);

    @Query("select a from Admin a where a.email = :email")
    Admin findByEmail(@Param("email") String email);



}
