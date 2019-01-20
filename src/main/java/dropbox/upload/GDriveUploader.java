package dropbox.upload;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.model.File;


public class GDriveUploader implements Uploader {
    private static final String CREDENTIALS_FILE_PATH=null;
    private final String CLIENT_ID = null;
    private final String CLIENT_SECRET = null;

    @Override
    public void upload(String path, String name) {
        /*File fileMetadata = new File();
        fileMetadata.setName("test.txt");
        java.io.File filePath = new java.io.File("files/photo.jpg");
        FileContent mediaContent = new FileContent("image/jpeg", filePath);
        File file = driveService.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
        System.out.println("File ID: " + file.getId());
*/
    }

}
