package cinema.booking.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cinema.booking.models.Theater;

public interface TheaterRepository extends CrudRepository<Theater, Integer> {

	@Query(value="SELECT * FROM theater t where t.hall_number= :hallNumber", nativeQuery=true)
	Theater findByHallNumber(@Param("hallNumber") Integer hallNumber);

	@Modifying
	@Transactional
	@Query(value="DELETE FROM theater where hall_number= :hallNumber", nativeQuery=true)
	void deleteByHallNumber(@Param("hallNumber") Integer hallNumber);

}
