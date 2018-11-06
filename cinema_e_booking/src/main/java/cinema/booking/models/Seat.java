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
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer seatId;
	@NotNull
	private Integer seatNo;
	@NotNull
	private char rowLetter;
	@NotNull
	private Integer colNumber;
	@NotNull
	private boolean taken = false;
	@ManyToOne
	private Showtime showtime;
	@ManyToOne
	@JsonBackReference
	private Booking booking;
	
	
	
	public Seat() {
		
	}
	public Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public char getRowLetter() {
		return rowLetter;
	}
	public void setRowLetter(char rowLetter) {
		this.rowLetter = rowLetter;
	}
	public Integer getColNumber() {
		return colNumber;
	}
	public void setColNumber(Integer colNumber) {
		this.colNumber = colNumber;
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
	public Integer getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}
	
}
