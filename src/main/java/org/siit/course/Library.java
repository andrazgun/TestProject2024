package org.siit.course;

public class Library {

    public static void main(String[] args) {

        Author a1 = new Author("Andrei", "andrei@yopmail.com");
        Book b1 = new Book("Dimineata", 2020, a1, 350);
        System.out.println("Book " + b1.getName() + " " + b1.getPrice() + ", by " + a1.getName() + ", published in " + b1.getYear());
    }
}
