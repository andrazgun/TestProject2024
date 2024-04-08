package org.siit.course;

import javax.swing.filechooser.FileNameExtensionFilter;

public class Course07 {

//    infinite loop
    public static void infiniteLoop(int index) {
        index ++;
        infiniteLoop(index);
    }

    public static void runCourseCode07(String[] args) throws CustomCourseException {
//        infiniteLoop(0); commented to exclude the infinite loop
        if (args.length < 1) {
            throw new IllegalArgumentException("This is an exception");
        }
        System.out.println(args[0]);
        System.out.println("Course 07");

        Circle c1 = new Circle(5);
        c1.printCircle();
        c1.setRadius(100);
        c1.printCircle();

//        try catch exception
        try {
            c1.setRadius(-100); // throws exception
        }
        catch (IllegalArgumentException iae) {
            System.out.println("Exception found with radius ");
        }
        c1.printCircle();
        System.out.println("----------------");
        try {
            Circle c2 = new Circle(-4); // throws exception
            c2.printCircle();
        }
        catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        catch (NullPointerException nex) {
            System.out.println("Null pointer exception");
        }
        catch (ArrayIndexOutOfBoundsException aob) {
            System.out.println(aob.getMessage());
        }
        catch (Exception ex) {
            System.out.println("General exception");
        }
        finally {
            System.out.println("This block execute regardless of whether exceptions were thrown or not");
        }
        System.out.println("App continues to run");
        System.out.println("----------------");

        try {
            Triangle t1 = new Triangle("Purple", true, 3,4,10);
        } catch (CustomCourseException e) { //message from CustomCourseException class
            System.out.println(e.getMessage()); //message m from CustomCourseException class with value from Triangle class
        }
        System.out.println("----------------");

        try {
            String test = " Test123";
            Double d = Double.parseDouble(test); //Double with D because Double wrapper of primitive type double is used
            Double d2 = Double.parseDouble(args[1]);
            double sum = d + d2;
            System.out.println(sum);
        }
        catch (NullPointerException | NumberFormatException ex) { //throws 2 exceptions
            System.out.println("The parsing failed");
            System.out.println(ex.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException aob) { //throws 1 exception
            System.out.println(aob.getMessage());
        }

        Circle c3 = new Circle();
        c3.setRadius(55);



    }
}
