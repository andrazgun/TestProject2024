package org.siit.course;

import org.siit.course.utils.Circle;

import java.awt.*;
import java.util.Date;

import static org.siit.course.utils.MathFunctions.*;
import static org.siit.course.ComputeVolume.*;

public class Course04 {

    public static void drawShapeOutline (int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height -1) {
                    System.out.print("*"); // will print * but not in new line
                }
                else {
                    if (j == 0 || j == width -1) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println(); // print new line

        }

    }

    public static void drawShapeCorners(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0 || i == height -1) && (j == 0 || j == width -1)) {
                    System.out.print("*"); // will print * but not in new line
                }
                else {
                    System.out.print(" ");
                }

            }
            System.out.println(); // print new line

        }


    }

    public static void drawFullShape (int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*"); // will print * but not in new line
            }
            System.out.println(); // print new line

        }

    }

    private static void drawFullShape(int i) {
        drawFullShape(i, i);
    }
    public static void runCourseCode4() {
        int n = 123456;
        System.out.println("Number " + n + " is prime ? " + isPrimeNumber(n));

        int r = compareNumbers(100, 500);
        compareNum(600, 670);

        System.out.println("Number " + n + " is odd? " + isOdd(n));

        drawFullShape(4, 5); // rectangle
        drawShapeOutline(7, 7);
        drawShapeCorners(3, 3);
        drawFullShape(3); // square

//        Method overloading --> computeVolume
        int vertex = 5;
        System.out.println("The volume for a cube with vertex " + vertex + " is " + computeVolume(vertex));

        double sphereRadius = 7;
        System.out.println("The volume for a sphere with radius " + sphereRadius + " is " + computeVolume(sphereRadius));

        int baseLength = 3;
        int baseWidth = 4;
        int pyramidHeight = 5;
        System.out.println("The volume for a pyramid with base length " + baseLength + ", base width " + baseWidth + " and height " + pyramidHeight + " is " + computeVolume(baseLength, baseWidth, pyramidHeight));

        double minorRadius = 3;
        double majorRadius = 8;
        System.out.println("The volume for a torus with minor radius " + minorRadius + " and major radius " + majorRadius + " is " + computeVolume(minorRadius, majorRadius));

//        Person p1 = new Person();
//        Person p2 = new Person();
//        p1.name = "Andrei";
//        p2.name = "Silvia";
//        System.out.println(p1.name);

        Person p3 = new Person(
                43,
                'M',
                "Andrei",
                185,
                80,
                false,
                new Date(1981, 9, 17)
        );
        p3.eat();

        Shape s1 = new Shape();
        s1.colorShape("blue");
        System.out.println("The shape is " + s1.color);

        Rectangle r1 = new Rectangle(10, 6);
        r1.printRectangle();

        Rectangle r2 = new Rectangle(3, 2);
        r2.printRectangle();

        Circle c1 = new Circle(5); // will call constructor with 1 arg
        Circle c2 = new Circle(7); // will call constructor with 1 arg
        Circle c3 = new Circle(); // will call default constructor
        c1.printCircle();
        c2.printCircle();
        c3.printCircle();

        CarBrands dacia = new CarBrands(
                "Dacia",
                new Date(1990, 9, 20),
                "Renault",
                "Pitesti",
                p3
        );
        Car car1 = new Car(
                dacia,
                "Duster",
                Color.RED,
                "benzina",
                true,
                "123"
        );
        car1.accelerate();
        car1.paintCar(Color.BLUE);
        System.out.println("Car " + car1.model + " with brand " + car1.brand.name);



    }



}
