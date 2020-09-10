package com.jwt.tiket.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.jwt.tiket.app.entity.Ticket;
import com.jwt.tiket.app.repo.TicketRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TicketBookingServiceImplTest {

	@InjectMocks
	private TicketBookingServiceImpl ticketBookingService;

	@Mock
	TicketRepository ticketRepository;

	private Ticket ticket;

	@Test
	public void testCreateTicket() {
		ticket = createTicketData();
		when(ticketRepository.save(ticket)).thenReturn(ticket);
		assertThat(ticketBookingService.createTicket(ticket)).isEqualTo(ticket);

	}

	@Test
	public void testCreateTicket_should_create_ticket() {
		ticket = createTicketData();
		when(ticketRepository.save(ticket)).thenReturn(ticket);
		Ticket result = ticketBookingService.createTicket(ticket);
		assertNotNull(result);
		verify(ticketRepository).save(ticket);
	}

	@Test
	public void testCreateTicket_should_not_create_ticket() {
		ticket = createTicketData();
		when(ticketRepository.save(ticket)).thenReturn(null);
		assertThat(ticketBookingService.createTicket(ticket)).isEqualTo(null);

	}

	@Test
	public void testGetTicketById_should_get_ticket() {
		ticket = createTicketData();
		when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket));
		assertThat(ticketBookingService.getTicketById(1)).isEqualTo(ticket);
	}

	@Test
	public void testGetTicketById_should_not_get_ticket() {
		when(ticketRepository.findById(1)).thenReturn(null);

	}

	@Test
	public void testGetAllBookedTickets() {
		Ticket ticket1 = new Ticket();
		ticket1.setPassengerName("Martin Bingel");
		ticket1.setSourceStation("Kolkata");
		ticket1.setDestStation("Delhi");
		ticket1.setBookingDate(new Date());
		ticket1.setEmail("martin.s2017@gmail.com");

		Ticket ticket2 = new Ticket();
		ticket2.setPassengerName("Sean Murphy");
		ticket2.setSourceStation("Kolkata");
		ticket2.setDestStation("Mumbai");
		ticket2.setBookingDate(new Date());
		ticket2.setEmail("sean.s2017@gmail.com");

		List<Ticket> ticketList = new ArrayList<>();
		ticketList.add(ticket1);
		ticketList.add(ticket2);
		Mockito.when(ticketRepository.findAll()).thenReturn(ticketList);
		List<Ticket> result = ticketBookingService.getAllBookedTickets();
		assertEquals(result, ticketList);
	}

	@Test
	public void testDeleteTicket() {

		Ticket ticket = createTicketData();
		when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket));
		when(ticketRepository.existsById(ticket.getTicketId())).thenReturn(false);
		assertFalse(ticketRepository.existsById(ticket.getTicketId()));
	}

	@Test
	public void testUpdateTicket() {
	}

	@Test
	public void testGetTicketByEmail() {
	}

	private Ticket createTicketData() {
		Ticket ticket = new Ticket();
		ticket.setTicketId(123);
		ticket.setBookingDate(new Date());
		ticket.setPassengerName("test");
		ticket.setEmail("m@gmail.com");
		ticket.setSourceStation("MFP");
		ticket.setDestStation("SBC");
		return ticket;
	}

}
