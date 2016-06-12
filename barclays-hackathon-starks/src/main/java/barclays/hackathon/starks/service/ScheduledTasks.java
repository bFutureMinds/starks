package barclays.hackathon.starks.service;

import barclays.hackathon.starks.model.LifeMoment;
import barclays.hackathon.starks.model.User;
import barclays.hackathon.starks.repository.UserRepository;
import barclays.hackathon.starks.repository.UserRepositoryImpl;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static barclays.hackathon.starks.service.EmailVariables.Type;

/**
 * Created by Ashish Sanodia on 12-Jun-16.
 */
@Component
public class ScheduledTasks {

    private static Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);
    private UserRepositoryImpl userRepository;
    private EmailService emailService;

    @Autowired
    public ScheduledTasks(UserRepositoryImpl userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @Scheduled(cron = "* 1 * * * *")
    public void sendMailForBirthdayEvent() {
        LocalDate now = new LocalDate();
        LocalDate afterSevenDaysFromNow = now.plusDays(4);
        List<User> users = userRepository.findByDobBetween(now, afterSevenDaysFromNow);
        for (User user : users) {
            user.setLifemoment(LifeMoment.BIRTHDAY);
            try {
                emailService.sendMailTo(getEventVariables(user), "");
                LOG.error(String.format("Sending mail to user with email : %s", user.getEmail()));
            } catch (Exception e) {
                LOG.error(String.format("Failed to send mail to user with email : %s", user.getEmail()), e);
            }
        }
    }

    private EmailVariables getEventVariables(User user) {
        EmailVariables emailVariables = new EmailVariables();
        emailVariables.addNew(Type.USER_EMAIL, user.getEmail());
        emailVariables.addNew(Type.USER_NAME, user.getName());
        emailVariables.addNew(Type.SUBJECT, "Birthday wishes!!");
        return emailVariables;
    }
}
