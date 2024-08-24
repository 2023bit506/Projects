public package Library;

public interface Library {
    void addBook(Book book);
    Book borrowBook(String title) throws BookNotFoundException;
    void returnBook(Book book);
}
