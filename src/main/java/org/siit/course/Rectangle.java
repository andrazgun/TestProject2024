package org.siit.course;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class Rectangle {

    private int height;
    private int width;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

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

}
