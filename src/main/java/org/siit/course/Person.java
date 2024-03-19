package org.siit.course;

import java.util.Date;

public class Person {

    public int age;
    char sex;
    String name;
    int height;
    int weight;
    boolean isHungry;
    Date birthday;

    public Person(int age, char sex, String name, int height, int weight, boolean isHungry, Date birthday) {
        this.age = age;
        this.sex = sex;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.isHungry = isHungry;
        this.birthday = birthday;
    }

    public void changeName(String newName) {
        name = newName;

    }

    public void eat(){
        if (!isHungry) {
            System.out.println("I am not hungry");
        } else {
            System.out.println("I am hungry");
            isHungry = false;
        }
    }

}
