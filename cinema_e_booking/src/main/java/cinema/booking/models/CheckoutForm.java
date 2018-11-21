package cinema.booking.models;

import javax.validation.constraints.NotNull;

public class CheckoutForm {

	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String email;
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
	@NotNull
	private String ccnum;
	@NotNull
	private String expDate;
	@NotNull
	private Integer CVV;
	private String promoCode;
	
	
	
	public CheckoutForm() {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getCcnum() {
		return ccnum;
	}
	public void setCcnum(String ccnum) {
		this.ccnum = ccnum;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public Integer getCVV() {
		return CVV;
	}
	public void setCVV(Integer cVV) {
		CVV = cVV;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
}
