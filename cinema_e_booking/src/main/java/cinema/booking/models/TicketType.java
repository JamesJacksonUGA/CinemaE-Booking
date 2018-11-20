package cinema.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="ticketType")
public class TicketType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ticketTypeId;
	@NotNull
	private String type;
	@NotNull
	private double price;
	
	
	
	public TicketType() {
		
	}
	public Integer getTicketTypeId() {
		return ticketTypeId;
	}
	public void setTicketTypeId(Integer ticketTypeId) {
		this.ticketTypeId = ticketTypeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
