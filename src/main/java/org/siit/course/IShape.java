package org.siit.course;

public interface IShape {

    public void draw(); // public access modifier is redundant
    void draw (String type);
    void erase(String type);
    //void doSomething();


}
