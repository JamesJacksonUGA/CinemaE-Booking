package cinema.booking.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cinema.booking.models.TicketType;

public interface TicketTypeRepository extends CrudRepository<TicketType, Integer> {

	@Query("SELECT price FROM TicketType where type = :type") 
	double findPriceByType(@Param("type") String type);	
	
}
