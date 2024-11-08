package Model;

import java.time.LocalDate;

public class BorrowRecord {
    private int recordId;
    private int userId;
    private int bookId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowRecord(int recordId, int userId, int bookId, LocalDate borrowDate) {
        this.recordId = recordId;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public int getRecordId() { return recordId; }
    public int getUserId() { return userId; }
    public int getBookId() { return bookId; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}

