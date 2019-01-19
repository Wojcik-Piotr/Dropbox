package dropbox.upload;



public class GDriveUploader implements Uploader {
    private final String CLIENT_ID=" 976073280002-rpun0ofs3nbbl02qf4ja6j04bimvufui.apps.googleusercontent.com ";
    private final String CLIENT_SECRET=" WWVZIjvi4Ux8YaSUSpue7koV ";
    @Override
    public void upload(String path, String name) {
    /*    File fileMetadata = new File();
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
