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
//    private static BaseCompanyService instance = null;
    private BaseCompanyRepository baseCompanyRepository;
    @PersistenceContext
    private EntityManager entityManager;



    public BaseCompanyService(BaseCompanyRepository baseCompanyRepository) {
        this.enrolledCompanies = new ArrayList<>();
        this.baseCompanyRepository = baseCompanyRepository;
//        populateList();
    }


//    public static BaseCompanyService getInstance(){
//        if(instance == null) {
//            instance = new BaseCompanyService();
//
//        }
//        return instance;
//    }

    public void addNewId(String companyName, String newId){

        BaseCompany baseCompany = baseCompanyRepository.findByCompanyName(companyName);
        baseCompany.addId(newId);
        entityManager.getTransaction().begin();
        entityManager.merge(baseCompany);
        entityManager.getTransaction().commit();


    }

//    private void populateList(){
//
//        BaseCompany waterCompany = new BaseCompany("Waterworks", CompanyType.WATER,"We handle all your water needs.");
//        this.enrolledCompanies.add(waterCompany);
//        waterCompany.addId("WA1");
//        waterCompany.addId("WA2");
//        waterCompany.addId("WA3");
//        waterCompany.assignId("WA3");
//
//        BaseCompany electricityCompany = new BaseCompany("NoBattery", CompanyType.ELECTRICITY, "So you never need to rely on batteries ever again.");
//        this.enrolledCompanies.add(electricityCompany);
//        electricityCompany.addId("EL1");
//        electricityCompany.addId("EL2");
//        electricityCompany.addId("EL3");
//        electricityCompany.assignId("EL3");
//    }
}
