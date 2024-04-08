package org.siit.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Circle extends Shape {

    private int radius;

//    constructor with 1 argument of type int
    public Circle(int radius) {
        setRadius(radius); //use setRadius method which contain throw exception
    }

//    constructor with default arguments
//    public Circle() {
//    }
//Setter method
    public void setRadius(int radius) throws IllegalArgumentException {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius " + radius + " cannot be negative");
            }
        this.radius = radius;
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
    //    method overriding method in Shape parent class using parent class constructor
    public void draw() {
        super.draw("circle");
    }

    public void erase() {
        super.erase("circle");
    }
}
