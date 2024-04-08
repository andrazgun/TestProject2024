package org.siit.course;

import org.siit.course.utils.GeneralUtils;

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
                true,
                45f
        );

        c1.printCar();
        c1.paintCar(Color.RED);
        c1.printCar();
        c1.accelerate(); //call method with default arg
        c1.accelerate(5f); //call method with speedDelta arg
        c1.printCar();
        c1.gearUp();

        System.out.println("STATIC METHOD CALL !");

//        GeneralUtils.printCar(c1);

        c1.turnLeft(540);

        System.out.println("-----------------");
        Light l1 = new Light();
        l1.dim(20);
        l1.turnOn();
        l1.brighten(1000f);
        l1.turnOff();

        Shape s1 = new Shape("green", true);
        Shape s2 = new Shape("red", false);
        s1.draw();
        s2.erase("shape");

        Triangle t1 = new Triangle(10, 20, 30);
        t1.setColor("yellow"); // set color via parent class Shape
        t1.draw();
        Triangle t2 = new Triangle( "blue", 10, 20, 30);
        t2.draw();
        t2.erase();

        Circle circle1 = new Circle(5);
        circle1.setColor("magenta");
        circle1.erase("circle"); //call method from super class with param
        circle1.erase(); //call method from super class without param

        Square sq1 = new Square(5);
        sq1.printRectangle();
        sq1.draw();
        sq1.draw("square");

        Shape t3 = new Triangle("white", 17, 32, 64); // new object from
        // super class Shape
        // using method from subclass Triangle
        t3.draw(); // call method from super class, overriding in subclass
        Shape r2 = new Rectangle("white", false, 6, 7); // polymorphism
        r2.draw();
        Person p3 = new Person(
                25,
                'M',
                "Otto",
                165,
                45,
                false,
                4,
                new Shape("black", true)); // polymorphism
        





    }
}
