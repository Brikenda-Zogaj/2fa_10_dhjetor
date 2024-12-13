package com.example.a2fa_10_dhjetor;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {


    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void dispatchEmail(String recipient, String subject, String content) {
        executor.submit(() -> {
            try {
                System.out.println("Preparing email...");
                Properties smtpConfig = new Properties();
                smtpConfig.put("mail.smtp.host", "smtp.gmail.com");
                smtpConfig.put("mail.smtp.port", "587");
                smtpConfig.put("mail.smtp.auth", "true");
                smtpConfig.put("mail.smtp.starttls.enable", "true");


                Session emailSession = Session.getInstance(smtpConfig, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("gmail@gmail.com", "app_password");
                    }
                });


                Message emailMessage = new MimeMessage(emailSession);
                emailMessage.setFrom(new InternetAddress("gmail@gmail.com"));
                emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                emailMessage.setSubject(subject);
                emailMessage.setText(content);


                Transport.send(emailMessage);
                System.out.println("Email successfully sent to: " + recipient);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
    }
}
