package io.alexaggs.project.BeerAlert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class BeerMailService {

    private static JavaMailSender jms;

    @Autowired
    public BeerMailService(JavaMailSender jms) {
        this.jms = jms;
    }

    public static void sendEmail() throws MailException {
        System.out.println("Sent the mail!");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("alexmaguilar18@gmail.com");
        mail.setFrom("alexmaguilar18@gmail.com");
        mail.setSubject("Beer Alert!");
        mail.setText("New beer!!!");
        jms.send(mail);
    }
}
