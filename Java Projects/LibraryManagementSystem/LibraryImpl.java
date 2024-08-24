public package Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryImpl implements Library {
    private List<Book> books = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book borrowBook(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                book.setBorrowed(true);
                return book;
            }
        }
        throw new BookNotFoundException("Book with title '" + title + "' not found");
    }

    @Override
    public void returnBook(Book book) {
        book.setBorrowed(false);
    }
}
