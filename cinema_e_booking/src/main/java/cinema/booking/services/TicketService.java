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
	
	public Integer getAdultByBookingId(Integer bookingId) {
		return ticketRepository.getAdultByBookingId(bookingId);
	}
	
	public Integer getChildByBookingId(Integer bookingId) {
		return ticketRepository.getChildByBookingId(bookingId);
	}
	
	public Integer getSeniorByBookingId(Integer bookingId) {
		return ticketRepository.getSeniorByBookingId(bookingId);
	}
	
	public double getAdultSellingPrice(Integer bookingId) {
		return ticketRepository.getAdultSellingPrice(bookingId);
	}
	
	public double getChildSellingPrice(Integer bookingId) {
		return ticketRepository.getChildSellingPrice(bookingId);
	}
	
	public double getSeniorSellingPrice(Integer bookingId) {
		return ticketRepository.getSeniorSellingPrice(bookingId);
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
