package com.jwt.tiket.app.service;

import java.util.List;

import com.jwt.tiket.app.entity.Ticket;

public interface TicketBookingService {

	Ticket createTicket(Ticket ticket);

	Ticket getTicketById(Integer ticketId);

	List<Ticket> getAllBookedTickets();

	void deleteTicket(Integer ticketId);

	Ticket updateTicket(Integer ticketId, String newEmail);

	Ticket getTicketByEmail(String email);

}
