package com.codecool.nepi.repository;

import com.codecool.nepi.model.companymodels.BaseCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface BaseCompanyRepository extends JpaRepository<BaseCompany, Long> {

    //TODO allocate ID

    @Query("SELECT bc.allocatedIds FROM BaseCompany bc WHERE bc.companyName = :company_name")
    String getAllocatedIds(@Param("company_name") String companyName);

    @Modifying
    @Query("UPDATE BaseCompany bc SET bc.allocatedIds = :id_list WHERE bc.companyName = :company_name")
    void persistAllocatedId(@Param("id_list") String id, @Param("company_name") String companyName);

    @Query("SELECT bc FROM BaseCompany bc WHERE bc.companyName = :company_name")
    BaseCompany findByCompanyName(@Param("company_name") String companyName);






    //TODO assign ID
}
