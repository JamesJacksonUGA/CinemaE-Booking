package cinema.booking.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cinema.booking.models.Theater;

public class TheaterRowMapper implements RowMapper<Theater> {
    @Override
    public Theater mapRow(ResultSet rs, int rowNum) throws SQLException {
        Theater theater = new Theater(rs.getInt("hallNumber"));
 
 
        return theater;
    }
}