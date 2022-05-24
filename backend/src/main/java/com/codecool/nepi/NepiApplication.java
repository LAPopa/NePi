package com.codecool.nepi;

import com.codecool.nepi.entity.Ticket;
import com.codecool.nepi.entity.useraccounts.Admin;
import com.codecool.nepi.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NepiApplication {

    private static final Logger log = LoggerFactory.getLogger(NepiApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(NepiApplication.class, args);
    }

    @Bean
    public CommandLineRunner testAdminLogin(AdminRepository adminRepository, OverseerRepository overseerRepository,
                                            OperatorRepository operatorRepository, OwnerRepository ownerRepository, RenterRepository renterRepository,
                                            PropertyObjectRepository propertyObjectRepository, BaseCompanyRepository baseCompanyRepository,
                                            TicketRepository ticketRepository) {
        return (args) -> {
//            adminRepository.save(new Admin("Mimi", "Moe", "01234", "test@mail.com", "1234"));
//            overseerRepository.save(new Overseer("Joe","the Overseer","1234","overseer@mail.com","1234"));
//            propertyObjectRepository.save(new PropertyObject("First Street", "1", "1", false, "AP1", false));
//            propertyObjectRepository.save(new PropertyObject("First Street", "1", "2", false, "AP2", false));
//            propertyObjectRepository.save(new PropertyObject("Second Street", "1", "1", false, "AP3", false));
//            propertyObjectRepository.save(new PropertyObject("Second Street", "1", "2", false, "AP4", false));
//            propertyObjectRepository.save(new PropertyObject("Third Street", "1", "1", false, "AP5", false));
//            propertyObjectRepository.save(new PropertyObject("Third Street", "1", "2", false, "AP6", false));
//            baseCompanyRepository.save(new BaseCompany("Waterworks", CompanyType.WATER, "We solve all your water issues !"));
//            BaseCompany waterworks = baseCompanyRepository.findByCompanyName("Waterworks");
//            waterworks.setAllocatedIds("WA1");
//            waterworks.addId("WA2");
//            waterworks.addId("WA3");
//            baseCompanyRepository.save(waterworks);
//            Owner testOwner = ownerRepository.findByEmail("owner_test@testing.com");
//            PropertyObject testPropertyObject = propertyObjectRepository.getPropertyObjectByEnrollmentId("AP2");
//            testOwner.assignProperty(testPropertyObject);
//            propertyObjectRepository.save(testPropertyObject);
//            ownerRepository.save(testOwner);


            log.info("Current admin accounts ::");
            for (Admin admin : adminRepository.findAll()) {
                log.info(admin.toString());
            }

            for(Ticket ticket : ticketRepository.findByPropertyId("UR2")) {
                log.info(ticket.toString());
            }
        };
    }

}

