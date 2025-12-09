package lab6;

class BookAlreadyBorrowedException extends Exception {
    public BookAlreadyBorrowedException(String msg) { super(msg); }
}
class BookNotBorrowedException extends Exception {
    public BookNotBorrowedException(String msg) { super(msg); }
}
class UserNotFoundException extends Exception {
    public UserNotFoundException(String msg) { super(msg); }
}
class MaxBooksLimitException extends Exception {
    public MaxBooksLimitException(String msg) { super(msg); }
}
class BookNotFoundException extends Exception {
    public BookNotFoundException(String msg) { super(msg); }
}
