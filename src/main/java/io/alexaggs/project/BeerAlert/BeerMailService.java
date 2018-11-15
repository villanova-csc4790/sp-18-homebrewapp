package io.alexaggs.project.BeerAlert;

import org.springframework.beans.factory.annotation.Autowired;
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

    public static void sendBreweries(String text) throws Exception {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("alexmaguilar18@gmail.com");
        mail.setFrom("alexmaguilar18@gmail.com");
        mail.setSubject("Breweries Near You");
        mail.setText(text);
        jms.send(mail);
    }

    public static void sendBeers(String text, String style) throws Exception {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("alexmaguilar18@gmail.com");
        mail.setFrom("alexmaguilar18@gmail.com");
        mail.setSubject("Top 10 " + style + 's');
        mail.setText(text);
        jms.send(mail);
    }
}
