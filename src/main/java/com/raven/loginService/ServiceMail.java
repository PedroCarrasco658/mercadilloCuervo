
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
    String from = "verifycodeappcuervo@gmail.com";
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "465");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "false");
    prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
    prop.put("mail.debug", "true");
    String username = "verifycodeappcuervo@gmail.com";
    String password = "xfjg aimw ilpn sfkh"; 
    
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
        e.printStackTrace();
        ms.setMessage("Error al enviar el correo: " + e.getMessage());
        System.out.println(e.getMessage());
    }
    return ms;
}
}
