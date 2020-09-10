package com.jwt.tiket.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.tiket.app.entity.Ticket;
import com.jwt.tiket.app.repo.TicketRepository;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Ticket createTicket(Ticket ticket) {
		return ticketRepository.save(ticket);

	}

	@Override
	public Ticket getTicketById(Integer ticketId) {

		return ticketRepository.findById(ticketId).get();
	}

	@Override
	public List<Ticket> getAllBookedTickets() {

		return ticketRepository.findAll();
	}

	@Override
	public void deleteTicket(Integer ticketId) {

		ticketRepository.deleteById(ticketId);

	}

	@Override
	public Ticket updateTicket(Integer ticketId, String newEmail) {

		Ticket ticketFromDB = ticketRepository.findById(ticketId).get();
		ticketFromDB.setEmail(newEmail);
		Ticket upadedTicket = ticketRepository.save(ticketFromDB);
		return upadedTicket;
	}

	@Override
	public Ticket getTicketByEmail(String email) {
		return ticketRepository.findByEmail(email);
	}

}
