package org.siit.course;

public class CustomCourseException extends Exception {
    public CustomCourseException() { //default constructor
        super(); //always first

    }
    public CustomCourseException(String s) {
        super(s);
        System.out.println("My exception triggered for " + s);
    }

    public CustomCourseException (String s, int n) {
        super(s);
        if (n < 1000) {
            System.out.println("Exception triggered with message " + s);
        }
    }

    public CustomCourseException(int l1, int l2, int l3, String m) {
        super(m);
        System.out.println("Cannot have a triangle with " + l1 + ", " + l2 + " and " + l3);
    }

}
