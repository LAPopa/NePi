package com.codecool.nepi.repository;

import com.codecool.nepi.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> getTicketByStatusFalse();
    List<Ticket> getTicketByTypeEquals(String type);
    List<Ticket> getTicketByPropertyId(String propertyId);
}
