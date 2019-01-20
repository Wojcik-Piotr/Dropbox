package dropbox.upload;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.users.FullAccount;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DropBoxUploader implements Uploader {


    public void upload(String path, String name, String accesToken) {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, accesToken);
        FullAccount account = null;

        try (InputStream in = new FileInputStream(path)) {
            FileMetadata metadata = client.files().uploadBuilder("/"+name)
                    .uploadAndFinish(in);
        } catch (IOException | DbxException e) {
            throw new UploadExcepcion("cos tam"+ path, e);
        }
    }
}
