package com.codecool.nepi.service;

import com.codecool.nepi.model.companymodels.BaseCompany;
import com.codecool.nepi.repository.BaseCompanyRepository;
import lombok.Getter;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;



@Service
@Getter
public class BaseCompanyService {

    private List<BaseCompany> enrolledCompanies;
    private BaseCompanyRepository baseCompanyRepository;
    @PersistenceContext
    private EntityManager entityManager;



    public BaseCompanyService(BaseCompanyRepository baseCompanyRepository) {
        this.enrolledCompanies = new ArrayList<>();
        this.baseCompanyRepository = baseCompanyRepository;
    }



    public void addNewId(String companyName, String newId){

        BaseCompany baseCompany = baseCompanyRepository.findByCompanyName(companyName);
        baseCompany.addId(newId);
        entityManager.getTransaction().begin();
        entityManager.merge(baseCompany);
        entityManager.getTransaction().commit();


    }


}
