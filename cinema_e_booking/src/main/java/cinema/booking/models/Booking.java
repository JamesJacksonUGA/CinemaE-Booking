package cinema.booking.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="booking")
public class Booking {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bookingId;
	@NotNull
	@ManyToOne
	private User user;
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "booking", orphanRemoval = true)
	@JsonManagedReference
	private List<Seat> seats = new ArrayList<>();
	@OneToOne
    private Payment payment;
	
	
	
	public Booking() {
		
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void addSeat(Seat seat) {
        seats.add(seat);
        seat.setBooking(this);
    }
    public void removeSeat(Seat seat) {
        seat.setBooking(null);
        this.seats.remove(seat);
    }
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}
