package cinema.booking.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeatSelectionController 
{
	@RequestMapping(value="/seatSelection")
	public String userProfile() {
		return "seatSelection";
	}
}
