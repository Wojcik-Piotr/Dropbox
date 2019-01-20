package dropbox;

import dropbox.config.ConfigurationService;
import dropbox.listener.DirectoryListener;
import dropbox.upload.DropBoxUploader;

import java.io.IOException;


public class Main {
    private final static int PROPERTIES_INDEX=0;
    public static void main(String args[]) throws IOException, InterruptedException {
        ConfigurationService cfg = new ConfigurationService(args[PROPERTIES_INDEX]);
        cfg.load();
        DropBoxUploader dropBoxUploader = new DropBoxUploader(cfg);
        new DirectoryListener(cfg.get("dir"), dropBoxUploader).listener();
    }
}
