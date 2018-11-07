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
@Table(name="movie")
public class Movie {
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer movieId;
	@NotNull
	private String title;
	private String category;
	private String cast;
	private String director;
	private String producer;
	private String synopsis;
	private String reviews;
	private String picture;
	private String video;
	private String rating;
	@NotNull
	private Boolean nowPlaying = true;
	@NotNull
	private Boolean comingSoon=false;
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "movie", orphanRemoval = true)
	@JsonBackReference
	private List<Showtime> showtimes = new ArrayList<>();
	@NotNull
	private Integer length;
	@OneToMany(cascade = CascadeType.ALL, 
	        mappedBy = "movie", orphanRemoval = true)
	@JsonBackReference
	private List<TheaterMovie> theaterMovies = new ArrayList<>();
	
	
	
	public Movie() {
		
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Boolean getNowPlaying() {
		return nowPlaying;
	}
	public void setNowPlaying(Boolean nowPlaying) {
		this.nowPlaying = nowPlaying;
	}
	public Boolean getComingSoon() {
		return comingSoon;
	}
	public void setComingSoon(Boolean comingSoon) {
		this.comingSoon = comingSoon;
	}
	public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
        showtime.setMovie(this);
    }
    public void removeShowtime(Showtime showtime) {
        showtime.setMovie(null);
        this.showtimes.remove(showtime);
    }
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public List<Showtime> getShowtimes() {
		return showtimes;
	}
	public void setShowtimes(List<Showtime> showtimes) {
		this.showtimes = showtimes;
	}
	public List<TheaterMovie> getTheaterMovies() {
		return theaterMovies;
	}
	public void setTheaterMovies(List<TheaterMovie> theaterMovies) {
		this.theaterMovies = theaterMovies;
	}
    
	
}
