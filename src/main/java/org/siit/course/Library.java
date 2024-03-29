package org.siit.course;

public class Library {

    public static void main(String[] args) {

        Author a1 = new Author(
                "Andrei",
                "andrei@yopmail.com"
        );

        Author a2 = new Author(
                "Vera",
                "vera@sun.io"
        );

        Book b1 = new Book(
                "Dimineata",
                2020,
                a1,
                350);

        Book b2 = new Book(
                "Iarna",
                1950,
                a2,
                200);

        b1.printBook();
        b1.printAuthor();

        b2.printBook();
        b2.printAuthor();


//        System.out.println("Book " + b1.getName() + " " +
//                b1.getPrice() + ", by " +
//                a1.getName() + ", published in " +
//                b1.getYear()); // Book Dimineata 350.0, by Andrei, published in 2020 --> using a1 and b1
//
//        System.out.println("Book " + b1.getName() + " " +
//                b1.getPrice() + ", by " +
//                b1.author.getName() + ", published in " +
//                b1.getYear()); // Book Dimineata 350.0, by Andrei, published in 2020 --> using b1 and author
//
//        System.out.println("Book " + b1.getName() + " " +
//                b1.getPrice() + ", by " +
//                b1.getAuthor().getName() + ", published in " +
//                b1.getYear()); // Book Dimineata 350.0, by Andrei, published in 2020 --> using b1 and methods from b1
//
//
//        System.out.println("Author name " +
//                b1.getAuthor().getName() +
//                "\n" + "Author email " +
//                b1.getAuthor().getEmail()); // Access method located in Class Author from Class Book


    }
}
