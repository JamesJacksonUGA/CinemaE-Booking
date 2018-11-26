package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cinema.booking.models.TicketType;
import cinema.booking.services.TicketTypeService;

@Controller
public class ManagePricingController {

	@Autowired
	private TicketTypeService ticketTypeService;
	
	
	@RequestMapping(value="/managePricing")
	public String managePricing(Model model) {
		
		double adult = ticketTypeService.getPriceByType("ADULT");
		double child = ticketTypeService.getPriceByType("CHILD");
		double senior = ticketTypeService.getPriceByType("SENIOR");
		double tax = ticketTypeService.getPriceByType("TAX");
		double fee = ticketTypeService.getPriceByType("FEE");
		
		model.addAttribute("adult", adult);
		model.addAttribute("child", child);
		model.addAttribute("senior", senior);
		model.addAttribute("tax", tax);
		model.addAttribute("fee", fee);
		
		return "managePricing";
	}
	
	@PostMapping(value="/changePricing")
	public String changePricing(@RequestParam("adult") double adult,
			@RequestParam("child") double child,
			@RequestParam("senior") double senior,
			@RequestParam("tax") double tax,
			@RequestParam("fee") double fee,
			Model model) {
		
		TicketType t = ticketTypeService.findTicketTypeByType("ADULT");
		t.setPrice(adult);
		ticketTypeService.updateTicketType(t);
		t = ticketTypeService.findTicketTypeByType("CHILD");
		t.setPrice(child);
		ticketTypeService.updateTicketType(t);
		t = ticketTypeService.findTicketTypeByType("SENIOR");
		t.setPrice(senior);
		ticketTypeService.updateTicketType(t);
		t = ticketTypeService.findTicketTypeByType("TAX");
		t.setPrice(tax);
		ticketTypeService.updateTicketType(t);
		t = ticketTypeService.findTicketTypeByType("FEE");
		t.setPrice(fee);
		ticketTypeService.updateTicketType(t);
		
		adult = ticketTypeService.getPriceByType("ADULT");
		child = ticketTypeService.getPriceByType("CHILD");
		senior = ticketTypeService.getPriceByType("SENIOR");
		tax = ticketTypeService.getPriceByType("TAX");
		fee = ticketTypeService.getPriceByType("FEE");
		
		model.addAttribute("adult", adult);
		model.addAttribute("child", child);
		model.addAttribute("senior", senior);
		model.addAttribute("tax", tax);
		model.addAttribute("fee", fee);
		
		model.addAttribute("changed", "true");
		return "managePricing";
	}
	
	
}









