package io.alexaggs.project.BeerAlert;

import com.google.maps.model.PlacesSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class BeerMailService {

    private static JavaMailSender jms;

    @Autowired
    public BeerMailService(JavaMailSender jms) {
        this.jms = jms;
    }

    public static void sendEmail() throws Exception {
        String text = "";
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("alexmaguilar18@gmail.com");
        mail.setFrom("alexmaguilar18@gmail.com");
        mail.setSubject("Breweries Near You");
        mail.setText(text);

        jms.send(mail);
    }
}
