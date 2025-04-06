/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BookInventary;

import JFrames.*;
import Library.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.UIManager;

/**
 *
 * @author migue
 */
public class BookInventory {
    // HashMap where key => book ISBN, value => Book

    public static HashMap<String, Book> books = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        retrieveBooks();
        Home home = new Home();
        home.setVisible(true);
    }

    public static String printBooks() {
        String data = "";
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            Book b = entry.getValue();
            String text
                    = "------------------------ISBN: " + b.getIsbn() + "------------------------\n"
                    + "Title: " + b.getTitle() + "\n"
                    + "Price: " + b.getPrice() + "\n"
                    + "Stock: " + b.getStock() + "\n"
                    + "Authors: " + b.getAuthors().get(0) + "\n";
            for (int i = 0; i < b.getAuthors().size(); i++) {
                text += "  -  " + b.getAuthors().get(i) + "\n";
            }
            data += text;
        }
        return data;
    }

    public static void retrieveBooks() {
        FileManager fm = new FileManager();
        ArrayList<String> lines = fm.read();
        for (String line : lines) {
            String[] splitted = line.split(";");
            String isbn = splitted[0];
            String title = splitted[1];
            ArrayList<String> authors = new ArrayList<>();
            String[] nl = splitted[2].split(":");
            for (int i = 0; i < nl.length; i++) {
                authors.add(nl[i]);
            }
            double price = Double.parseDouble(splitted[3]);
            int stock = Integer.parseInt(splitted[4]);
            books.put(isbn, new Book(isbn, title, authors, price, stock));
        }
    }
    
    
    public static void writeBooks() {
        FileManager fm = new FileManager();
        fm.clear();
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            System.out.println(entry.getValue().getIsbn());
            Book b = entry.getValue();
            fm.write(b.getIsbn() + ";");
            fm.write(b.getTitle() + ";");
            fm.write(b.getAuthors().get(0));
            for (int i = 1; i < b.getAuthors().size(); i++) {
                fm.write(":" + b.getAuthors().get(i));
            }
            fm.write(";" + b.getPrice() + ";");
            fm.write(b.getStock() + "\n");
        }
    }

    public static Book obtainBook(String isbn) {
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getIsbn().equals(isbn)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static boolean deleteBook(String isbn) {
        Book b = obtainBook(isbn); //Obtain the book to do the equals that we overrided
        if (b != null) {
            for (Map.Entry<String, Book> entry : books.entrySet()) {
                if (entry.getValue().equals(b)) { //Equals used
                    books.remove(b.getIsbn());
                    return true; //removed
                }
            }
        }
        return false; // not removed
    }
}
