package org.siit.course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor


public class Teacher extends Person {

    private String specialization;

//    constructor
    public Teacher(int age,
                   char sex,
                   String name,
                   int height,
                   int weight,
                   boolean isHungry,
                   int year,
                   String specialization) {
        super(age, sex, name, height, weight, isHungry, year); //args from super class Person
        this.specialization = specialization;
    }
}
