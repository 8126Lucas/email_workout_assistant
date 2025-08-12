import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) {
        String EMAIL = "Email Workout Assistant <" + System.getenv("EMAIL_ADDRESS") + ">";
        String USERNAME = System.getenv("EMAIL_ADDRESS");
        String PASSWORD = System.getenv("EWA_PASSWORD");

        if(USERNAME == null || PASSWORD == null) {
            System.out.println("SIR! THERE HAS BEEN A PROBLEM THE ENVIRONMENT VARIABLES!");
            return;
        }

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(props, 
            new jakarta.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(EMAIL));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(USERNAME));
            msg.setSubject("From EWA (by Lucas)");
            CreateEmailContent content_creator = new CreateEmailContent();
            String email_content = content_creator.makeHTMLContent();
            msg.setContent(email_content, "text/html");
            Transport.send(msg);

        } catch(MessagingException error) {
            error.printStackTrace();
        }

        System.out.println("The email was sent, sir!");
    }
    






}
