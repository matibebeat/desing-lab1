package org.example;

import java.util.List;
import java.util.ArrayList;
class Subscriber {
    private String name;
    private String id;
    private String email;
    private String contact;
    private String role; // "Student", "Teacher", "External"
    private List<Borrowing> borrowedBooks; // One-to-many relationship with Borrowing
    private boolean isSuspended;

    public Subscriber(String name, String id, String email, String contact, String role) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.contact = contact;
        this.role = role;
        this.borrowedBooks = new ArrayList<>();
        this.isSuspended = false;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getContact() { return contact; }
    public String getRole() { return role; }
    public List<Borrowing> getBorrowedBooks() { return borrowedBooks; }
    public boolean isSuspended() { return isSuspended; }
    public void setSuspended(boolean suspended) { isSuspended = suspended; }

    public void addBorrowedBook(Borrowing borrowing) {
        this.borrowedBooks.add(borrowing);
    }

    public void removeBorrowedBook(Borrowing borrowing) {
        this.borrowedBooks.remove(borrowing);
    }
}
