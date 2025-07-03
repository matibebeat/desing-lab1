package org.example;

import java.util.List;
import java.util.Date;
class Reservation {
    private Subscriber subscriber; // Association with Subscriber
    private Book book; // Association with Book
    private Date reservationDate;
    private Date expirationDate;

    public Reservation(Subscriber subscriber, Book book, Date reservationDate, Date expirationDate) {
        this.subscriber = subscriber;
        this.book = book;
        this.reservationDate = reservationDate;
        this.expirationDate = expirationDate;
    }

    // Getters
    public Subscriber getSubscriber() { return subscriber; }
    public Book getBook() { return book; }
    public Date getReservationDate() { return reservationDate; }
    public Date getExpirationDate() { return expirationDate; }
}