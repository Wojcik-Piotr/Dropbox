package dropbox.listener;

import dropbox.upload.DropBoxUploader;

import java.io.IOException;
import java.nio.file.*;

public class DirectoryListener {
    public void listener() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();

        Path path = Paths.get("C:\\Users\\Piotr\\IdeaProjects\\dropbox");

        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            String name =  key.pollEvents().get(0).context().toString();
            System.out.println(name);
            new DropBoxUploader().upload(path.toString()+"\\"+name,name);
            key.reset();
        }
    }

}
