package lab6;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void registerUser(User user) { users.add(user); }

    public void lendBook(String bookTitle, String userName)
            throws UserNotFoundException, BookNotFoundException, BookAlreadyBorrowedException, MaxBooksLimitException {
        User u = findUser(userName);
        Book b = findBook(bookTitle);
        u.borrowBook(b);
    }

    public void returnBook(String bookTitle, String userName)
            throws UserNotFoundException, BookNotFoundException, BookNotBorrowedException {
        User u = findUser(userName);
        Book b = findBook(bookTitle);
        u.returnBook(b);
    }

    private User findUser(String name) throws UserNotFoundException {
        return users.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst()
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден: " + name));
    }

    private Book findBook(String title) throws BookNotFoundException {
        return books.stream().filter(x -> x.getTitle().equalsIgnoreCase(title)).findFirst()
                .orElseThrow(() -> new BookNotFoundException("Книга не найдена: " + title));
    }

    public void printState() {
        System.out.println("Пользователи:");
        users.forEach(u -> System.out.println("  - " + u));
        System.out.println("Книги:");
        books.forEach(b -> System.out.println("  - " + b));
    }
}
