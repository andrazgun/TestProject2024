package org.siit.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Triangle extends Shape {
    private int l1;
    private int l2;
    private int l3;

    public Triangle(String color, boolean is3d, int l1, int l2, int l3) {
        super(color, is3d);
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    //    constructor which contains setter from parent class Shape with keyword super
    public Triangle(String color, int l1, int l2, int l3) {
        super(color, true); // constructor from Shape parent class, must be first in statement in constructor
        // same as super.setColor(color) which is not a must to be first in constructor ;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

//    method overriding method in Shape parent class
//    public void draw() {
//        System.out.println("Draw a triangle with color " + getColor());
//    }

//    method overriding method in Shape parent class using parent class constructor
    public void draw() {
        super.draw("triangle");
    }

    //    method overriding method in Shape parent class "@Override" not mandatory

    public void erase() {
        super.erase("triangle");
//        System.out.println("Erase a triangle with color " + getColor());
    }




}