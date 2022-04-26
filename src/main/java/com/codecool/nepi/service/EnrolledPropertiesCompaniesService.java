package com.codecool.nepi.service;


import com.codecool.nepi.entity.BaseCompany;
import com.codecool.nepi.entity.PropertyObject;
import com.codecool.nepi.model.registrationmodels.CompanyRegistrationModel;
import com.codecool.nepi.model.registrationmodels.PropertyRegistrationModel;
import com.codecool.nepi.repository.BaseCompanyRepository;
import com.codecool.nepi.repository.PropertyObjectRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
@Service
@Component

public class EnrolledPropertiesCompaniesService {

    private PropertyObjectRepository propertyObjectRepository;
    private BaseCompanyRepository baseCompanyRepository;

    public void registerNewProperty(PropertyRegistrationModel propertyRegistrationModel) {
        propertyObjectRepository.save(new PropertyObject(propertyRegistrationModel.getStreetName(), propertyRegistrationModel.getStreetNumber(),
                propertyRegistrationModel.getApartmentNumber(), propertyRegistrationModel.getEnrollmentId()));

    }

    public void registerNewCompany(CompanyRegistrationModel companyRegistrationModel) {
        baseCompanyRepository.save(new BaseCompany(companyRegistrationModel.getCompanyName(), companyRegistrationModel.getCompanyType(),
                companyRegistrationModel.getDescription()));
    }

    public void addNewCompanyId(String companyName, String id){
        BaseCompany company = baseCompanyRepository.findByCompanyName(companyName);
        company.addId(id);
        baseCompanyRepository.save(company);
    }


}
