package org.siit.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Rectangle extends Shape {

    private int height;
    private int width;

    // constructor with 2 parameters
//    public Rectangle(int width, int height) {
//        this.width = width;
//        this.height = height;
//    }

    public int computeArea() {
        return this.height * this.width;
    }
    public int computePerimeter() {
        return (this.height + this.width) * 2;
    }

    public double computeDiagonal() {
        return Math.sqrt(Math.pow(this.height, 2) + Math.pow(this.width, 2));
    }

    public void printRectangle() {
        System.out.println("Area: " + computeArea());
        System.out.println("Diagonal: " + computeDiagonal());
        System.out.println("Perimeter: " + computePerimeter());
    }

    //    method overriding method in Shape parent class using parent class constructor
    public void draw() {
        super.draw("rectangle");
    }

    public Rectangle(String color, boolean is3d, int height, int width) {
        super(color, is3d);
        this.height = height;
        this.width = width;
    }

    public void erase() {
        super.erase("rectangle");
    }
}
