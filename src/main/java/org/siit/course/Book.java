package org.siit.course;

public class Book {

    String bookName;
    int year;
    Author author;
    double price;

    public Book(String bookName, int year, Author author, double price) {
        this.bookName = bookName;
        this.year = year;
        this.author = author;
        this.price = price;
    }

    public Book() {
    }

    public String getName() {
        return this.bookName;
    }

    public Author getAuthor() {
        return this.author;
    }
    public double getPrice() {
        return this.price;
    }
    public int getYear() {
        return this.year;
    }

}
