package dropbox.upload;

public class UploadExcepcion extends RuntimeException {
    UploadExcepcion(String message, Throwable cause) {
        super(message, cause);
    }
}
