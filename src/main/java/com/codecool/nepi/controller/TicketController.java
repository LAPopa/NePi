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

    @PostMapping("/tickets/new")
    public void createNewTicket(@RequestBody TicketModel ticketModel) {
        ticketService.createNewTicket(ticketModel);
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
