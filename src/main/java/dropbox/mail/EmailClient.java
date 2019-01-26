package dropbox.mail;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;

import java.io.IOException;

public interface EmailClient {
    void send(Emails emails) throws MailjetSocketTimeoutException, MailjetException, IOException;
}
