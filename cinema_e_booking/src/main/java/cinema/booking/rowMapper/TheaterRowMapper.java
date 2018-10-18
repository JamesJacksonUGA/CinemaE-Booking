package cinema.booking.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cinema.booking.models.Theater;

public class TheaterRowMapper implements RowMapper<Theater> {
    @Override
    public Theater mapRow(ResultSet rs, int rowNum) throws SQLException {
        Theater theater = new Theater();
 
        theater.setTheaterId(rs.getInt("theater_id"));
        theater.setName(rs.getString("name"));
        theater.setCity(rs.getString("city"));
        theater.setState(rs.getString("state"));
        theater.setZipCode(rs.getString("zip_code"));
 
        return theater;
    }
}