
package com.raven.loginService;

import com.raven.loginModel.ModelMessage;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import java.util.Properties;


public class ServiceMail {
    public ModelMessage sendMain(String toEmail, String code) {
    ModelMessage ms = new ModelMessage(false, "");
    String from = "pedrocarrasco111105@gmail.com";
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true");
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    String username = "pedrocarrasco111105@gmail.com";
    String password = "aqvz dqwq ktnh lhot"; // Pon aquí tu contraseña real o usa variables de entorno
    
    Session session = Session.getInstance(prop, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });
    
    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject("Verify Code");
        message.setText(code);
        Transport.send(message);
        ms.setSuccess(true);
    } catch (MessagingException e) {
        if (e.getMessage().equals("Invalid Addresses")) {
            ms.setMessage("Invalid email");
        } else {
            ms.setMessage("Error");
        }
    }
    return ms;
}
}
