package com.codecool.nepi;

import com.codecool.nepi.model.companymodels.BaseCompany;
import com.codecool.nepi.model.propertymodels.PropertyObject;
import com.codecool.nepi.model.types.CompanyType;
import com.codecool.nepi.model.useraccounts.Admin;
import com.codecool.nepi.model.useraccounts.Overseer;
import com.codecool.nepi.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class NepiApplication {

    private static final Logger log = LoggerFactory.getLogger(NepiApplication.class);

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nepiPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        SpringApplication.run(NepiApplication.class, args);
    }

    @Bean
    public CommandLineRunner testAdminLogin(AdminRepository adminRepository, OverseerRepository overseerRepository,
                                            OperatorRepository operatorRepository, OwnerRepository ownerRepository, RenterRepository renterRepository,
                                            PropertyObjectRepository propertyObjectRepository, BaseCompanyRepository baseCompanyRepository) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nepiPersistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return (args) -> {
//            adminRepository.save(new Admin("Mimi", "Moe", "01234", "test@mail.com", "1234"));
//            overseerRepository.save(new Overseer("Joe","the Overseer","1234","overseer@mail.com","1234"));
//            propertyObjectRepository.save(new PropertyObject("First Street", "1", "1", false, "AP1", false));
//            propertyObjectRepository.save(new PropertyObject("First Street", "1", "2", false, "AP2", false));
//            propertyObjectRepository.save(new PropertyObject("Second Street", "1", "1", false, "AP3", false));
//            propertyObjectRepository.save(new PropertyObject("Second Street", "1", "2", false, "AP4", false));
//            baseCompanyRepository.save(new BaseCompany("Waterworks", CompanyType.WATER, "We solve all your water issues !"));
            entityManager.getTransaction().begin();
            BaseCompany testCompany = baseCompanyRepository.findByCompanyName("Waterworks");
            System.out.println("found the company : " + testCompany.toString());
            testCompany.addId("WA1");
            entityManager.persist(testCompany);
            entityManager.getTransaction().commit();

            log.info("Current admin accounts ::");
            for (Admin admin : adminRepository.findAll()) {
                log.info(admin.toString());
            }
        };
    }

}

