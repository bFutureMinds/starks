package barclays.hackathon.starks.web;

import barclays.hackathon.starks.service.EmailService;
import barclays.hackathon.starks.web.vo.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ashish Sanodia on 12-Jun-16.
 */
@Controller
@RequestMapping("/mail")
public class MailController {

    private EmailService service;

    @Autowired
    public MailController(EmailService service) {
        this.service = service;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Email> sendMail(@RequestBody Email email) {
//        String userEmail = email.getEmail();
//        try {
//            EmailVariables emailVariables = new EmailVariables();
//            emailVariables.addNew(EmailVariables.Type.USER_EMAIL, userEmail);
//            emailVariables.addNew(EmailVariables.Type.SUBJECT, "some-subject");
//            emailVariables.addNew(EmailVariables.Type.USER_NAME, "some-name");
////            service.sendMailTo(new User(), "email");
//        } catch (MessagingException e) {
//            return ResponseEntity.unprocessableEntity().body(email);
//        } catch (IOException e) {
//            return ResponseEntity.unprocessableEntity().body(email);
//        }
        return ResponseEntity.accepted().body(email);
    }
}
