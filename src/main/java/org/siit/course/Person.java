package org.siit.course;

public class Person {

    private int age;
    private char sex;
    private String name;
    private int height;
    private int weight;
    private boolean isHungry;
    private int year;

    public Person(int age,
                  char sex,
                  String name,
                  int height,
                  int weight,
                  boolean isHungry,
                  int year
    ) {
        this.age = age;
        this.sex = sex;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.isHungry = isHungry;
        this.year = year;
    }


    public void eat() {
        if (!isHungry) {
            System.out.println("I am not hungry");
        } else {
            System.out.println("I am hungry");
            isHungry = false;
        }
    }
    //    Getter
    public String getName() {
        return this.name;
    }
    //    Setter
    public void setName(String newName) {
        this.name = newName;
    }
    public void printName() {
        System.out.println("Person's name is " + getName());
    }
//    Getter
    public int getAge() {
        return this.age;
    }

//    Setter
    public void setAge(int newAge) {
        this.age = newAge;
    }
    public void printAge() {
        System.out.println("Age is " + getAge());
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }


}
