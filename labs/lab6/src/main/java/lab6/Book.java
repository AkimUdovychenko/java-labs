package lab6;

public class Book {
    private final String title;
    private final String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }

    public void borrow() throws BookAlreadyBorrowedException {
        if (isBorrowed) throw new BookAlreadyBorrowedException("Книга уже взята: " + title);
        isBorrowed = true;
    }

    public void returnBook() throws BookNotBorrowedException {
        if (!isBorrowed) throw new BookNotBorrowedException("Книга не была взята: " + title);
        isBorrowed = false;
    }

    @Override public String toString() {
        return "\"" + title + "\" (" + author + ") " + (isBorrowed ? "[взята]" : "[свободна]");
    }
}
