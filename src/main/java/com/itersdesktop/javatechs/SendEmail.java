package com.itersdesktop.javatechs;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public static void send(String subject, String address, String text) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", 465);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.auth", "true");
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tung@email.com", "aaabbbcccddd");
                }
            });

            // Used to debug SMTP issues
            session.setDebug(true);

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("someone@email.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address, false));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
