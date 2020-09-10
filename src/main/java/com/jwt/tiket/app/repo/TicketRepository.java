package com.jwt.tiket.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.tiket.app.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	Ticket findByEmail(String email);

}
