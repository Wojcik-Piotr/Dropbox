package dropbox.upload;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import dropbox.config.ConfigurationService;
import dropbox.config.Keys;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DropBoxUploader implements Uploader, Keys {

    private final ConfigurationService cfg;

    public DropBoxUploader(ConfigurationService cfg) {
        this.cfg = cfg;
    }

    public void upload(String path, String name) {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, cfg.get(DROPBOX_KEY));

        try (InputStream in = new FileInputStream(path)) {
            client.files().uploadBuilder("/" + name)
                    .uploadAndFinish(in);
        } catch (IOException | DbxException e) {
            throw new UploadExcepcion("File not found" + path, e);
        }
    }
}
