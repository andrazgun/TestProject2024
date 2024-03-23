package org.siit.course;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class Course05 {

    public static void runCourseCode05 () {
        double d1 = Double.parseDouble("123.45");

        Person p1 = new Person(
                22,
                'M',
                "Alex",
                180,
                80,
                false,
                1981
        );
        p1.printName(); //Alex --> call method before changing name
        p1.setName("Doru"); //call public setName method from Class Person
        p1.printName(); //Doru --> call method after changing name

        p1.printAge(); //22 --> call method before changing age
        p1.setAge(44);
        p1.printAge(); //44 --> call method after changing name

        p1.setSex('F');
        System.out.println("Sex is " + p1.getSex());

        CarBrands cb = new CarBrands(
                "Suzuki",
                new Date(1990, Calendar.FEBRUARY, 20),
                "Andrei",
                "No info",
                p1
        );
        Car c1 = new Car(
                cb,
                "Vitara",
                Color.BLUE,
                "benzina",
                true,
                "Suz123",
                0f,
                100f,
                (byte) 3,
                true
        );

        c1.printCar();
        c1.paintCar(Color.RED);
        c1.printCar();
        c1.accelerate(); //call method with default arg
        c1.accelerate(5f); //call method with speedDelta arg
        c1.printCar();
        c1.gearUp();

        System.out.println("-----------------");
        Light l1 = new Light();
        l1.dim(20);
        l1.turnOn();
        l1.brighten(1000f);
        l1.turnOff();




    }
}
