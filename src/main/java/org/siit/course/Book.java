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

    public Book() { // default constructor
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

    public void printBook() {
        System.out.println("Book " + getName() + " " +
                getPrice() + ", by " +
                getAuthor().getName() + ", published in " +
                getYear());
    }

    public void printAuthor() { //is void type because there is nothing to return
        System.out.println("Author's name " +
                getAuthor().getName() +
                "\n" + "Author's email " +
                getAuthor().getEmail());
    }



}
