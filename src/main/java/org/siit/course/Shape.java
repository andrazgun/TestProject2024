package org.siit.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Shape implements IShape{

    private String color;
    private boolean is3d;

    public void draw() {
        System.out.println("Draw a shape with color " + color);
    }

    public void draw(String type) {
        System.out.println("Draw a " + type + " with color " + color);
    }

    public void erase(String type) {
        System.out.println("Erase a " + type + " with color " + color);
    }

    private void shapePrivateMethod() {
        System.out.println("This is a method just for shape");

    }


}
