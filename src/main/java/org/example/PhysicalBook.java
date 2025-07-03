package org.example;

import java.util.List;

class PhysicalBook extends Book {
    private int copyCount;
    private int availableCopies;

    public PhysicalBook(String title, List<String> authors, String category, String ISBN, String language, int publicationYear, String bookID, boolean isRestricted, String series, int copyCount) {
        super(title, authors, category, ISBN, language, publicationYear, bookID, isRestricted, series);
        this.copyCount = copyCount;
        this.availableCopies = copyCount; // Initially all copies are available
    }

    // Getters and Setters
    public int getCopyCount() { return copyCount; }
    public int getAvailableCopies() { return availableCopies; }
    public void setAvailableCopies(int availableCopies) { this.availableCopies = availableCopies; }
}