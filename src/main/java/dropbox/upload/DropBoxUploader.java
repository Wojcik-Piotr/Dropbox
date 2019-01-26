package dropbox.upload;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import dropbox.config.ConfigurationService;
import dropbox.mail.EmailService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static dropbox.config.Keys.DROPBOX_KEY;

public class DropBoxUploader implements Uploader {

    private final ConfigurationService cfg;

    public DropBoxUploader(ConfigurationService cfg) {
        this.cfg = cfg;
    }

    public void upload(String path, String name) {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 dbClient = new DbxClientV2(config, cfg.get(DROPBOX_KEY));

        try (InputStream in = new FileInputStream(path)) {
            dbClient.files().uploadBuilder("/" + name)
                    .uploadAndFinish(in);
            new EmailService(cfg).sendMail(name);
        } catch (IOException | DbxException e) {
            throw new UploadExcepcion("File not found" + path, e);
        } catch (MailjetSocketTimeoutException | MailjetException e) {
            e.printStackTrace();
        }
    }
}
