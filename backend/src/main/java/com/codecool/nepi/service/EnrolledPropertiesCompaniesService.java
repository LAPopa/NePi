package com.codecool.nepi.service;


import com.codecool.nepi.entity.BaseCompany;
import com.codecool.nepi.entity.PropertyObject;
import com.codecool.nepi.entity.useraccounts.Owner;
import com.codecool.nepi.model.registration.CompanyRegistrationModel;
import com.codecool.nepi.model.registration.PropertyRegistrationModel;
import com.codecool.nepi.repository.BaseCompanyRepository;
import com.codecool.nepi.repository.OwnerRepository;
import com.codecool.nepi.repository.PropertyObjectRepository;
import com.codecool.nepi.repository.RenterRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Service
@Component

public class EnrolledPropertiesCompaniesService {

    private PropertyObjectRepository propertyObjectRepository;
    private BaseCompanyRepository baseCompanyRepository;
    private OwnerRepository ownerRepository;
    private RenterRepository renterRepository;

    public void enrollNewProperty(PropertyRegistrationModel propertyRegistrationModel) {
        propertyObjectRepository.save(new PropertyObject(propertyRegistrationModel.getStreetName(), propertyRegistrationModel.getStreetNumber(),
                propertyRegistrationModel.getApartmentNumber(), propertyRegistrationModel.getEnrollmentId()));

    }

    public void registerNewCompany(CompanyRegistrationModel companyRegistrationModel) {
        baseCompanyRepository.save(new BaseCompany(companyRegistrationModel.getCompanyName(), companyRegistrationModel.getCompanyType(),
                companyRegistrationModel.getDescription()));
    }

    public void addNewCompanyId(String companyName, String id) {
        BaseCompany company = baseCompanyRepository.findByCompanyName(companyName);
        company.addId(id);
        baseCompanyRepository.save(company);
    }

    public void registerNewPropertyByOwner(PropertyRegistrationModel propertyRegistrationModel, String id) {
        long ID = Long.parseLong(id);
        Owner currentOwner = ownerRepository.findOwnerById(ID);
        try {
            PropertyObject currentProperty = propertyObjectRepository.getPropertyObjectByEnrollmentId(propertyRegistrationModel.getEnrollmentId());
            currentOwner.assignProperty(currentProperty);

            ownerRepository.save(currentOwner);
            propertyObjectRepository.save(currentProperty);
        } catch (Exception e) {
            throw new RuntimeException("PROPERTY NOT FOUND");
        }

    }

    public List<String> getEnrolledPropertyIds() {

        List<String> enrolledPropertyIds = new ArrayList<>();
        List<PropertyObject> allProperties = propertyObjectRepository.findAll();
        for(PropertyObject propertyObject : allProperties) {
            enrolledPropertyIds.add(propertyObject.getEnrollmentId());
        }
        return  enrolledPropertyIds;
    }
    public List<String> getBaseCompanyAllocatedIds() {

        List<String> allocatedIds = new ArrayList<>();
        List<BaseCompany> allCompanies = baseCompanyRepository.findAll();
        for(BaseCompany baseCompany : allCompanies) {
            allocatedIds.addAll(baseCompany.getAllocatedIds());
        }
        return allocatedIds;
    }


}
