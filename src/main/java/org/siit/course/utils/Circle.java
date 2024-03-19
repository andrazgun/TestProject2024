package org.siit.course.utils;

public class Circle {

    int radius;

//    constructor with 1 argument of type int
    public Circle(int radius) {
        this.radius = radius;
    }

//    constructor with default arguments
    public Circle() {
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getLength() {
        return 2 * Math.PI * radius;
    }

    public void printCircle() {
        System.out.println("Circle with radius " + radius + " has area " + getArea() + " and length " + getLength());
    }


}
