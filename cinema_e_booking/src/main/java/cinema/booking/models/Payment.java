package cinema.booking.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer paymentId;
	@OneToOne(cascade =  CascadeType.ALL,
            mappedBy = "payment")
	private Booking booking;
	private double total=0.0;
	private boolean usesPromotion=false;
	@ManyToOne
	@JsonBackReference
	private Promotion promotion;
	
	
	
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public boolean isUsesPromotion() {
		return usesPromotion;
	}
	public void setUsesPromotion(boolean usesPromotion) {
		this.usesPromotion = usesPromotion;
	}
    public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
    
}
