package com.codecool.nepi.service;

import com.codecool.nepi.entity.Ticket;
import com.codecool.nepi.entity.useraccounts.Operator;
import com.codecool.nepi.entity.useraccounts.Owner;
import com.codecool.nepi.entity.useraccounts.Renter;
import com.codecool.nepi.model.TicketModel;
import com.codecool.nepi.repository.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Ticket> getTicketsByUserId(String userId){
        List<Ticket> tickets = new ArrayList<>();
        if(renterRepository.findById(Long.parseLong(userId)).isPresent()) {
            tickets = renterRepository.findById(Long.parseLong(userId)).get().getTicketList();
        } else if(ownerRepository.findById(Long.parseLong(userId)).isPresent()) {
            tickets = ownerRepository.findById(Long.parseLong(userId)).get().getTicketList();
        } else if (operatorRepository.findById(Long.parseLong(userId)).isPresent()) {
            tickets = operatorRepository.findById(Long.parseLong(userId)).get().getAssignedTickets();
        }
        return tickets;
    }

    public void createNewTicket(TicketModel ticketModel, String userId) {
        Ticket newTicket = new Ticket(ticketModel.getType(), ticketModel.getName(), ticketModel.getDescription(),
                ticketModel.getPropertyId(), ticketModel.getUserEmail(), ticketModel.getUserPhonenumber());
        ticketRepository.save(newTicket);
        if (renterRepository.findById(Long.parseLong(userId)).isPresent()) {
            Renter renter = renterRepository.getById(Long.parseLong(userId));
            renter.getTicketList().add(newTicket);
            renterRepository.save(renter);
        } else if (ownerRepository.findById(Long.parseLong(userId)).isPresent()) {
            Owner owner = ownerRepository.getById(Long.parseLong(userId));
            owner.getTicketList().add(newTicket);
            ownerRepository.save(owner);
        }
    }

    public void assignOperatorToTicket(String operatorContractId, Long ticketId) {
        Ticket currentTicket = ticketRepository.getById(ticketId);
        Operator currentOperator = operatorRepository.findByContractID(operatorContractId);
        currentOperator.getAssignedTickets().add(currentTicket);
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
