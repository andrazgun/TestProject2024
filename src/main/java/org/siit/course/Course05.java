package org.siit.course;

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



    }
}
