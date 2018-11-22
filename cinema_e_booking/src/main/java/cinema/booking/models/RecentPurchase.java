package cinema.booking.models;

import java.util.Date;

public class RecentPurchase {

	private String title;
	private Date datetime;
	private Integer adult;
	private Integer child;
	private Integer senior;
	private double adultPrice;
	private double childPrice;
	private double seniorPrice;
	private double total;
	private String address;
	private String address2;
	private String country;
	private String state;
	private String zip;
	private String creditCard;
	
	
	
	public RecentPurchase() {
		
	}
	public RecentPurchase(String title, Date datetime, Integer adult, Integer child, Integer senior, double adultPrice,
			double childPrice, double seniorPrice, double total, String address, String address2, String country,
			String state, String zip, String creditCard) {
		super();
		this.title = title;
		this.datetime = datetime;
		this.adult = adult;
		this.child = child;
		this.senior = senior;
		this.adultPrice = adultPrice;
		this.childPrice = childPrice;
		this.seniorPrice = seniorPrice;
		this.total = total;
		this.address = address;
		this.address2 = address2;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.creditCard = creditCard;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Integer getAdult() {
		return adult;
	}
	public void setAdult(Integer adult) {
		this.adult = adult;
	}
	public Integer getChild() {
		return child;
	}
	public void setChild(Integer child) {
		this.child = child;
	}
	public Integer getSenior() {
		return senior;
	}
	public void setSenior(Integer senior) {
		this.senior = senior;
	}
	public double getAdultPrice() {
		return adultPrice;
	}
	public void setAdultPrice(double adultPrice) {
		this.adultPrice = adultPrice;
	}
	public double getChildPrice() {
		return childPrice;
	}
	public void setChildPrice(double childPrice) {
		this.childPrice = childPrice;
	}
	public double getSeniorPrice() {
		return seniorPrice;
	}
	public void setSeniorPrice(double seniorPrice) {
		this.seniorPrice = seniorPrice;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
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
	
}
