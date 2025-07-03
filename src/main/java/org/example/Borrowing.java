package org.example;

import java.util.Date;

class Borrowing {
    private Subscriber subscriber; // Association with Subscriber
    private Book book; // Association with Book
    private Date borrowDate;
    private Date returnDate;
    private Date dueDate;
    private boolean isReturned;
    private Penalty penalty; // One-to-one association with Penalty (can be null if no penalty)

    public Borrowing(Subscriber subscriber, Book book, Date borrowDate, Date dueDate) {
        this.subscriber = subscriber;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.isReturned = false;
    }

    // Getters and Setters
    public Subscriber getSubscriber() { return subscriber; }
    public Book getBook() { return book; }
    public Date getBorrowDate() { return borrowDate; }
    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }
    public Date getDueDate() { return dueDate; }
    public boolean isReturned() { return isReturned; }
    public void setReturned(boolean returned) { isReturned = returned; }
    public Penalty getPenalty() { return penalty; }
    public void setPenalty(Penalty penalty) { this.penalty = penalty; }
}