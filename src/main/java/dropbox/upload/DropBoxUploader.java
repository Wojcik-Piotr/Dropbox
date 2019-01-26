package dropbox.upload;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import dropbox.config.ConfigurationService;
import dropbox.mail.Emails;
import dropbox.mail.EmailClient;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static dropbox.config.Keys.*;

public class DropBoxUploader implements Uploader {

    private final ConfigurationService cfg;
    private final EmailClient client;

    public DropBoxUploader(ConfigurationService cfg, EmailClient client) {
        this.cfg = cfg;
        this.client=client;
    }

    public void upload(String path, String name) {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 dbClient = new DbxClientV2(config, cfg.get(DROPBOX_KEY));

        try (InputStream in = new FileInputStream(path)) {
            dbClient.files().uploadBuilder("/" + name)
                    .uploadAndFinish(in);
            String content = cfg.get(EMAIL_CONTENT)+", "+name;
            client.send(new Emails(cfg.get(EMAIL_TO),cfg.get(EMAIL_SUBJECT),content));
        } catch (IOException | DbxException e) {
            throw new UploadExcepcion("File not found" + path, e);
        }
    }
}
