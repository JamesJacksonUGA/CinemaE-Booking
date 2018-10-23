package cinema.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.models.Movie;
import cinema.booking.rowMapper.MovieRowMapper;

@Controller
public class MovieDetailsController {

	@Autowired
    JdbcTemplate jdbcTemplate;

	@RequestMapping(value= {"/movieDetails/{movie_id}"})
	public String movieDetails(@PathVariable("movie_id") Integer movie_id, Model model) {
		
		String query = "SELECT * FROM movie WHERE movie_id=" + movie_id;
		List<Movie> movies = jdbcTemplate.query(query, new MovieRowMapper());
		
		model.addAttribute("movies", movies);
		
		return "movieDetails";
	}
	
}
