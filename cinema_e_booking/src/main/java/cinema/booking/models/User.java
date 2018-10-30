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
	private Boolean enabled = true;
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
	@NotNull
	private String role;
	
	//optional user fields
	private String phone;
	
	
	
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


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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
    
    
	public List<Booking> getBookings() {
		return bookings;
	}
	
	
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	public List<PaymentInfo> getPaymentInfos() {
		return paymentInfos;
	}
	
	
	public void setPaymentInfos(List<PaymentInfo> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}
	
	
	public String getRole() {
		return role;
	}
	
	
	public void setRole(String role) {
		this.role = role;
	}
	
}
