package cinema.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.booking.models.TicketType;
import cinema.booking.repositories.TicketTypeRepository;


@Service
public class TicketTypeService {

	@Autowired
	private TicketTypeRepository ticketTypeRepository;
	
	
	public List<TicketType> getAllTicketTypes() {
		List<TicketType> ticketTypes = new ArrayList<>();
		ticketTypeRepository.findAll().forEach(ticketTypes::add);
		return ticketTypes;
	}
	
	public double getPriceByType(String type) {
		return ticketTypeRepository.findPriceByType(type);
	}
	
	public Integer getTicketTypeIdByType(String type) {
		return ticketTypeRepository.findTicketTypeIdByType(type);
	}

	public Optional<TicketType> getTicketTypeById(Integer ticketTypeId) {
		return ticketTypeRepository.findById(ticketTypeId);
	}
	
	public TicketType findTicketTypeByType(String type) {
		return ticketTypeRepository.findTicketTypeByType(type);
	}
	
	public void addTicketType(TicketType ticketType) {
		ticketTypeRepository.save(ticketType);
	}
	
	public void updateTicketType(TicketType ticketType) {
		ticketTypeRepository.save(ticketType);
	}
	
	public void deleteTicketTypeById(Integer ticketTypeId) {
		ticketTypeRepository.deleteById(ticketTypeId);
	}
	
}
