package org.siit.course.utils;

import org.siit.course.Car;

public class GeneralUtils {

    public static void printCar (Car c1) {
        System.out.println("-------------");
        System.out.println("Car model: " + c1.getModel());
        System.out.println("Car brand: " + c1.getBrand().getName());
        System.out.println("Car owner: " + c1.getBrand().getOwner());
        System.out.println("Car color: " + c1.getColor());
        System.out.println("Current speed: " + c1.getCurrentSpeed());
        System.out.println("Current gear: " + c1.getGear());


    }

}
