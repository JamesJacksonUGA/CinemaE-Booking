package cinema.booking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cinema.booking.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("SELECT code FROM User where userId = :id") 
    String findCodeByUserId(@Param("id") Integer userId);
	
	@Modifying
	@Query("UPDATE User SET enabled = true WHERE userId = :id")
	void setEnabledByUserId(@Param("id") Integer userId);
	
	@Query("SELECT email FROM User where email = :email") 
    String findEmail(@Param("email") String email);
	
	User findUserByEmail(String email);

	@Query(value="SELECT * FROM user u where u.user_id = :userId", nativeQuery=true)
	User findUserById(@Param("userId") Integer userId);

	@Query(value="SELECT * FROM user u where u.recieve_promotions=true", nativeQuery=true)
	List<User> findUsersWithPromo();
	
}
