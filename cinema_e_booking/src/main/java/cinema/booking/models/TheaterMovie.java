package cinema.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="theaterMovie")
public class TheaterMovie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer theaterMovieId;
	@NotNull
	@ManyToOne
	private Theater theater;
	@NotNull
	@ManyToOne
	private Movie movie;
	
	
	
	public TheaterMovie() {
		
	}

	public Integer getTheaterMovieId() {
		return theaterMovieId;
	}

	public void setTheaterMovieId(Integer theaterMovieId) {
		this.theaterMovieId = theaterMovieId;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
