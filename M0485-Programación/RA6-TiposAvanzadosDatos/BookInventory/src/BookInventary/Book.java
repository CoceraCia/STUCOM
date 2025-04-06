/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BookInventary;

import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class Book {

    //ATRIBUTES
    /**
     * The ISBN (International Standard Book Number) is a unique identifier for
     * books. It follows a structured format to distinguish different
     * publications.
     *
     * ISBN-13 Format (Current Standard): - Contains 13 digits, divided into 5
     * parts: 1. Prefix: "978" or "979" (indicates a book identifier) 2.
     * Registration Group: Represents the country or language area (e.g., "84"
     * for Spain) 3. Publisher Code: Identifies the publisher 4. Title Number:
     * Specific to each book within the publisher 5. Check Digit: Ensures the
     * ISBN is valid
     *
     * Example: 978-84-376-0494-7
     */
    
    private  String isbn;
    private String title;
    private ArrayList<String> authors;
    private double price;
    private int stock;

    public Book(String isbn, String title, ArrayList<String> authors, double price, int stock) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.price = price;
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    /**
     *
     * @param obj Book that's going to be compared
     * @return returns true if they are the same Book
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book bk) {
            return bk.getTitle() != null && bk.getTitle().equals(this.title);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (this.title != null) ? this.title.hashCode() : 0;
    }

}
