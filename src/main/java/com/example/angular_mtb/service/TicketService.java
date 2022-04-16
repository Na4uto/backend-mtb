package com.example.angular_mtb.service;

import java.util.List;

import com.example.angular_mtb.exception.TicketNotFoundException;
import com.example.angular_mtb.model.Ticket;

public interface TicketService {
	public Ticket addTicket(Ticket ticket,Integer bookingId) throws TicketNotFoundException;

	public Ticket findTicket(int ticketId);

	List<Ticket> viewTicketList() throws TicketNotFoundException;
}
