package com.codecool.nepi.repository;

import com.codecool.nepi.entity.BaseCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BaseCompanyRepository extends JpaRepository<BaseCompany, Long> {

    //TODO allocate ID

    @Query("SELECT bc.allocatedIds FROM BaseCompany bc WHERE bc.companyName = :company_name")
    List<String> getAllocatedIds(@Param("company_name") String companyName);


    @Query("SELECT bc FROM BaseCompany bc WHERE bc.companyName = :company_name")
    BaseCompany findByCompanyName(@Param("company_name") String companyName);







    //TODO assign ID
}
