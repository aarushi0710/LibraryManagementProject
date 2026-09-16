import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    String id;
    String title;
    boolean isIssued;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Title: " + title + " | Status: " + (isIssued ? "Issued" : "Available");
    }
}