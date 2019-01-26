package dropbox;

import dropbox.config.ConfigurationService;
import dropbox.listener.DirectoryListener;
import dropbox.upload.DropBoxUploader;

import static dropbox.config.Keys.DIR;

public class Main {
    private final static int PROPERTIES_INDEX = 0;

    public static void main(String args[]) {
        ConfigurationService cfg = new ConfigurationService(args[PROPERTIES_INDEX]);
        cfg.load();
        DropBoxUploader dropBoxUploader = new DropBoxUploader(cfg);
        new DirectoryListener(cfg.get(DIR), dropBoxUploader).listener();
    }
}
