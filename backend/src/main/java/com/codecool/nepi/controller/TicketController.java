package com.codecool.nepi.controller;

import com.codecool.nepi.entity.Ticket;
import com.codecool.nepi.entity.useraccounts.Operator;
import com.codecool.nepi.model.TicketModel;
import com.codecool.nepi.model.TicketOperatorAssign;
import com.codecool.nepi.service.TicketService;
import com.codecool.nepi.service.UserAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
@RestController
public class TicketController {

    TicketService ticketService;
    UserAccountsService userAccountsService;


    @GetMapping("/tickets/operators/all")
    public List<Operator> getAllOperators() {return userAccountsService.getAllOperators();}

    @GetMapping("/tickets/all")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/tickets/type")
    public List<Ticket> getTicketsByType(@RequestParam String ticketType) {
        return ticketService.getTicketsByType(ticketType);
    }

    @GetMapping("/tickets/show")
    public List<Ticket> getUserTickets(@RequestParam String userId) {
        return ticketService.getTicketsByUserId(userId);
    }

    @PostMapping("/tickets/new")
    public void createNewTicket(@RequestBody TicketModel ticketModel, @RequestParam String userId) {
        ticketService.createNewTicket(ticketModel, userId);
    }


    @PostMapping("/tickets/assign-operator")
    public void assignOperatorToTicket(@RequestBody TicketOperatorAssign ticketOperatorAssign) {
        ticketService.assignOperatorToTicket(ticketOperatorAssign.getOperatorContractId(), Long.parseLong(ticketOperatorAssign.getTicketId()));

    }


    @PostMapping("/tickets/resolve-ticket")
    public void markTicketAsSolved(@RequestParam String ticketId) {
        System.out.println(ticketId + ticketId.getClass());
        ticketService.resolveTicket(Long.parseLong(ticketId));
    }

}
