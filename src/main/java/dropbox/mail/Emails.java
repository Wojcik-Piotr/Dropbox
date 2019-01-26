package dropbox.mail;

public class Emails {
    private String address;
    private String subject;
    private String contents;

    public Emails(String address, String subject, String contents) {
        this.address = address;
        this.subject = subject;
        this.contents = contents;
    }

    public String getAddress() {
        return address;
    }

    public String getSubject() {
        return subject;
    }

    public String getContents() {
        return contents;
    }
}
