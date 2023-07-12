package spider.method;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.List;
import java.util.Properties;

public class SentEmail {
    public  void sentEmail (List<String> sentEmail) throws MessagingException {
        String emailMessage = sentEmail.toString();
        if (sentEmail.isEmpty()) {
        } else {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", "smtp.qq.com");
            prop.put("mail.smtp.port", "587");

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(System.getenv("qqmail"), System.getenv("password"));
                }
            });

            Message message = new MimeMessage(session);
            // who you are
            message.setFrom(new InternetAddress(System.getenv("qqmail")));
            // send to ...
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("709074535@qq.com"));

            message.setSubject("Mail Subject");

            String msg = emailMessage;

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Sent message successfully....");
        }

    }
}
