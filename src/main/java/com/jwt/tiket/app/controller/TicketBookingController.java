package com.jwt.tiket.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.tiket.app.entity.Ticket;
import com.jwt.tiket.app.service.TicketBookingService;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.createTicket(ticket);

	}

	@GetMapping(value = "/ticket/{ticketId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
		return ticketBookingService.getTicketById(ticketId);
	}

	@GetMapping(value = "/alltickets", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingService.getAllBookedTickets();
	}

	@GetMapping(value = "/email/{email:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ticket getTicketByEmail(@PathVariable("email") String email) {
		return ticketBookingService.getTicketByEmail(email);
	}

	@DeleteMapping(value = "/ticketId/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		ticketBookingService.deleteTicket(ticketId);
	}

	@PutMapping(value = "/ticketId/{ticketId}/email/{newEmail:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId, @PathVariable("newEmail") String newEmail) {
		return ticketBookingService.updateTicket(ticketId, newEmail);
	}

}
