package com.codecool.nepi.service;

import com.codecool.nepi.model.companymodels.BaseCompany;
import com.codecool.nepi.model.types.CompanyType;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@Getter
public class EnrolledCompaniesService {

    private List<BaseCompany> enrolledCompanies;
    private static EnrolledCompaniesService instance = null;


    public EnrolledCompaniesService() {
        this.enrolledCompanies = new ArrayList<>();
        populateList();
    }


    public static EnrolledCompaniesService getInstance(){
        if(instance == null) {
            instance = new EnrolledCompaniesService();

        }
        return instance;
    }

    private void populateList(){

        BaseCompany waterCompany = new BaseCompany("Waterworks", CompanyType.WATER,"We handle all your water needs.");
        waterCompany.addId("WA1");
        waterCompany.addId("WA2");
        waterCompany.addId("WA3");
        waterCompany.assignId("WA3");

        BaseCompany electricityCompany = new BaseCompany("NoBattery", CompanyType.ELECTRICITY, "So you never need to rely on batteries ever again.");
        electricityCompany.addId("EL1");
        electricityCompany.addId("EL2");
        electricityCompany.addId("EL3");
        electricityCompany.assignId("EL3");
    }
}
