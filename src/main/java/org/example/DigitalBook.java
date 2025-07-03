package org.example;

import java.util.List;
class DigitalBook extends Book {
    private int totalLicenses;
    private int availableLicenses;

    public DigitalBook(String title, List<String> authors, String category, String ISBN, String language, int publicationYear, String bookID, boolean isRestricted, String series, int totalLicenses) {
        super(title, authors, category, ISBN, language, publicationYear, bookID, isRestricted, series);
        this.totalLicenses = totalLicenses;
        this.availableLicenses = totalLicenses; // Initially all licenses are available
    }

    // Getters and Setters
    public int getTotalLicenses() { return totalLicenses; }
    public int getAvailableLicenses() { return availableLicenses; }
    public void setAvailableLicenses(int availableLicenses) { this.availableLicenses = availableLicenses; }
}