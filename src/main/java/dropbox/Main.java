package dropbox;

import com.dropbox.core.DbxException;
import dropbox.listener.DirectoryListener;
import dropbox.upload.DropBoxUploader;

import java.io.IOException;


public class Main {


    public static void main(String args[]) throws DbxException, IOException, InterruptedException {
        new DirectoryListener().listener();
    }
}
