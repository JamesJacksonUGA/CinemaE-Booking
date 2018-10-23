package cinema.booking.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	//mandatory user fields
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@Column(unique=true)
	private String email;
	@NotNull
	private String password;
	@NotNull
	private Boolean admin = false;
	@NotNull
	private Boolean employee = false;
	@NotNull
	private Boolean suspended = false;
	@NotNull
	private Date birthDate;
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "user", orphanRemoval = true)
	private List<Booking> bookings = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "userAddress", orphanRemoval = true)
	private List<Address> addresses = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "userPaymentInfo", orphanRemoval = true)
	private List<PaymentInfo> paymentInfos = new ArrayList<>();
	
	//optional user fields
	private String phone;
	private String cardType;
	private String cardNumber;
	private String cardExpDateMonth;
	private String cardExpDateYear;
	private String cardZip;
	
	
	
	public User() {
		
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Boolean getAdmin() {
		return admin;
	}


	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}


	public Boolean getEmployee() {
		return employee;
	}


	public void setEmployee(Boolean employee) {
		this.employee = employee;
	}


	public Boolean getSuspended() {
		return suspended;
	}


	public void setSuspended(Boolean suspended) {
		this.suspended = suspended;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getCardType() {
		return cardType;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getCardExpDateMonth() {
		return cardExpDateMonth;
	}


	public void setCardExpDateMonth(String cardExpDateMonth) {
		this.cardExpDateMonth = cardExpDateMonth;
	}


	public String getCardExpDateYear() {
		return cardExpDateYear;
	}


	public void setCardExpDateYear(String cardExpDateYear) {
		this.cardExpDateYear = cardExpDateYear;
	}


	public String getCardZip() {
		return cardZip;
	}


	public void setCardZip(String cardZip) {
		this.cardZip = cardZip;
	}
	public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setUser(this);
    }
    public void removeBooking(Booking booking) {
        booking.setUser(null);
        this.bookings.remove(booking);
    }
    public void addAddress(Address address) {
        addresses.add(address);
        address.setUserAddress(this);
    }
    public void removeAddress(Address address) {
        address.setUserAddress(null);
        this.addresses.remove(address);
    }
    public void addPaymentInfo(PaymentInfo paymentInfo) {
        paymentInfos.add(paymentInfo);
        paymentInfo.setUserPaymentInfo(this);
    }
    public void removePaymentInfo(PaymentInfo paymentInfo) {
        paymentInfo.setUserPaymentInfo(null);
        this.paymentInfos.remove(paymentInfo);
    }
	
}
