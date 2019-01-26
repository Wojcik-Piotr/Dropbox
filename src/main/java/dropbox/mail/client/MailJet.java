package dropbox.mail.client;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import dropbox.config.ConfigurationService;
import dropbox.mail.Emails;
import dropbox.mail.EmailClient;
import org.json.JSONArray;
import org.json.JSONObject;

import static dropbox.config.Keys.MJ_APIKEY_PRIVATE;
import static dropbox.config.Keys.MJ_APIKEY_PUBLIC;

public class MailJet implements EmailClient {
    private final ConfigurationService cfg;
    private MailjetClient client;
    private MailjetRequest email;
    private MailjetResponse response;

    public MailJet(ConfigurationService cfg){
        this.cfg=cfg;
    }

    @Override
    public void send(Emails emails) throws MailjetSocketTimeoutException, MailjetException {
            MailjetClient client;
            MailjetRequest request;
            MailjetResponse response;
            client = new MailjetClient(System.getenv(cfg.get(MJ_APIKEY_PUBLIC)), System.getenv(cfg.get(MJ_APIKEY_PRIVATE)), new ClientOptions("v3.1"));
            request = new MailjetRequest(Emailv31.resource)
                    .property(Emailv31.MESSAGES, new JSONArray()
                            .put(new JSONObject()
                                    .put(Emailv31.Message.FROM, new JSONObject()
                                            .put("Emails", "taxuniro@321-emails.com")
                                            .put("Name", "Lol Lol"))
                                    .put(Emailv31.Message.TO, new JSONArray()
                                            .put(new JSONObject()
                                                    .put("Emails", emails.getAddress())
                                                    .put("Name", emails.getAddress())))
                                    .put(Emailv31.Message.SUBJECT, emails.getSubject())
                                    .put(Emailv31.Message.TEXTPART, emails.getContents())));
            response = client.post(request);
            System.out.println(response.getStatus());
            System.out.println(response.getData());

    }
}
