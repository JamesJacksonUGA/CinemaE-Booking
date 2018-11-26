package cinema.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cinema.booking.models.Theater;
import cinema.booking.services.TheaterService;

@Controller
public class ManageHallsController {

	@Autowired
	private TheaterService theaterService;
	
	
	@RequestMapping(value="/manageHalls")
	public String manageHalls(Model model) {
		model.addAttribute("theaters", theaterService.getAllTheaters());
		return "manageHalls";
	}

	@PostMapping(value="/addHall")
	public  String addHall(@RequestParam("hallNumber") Integer hallNumber, Model model) {
		
		//make sure a theater with hall number doesn't exist already
		if (theaterService.getTheaterByHallNumber(hallNumber) == null) {
		
			Theater theater = new Theater(hallNumber);
			theaterService.addTheater(theater);
			
			model.addAttribute("added", "true");
			model.addAttribute("theaters", theaterService.getAllTheaters());
			return "manageHalls";
		}
		else {
			model.addAttribute("duplicate", "true");
			model.addAttribute("theaters", theaterService.getAllTheaters());
			return "manageHalls";
		}
		
	}
	
	@PostMapping(value="/deleteHall")
	public String deleteHall(@RequestParam("removeHall") Integer removeNumber, Model model) {
		theaterService.deleteTheaterByHallNumber(removeNumber);
		model.addAttribute("theaters", theaterService.getAllTheaters());
		model.addAttribute("deleted", "true");
		return "manageHalls";
	}
	
}



