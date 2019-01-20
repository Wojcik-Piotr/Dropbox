package dropbox.upload;

public class ListenerExepcion extends RuntimeException {
    public ListenerExepcion(String message, Throwable cause) {
        super(message, cause);
    }
}
