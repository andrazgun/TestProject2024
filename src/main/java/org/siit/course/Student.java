package org.siit.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor


public class Student extends Person {

        private String faculty;
        private String studentId;

//        constructor
    public Student(int age, char sex, String name, int height, int weight, boolean isHungry, int year, String faculty, String studentId) {
        super(age, sex, name, height, weight, isHungry, year); // args from super class Person
        this.faculty = faculty;
        this.studentId = studentId;
    }

    public void party() {
        System.out.println("Party");
    }

}
