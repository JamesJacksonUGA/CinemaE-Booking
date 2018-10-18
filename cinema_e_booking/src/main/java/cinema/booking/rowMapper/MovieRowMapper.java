package cinema.booking.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cinema.booking.models.Movie;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
 
        movie.setMovieId(rs.getInt("movie_id"));
        movie.setCast(rs.getString("cast"));
        movie.setCategory(rs.getString("category"));
        movie.setComingSoon(rs.getBoolean("coming_soon"));
        movie.setDirector(rs.getString("director"));
        movie.setNowPlaying(rs.getBoolean("now_playing"));
        movie.setPicture(rs.getString("picture"));
        movie.setProducer(rs.getString("producer"));
        movie.setRating(rs.getString("rating"));
        movie.setReviews(rs.getString("reviews"));
        movie.setSynopsis(rs.getString("synopsis"));
        movie.setTitle(rs.getString("title"));
        movie.setVideo(rs.getString("video"));
        movie.setLength(rs.getInt("length"));
        
        return movie;
    }
}