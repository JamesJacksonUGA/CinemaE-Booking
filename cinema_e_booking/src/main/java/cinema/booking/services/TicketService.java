package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.Ticket;
import cinema.booking.repositories.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	
	public List<Ticket> getAllTickets() {
		List<Ticket> tickets = new ArrayList<>();
		ticketRepository.findAll().forEach(tickets::add);
		return tickets;
	}

	public Optional<Ticket> getTicketById(Integer ticketId) {
		return ticketRepository.findById(ticketId);
	}
	
	public void addTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}
	
	public void updateTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}
	
	public void deleteTicketById(Integer ticketId) {
		ticketRepository.deleteById(ticketId);
	}
	
}
