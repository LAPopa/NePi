package com.codecool.nepi.service;


import com.codecool.nepi.entity.Ticket;
import com.codecool.nepi.entity.useraccounts.Operator;
import com.codecool.nepi.model.TicketModel;
import com.codecool.nepi.repository.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Getter
@Service
public class TicketService {

    private TicketRepository ticketRepository;
    private AdminRepository adminRepository;
    private OverseerRepository overseerRepository;
    private OperatorRepository operatorRepository;
    private OwnerRepository ownerRepository;
    private RenterRepository renterRepository;


    public List<Ticket> getAllTickets() {
        return ticketRepository.getAll();
    }

    public List<Ticket> getTicketsByType(String type) {
        return ticketRepository.findByType(type);
    }


    public void createNewTicket(TicketModel ticketModel) {
        ticketRepository.save(new Ticket(ticketModel.getType(), ticketModel.getName(), ticketModel.getDescription(),
                ticketModel.getPropertyId(), ticketModel.getUserEmail(), ticketModel.getUserPhonenumber()));
    }

    public void assignOperatorToTicket(String operatorContractId, Long ticketId) {
        Ticket currentTicket = ticketRepository.getById(ticketId);
        Operator currentOperator = operatorRepository.findByContractID(operatorContractId);

        currentOperator.getAssignedTickets().add(String.valueOf(ticketId));
        operatorRepository.save(currentOperator);

        currentTicket.setOperatorContractId(operatorContractId);
        ticketRepository.save(currentTicket);

    }

    public void resolveTicket(Long ticketId) {
        Ticket currentTicket = ticketRepository.getById(ticketId);
        currentTicket.setStatus(true);
        ticketRepository.save(currentTicket);
    }

}
