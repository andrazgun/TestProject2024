package org.siit.course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.awt.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Car {

    private final float ACC_STEP = 5; // it is constant, has only getter, not setter
    private CarBrands brand;
    private String model;
    private Color color;
    private String fuelType;
    private boolean isNew;
    private String vin;
    private float currentSpeed;


    public void accelerate() {
        currentSpeed += ACC_STEP;
    }

    public void paintCar(Color color) {
        this.color = color;
    }


}
