package cinema.booking.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="theater")
public class Theater {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer theaterId;
	@NotNull
	private String name;
	private String city;
	private String state;
	private String zipCode;
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "theater", orphanRemoval = true)
	@JsonBackReference
	private List<Showtime> showtimes = new ArrayList<>();
	
	
	
	public Theater() {
		
	}
	public Integer getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
        showtime.setTheater(this);
    }
    public void removeShowtime(Showtime showtime) {
        showtime.setTheater(null);
        this.showtimes.remove(showtime);
    }
	public List<Showtime> getShowtimes() {
		return showtimes;
	}
	public void setShowtimes(List<Showtime> showtimes) {
		this.showtimes = showtimes;
	}
    
}
