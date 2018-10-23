package cinema.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="paymentInfo")
public class PaymentInfo {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer paymentInfoId;
	@NotNull
	private Integer ccNum;
	@NotNull
	private Integer ccSeccode;
	@NotNull
	private String expDate;
	@NotNull
	@ManyToOne
	private User userPaymentInfo;
	
	
	
	public PaymentInfo() {
		
	}
	public Integer getPaymentInfoId() {
		return paymentInfoId;
	}
	public void setPaymentInfoId(Integer paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}
	public Integer getCcNum() {
		return ccNum;
	}
	public void setCcNum(Integer ccNum) {
		this.ccNum = ccNum;
	}
	public Integer getCcSeccode() {
		return ccSeccode;
	}
	public void setCcSeccode(Integer ccSeccode) {
		this.ccSeccode = ccSeccode;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public User getUserPaymentInfo() {
		return userPaymentInfo;
	}
	public void setUserPaymentInfo(User userPaymentInfo) {
		this.userPaymentInfo = userPaymentInfo;
	}
	
}
