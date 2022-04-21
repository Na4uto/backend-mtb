package com.example.angular_mtb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.angular_mtb.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
