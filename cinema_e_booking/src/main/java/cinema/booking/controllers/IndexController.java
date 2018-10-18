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
public class IndexController {
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	@RequestMapping(value= {"/", "/home"})
	public String index(Model model) {
		
		String query = "SELECT * FROM movie";
		List<Movie> movies = jdbcTemplate.query(query, new MovieRowMapper());
				
		model.addAttribute("movies", movies);
		
		return "homepage";
	}
	
}



