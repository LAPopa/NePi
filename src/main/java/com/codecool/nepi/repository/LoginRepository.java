package com.codecool.nepi.repository;

import com.codecool.nepi.model.useraccounts.Admin;
import com.codecool.nepi.model.useraccounts.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<Admin,Long> {



    @Query("SELECT a FROM Admin a where a.email = :input_email and a.password = :input_password")
    Admin checkAdminCredentials(@Param("input_email") String inputEmail, @Param("input_password") String inputPassword);


}
