package dropbox.mail;

import dropbox.config.ConfigurationService;
import dropbox.mail.client.MailJet;
import dropbox.mail.client.MySendGrid;

import static dropbox.config.Keys.MAIL_CLIENT;


public class ClientFactor {

    private final ConfigurationService cfg;

    public ClientFactor(ConfigurationService cfg) {
        this.cfg = cfg;
    }

    public EmailClient createClient(){
        String client = cfg.get(MAIL_CLIENT);
        if(client.equals("mailjet")){
            return new MailJet(cfg);
        }else if(client.equals("sendgrid")){
            return new MySendGrid(cfg);
        }else {
            throw new RuntimeException("No such client availabe");
        }
    }



}
