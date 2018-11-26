package cinema.booking.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="theater")
public class Theater {

	@Id
	@NotNull
	private Integer hallNumber;
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "theater", orphanRemoval = true)
	@JsonBackReference
	private List<Showtime> showtimes = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "theater", orphanRemoval = true)
	@JsonBackReference
	private List<TheaterMovie> theaterMovies = new ArrayList<>();
	
	
	
	public Theater() {
		
	}
	public Theater(@NotNull Integer hallNumber) {
		super();
		this.hallNumber = hallNumber;
	}
	public Integer getHallNumber() {
		return hallNumber;
	}
	public void setHallNumber(Integer hallNumber) {
		this.hallNumber = hallNumber;
	}
	public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
        showtime.setTheater(this);
    }
    public void removeShowtime(Showtime showtime) {
        showtime.setTheater(null);
        this.showtimes.remove(showtime);
    }
	public List<Showtime> getShowtimes() {
		return showtimes;
	}
	public void setShowtimes(List<Showtime> showtimes) {
		this.showtimes = showtimes;
	}
	public List<TheaterMovie> getTheaterMovies() {
		return theaterMovies;
	}
	public void setTheaterMovies(List<TheaterMovie> theaterMovies) {
		this.theaterMovies = theaterMovies;
	}
	
    
}
