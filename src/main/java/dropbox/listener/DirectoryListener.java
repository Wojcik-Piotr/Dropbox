package dropbox.listener;

import dropbox.upload.DropBoxUploader;

import java.io.IOException;
import java.nio.file.*;

public class DirectoryListener {
    private DropBoxUploader dropBoxUploader;
    private String dir;
    private String accesToken;

    public DirectoryListener(String dir, DropBoxUploader dropBoxUploader, String accesToken) {
        this.dropBoxUploader = dropBoxUploader;
        this.dir = dir;
        this.accesToken = accesToken;
    }

    public void listener() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path path = Paths.get(dir);

        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            String name = key.pollEvents().get(0).context().toString();
            System.out.println(name);
            dropBoxUploader.upload(path.toString() + "\\" + name, name, accesToken;
            key.reset();
        }
    }

}
