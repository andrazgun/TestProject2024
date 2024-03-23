package org.siit.course;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class Shape {

    private String color;

    public void colorShape(String newColor) {
        color = newColor;
    }

}
