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
	private List<Ticket> tickets = new ArrayList<>();
	@ManyToOne
    private Promotion promotion;
	@NotNull
	@ManyToOne
	private Showtime showtime;
	@NotNull
	private Integer cc_num;
	
	
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
	public void addTicket(Ticket ticket) {
        tickets.add(ticket);
        ticket.setBooking(this);
    }
    public void removeTicket(Ticket ticket) {
        ticket.setBooking(null);
        this.tickets.remove(ticket);
    }
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	public Showtime getShowtime() {
		return showtime;
	}
	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	
}
