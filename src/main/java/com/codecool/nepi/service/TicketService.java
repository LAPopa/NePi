package com.codecool.nepi.service;


import com.codecool.nepi.entity.Ticket;
import com.codecool.nepi.model.TicketModel;
import com.codecool.nepi.repository.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter
@Service
@Component
public class TicketService {

    private TicketRepository ticketRepository;
    private AdminRepository adminRepository;
    private OverseerRepository overseerRepository;
    private OperatorRepository operatorRepository;
    private OwnerRepository ownerRepository;
    private RenterRepository renterRepository;


    public void createNewTicket(TicketModel ticketModel) {
        ticketRepository.save(new Ticket(ticketModel.getType(), ticketModel.getName(), ticketModel.getDescription(),
                ticketModel.getPropertyId(), ticketModel.getUserEmail(), ticketModel.getUserPhonenumber()));
    }

    public void assignOperatorToTicket()

}
