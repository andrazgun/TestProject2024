package org.siit.course;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Light {

    public float MAX_INTENSITY = 100f; //constants to be defined first
    private boolean isOn; // false by default
    private float intensity;


    public void turnOn() {
    isOn = true;
    intensity = 1f;
//        System.out.println("Light on");
        print();
    }

    public void turnOff() {
        isOn = false;
        intensity = 0;
//        System.out.println("Light off");
        print();
    }

    public void dim(float intensity) {
        this.intensity -= intensity;
        if (this.intensity <= 0) { //else not needed
            turnOff();
            print();
        }
    }

    public void brighten (float intensity) {
        this.intensity += intensity;
        if (this.intensity > MAX_INTENSITY) {
            this.intensity = MAX_INTENSITY;
        }
        isOn = true;
        print();
    }

    public void print() {
        String state = (isOn) ? "ON" : "OFF"; //check isOn state
        System.out.println("The light is " + state + " and intensity is " + intensity);
    }


}
