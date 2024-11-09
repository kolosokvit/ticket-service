package ticketservice.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ticketservice.model.User;
import ticketservice.model.UserStatus;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Modifying
    @Query(value = "UPDATE users SET user_status = ?1::user_status WHERE user_id = ?2", nativeQuery = true)
    int updateUserStatus(UserStatus userStatus, int id);

}
