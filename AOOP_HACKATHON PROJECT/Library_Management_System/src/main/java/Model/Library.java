package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<BorrowRecord> borrowRecords = new ArrayList<>();
    private int borrowRecordCounter = 1;

    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }

    public List<Book> searchBooks(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public String borrowBook(int userId, int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId && book.isAvailable()) {
                book.setAvailable(false);
                borrowRecords.add(new BorrowRecord(borrowRecordCounter++, userId, bookId, LocalDate.now()));
                return "Book borrowed successfully.";
            }
        }
        return "Book is not available.";
    }

    public String returnBook(int bookId) {
        for (BorrowRecord record : borrowRecords) {
            if (record.getBookId() == bookId && record.getReturnDate() == null) {
                record.setReturnDate(LocalDate.now());
                for (Book book : books) {
                    if (book.getBookId() == bookId) {
                        book.setAvailable(true);
                        return "Book returned successfully.";
                    }
                }
            }
        }
        return "No record found for this book.";
    }
}

