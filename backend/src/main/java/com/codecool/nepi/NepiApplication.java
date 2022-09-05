package com.codecool.nepi;

import com.codecool.nepi.entity.Ticket;
import com.codecool.nepi.entity.useraccounts.Admin;
import com.codecool.nepi.repository.AdminRepository;
import com.codecool.nepi.repository.BaseCompanyRepository;
import com.codecool.nepi.repository.OperatorRepository;
import com.codecool.nepi.repository.OverseerRepository;
import com.codecool.nepi.repository.OwnerRepository;
import com.codecool.nepi.repository.PropertyObjectRepository;
import com.codecool.nepi.repository.RenterRepository;
import com.codecool.nepi.repository.TicketRepository;
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
            log.info("Current admin accounts ::");
            for (Admin admin : adminRepository.findAll()) {
                log.info(admin.toString());
            }
            for (Ticket ticket : ticketRepository.findByPropertyId("UR2")) {
                log.info(ticket.toString());
            }
        };
    }
}

