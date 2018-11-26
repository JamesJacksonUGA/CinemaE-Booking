package cinema.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="seat")
public class Seat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer seatId;
	@NotNull
	private String seatNo;
	@NotNull
	private boolean taken = false;
	@ManyToOne
	private Showtime showtime;
	@ManyToOne
	@JsonBackReference
	private Booking booking = null;
	
	
	
	public Seat() {
		
	}
	public Seat(@NotNull String seatNo, @NotNull boolean taken,
			Showtime showtime) {
		super();
		this.seatNo = seatNo;
		this.taken = taken;
		this.showtime = showtime;
	}
	public Seat(@NotNull String seatNo, @NotNull boolean taken,
			Showtime showtime, Booking booking) {
		super();
		this.seatNo = seatNo;
		this.taken = taken;
		this.showtime = showtime;
		this.booking = booking;
	}
	public Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public boolean isTaken() {
		return taken;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	public Showtime getShowtime() {
		return showtime;
	}
	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	
	
}
