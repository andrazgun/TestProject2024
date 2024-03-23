package org.siit.course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.awt.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class Car {

    public final float ACC_STEP = 12; // it is constant, has only getter, not setter
    public final float MAX_SPEED = 240F;
    public final byte MAX_GEAR = 5;

    private CarBrands brand;
    private String model;
    private Color color;
    private String fuelType;
    private boolean isNew;
    private String vin;
    private float currentSpeed;
    private float fuelLevel;
    private byte gear;
    private boolean isStopped;

//    private method not accessible from outside the class
//    method overloading, because this method is not in parent class CarBrands
    private void accelerateStep(float step) {
        if (gear == 0) {
            gear++;
        }
        isStopped = false;
        if (currentSpeed + ACC_STEP > MAX_SPEED) {
        currentSpeed = MAX_SPEED;
        }
        else {
        currentSpeed += step;
        }

    }
//call accelerateStep() method with default argument
    public void accelerate() {
        accelerateStep(ACC_STEP);
    }
//    call accelerateStep() method with speedDelta argument
    public void accelerate(float speedDelta) {
        accelerateStep(speedDelta);
    }

    public void paintCar(Color color) {
        this.color = color;
    }

    public void printCar(){
        System.out.println("-------------");
        System.out.println("Car model: " + this.model);
        System.out.println("Car brand: " + this.brand.getName());
        System.out.println("Car owner: " + this.brand.getOwner());
        System.out.println("Car color: " + getColor());
        System.out.println("Current speed: " + getCurrentSpeed());
        System.out.println("Current gear: " + getGear());
    }

    public void startCar() {
        isStopped = false;
        gear = 1;
        currentSpeed = 0;

    }

    public void stopCar() {
        isStopped = true;
        gear = 0;
        currentSpeed = 0;
    }

    public void gearUp() {
        if (gear == MAX_GEAR) {
            System.out.println("Max gear level reached!");
        }
        else {
            gear++;
        }
    }

    public void gearDown() {
        if (gear == 0) {
            System.out.println("Minimum gear level reached!");
        }
        else {
            gear--;
        }
    }



}
