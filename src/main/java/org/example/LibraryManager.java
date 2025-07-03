package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class LibraryManager {
    private List<Book> books;
    private List<Subscriber> subscribers;
    private List<Borrowing> borrowings;
    private List<Reservation> reservations;
    private List<Penalty> penalties;

    public LibraryManager() {
        this.books = new ArrayList<>();
        this.subscribers = new ArrayList<>();
        this.borrowings = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.penalties = new ArrayList<>();
    }

    // Methods as per UML
    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void registerSubscriber(Subscriber s) {
        this.subscribers.add(s);
    }

    public Borrowing borrowBook(Subscriber s, Book b) {
        // Basic implementation, actual logic for availability, constraints etc. would go here.
        // This just creates the borrowing object and adds to the list.
        Date borrowDate = new Date(); // Current date
        // For simplicity, dueDate is not calculated here but would be based on subscriber role.
        Date dueDate = new Date(borrowDate.getTime() + (14 * 24 * 60 * 60 * 1000L)); // Example: 14 days later

        Borrowing newBorrowing = new Borrowing(s, b, borrowDate, dueDate);
        this.borrowings.add(newBorrowing);
        s.addBorrowedBook(newBorrowing); // Add borrowing to subscriber's list
        return newBorrowing;
    }

    public void returnBook(Subscriber s, Book b) {
        // Find the borrowing record for this subscriber and book
        Borrowing borrowingToReturn = null;
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getSubscriber().equals(s) && borrowing.getBook().equals(b) && !borrowing.isReturned()) {
                borrowingToReturn = borrowing;
                break;
            }
        }

        if (borrowingToReturn != null) {
            borrowingToReturn.setReturnDate(new Date());
            borrowingToReturn.setReturned(true);
            s.removeBorrowedBook(borrowingToReturn); // Remove borrowing from subscriber's list

            // Logic to calculate and apply penalty if late
            Penalty calculatedPenalty = calculatePenalty(borrowingToReturn);
            if (calculatedPenalty != null) {
                borrowingToReturn.setPenalty(calculatedPenalty);
                this.penalties.add(calculatedPenalty);
            }
            // Update available copies/licenses
            if (b instanceof PhysicalBook) {
                PhysicalBook pb = (PhysicalBook) b;
                pb.setAvailableCopies(pb.getAvailableCopies() + 1);
            } else if (b instanceof DigitalBook) {
                DigitalBook db = (DigitalBook) b;
                db.setAvailableLicenses(db.getAvailableLicenses() + 1);
            }
        }
    }

    public Reservation reserveBook(Subscriber s, Book b) {
        // Basic implementation, actual logic for reservation rules would go here.
        Date reservationDate = new Date();
        Date expirationDate = new Date(reservationDate.getTime() + (48 * 60 * 60 * 1000L)); // 48 hours later

        Reservation newReservation = new Reservation(s, b, reservationDate, expirationDate);
        this.reservations.add(newReservation);
        return newReservation;
    }

    public Penalty calculatePenalty(Borrowing borrowing) {
        // This is a placeholder; actual calculation based on dueDate, returnDate and subscriber role.
        if (borrowing.getReturnDate() != null && borrowing.getReturnDate().after(borrowing.getDueDate())) {
            long lateDays = (borrowing.getReturnDate().getTime() - borrowing.getDueDate().getTime()) / (1000 * 60 * 60 * 24);
            double dailyRate = 0.0;
            switch (borrowing.getSubscriber().getRole()) {
                case "Student":
                    dailyRate = 0.50;
                    break;
                case "Teacher":
                    dailyRate = 0.20;
                    break;
                case "External":
                    dailyRate = 1.00;
                    break;
            }
            double amount = lateDays * dailyRate;
            // Max penalty limit not implemented here for simplicity as per "core model" instruction
            return new Penalty(amount, "Late return");
        }
        return null;
    }

    // Getters for lists (for viewing statistics/managing)
    public List<Book> getBooks() { return books; }
    public List<Subscriber> getSubscribers() { return subscribers; }
    public List<Borrowing> getBorrowings() { return borrowings; }
    public List<Reservation> getReservations() { return reservations; }
    public List<Penalty> getPenalties() { return penalties; }

    // Additional management methods (as per description, not explicitly in UML but implied for manager)
    public void manageUserSuspension(Subscriber subscriber, boolean suspend) {
        subscriber.setSuspended(suspend);
    }
}