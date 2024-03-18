package org.siit.course;
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


    }



}
