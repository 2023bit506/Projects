package Library;

public class Main {
    public static void main(String[] args) {
        Library library = new LibraryImpl();

        // Adding books to the library
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));

        try {
            // Borrowing a book
            Book borrowedBook = library.borrowBook("1984");
            System.out.println("Borrowed Book: " + borrowedBook);

            // Trying to borrow a book that does not exist
            library.borrowBook("The Catcher in the Rye");
        } catch (BookNotFoundException e) {
            System.err.println(e.getMessage());
        }

        // Returning a book
        Book bookToReturn = new Book("1984", "George Orwell");
        library.returnBook(bookToReturn);

        // Verify if the book is returned
        try {
            Book borrowedBookAgain = library.borrowBook("1984");
            System.out.println("Borrowed Book Again: " + borrowedBookAgain);
        } catch (BookNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}