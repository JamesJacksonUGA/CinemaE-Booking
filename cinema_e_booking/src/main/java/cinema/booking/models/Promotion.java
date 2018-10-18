package cinema.booking.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="promotion")
public class Promotion {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer promotionId;
	@NotNull
	private String promoCode;
	@Temporal(TemporalType.DATE)
    private Date expDate;
	@NotNull
	private boolean active;
	@NotNull
	private Integer percentOff;
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "promotion", orphanRemoval = true)
	@JsonManagedReference
	private List<Payment> payments = new ArrayList<>();
	
	
	
	public Integer getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Integer getPercentOff() {
		return percentOff;
	}
	public void setPercentOff(Integer percentOff) {
		this.percentOff = percentOff;
	}
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	public void addPayment(Payment payment) {
        payments.add(payment);
        payment.setPromotion(this);
    }
    public void removePayment(Payment payment) {
        payment.setPromotion(null);
        this.payments.remove(payment);
    }
	
}



