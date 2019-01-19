package dropbox.upload;

public class UploadExcepcion extends RuntimeException {
    public UploadExcepcion(String message, Throwable cause) {
        super(message, cause);
    }
}
