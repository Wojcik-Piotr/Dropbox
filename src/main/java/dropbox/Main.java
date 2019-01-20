package dropbox;

import dropbox.listener.DirectoryListener;
import dropbox.upload.DropBoxUploader;

import java.io.IOException;


public class Main {

    private final static int DIR = 0;

    public static void main(String args[]) throws IOException, InterruptedException {
        String dir = args[DIR];
        DropBoxUploader dropBoxUploader = new DropBoxUploader();
        new DirectoryListener(dir, dropBoxUploader).listener();
    }
}
