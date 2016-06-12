package barclays.hackathon.starks.repository;

import barclays.hackathon.starks.model.User;
import org.joda.time.LocalDate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Ashish Sanodia on 12-Jun-16.
 */
public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByDobBetween(LocalDate departure, LocalDate arrival);

}
