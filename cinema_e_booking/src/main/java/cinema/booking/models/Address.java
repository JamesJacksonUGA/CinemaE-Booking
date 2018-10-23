package cinema.booking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="address")
public class Address {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addressId;
	@NotNull
	private Integer streetNo;
	@NotNull
	private String streeName;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private Integer zipCode;
	private Integer aptNo;
	@NotNull
	private Boolean apartmentBoolean = false;  
	@NotNull
	@ManyToOne
	private User userAddress;
	
	
	
	public Address() {
		
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getStreetNo() {
		return streetNo;
	}
	public void setStreetNo(Integer streetNo) {
		this.streetNo = streetNo;
	}
	public String getStreeName() {
		return streeName;
	}
	public void setStreeName(String streeName) {
		this.streeName = streeName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public Integer getAptNo() {
		return aptNo;
	}
	public void setAptNo(Integer aptNo) {
		this.aptNo = aptNo;
	}
	public Boolean getApartmentBoolean() {
		return apartmentBoolean;
	}
	public void setApartmentBoolean(Boolean apartmentBoolean) {
		this.apartmentBoolean = apartmentBoolean;
	}
	public User getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(User userAddress) {
		this.userAddress = userAddress;
	}

}
