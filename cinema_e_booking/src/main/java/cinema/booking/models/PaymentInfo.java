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
@Table(name="paymentInfo")
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer paymentInfoId;
	@NotNull
	private String ccNum;
	@NotNull
	private Integer ccSeccode;
	private String expDate;
	@NotNull
	@ManyToOne
	private User userPaymentInfo;
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "paymentInfo", orphanRemoval = true)
	@JsonManagedReference
	private List<Booking> bookings = new ArrayList<>();
	@NotNull
	private String address;
	private String address2;
	@NotNull
	private String country;
	@NotNull
	private String state;
	@NotNull
	private String zip;
	@NotNull
	private String cardholderName;
	
	
	
	public PaymentInfo() {
		
	}
	public PaymentInfo(@NotNull String ccNum, @NotNull Integer ccSeccode, String expDate,
			@NotNull User userPaymentInfo, @NotNull String address, String address2,
			@NotNull String country, @NotNull String state, @NotNull String zip, @NotNull String cardholderName) {
		super();
		this.ccNum = ccNum;
		this.ccSeccode = ccSeccode;
		this.expDate = expDate;
		this.userPaymentInfo = userPaymentInfo;
		this.address = address;
		this.address2 = address2;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.cardholderName = cardholderName;
	}
	public Integer getPaymentInfoId() {
		return paymentInfoId;
	}
	public void setPaymentInfoId(Integer paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}
	public String getCcNum() {
		return ccNum;
	}
	public void setCcNum(String ccNum) {
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
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCardholderName() {
		return cardholderName;
	}
	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}
	
}
