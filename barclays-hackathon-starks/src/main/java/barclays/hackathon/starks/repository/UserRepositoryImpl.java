package barclays.hackathon.starks.repository;

import barclays.hackathon.starks.model.*;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaniska on 12-Jun-16.
 */
@Repository
public class UserRepositoryImpl {
    public List<User> findByDobBetween(LocalDate departure, LocalDate arrival) {
        List<User> users = new ArrayList<User>();
        users.add(new User("1", "Ashish Sanodia", "ashishsanodia@gmail.com", UserLocation.METRO, new LocalDate().plusDays(1), "", LifeMoment.BIRTHDAY, AgeRange.AGE_RANGE_25_35, Card.Carnival));
        return users;
    }
}
