package cinema.booking.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cinema.booking.models.Movie;
import cinema.booking.models.Seat;
import cinema.booking.models.Showtime;
import cinema.booking.models.Theater;
import cinema.booking.services.MovieService;
import cinema.booking.services.SeatService;
import cinema.booking.services.ShowtimeService;
import cinema.booking.services.TheaterService;

@Controller
public class ManageShowtimesController {

	@Autowired
	private TheaterService theaterService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private ShowtimeService showtimeService;
	@Autowired
	private SeatService seatService;
	
	
	@RequestMapping(value="/manageShowtimes")
	public String manageShowtimes(Model model) {
		
		model.addAttribute("movies", movieService.getAllMovies());
		model.addAttribute("theaters", theaterService.getAllTheaters());
		return "manageShowtimes";
	}
	
	@PostMapping(value="/addShowtime")
	public String addShowtime(@RequestParam("date") String date, 
			@RequestParam("hall") Integer hall, 
			@RequestParam("movieId") Integer movieId,
			Model model) throws ParseException {
		
		//make sure there isn't a showtime already set for selected theater and date
		List<Showtime> showtimes = showtimeService.findShowtimeByDateTheaterId(date, hall);
		if (showtimes.isEmpty()) {
			Theater theater = theaterService.getTheaterByHallNumber(hall);
			Movie movie = movieService.findMovieById(movieId);
			
			//format date and times for each showtime to be created
			String showtime11 = date + " 11:00:00";
			String showtime14 = date + " 14:00:00";
			String showtime17 = date + " 17:00:00";
			String showtime20 = date + " 20:00:00";
			String showtime23 = date + " 23:00:00";
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
			Date s1 = format.parse(showtime11);
			Date s2 = format.parse(showtime14);
			Date s3 = format.parse(showtime17);
			Date s4 = format.parse(showtime20);
			Date s5 = format.parse(showtime23);
			
			Showtime showtime1 = new Showtime(s1, movie, theater, "AVAILABLE");
			Showtime showtime2 = new Showtime(s2, movie, theater, "AVAILABLE");
			Showtime showtime3 = new Showtime(s3, movie, theater, "AVAILABLE");
			Showtime showtime4 = new Showtime(s4, movie, theater, "AVAILABLE");
			Showtime showtime5 = new Showtime(s5, movie, theater, "AVAILABLE");
			
			showtimeService.addShowtime(showtime1);
			showtimeService.addShowtime(showtime2);
			showtimeService.addShowtime(showtime3);
			showtimeService.addShowtime(showtime4);
			showtimeService.addShowtime(showtime5);
			
			Integer hallNo = theater.getHallNumber();
			//create seats for the showtime
			for (int i = 1; i <= 120; i++) {
				if (i < 13) {
					Seat seat = new Seat((hallNo + "A" + i), false, showtime1);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "A" + i), false, showtime2);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "A" + i), false, showtime3);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "A" + i), false, showtime4);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "A" + i), false, showtime5);
					seatService.addSeat(seat);
				}
				else if (i >= 13 && i < 25) {
					Seat seat = new Seat((hallNo + "B" + (i-12)), false, showtime1);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "B" + (i-12)), false, showtime2);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "B" + (i-12)), false, showtime3);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "B" + (i-12)), false, showtime4);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "B" + (i-12)), false, showtime5);
					seatService.addSeat(seat);
				}
				else if (i >= 25 && i < 37) {
					Seat seat = new Seat((hallNo + "C" + (i-24)), false, showtime1);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "C" + (i-24)), false, showtime2);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "C" + (i-24)), false, showtime3);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "C" + (i-24)), false, showtime4);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "C" + (i-24)), false, showtime5);
					seatService.addSeat(seat);
				}
				else if (i >= 37 && i < 49) {
					Seat seat = new Seat((hallNo + "D" + (i-36)), false, showtime1);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "D" + (i-36)), false, showtime2);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "D" + (i-36)), false, showtime3);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "D" + (i-36)), false, showtime4);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "D" + (i-36)), false, showtime5);
					seatService.addSeat(seat);
				}
				else if (i >= 49 && i < 61) {
					Seat seat = new Seat((hallNo + "E" + (i-48)), false, showtime1);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "E" + (i-48)), false, showtime2);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "E" + (i-48)), false, showtime3);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "E" + (i-48)), false, showtime4);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "E" + (i-48)), false, showtime5);
					seatService.addSeat(seat);
				}
				else if (i >= 61 && i < 73) {
					Seat seat = new Seat((hallNo + "F" + (i-60)), false, showtime1);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "F" + (i-60)), false, showtime2);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "F" + (i-60)), false, showtime3);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "F" + (i-60)), false, showtime4);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "F" + (i-60)), false, showtime5);
					seatService.addSeat(seat);
				}
				else if (i >= 73 && i < 85) {
					Seat seat = new Seat((hallNo + "G" + (i-72)), false, showtime1);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "G" + (i-72)), false, showtime2);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "G" + (i-72)), false, showtime3);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "G" + (i-72)), false, showtime4);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "G" + (i-72)), false, showtime5);
					seatService.addSeat(seat);
				}
				else if (i >= 85 && i < 97) {
					Seat seat = new Seat((hallNo + "H" + (i-84)), false, showtime1);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "H" + (i-84)), false, showtime2);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "H" + (i-84)), false, showtime3);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "H" + (i-84)), false, showtime4);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "H" + (i-84)), false, showtime5);
					seatService.addSeat(seat);
				}
				else if (i >= 97 && i < 109) {
					Seat seat = new Seat((hallNo + "I" + (i-96)), false, showtime1);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "I" + (i-96)), false, showtime2);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "I" + (i-96)), false, showtime3);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "I" + (i-96)), false, showtime4);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "I" + (i-96)), false, showtime5);
					seatService.addSeat(seat);
				}
				else if (i >= 109 && i < 121) {
					Seat seat = new Seat((hallNo + "J" + (i-108)), false, showtime1);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "J" + (i-108)), false, showtime2);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "J" + (i-108)), false, showtime3);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "J" + (i-108)), false, showtime4);
					seatService.addSeat(seat);
					seat = new Seat((hallNo + "J" + (i-108)), false, showtime5);
					seatService.addSeat(seat);
				}
			}
			
			model.addAttribute("added", "true");
			model.addAttribute("movies", movieService.getAllMovies());
			model.addAttribute("theaters", theaterService.getAllTheaters());
			return "manageShowtimes";
		}
		else {
			model.addAttribute("duplicate", "true");
			model.addAttribute("movies", movieService.getAllMovies());
			model.addAttribute("theaters", theaterService.getAllTheaters());
			return "manageShowtimes";
			
		}

	}

}
