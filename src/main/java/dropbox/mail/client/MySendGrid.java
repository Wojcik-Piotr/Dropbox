package dropbox.mail.client;

import dropbox.config.ConfigurationService;
import dropbox.mail.EmailClient;
import com.sendgrid.*;
import dropbox.mail.Emails;

import java.io.IOException;

import static dropbox.config.Keys.SENDGRID_API_KEY;

public class MySendGrid implements EmailClient {
    private final ConfigurationService cfg;

    public MySendGrid(ConfigurationService cfg){
        this.cfg=cfg;
    }

    @Override
    public void send(Emails email) throws IOException {
        Email from = new Email("taxuniro@321-email.com");
        String subject = email.getSubject();
        Email to = new Email(email.getAddress());
        Content content = new Content("text/plain", email.getContents());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(System.getenv(cfg.get(SENDGRID_API_KEY)));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}
