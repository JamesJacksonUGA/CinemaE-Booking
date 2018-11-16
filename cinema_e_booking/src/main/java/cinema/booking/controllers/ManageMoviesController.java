package cinema.booking.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cinema.booking.models.Movie;
import cinema.booking.services.MovieService;

@Controller
public class ManageMoviesController {

	@Autowired
	private MovieService movieService;
	
	
	@RequestMapping(value="/manageMovies")
	public String manageMovies(Model model) {
		model.addAttribute("newMovie", new Movie());
		return "manageMovies";
	}

	@PostMapping(value="/addMovie")
	public String addMovie(@RequestParam("poster") MultipartFile file, @ModelAttribute Movie newMovie, 
			RedirectAttributes redirectAttributes, Model model) {
		
		//save the file for the movie poster
		if (!file.isEmpty()) {
			
			try {

				String rootPath = System.getProperty("user.dir");
			    File saveTo = new File(rootPath + File.separator + "src"+File.separator+"main"+File.separator+"resources"
			    		+File.separator+"static"+File.separator+"images"+File.separator+file.getOriginalFilename());
				
	            byte[] bytes = file.getBytes();	            
	            Path path = Paths.get(saveTo.getAbsolutePath());
	            
	            Files.write(path, bytes);

	            redirectAttributes.addFlashAttribute("message",
	                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			newMovie.setPicture(file.getOriginalFilename());
		}
		
		
		//alter the youtube trailer link to be the embedded version
		String trailer = newMovie.getVideo().replace("watch?v=", "embed/");
		newMovie.setVideo(trailer);
		
		
		//make sure the movie is either now playing or coming soon, not both
		if (newMovie.getNowPlaying() == true) {
			newMovie.setComingSoon(false);
		}
		else {
			newMovie.setComingSoon(true);
		}
		
		movieService.addMovie(newMovie);
		model.addAttribute("added", "true");
		model.addAttribute("newMovie", new Movie());
		return "manageMovies";
	}

	
}








