package com.codecool.nepi.repository;

import com.codecool.nepi.model.companymodels.BaseCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseCompanyRepository extends JpaRepository<BaseCompany, Long> {

    //TODO allocate ID
    //TODO assign ID
}
