package org.example;

import java.util.List;

class Book {
    private String title;
    private List<String> authors; // Changed to List<String> for multiple authors
    private String category;
    private String ISBN;
    private String language;
    private int publicationYear;
    private String bookID;
    private boolean isRestricted;
    private String series;

    public Book(String title, List<String> authors, String category, String ISBN, String language, int publicationYear, String bookID, boolean isRestricted, String series) {
        this.title = title;
        this.authors = authors;
        this.category = category;
        this.ISBN = ISBN;
        this.language = language;
        this.publicationYear = publicationYear;
        this.bookID = bookID;
        this.isRestricted = isRestricted;
        this.series = series;
    }

    // Getters
    public String getTitle() { return title; }
    public List<String> getAuthors() { return authors; }
    public String getCategory() { return category; }
    public String getISBN() { return ISBN; }
    public String getLanguage() { return language; }
    public int getPublicationYear() { return publicationYear; }
    public String getBookID() { return bookID; }
    public boolean isRestricted() { return isRestricted; }
    public String getSeries() { return series; }
}