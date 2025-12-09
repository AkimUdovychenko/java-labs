package lab6;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public User(String name) { this.name = name; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) throws BookAlreadyBorrowedException, MaxBooksLimitException {
        if (borrowedBooks.size() >= 5) throw new MaxBooksLimitException("Предел 5 книг превышен для " + name);
        book.borrow();
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) throws BookNotBorrowedException {
        book.returnBook();
        borrowedBooks.remove(book);
    }

    @Override public String toString() {
        return name + " (книг на руках: " + borrowedBooks.size() + ")";
    }
}
