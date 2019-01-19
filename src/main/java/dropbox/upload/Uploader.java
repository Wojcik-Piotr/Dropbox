package dropbox.upload;

import java.nio.file.Path;

public interface Uploader {
    void upload(String path, String name);
}
