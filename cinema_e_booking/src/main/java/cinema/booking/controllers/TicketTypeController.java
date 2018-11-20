package cinema.booking.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.booking.models.TicketType;
import cinema.booking.services.TicketTypeService;

@RestController
public class TicketTypeController {

	@Autowired
	private TicketTypeService ticketTypeService;
	
	
	@GetMapping("/ticketType")
	public List<TicketType> getAllTicketTypes() {
		return ticketTypeService.getAllTicketTypes();
	}
	
	@GetMapping("/ticketType/{ticketTypeId}")
	public Optional<TicketType> getTicketTypeById(@PathVariable Integer ticketTypeId) {
		return ticketTypeService.getTicketTypeById(ticketTypeId);
	}
	
	@PostMapping("/ticketType")
	public void addTicketType(@RequestBody TicketType ticketType) {
		ticketTypeService.addTicketType(ticketType);
	}
	
	@PutMapping("/ticketType/{ticketTypeId}")
	public void updateTicketType(@RequestBody TicketType ticketType, @PathVariable Integer ticketTypeId) {
		ticketTypeService.updateTicketType(ticketType);
	}
	
	@DeleteMapping("ticketType/{ticketTypeId}")
	public void deleteTicketTypeById(@PathVariable Integer ticketTypeId) {
		ticketTypeService.deleteTicketTypeById(ticketTypeId);
	}
	
}
