package cinema.booking.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="showtime")
public class Showtime {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer showtimeId;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
	@NotNull
	@ManyToOne
	private Movie movie;
	@NotNull
	@ManyToOne
	@JsonManagedReference
	private Theater theater = new Theater(-1);
	private String showStatus;
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "showtime", orphanRemoval = true)
	private List<Seat> seats = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "showtime", orphanRemoval = true)
	private List<Booking> bookings = new ArrayList<>();
	
	
	
	public Showtime() {
		
	}
	public Showtime(@NotNull Date dateTime, @NotNull Movie movie, @NotNull Theater theater, String showStatus) {
		super();
		this.dateTime = dateTime;
		this.movie = movie;
		this.theater = theater;
		this.showStatus = showStatus;
	}
	public Integer getShowtimeId() {
		return showtimeId;
	}
	public void setShowtimeId(Integer showtimeId) {
		this.showtimeId = showtimeId;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public String getShowStatus() {
		return showStatus;
	}
	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}
	public void addSeat(Seat seat) {
        seats.add(seat);
        seat.setShowtime(this);
    }
    public void removeSeat(Seat seat) {
        seat.setShowtime(null);
        this.seats.remove(seat);
    }
	
}





