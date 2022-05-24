package com.codecool.nepi.controller;

import com.codecool.nepi.entity.Ticket;
import com.codecool.nepi.model.TicketModel;
import com.codecool.nepi.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
@RestController
public class TicketController {

    TicketService ticketService;


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
    public void assignOperatorToTicket(@RequestParam String operatorContractId, @RequestParam String ticketId) {
        ticketService.assignOperatorToTicket(operatorContractId, Long.parseLong(ticketId));

    }


    @PostMapping("/tickets/resolve-ticket")
    public void markTicketAsSolved(@RequestParam String ticketId) {
        ticketService.resolveTicket(Long.parseLong(ticketId));
    }

}
