package dropbox.mail;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import dropbox.config.ConfigurationService;

import java.io.IOException;

import static dropbox.config.Keys.*;

public class EmailService {
    private final ConfigurationService cfg;
    private final EmailClient client;

    public EmailService(ConfigurationService cfg) {
        this.cfg = cfg;
        this.client = new ClientFactor(cfg).createClient();
    }

    public void sendMail(String name) throws MailjetSocketTimeoutException, IOException, MailjetException {
        String content = cfg.get(EMAIL_CONTENT) + ", " + name;
        client.send(new Emails(cfg.get(EMAIL_TO), cfg.get(EMAIL_SUBJECT), content));
    }
}
