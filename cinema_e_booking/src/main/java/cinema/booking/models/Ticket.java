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
@Table(name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ticketId;
	@ManyToOne
	@JsonBackReference
	private Booking booking;
	@NotNull
	private String seatNo;
	@NotNull
	private Integer type;
	@NotNull
	private double sellingPrice;
	
	
	
	public Ticket() {
		
	}
	public Ticket(Booking booking, @NotNull String seatNo, @NotNull Integer type, @NotNull double sellingPrice) {
		super();
		this.booking = booking;
		this.seatNo = seatNo;
		this.type = type;
		this.sellingPrice = sellingPrice;
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
}
