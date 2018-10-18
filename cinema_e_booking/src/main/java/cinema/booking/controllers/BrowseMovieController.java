package cinema.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cinema.booking.models.Movie;
import cinema.booking.rowMapper.MovieRowMapper;

@Controller
public class BrowseMovieController {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value= {"/movies"})
	public String movies(Model model) {
		
		String query = "SELECT * FROM movie WHERE coming_soon=0";
		List<Movie> movies = jdbcTemplate.query(query, new MovieRowMapper());
				
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	@RequestMapping(value= {"/comingSoon"})
	public String comingSoon(Model model) {
		
		String query = "SELECT * FROM movie WHERE coming_soon=1";
		List<Movie> comingSoon = jdbcTemplate.query(query, new MovieRowMapper());
				
		model.addAttribute("movies", comingSoon);
		
		return "comingSoon";
	}
	
}
