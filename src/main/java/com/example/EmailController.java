package com.example;

import com.example.entities.EmailSender;
import com.example.entities.User;
import com.example.models.SignupRequest;
import com.example.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.UUID;


@Controller
public class EmailController {

    //private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Inject
    public EmailController(UserRepository userRepository, Notifications notifications) {
        this.userRepository = userRepository;
        this.notifications = notifications;
    }

    private final UserRepository userRepository;

    private final Notifications notifications;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String Home() {
        return "login.html";

    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public String signup(SignupRequest request) {

        final UUID userKey = UUID.nameUUIDFromBytes(request.getEmailAddress().getBytes());

        if (userRepository.exists(userKey)) {
            return "email already in use";
        }

        //creating a user
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmailAddress(request.getEmailAddress());
        user.setUserKey(userKey);
        userRepository.save(user);

        ArrayList<String> emailInfo = new ArrayList<String>();
        emailInfo.add(user.getEmailAddress());
        emailInfo.add("An account has been created for you!");
        emailInfo.add("Here is a message");
        EmailSender newEmail = new EmailSender();
        try {
            newEmail.createAndSendEmailMessage(emailInfo, user);
        } catch (MessagingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }





//        MailSender mailSender = new MailSender() {
//
//            public void send(mailMessage) throws MailException {
//
//            }
//
//            @Override
//            public void send(SimpleMailMessage... simpleMailMessages) throws MailException {
//
//            }
//        }
        //send the url for the new user to click on to validate their account

        //after the user is saved into our repository we send them an email to verify that their email exists.

        //do i have to implement this send method twice, again with then first send method, because it goes red when i take it out

        //have the server send our user an email
//        return "Thank you for registering with Pester Your Rep.  An e-mail has been sent to your e-mail address for verification";

//    }
//
//
//    @RequestMapping(path = "/registration", method = RequestMethod.GET)
//    public Iterable<User> users() {
//
//       return userRepository.findAll();
//
//
//    }
//
//
//
//    //create a simpleMailMessage object
//
        return "redirect:/";
    }
}



